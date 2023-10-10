import java.util.ArrayList;

public class Room {

    private String name;
    private String description;
    private Room goNorth;
    private Room goSouth;
    private Room goEast;
    private Room goWest;
    private ArrayList<Item> itemList;
    private ArrayList<Enemy> enemyList;

    public Room(String name, String description, ArrayList<Item> itemList, ArrayList<Enemy> enemyList) {
        this.name = name;
        this.description = description;
        this.itemList = itemList != null ? itemList : new ArrayList<>();
        this.enemyList = enemyList != null ? enemyList : new ArrayList<>();
    }
    public Room(String name, String description, ArrayList<Item> itemList) {
        this.name = name;
        this.description = description;
        this.itemList = itemList != null ? itemList : new ArrayList<>();
        this.enemyList = new ArrayList<>();
    }

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        this.itemList = new ArrayList<>();
        this.enemyList = new ArrayList<>();
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

    // methods for items

    public ArrayList<Item> getItemList() {
        return itemList;
    }

    public void addItem(Item item) {
        itemList.add(item);
    }

    public void removeItem(Item item) {
        itemList.remove(item);
    }

    public ArrayList<Enemy> getEnemyList() {
        return enemyList;
    }

    public void addEnemy(Enemy enemy) {
        enemyList.add(enemy);
    }

    public void removeEnemy(Enemy enemy) {
        enemyList.remove(enemy);
    }




}
