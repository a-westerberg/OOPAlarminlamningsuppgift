public class Windowdetector extends Detector implements DetectorInterface{

    public Windowdetector() {
    }

    public Windowdetector(String name, boolean isActive, boolean isAlerting) {
        super(name, isActive, isAlerting);
    }

    @Override
    public void alertTrigger() {
        if(!isActive()){
            System.out.println("Alarmet är avstängt, och ingen åtgärd vidtas.");
            return;
        }
        if (isAlerting()) {
            System.out.println("Någon försöker bryta sig in genom fönstret!!!");
        } else {
            System.out.println("Alla fönster är intakt, inget att rapportera.");
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
