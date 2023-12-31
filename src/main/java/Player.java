import java.util.ArrayList;

public class Player {

    private Room currentRoom;
    private int health;
    private Weapon equippedWeapon;

    private ArrayList<Item> inventory = new ArrayList<>();

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room room) {
        currentRoom = room;
    }

    public void move(String direction) {

        Room nextRoom = switch (direction) {
            case "north" -> currentRoom.getGoNorth();
            case "east" -> currentRoom.getGoEast();
            case "south" -> currentRoom.getGoSouth();
            case "west" -> currentRoom.getGoWest();
            default -> null;
        };

        if (nextRoom != null) {
            currentRoom = nextRoom;
        } else {
            System.out.print("You can't go that way. Try again. ");
        }
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public void takeItem(Item item) {
        inventory.add(item);
    }

    public void dropItem(Item item) {
        inventory.remove(item);
    }

    public Item findItem(String itemName) {
        for (Item item : inventory) {
            if (item.getItemName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null;
    }
    public int getHealth() {
         return health;
    }
    public void setHealth(int newHealth) {
        health = newHealth;
    }
    public void eat(String whatToEat) {
    }

    public Weapon getEquippedWeapon() {
        return equippedWeapon;
    }

    public void setEquippedWeapon(Weapon weaponToEquip) {
        this.equippedWeapon = weaponToEquip;
    }

    public String attack(Enemy enemy) {
        if (equippedWeapon != null) {
            return equippedWeapon.attack() + " at " + enemy.getName();
        } else {
            return "You have no weapon equipped.";
        }
    }
    public void takeDamage(int damage) {
        // Reduce player's health by the specified damage amount
        health -= damage;

        }
}