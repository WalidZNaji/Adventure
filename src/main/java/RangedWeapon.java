public class RangedWeapon extends Weapon {

    public RangedWeapon(String name, String description, String isWeaponEquipped) {
        super(name, description, isWeaponEquipped);
    }

@Override
    public String attack() {
        return getItemName() + " is shooting";
}

@Override
    public String equipWeapon(String weaponToEquip) {
        return weaponToEquip + " is equipped";
}

}

