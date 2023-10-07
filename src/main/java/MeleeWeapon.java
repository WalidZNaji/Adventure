public class MeleeWeapon extends Weapon {

    public MeleeWeapon (String itemName, String description, String isWeaponEquipped) {
        super(itemName, description, isWeaponEquipped);
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
