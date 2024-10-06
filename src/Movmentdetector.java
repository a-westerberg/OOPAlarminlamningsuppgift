public class Movmentdetector extends Detector implements DetectorInterface{

    public Movmentdetector() {
    }

    public Movmentdetector(String name, boolean isActive, boolean isAlerting) {
        super(name, isActive, isAlerting);
    }

    @Override
    public void alertTrigger() {
        if(!isActive()){
            System.out.println("Alarmet är avstängt, och ingen åtgärd vidtas.");
            return;
        }
        if (isAlerting()) {
            System.out.println("Rörelsealarmet känner av rörelse!!!");
        } else {
            System.out.println("Rörelsealarmet har inget att rapportera.");
        }
    }

    @Override
    public void resetAlarm() {
        setActive(false);
        setAlerting(false);
        System.out.println(getName() + " stängs av och startar om igen...");
        setActive(true);
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
}
