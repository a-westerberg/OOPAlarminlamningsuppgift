public class Sprinkler {
    private String name;
    private boolean isTriggered;

    public Sprinkler() {
    }

    public Sprinkler(String name, boolean isTriggered) {
        this.name = name;
        this.isTriggered = isTriggered;
    }

    public void resetSprinkler(){
        isTriggered = false;
        System.out.println(name + " är nu avstängt.");
    }

    //------------------------------------Getter/Setter----------------------------------------------------------//

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isTriggered() {
        return isTriggered;
    }

    public void setTriggered(boolean triggered) {
        isTriggered = triggered;
    }
}
