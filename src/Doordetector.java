public class Doordetector extends Detector implements DetectorInterface, Keypad{

    public Doordetector() {
    }

    public Doordetector(String name, boolean isActive, boolean isAlerting) {
        super(name, isActive, isAlerting);
    }

    @Override
    public void alertTrigger() {
        if(!isActive()){
            System.out.println("Alarmet är avstängt, och ingen åtgärd vidtas.");
            return;
        }
        if (isAlerting()) {
            System.out.println("Någon har sparkat in dörren!!!");
        } else {
            System.out.println("Dörren är intakt, inget att rapportera.");
        }
    }

    @Override
    public void resetAlarm() {
        setActive(false);
        setAlerting(false);
        System.out.println(getName() + " stängs av och startar om igen...");
        setActive(true);
    }

    @Override
    public void alarmSwitch() {
        if(isActive()){
            setActive(false);
            System.out.println(getName() + "  är nu avaktiverat.");
        }else {
            setActive(true);
            System.out.println(getName() + " är nu aktiverat.");
        }
    }

    @Override
    public void alarmOn() {
        if(isActive()){
            System.out.println(getName() + " är redan påslaget.");
        }else{
            setActive(true);
            System.out.println(getName() + " startar.....");
        }
    }

    @Override
    public void alarmOff() {
        if(!isActive()){
            System.out.println(getName() + " är redan avslaget.");
        }else{
            setActive(false);
            System.out.println(getName() + " stänger av.....");
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
}
