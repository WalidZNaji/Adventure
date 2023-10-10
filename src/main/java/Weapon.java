public abstract class Weapon extends Item {

    private String isWeaponEquipped;
    private int damage;

    public Weapon(String itemName, String itemDescription, String isWeaponEquipped, int damage) {
        super(itemName, itemDescription);
        this.isWeaponEquipped = isWeaponEquipped;
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }
    public String getIsWeaponEquipped() {
        return isWeaponEquipped;
    }

    public void setIsWeaponEquipped(String isWeaponEquipped) {
        this.isWeaponEquipped = isWeaponEquipped;
    }

    public String toString() {
        return getItemName();
    }

    public abstract String attack();

    public abstract String equipWeapon(String weaponToEquip);

}
