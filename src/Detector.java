public abstract class Detector implements DetectorInterface, Keypad {
    private boolean isActive;
    private boolean isAlerting;
    private String name;

    public Detector() {
    }

    public Detector(String name, boolean isActive, boolean isAlerting) {
        this.name = name;
        this.isActive = isActive;
        this.isAlerting = isAlerting;
    }

    @Override
    public void alertTrigger() {    //<- interface
        DetectorInterface.super.alertTrigger();
    }

    @Override
    public void resetAlarm() {
        DetectorInterface.super.resetAlarm();
    }

    @Override
    public void alarmSwitch() {
        Keypad.super.alarmSwitch();
    }

    @Override
    public void alarmOn() {
        Keypad.super.alarmOn();
    }

    @Override
    public void alarmOff() {
        Keypad.super.alarmOff();
    }

    //------------------------------------Getter/Setter----------------------------------------------------------//

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isAlerting() {
        return isAlerting;
    }

    public void setAlerting(boolean alerting) {
        isAlerting = alerting;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
