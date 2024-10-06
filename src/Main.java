import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

    //------------------------------------Central unit----------------------------------------------//
        Centralunit centralunit = new Centralunit();

    //-----------------------------------------------Siren------------------------------------------//
        Siren leftSiren = new Siren("Left Sirén", false);
        Siren rightSiren = new Siren("Right Sirén",false);

        centralunit.setLeftSiren(leftSiren);
        centralunit.setRightSiren(rightSiren);

    //------------------------------------Personerna som bor i huset-------------------------------//
    People jared = new People("Jared");
    People elich = new People("Erlich Bachman");
    People jian = new People("Jian Yang");
    People richard = new People("Richard Hendricks");
    People bertram = new People("Bertram Gilfoyle");
    People dinesh = new People("Dinesh Chugtai");

    //------------------------------------Rummen i huset------------------------------------------//
    Room garage = new Room("Garage", 1, jared);
    Room vardagsrum = new Room("Vardagsrum", 2);
    Room kök = new Room("Kök", 1);
    Room sovrum1 = new Room("Sovrum1", 2, elich);
    Room sovrum2 = new Room("Sovrum2", 1, jian);
    Room sovrum3 = new Room("Sovrum3", 1, richard);
    Room sovrum4 = new Room("Sovrum4", 2, bertram);
    Room sovrum5 = new Room("Sovrum5", 1, dinesh);
    Room hallen = new Room("Hallen", 1);
    Room trädgården = new Room("Trädgården");  // inte ett rum i know men vet ej vad jag ska döpa

    //------------------------------------Sprinkler----------------------------------------------------------//
    Sprinkler garageSprinkler = new Sprinkler("Garage Sprinkler", false);
    Sprinkler vardagsrumSprinkler = new Sprinkler("Vardagsrum Sprinkler", false);
    Sprinkler kökSprinkler = new Sprinkler("Köks Sprinkler", false);
    Sprinkler sovrum1Sprinkler = new Sprinkler("Sovrum1 Sprinkler", false);
    Sprinkler sovrum2Sprinkler = new Sprinkler("Sovrum2 Sprinkler", false);
    Sprinkler sovrum3Sprinkler = new Sprinkler("Sovrum3 Sprinkler", false);
    Sprinkler sovrum4Sprinkler = new Sprinkler("Sovrum4 Sprinkler", false);
    Sprinkler sovrum5Sprinkler = new Sprinkler("Sovrum5 Sprinkler", false);
    Sprinkler hallenSprinkler = new Sprinkler("Hallen Sprinkler", false);

    //------------------------------------Rök Detector i huset---------------------------------------//
    Detector garageSmoke = new Smokedetector("Garage Rökdetektor",true,false,garageSprinkler);
    Detector vardagsrumSmoke = new Smokedetector("Vardagsrum Rökdetektor",true, false,vardagsrumSprinkler);
    Detector kökSmoke = new Smokedetector("Köks Rökdetektor",true, false,kökSprinkler);
    Detector sovrum1Smoke = new Smokedetector("Sovrum1 Rökdetektor",true, false,sovrum1Sprinkler);
    Detector sovrum2Smoke = new Smokedetector("Sovrum2 Rökdetektor",true, false,sovrum2Sprinkler);
    Detector sovrum3Smoke = new Smokedetector("Sovrum3 Rökdetektor",true, false,sovrum3Sprinkler);
    Detector sovrum4Smoke = new Smokedetector("Sovrum4 Rökdetektor",true, false,sovrum4Sprinkler);
    Detector sovrum5Smoke = new Smokedetector("Sovrum5 Rökdetektor",true, false,sovrum5Sprinkler);
    Detector hallenSmoke = new Smokedetector("Hallen Rökdetektor",true, false,hallenSprinkler);

    //------------------------------------Fönster detector-----------------------------------------------------------//
    Detector garageWindow = new Windowdetector("Garage Fönsterdetektor ", true, false);
    Detector vardagsrumWindow = new Windowdetector("Vardagsrum Fönsterdetektor ", true, false);
    Detector vardagsrumWindow2 = new Windowdetector("Vardagsrum Fönsterdetektor2 ", true, false);
    Detector kökWindow = new Windowdetector("Köks Fönsterdetektor", true, false);
    Detector sovrum1Window1 = new Windowdetector("Sovrum1 Fönsterdetektor1", true, false);
    Detector sovrum1Window2 = new Windowdetector("Sovrum1 Fönsterdetektor2", true, false);
    Detector sovrum2Window = new Windowdetector("Sovrum2 Fönsterdetektor", true, false);
    Detector sovrum3Window = new Windowdetector("Sovrum3 Fönsterdetektor", true, false);
    Detector sovrum4Window1 = new Windowdetector("Sovrum4 Fönsterdetektor1", true, false);
    Detector sovrum4Window2 = new Windowdetector("Sovrum4 Fönsterdetektor2", true, false);
    Detector sovrum5Window = new Windowdetector("Sovrum5 Fönsterdetektor", true, false);
    Detector hallenWindow = new Windowdetector("Hallen Fönsterdetektor", true, false);

    //------------------------------------Dörr detector-----------------------------------------------------------//
    Detector garageDoor = new Doordetector("Garage Dörrdetektor", true, false);
    Detector vardagsrumDoor = new Doordetector("Vardagsrum Dörrdetektor", true, false);
    Detector hallenDoor = new Doordetector("Hallen Dörrdetektor", true, false);
    Detector sovrum2Door = new Doordetector("Sovrum2 Dörrdetektor", true, false);

    //------------------------------------Rörelse detector-----------------------------------------------------------//
    Detector vardagsrumMovement = new Movmentdetector("Vardagsrum Rörelse detector", true, false);
    Detector hallenMovement = new Movmentdetector("Hallen Rörelse detector", true, false);
    Detector trädgårdMovement = new Movmentdetector("Trädgård Rörelse detector", true, false);

    List<Room> rooms = Arrays.asList(garage, vardagsrum, kök,sovrum1,sovrum2,sovrum3,sovrum4,sovrum5,hallen,trädgården);

    for(Room room : rooms){
        centralunit.addRoom(room);
    }

    List<Detector> detectors = Arrays.asList(garageSmoke,vardagsrumSmoke,kökSmoke,sovrum1Smoke,sovrum2Smoke,sovrum3Smoke,sovrum4Smoke,sovrum5Smoke,hallenSmoke,garageWindow,vardagsrumWindow,vardagsrumWindow2,
    kökWindow,sovrum1Window1,sovrum1Window2,sovrum2Window,sovrum3Window,sovrum4Window1,sovrum4Window2,sovrum5Window,hallenWindow,garageDoor,vardagsrumDoor,hallenDoor,sovrum2Door,vardagsrumMovement,hallenMovement,trädgårdMovement);

    for(Detector detector : detectors){
        centralunit.addDetector(detector);
    }
    // //------------------------------------Respektive-detektorer-till-sina-rum-----------------------------------------------------------//
    // Garage
    garage.addRoomDetector(garageSmoke);    garage.addRoomDetector(garageWindow);   garage.addRoomDetector(garageDoor);
    // Vardagsrum
    vardagsrum.addRoomDetector(vardagsrumSmoke);    vardagsrum.addRoomDetector(vardagsrumWindow);   vardagsrum.addRoomDetector(vardagsrumWindow2);  vardagsrum.addRoomDetector(vardagsrumDoor); vardagsrum.addRoomDetector(vardagsrumMovement);
    // Kök
    kök.addRoomDetector(kökSmoke);  kök.addRoomDetector(kökWindow);
    // Sovrum 1 - 5
    sovrum1.addRoomDetector(sovrum1Smoke);  sovrum1.addRoomDetector(sovrum1Window1);    sovrum1.addRoomDetector(sovrum1Window2);
    sovrum2.addRoomDetector(sovrum2Smoke);  sovrum2.addRoomDetector(sovrum2Window);     sovrum2.addRoomDetector(sovrum2Door);
    sovrum3.addRoomDetector(sovrum3Smoke);  sovrum3.addRoomDetector(sovrum3Window);
    sovrum4.addRoomDetector(sovrum4Smoke);  sovrum4.addRoomDetector(sovrum4Window1);    sovrum4.addRoomDetector(sovrum4Window2);
    sovrum5.addRoomDetector(sovrum5Smoke);  sovrum5.addRoomDetector(sovrum5Window);
    // Hallen
    hallen.addRoomDetector(hallenSmoke);    hallen.addRoomDetector(hallenWindow);       hallen.addRoomDetector(hallenDoor);     hallen.addRoomDetector(hallenMovement);
    // Trädgård
    trädgården.addRoomDetector(trädgårdMovement);


    centralunit.setPowered(true);
    centralunit.showMenu();


    }
}