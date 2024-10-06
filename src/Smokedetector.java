public class Smokedetector extends Detector implements DetectorInterface{
    private Sprinkler sprinkler;


    String fire = "\uD83D\uDD25";

    public Smokedetector() {
        super();
    }

    public Smokedetector(String name, boolean isActive, boolean isAlerting, Sprinkler sprinkler ) {
        super(name, isActive, isAlerting);
        this.sprinkler = sprinkler;

    }

    @Override
    public void alertTrigger() {
        if (isAlerting()) {
            System.out.println("Det brinner!!! Det är rök överallt!" + fire + fire + fire);
        } else {
            System.out.println("Ingen brand upptäckt i rummet.");
        }
    }

    public void activateSprinkler(Sprinkler sprinkler){
        if (isActive() && isAlerting()){
            sprinkler.setTriggered(true);
            System.out.println("Sprinkler aktiveras....");
            System.out.println(sprinkler.getName() + " är aktiverad och elden släcks");
        } else {
            System.out.println("Sprinklern kan inte aktiveras....");
            System.out.println("Check alarm status...");
        }
    }

    @Override
    public void resetAlarm() {
        setActive(true);
        setAlerting(false);
        System.out.println(getName() + " larmar av");

        if(getSprinkler() != null)  {
            getSprinkler().resetSprinkler();
        }
    }
    //------------------------------------Getter/Setter----------------------------------------------------------//
    @Override
    public boolean isActive() {
        return super.isActive();
    }

    @Override
    public void setActive(boolean active) {
        super.setActive(active);
    }

    @Override
    public boolean isAlerting() {
        return super.isAlerting();
    }

    @Override
    public void setAlerting(boolean alerting) {
        super.setAlerting(alerting);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    public Sprinkler getSprinkler() {
        return sprinkler;
    }

    public void setSprinkler(Sprinkler sprinkler) {
        this.sprinkler = sprinkler;
    }
}
