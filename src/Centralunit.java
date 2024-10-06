import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Centralunit {
    private ArrayList<Detector> detectors;
    private ArrayList<Room> rooms;
    private boolean isPowered;
    private Siren leftSiren;
    private Siren rightSiren;


    public Centralunit() {
        this.detectors = new ArrayList<>();
        this.rooms = new ArrayList<>();
    }

    public Centralunit(ArrayList<Detector> detectors, boolean isPowered, Siren leftSiren, Siren rightSiren) {
        this.detectors = detectors;
        this.isPowered = isPowered;
        this.rooms = new ArrayList<>();
        this.leftSiren = leftSiren;
        this.rightSiren = rightSiren;

    }

    public void addDetector(Detector detector){
        detectors.add(detector);
    }

    public void addRoom(Room room){
        rooms.add(room);
    }

    public void activateAlarm(){
        System.out.println("Fönster, Dörr och Rörelse alarm är aktiverade...");
        System.out.println("Rökdetektorn är alltid aktiverad.");
        System.out.println();
            for(Detector detector : detectors){
                detector.setActive(true);
            }
    }

    public void deactivateAlarm(){
        System.out.println("Fönster, Dörr och Rörelse alarm är avaktiverade...");
        System.out.println("Rökdetektorn är alltid aktiv och kan ej stängas av.");
        System.out.println();
        for(Detector detector : detectors){
            detector.setActive(false);
            detector.setAlerting(false);
            if(detector instanceof Smokedetector){

                detector.setActive(true);
                detector.setAlerting(false);
            }
        }
    }

    public void houseInfo(List<Room> rooms){
        for (Room room : rooms){
            if(room.getPeople() != null){
                System.out.println(room.getName() + " - " + room.getPeople().getName() + " sover här.");
            }else{
                System.out.println(room.getName() + " -  allmän plats.");
            }

        }
    }

    public void startSirenAlarm() {
        System.out.println("--------------------------------");
        leftSiren.startSirenAlarm();
        rightSiren.startSirenAlarm();
        System.out.println("--------------------------------");
    }

    public void stopSirenAlarm(){
        System.out.println("--------------------------------");
        leftSiren.stopSirenAlarm();
        rightSiren.stopSirenAlarm();
        System.out.println("--------------------------------");
    }

    public void deactivateSprinkler(){
        boolean sprinklerDeactive = false;
        for (Room room : rooms){
            for(Detector detector : room.getDetectors()){
                if(detector instanceof Smokedetector){
                Smokedetector smokeDetector = (Smokedetector) detector;
                Sprinkler sprinkler = smokeDetector.getSprinkler();
                if(sprinkler.isTriggered()) {
                    sprinkler.resetSprinkler();
                    sprinklerDeactive = true;
                    }
                }
            }
        }
        if (sprinklerDeactive){
            System.out.println("Alla aktiva sprinklers är nu avstängda.");
            System.out.println("--------------------------------");
            System.out.println();
        } else {
            System.out.println("Alla sprinklers är redan avslagna.");
            System.out.println("--------------------------------");
            System.out.println();
        }
    }

    public void simFire(){
        List<Room> smokeDetectorRooms = new ArrayList<>();

        for (Room room : rooms){
            for(Detector detector : room.getDetectors()){
                if(detector instanceof Smokedetector && detector.isActive() && !detector.isAlerting()){
                    smokeDetectorRooms.add(room);
                    break;
                }
            }
        }
        if (smokeDetectorRooms.isEmpty()){
            System.out.println("Det finns inget alarm kvar att larma...");
            return;
        }
        Random random = new Random();
        int roomIndex = random.nextInt(smokeDetectorRooms.size());
        Room selectedRoomIndex = smokeDetectorRooms.get(roomIndex);

        for (Detector detector : selectedRoomIndex.getDetectors()){
            if (detector instanceof Smokedetector && detector.isActive() && !detector.isAlerting()){
                detector.setAlerting(true);
                System.out.println();
                System.out.println("----------Rökdetektor----------");
                System.out.println(detector.getName() + " har aktiverats av rök.");
                detector.alertTrigger();
                Smokedetector smokeDetector = (Smokedetector) detector;
                smokeDetector.activateSprinkler(smokeDetector.getSprinkler());
            }
        }
    }

    public void simWindow(){
        List<Room> windowDetectorRooms = new ArrayList<>();

        for (Room room : rooms){
            for(Detector detector : room.getDetectors()){
                if(detector instanceof Windowdetector && detector.isActive() && !detector.isAlerting()){
                    windowDetectorRooms.add(room);
                    break;
                }
            }
        }
        if (windowDetectorRooms.isEmpty()){
            System.out.println("Det finns inget alarm kvar att larma...");
            return;
        }
        Random random = new Random();
        int roomIndex = random.nextInt(windowDetectorRooms.size());
        Room selectedRoomIndex = windowDetectorRooms.get(roomIndex);

        for (Detector detector : selectedRoomIndex.getDetectors()){
            if (detector instanceof Windowdetector && detector.isActive() && !detector.isAlerting()){
                detector.setAlerting(true);
                System.out.println();
                System.out.println("----------Fönsterdetektor----------");
                System.out.println(detector.getName() + " har aktiverats...");
                detector.alertTrigger();

            }
        }
    }

    public void simDoor(){
        List<Room> doorDetectorRooms = new ArrayList<>();

        for (Room room : rooms){
            for(Detector detector : room.getDetectors()){
                if(detector instanceof Doordetector && detector.isActive() && !detector.isAlerting()){
                    doorDetectorRooms.add(room);
                    break;
                }
            }
        }
        if (doorDetectorRooms.isEmpty()){
            System.out.println("Det finns inget alarm kvar att larma...");
            return;
        }
        Random random = new Random();
        int roomIndex = random.nextInt(doorDetectorRooms.size());
        Room selectedRoomIndex = doorDetectorRooms.get(roomIndex);

        for (Detector detector : selectedRoomIndex.getDetectors()){
            if (detector instanceof Doordetector && detector.isActive() && !detector.isAlerting()){
                detector.setAlerting(true);
                System.out.println();
                System.out.println("----------Dörrdetektor----------");
                System.out.println(detector.getName() + " har aktiverats...");
                detector.alertTrigger();

            }
        }
    }

    public void simMovement(){
        List<Room> movementDetectorRooms = new ArrayList<>();

        for (Room room : rooms){
            for(Detector detector : room.getDetectors()){
                if(detector instanceof Movmentdetector && detector.isActive() && !detector.isAlerting()){
                    movementDetectorRooms.add(room);
                    break;
                }
            }
        }
        if (movementDetectorRooms.isEmpty()){
            System.out.println("Det finns inget alarm kvar att larma...");
            return;
        }
        Random random = new Random();
        int roomIndex = random.nextInt(movementDetectorRooms.size());
        Room selectedRoomIndex = movementDetectorRooms.get(roomIndex);

        for (Detector detector : selectedRoomIndex.getDetectors()){
            if (detector instanceof Movmentdetector && detector.isActive() && !detector.isAlerting()){
                detector.setAlerting(true);
                System.out.println();
                System.out.println("----------Rörelsedetektor----------");
                System.out.println(detector.getName() + " har aktiverats...");
                detector.alertTrigger();

            }
        }
    }

    public void simPool(){
        Room poolArea = null;
        for (Room room : rooms){
            if(room.getName().equals("Trädgården")){
                poolArea = room;
                break;
            }
        }
        if(poolArea != null){
            for(Detector detector : poolArea.getDetectors()){
                if(!detector.isActive()){
                    System.out.println();
                    System.out.println("----------Trädgårdens-poolområde----------");
                    System.out.println("Larmet är inte aktivt se över över larm status...");
                } else if (detector.isAlerting()){
                    System.out.println();
                    System.out.println("----------Trädgårdens-poolområde----------");
                    System.out.println("Alarmet är redan aktiverat. se över larm status...");
                } else{
                    detector.setAlerting(true);
                    System.out.println();
                    System.out.println("----------Trädgårdens-poolområde----------");
                    detector.alertTrigger();
                    System.out.println(detector.getName() + " har aktiverats nån simmar i " + poolArea.getName() + "s pool!");
                }
            }
        }
    }

    public void simAll(){
        List<Detector> allDetectors = new ArrayList<>();
        for (Room room : rooms){
            for(Detector detector : room.getDetectors()){
                if(detector.isActive() && !detector.isAlerting()){
                    allDetectors.add(detector);
                }
            }
        }
        if(allDetectors.isEmpty()){
            System.out.println("Det finns inget alarm kvar att larma...");
            return;
        }
        Random random = new Random();
        int randomIndex = random.nextInt(allDetectors.size());
        Detector simedDetector = allDetectors.get(randomIndex);
        if(simedDetector instanceof Movmentdetector && simedDetector.getName().equals("Trädgård Rörelse detector")){
            simedDetector.setAlerting(true);
            System.out.println();
            System.out.println("----------Trädgårdens-poolområde----------");
            System.out.println(simedDetector.getName() + " har aktiverats av överdrivet mycket plask...");
            System.out.println("Någon verkar ha för roligt i poolen.");
            System.out.println("Eller har en inkräktare trillat i?");

        }else if(simedDetector instanceof Smokedetector){
            simedDetector.setAlerting(true);
            System.out.println();
            System.out.println("----------Rökdetektor----------");
            System.out.println(simedDetector.getName() + " har aktiverats av rök.");
            simedDetector.alertTrigger();
            Smokedetector smokeDetector = (Smokedetector) simedDetector;
            smokeDetector.activateSprinkler(smokeDetector.getSprinkler());
        } else if (simedDetector instanceof Windowdetector) {
            simedDetector.setAlerting(true);
            System.out.println();
            System.out.println("----------Fönsterdetektor----------");
            System.out.println(simedDetector.getName() + " har aktiverats...");
        } else if (simedDetector instanceof Doordetector) {
            simedDetector.setAlerting(true);
            System.out.println();
            System.out.println("----------Dörrdetektor----------");
            System.out.println(simedDetector.getName() + " har aktiverats...");
        }else if (simedDetector instanceof Movmentdetector){
            simedDetector.setAlerting(true);
            System.out.println();
            System.out.println("----------Rörelsedetektor----------");
            System.out.println(simedDetector.getName() + " har aktiverats...");
        }

    }

    public void simStatus(){
        boolean alarmActive = false;
        System.out.println("--------------Simulation-Status--------------");
        for (Room room : rooms){
            for (Detector detector : room.getDetectors()){
                if(detector.isAlerting()){
                    alarmActive = true;
                    System.out.println("Aktivt alarm i " + detector.getName() + " larmar!");

                    if(detector instanceof Smokedetector){
                        Smokedetector smokeDetector = (Smokedetector) detector;
                        if(smokeDetector.getSprinkler() != null && smokeDetector.getSprinkler().isTriggered()){
                            System.out.println("Sprinkler är aktiverat i " + room.getName() + ".");
                        }
                    }
                }
            }
        }
        if(!alarmActive){
            System.out.println("Inget att rapportera för tillfället...");
        }
    }


    public void showMenu(){
        Scanner scanner = new Scanner(System.in);
        while (isPowered){
            System.out.println("--------------Centralenhet--------------");
            System.out.println("1. Alarm interface.");
            System.out.println("2. Simulera brand/brott ");
            System.out.println("3. House Inf0");
            System.out.println("4. Stäng av centralenheten.");
            System.out.print("Välj ett alternativ: ");

            String menuChoice = scanner.nextLine();
            System.out.println();

            switch (menuChoice){
                case "1":
                    System.out.println("--------------Alarm-Interface--------------");
                    System.out.println("1. Aktivera Alarm.");
                    System.out.println("2. Avaktivera Alarm.");
                    System.out.println("3. Återställ Alarm.");
                    System.out.println("4. Stäng av Sirén.");
                    System.out.println("5. Stäng av Sprinkler.");
                    System.out.println("6. Keypad till dörrdetektor.");
                    System.out.println("7. Gå tillbaka.");
                    System.out.print("Välj ett alternativ: ");

                    String menuChoice1 = scanner.nextLine();
                    System.out.println();

                    switch (menuChoice1){
                        case "1":
                            activateAlarm();
                            break;
                        case "2":
                            deactivateAlarm();
                            break;
                        case "3":
                            System.out.println("Alla detectors larmar av, standby....");
                            System.out.println("------------------------------------------------------");
                            for(Detector detector : detectors){
                                detector.resetAlarm();
                            }
                            System.out.println();
                            System.out.println("Alla alarmen är nu återställda.");
                            System.out.println();
                            break;
                        case "4":
                            stopSirenAlarm();
                            System.out.println();
                            break;
                        case "5":
                            deactivateSprinkler();
                            break;
                        case "6":       // Keypad switch?
                            System.out.println("--------------Keypad--------------");
                            System.out.println("1. Alarm Switch.");
                            System.out.println("2. Alarm On.");
                            System.out.println("3. Alarm Off.");
                            System.out.println("4. Gå tillbaka.");
                            System.out.print("Välj ett alternativ: ");

                            String menuChoice3 = scanner.nextLine();
                            System.out.println();
                                switch (menuChoice3){
                                    case "1":
                                        for(Detector detector : detectors){
                                            if(detector instanceof Doordetector){
                                                detector.alarmSwitch();
                                            }
                                        }
                                        break;
                                    case "2":
                                        for(Detector detector : detectors){
                                            if(detector instanceof Doordetector){
                                                detector.alarmOn();
                                            }
                                        }
                                        break;
                                    case "3":
                                        for(Detector detector : detectors){
                                            if(detector instanceof Doordetector){
                                                detector.alarmOff();
                                            }
                                        }
                                        break;
                                    case "4": // Gå tillbaka
                                        break;
                                    default:
                                        System.out.println("Ogiltigt val, försök igen.");
                                }

                            break;
                        case "7":        // gå tillbaka.
                            break;
                        default:
                            System.out.println("Ogiltigt val, försök igen.");
                    }
                    break;

                case "2":   // Brand/brott
                    System.out.println("--------------Simulation-Interface--------------");
                    System.out.println("1. Simulera Brand.");
                    System.out.println("2. Simulera Inbrott via fönster.");
                    System.out.println("3. Simulera Inbrott via dörr.");
                    System.out.println("4. Simulera Rörelse.");
                    System.out.println("5. Simulera Rörelse vid poolområdet.");
                    System.out.println("6. Simulera alla.");
                    System.out.println("7. Status av simulation.");
                    System.out.println("8. Gå tillbaka.");
                    System.out.print("Välj ett alternativ: ");

                    String menuChoice2 = scanner.nextLine();
                    System.out.println();

                        switch (menuChoice2){
                            case "1":
                                startSirenAlarm();
                                simFire();
                                System.out.println("--------------------------------");
                                System.out.println();
                                break;

                            case "2":
                                startSirenAlarm();
                                simWindow();
                                System.out.println("--------------------------------");
                                System.out.println();
                                break;

                            case "3":
                                startSirenAlarm();
                                simDoor();
                                System.out.println("--------------------------------");
                                System.out.println();
                                break;

                            case "4":
                                startSirenAlarm();
                                simMovement();
                                System.out.println("--------------------------------");
                                System.out.println();
                                break;

                            case "5":
                                startSirenAlarm();
                                simPool();
                                System.out.println("--------------------------------");
                                System.out.println();
                                break;

                            case "6":
                                startSirenAlarm();
                                simAll();
                                System.out.println("--------------------------------");
                                System.out.println();
                                break;

                            case "7":
                                simStatus();
                                System.out.println("---------------------------------------------");
                                System.out.println();
                                break;

                            case "8": // Gå tillbaka.
                                break;

                            default:
                                System.out.println("Ogiltigt val, försök igen.");
                        }

                    break;

                case "3":
                    System.out.println("--------------House-Inf0--------------");
                    System.out.println("Summering av huset och boende: ");
                    houseInfo(rooms);
                    System.out.println();
                    break;

                case "4":
                    System.out.println("Programmet avslutas..");
                    isPowered = false;
                    break;

                default:
                    System.out.println("Ogiltigt val, försök igen.");
            }
        }
    }

    //------------------------------------Getter/Setter----------------------------------------------------------//

    public ArrayList<Detector> getDetectors() {
        return detectors;
    }

    public void setDetectors(ArrayList<Detector> detectors) {
        this.detectors = detectors;
    }

    public boolean isPowered() {
        return isPowered;
    }

    public void setPowered(boolean powered) {
        isPowered = powered;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public void setRooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }

    public Siren getLeftSiren() {
        return leftSiren;
    }

    public void setLeftSiren(Siren leftSiren) {
        this.leftSiren = leftSiren;
    }

    public Siren getRightSiren() {
        return rightSiren;
    }

    public void setRightSiren(Siren rightSiren) {
        this.rightSiren = rightSiren;
    }
}
