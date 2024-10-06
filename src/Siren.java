public class Siren {
    private String name;
    private boolean isRinging;

    public Siren() {
    }

    public Siren(String name, boolean isRinging) {
        this.name = name;
        this.isRinging = isRinging;
    }

    public void startSirenAlarm(){
        if(!isRinging){
            isRinging = true;
            System.out.println("Varning! " + name + " Larmar!!!");
        } else {
            System.out.println("Varning! " + name + " Larmar redan!!!");
        }
    }

    public void stopSirenAlarm(){
        if(isRinging){
            isRinging = false;
            System.out.println(name + " stängs av.");
        } else {
            System.out.println(name + " är redan avstängd.");
        }
    }


    //------------------------------------Getter/Setter----------------------------------------------------------//

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isRinging() {
        return isRinging;
    }

    public void setRinging(boolean ringing) {
        isRinging = ringing;
    }
}
