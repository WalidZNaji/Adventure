public class RangedWeapon extends Weapon {

    private int ammunition = 10;

    public RangedWeapon(String name, String description, String isWeaponEquipped, int damage, int rangedAmm) {
        super(name, description, isWeaponEquipped, damage);
        this.ammunition = rangedAmm;
    }

@Override
    public String attack() {
        return getItemName() + " is shooting";
}

@Override
    public String equipWeapon(String weaponToEquip) {
        return weaponToEquip + " is equipped";
}

    public int getAmmunition() {
        return ammunition;
}

    public void setAmmunition(int newAmm) {
        ammunition = newAmm;
    }

    public String decrementAmmunition() {
        if (ammunition > 0) {
            ammunition--;
            return "Ammo: " + getAmmunition();
        }
        else return "Out of ammo.";
    }

}

