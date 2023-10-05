public abstract class Weapon extends Item {

    private String isWeaponEquipped;

    public Weapon(String itemName, String itemDescription, String isWeaponEquipped) {
        super(itemName, itemDescription);
        this.isWeaponEquipped = isWeaponEquipped;

    }
    public String getIsWeaponEquipped() {
        return isWeaponEquipped;
    }

    public void setIsWeaponEquipped(String isWeaponEquipped) {
        this.isWeaponEquipped = isWeaponEquipped;
    }

    public abstract String attack();

    public abstract String equipWeapon(String weaponToEquip);

}
