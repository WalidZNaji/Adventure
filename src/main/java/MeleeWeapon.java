public class MeleeWeapon extends Weapon {

    public MeleeWeapon (String itemName, String description, String isWeaponEquipped, int damage) {
        super(itemName, description, isWeaponEquipped, damage);
    }

    @Override
    public String attack() {
        return "you are attacking with " + getItemName();
    }

    @Override
    public String equipWeapon(String weaponToEquip) {
        return null;
    }

}
