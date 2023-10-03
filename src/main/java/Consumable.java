public class Consumable extends Item {

    private int health;

    public Consumable(String itemName, String itemDescription, int health) {
        super(itemName, itemDescription);
        this.health = health;

    }


    public int getHealth() {
        return health;
    }


}
