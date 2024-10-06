import java.util.ArrayList;
import java.util.List;

public class Room {
    private String name; // rummets namn t.ex bedroom
    private int window; // hur många fönster 1,2,3 osv
    private People people;
    private List<Detector> detectors;

    public Room() {
        this.detectors = new ArrayList<>();
    }

    public Room(String name) {
        this.name = name;
        this.detectors = new ArrayList<>();
    }

    public Room(String name, int window) {
        this.name = name;
        this.window = window;
        this.detectors = new ArrayList<>();
    }

    public Room(String name, int window, People people) {
        this.name = name;
        this.window = window;
        this.people = people;
        this.detectors = new ArrayList<>();
    }

    public void addRoomDetector(Detector detector){
        detectors.add(detector);
    }

    //------------------------------------Getter/Setter----------------------------------------------------------//

    public int getWindow() {
        return window;
    }

    public void setWindow(int window) {
        this.window = window;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public People getPeople() {
        return people;
    }

    public void setPeople(People people) {
        this.people = people;
    }

    public List<Detector> getDetectors() {
        return detectors;
    }

    public void setDetectors(List<Detector> detectors) {
        this.detectors = detectors;
    }
}
