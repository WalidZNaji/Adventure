public class Enemy {

    private String name;
    private String description;
    private int health;
    private Weapon equippedWeapon;
    private int damage;
    public Enemy(String name, String description, int health, int damage) {
        this.name = name;
        this.description = description;
        this.health = health;
        this.equippedWeapon = null;
        this.damage = damage;
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

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setEquippedWeapon(Weapon weapon) {
        this.equippedWeapon = equippedWeapon;
    }

    public Weapon getEquippedWeapon() {
        return equippedWeapon;
    }

    public int attack() {
        return damage;
    }
    public void takeDamage(int damage) {
        health -= damage;

    }
    public boolean isDefeated() {
        return health <= 0;
    }
}
