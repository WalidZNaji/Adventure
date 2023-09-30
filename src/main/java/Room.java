import java.util.ArrayList;

public class Room {

    private String name;
    private String description;
    private Room goNorth;
    private Room goSouth;
    private Room goEast;
    private Room goWest;
    private ArrayList<Item> itemList;

    public Room(String name, String description, ArrayList<Item> itemList) {
        this.name = name;
        this.description = description;
        this.itemList = itemList;
    }

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Room getGoNorth() {
        return goNorth;
    }

    public void setGoNorth(Room goNorth) {
        this.goNorth = goNorth;
    }

    public Room getGoSouth() {
        return goSouth;
    }

    public void setGoSouth(Room goSouth) {
        this.goSouth = goSouth;
    }

    public Room getGoEast() {
        return goEast;
    }

    public void setGoEast(Room goEast) {
        this.goEast = goEast;
    }

    public Room getGoWest() {
        return goWest;
    }

    public void setGoWest(Room goWest) {
        this.goWest = goWest;
    }

    public String toString() {
        return name;
    }
}
