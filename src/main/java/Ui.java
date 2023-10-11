import java.util.ArrayList;
import java.util.Scanner;


// TODO Fix commands. Take etc. followed by name instead of take 'enter' then name.
// TODO fix only being able to drop from inv.
// TODO Fix ranged weapon still shooting after exceeding mag capacity.
// TODO make enemy drop weapon when killed.


public class Ui {

    private static Adventure adventure;

    public Ui(Adventure adventure) {
        Ui.adventure = adventure;
    }

    public void startProgram() {

        Scanner scan = new Scanner(System.in);
        Player player = adventure.getPlayer();
        Enemy enemy = adventure.getEnemy();

        printStartMessage();

        printRoomInfo();

        player.setHealth(50); // Start health.

        String input;

        while (true) {

            input = scan.nextLine();

            switch (input) {
                case "go north", "go n" -> {
                    adventure.move("north");
                    printRoomInfo();
                }
                case "go south", "go s" -> {
                    adventure.move("south");
                    printRoomInfo();
                }
                case "go east", "go e" -> {
                    adventure.move("east");
                    printRoomInfo();
                }
                case "go west", "go w" -> {
                    adventure.move("west");
                    printRoomInfo();
                }
                case "look" -> printDescription();

                case "help" -> printHelp();
                case "take" -> {
                    System.out.println("What would you like to pick up?");
                    String itemName = scan.next();
                    takeItem(itemName);
                }
                case "drop" -> {
                    System.out.println("What would you like to drop?");
                    String itemName = scan.nextLine();
                    dropItem(itemName);
                }
                case "inventory", "inv" -> showInventory();

                case "health" -> System.out.println("Current health: " + player.getHealth());
                case "eat" -> {
                    System.out.println("what would you like to eat? ");
                    String whatToEat = scan.next();
                    eat(whatToEat, adventure.getCurrentRoom());
                }
                case "equip" -> {
                    System.out.println("what would you like to equip? ");
                    String weaponToEquip = scan.next();
                    equipWeapon(weaponToEquip);
                }
                case "attack" -> {
                    System.out.println("Who would you like to attack?");
                    String target = scan.next();
                    attack(target);
                }
                case "exit" -> {
                    System.out.println("Game has been quit. Thank you for playing");
                    return;

                }
            }
        }
    }

    public static void printStartMessage() {
        System.out.println("\nWelcome to The Adventure!\n");

        System.out.println("""
                The Adventure consists of 9 different rooms.
                All the rooms are different. Have a look around.
                See if you can find room 5..
                """);

        System.out.println("""
                You are able to move around by typing "go north/south/east/west" or "go n/s/e/w"
                If you need anything type "help"
                """);
    }

    public static void printRoomInfo() {

        Room currentRoom = adventure.getCurrentRoom();
        ArrayList<Enemy> enemiesInRoom = currentRoom.getEnemyList();

        System.out.println("Currently you're in " + currentRoom);
        System.out.println(currentRoom.getDescription());

        ArrayList<Item> itemsInRoom = currentRoom.getItemList();

        if (itemsInRoom != null && !itemsInRoom.isEmpty()) {
            System.out.println("Items in this room: ");
            for (Item item : itemsInRoom) {
                System.out.println(item.getItemName() + ", " + item.getItemDescription());
            }
        }
        if (enemiesInRoom != null && !enemiesInRoom.isEmpty()) {
            System.out.println("Enemies: ");
            for (Enemy enemy : enemiesInRoom) {
                System.out.println(enemy.getName() + ", " + enemy.getDescription() + ", health: " + enemy.getHealth());
            }
        }


        System.out.print("\nWhat would you like to do: ");
    }

    public static void printHelp() {
        System.out.println("Available commands:");
        System.out.println("go north/ go n - Move to the room to the north.");
        System.out.println("go east/ go e - Move to the room to the east.");
        System.out.println("go south/ go s - Move to the room to the south.");
        System.out.println("go west/ go w - Move to the room to the west.");
        System.out.println("look - Show description of current room.");
        System.out.println("help - Show this help message.");
        System.out.println("inventory - Show your inventory.");
        System.out.println("eat - eat food from inventory");
        System.out.println("\"take\"  - Pick up item ");
        System.out.println("\"drop\" - drop item ");
        System.out.println("equip - equip weapon");
        System.out.println("attack - attacks using currently equipped weapon");
        System.out.println("health - Show current health");
        System.out.println("exit - Quit the game.");
    }

    public static void printDescription() {

        Room currentRoom = adventure.getCurrentRoom();
        ArrayList<Item> itemsInRoom = currentRoom.getItemList();
        ArrayList<Enemy> enemiesInRoom = currentRoom.getEnemyList();


        System.out.println(currentRoom.getDescription());

        if (itemsInRoom != null && !itemsInRoom.isEmpty()) {
            System.out.println("Items in this room: ");
            for (Item item : itemsInRoom) {
                System.out.println(item.getItemName() + ", " + item.getItemDescription());
            }
        }
        if (enemiesInRoom != null && !enemiesInRoom.isEmpty()) {
            System.out.println("Enemies: ");
            for (Enemy enemy : enemiesInRoom) {
                System.out.println(enemy.getName() + ", " + enemy.getDescription() + ", health: " + enemy.getHealth());
            }
        }
    }

    public void takeItem(String input) {
        String itemName = input.substring(input.indexOf(" ") + 1).trim();
        Player player = adventure.getPlayer();
        Room currentRoom = adventure.getCurrentRoom();
        Item itemToTake = null;

        for (Item item : currentRoom.getItemList()) {
            if (item.getItemName().equalsIgnoreCase(itemName)) {
                itemToTake = item;
                break;
            }
        }

        if (itemToTake != null) {
            currentRoom.removeItem(itemToTake);
            player.takeItem(itemToTake);
            System.out.println("You have picked up the " + itemToTake.getItemName() + ".");
        } else {
            System.out.println("There is nothing like " + itemName + " to pick up around here.");
        }
    }

    public void dropItem(String itemName) {
        Player player = adventure.getPlayer();
        Room currentRoom = adventure.getCurrentRoom();
        Item item = player.findItem(itemName);
        ArrayList<Item> inventory = player.getInventory();

        if (item != null) {
            if (item.equals(player.getEquippedWeapon())) {
                player.setEquippedWeapon(null);// drop 'item' into inv.
                inventory.add(item);
            }


            player.dropItem(item); // drop if in inv
            currentRoom.addItem(item);
            System.out.println("You have dropped " + item.getItemName());
        } else System.out.println("There is nothing like " + itemName + " in your inventory");
    }

    public void showInventory() {
        Player player = adventure.getPlayer();
        ArrayList<Item> inventory = player.getInventory();
        Weapon equippedWeapon = player.getEquippedWeapon();

        if (inventory.isEmpty()) {
            System.out.println("Your inventory is empty.");
        } else
            System.out.println("Inventory: ");
        for (Item item : inventory) {
            System.out.println(item.getItemName() + " " + item.getItemDescription());
        }

        if (equippedWeapon != null) {
            System.out.println("Equipped weapon: " + equippedWeapon);
        } else
            System.out.println("No equipped weapon.");
    }

    public void eat(String whatToEat, Room currentRoom) {
        Player player = adventure.getPlayer();

        // Check if the item is in the player's inventory
        Item itemInInventory = player.findItem(whatToEat);

        // Check if the item is in the current room
        Item itemInRoom = null;
        for (Item item : currentRoom.getItemList()) {
            if (item.getItemName().equalsIgnoreCase(whatToEat)) {
                itemInRoom = item;
                break;
            }
        }

        if (itemInInventory != null || itemInRoom != null) {
            // Determine which item to eat (from inventory or room)
            Item itemToEat = (itemInInventory != null) ? itemInInventory : itemInRoom;

            if (itemToEat instanceof Food food) {
                player.setHealth(food.getHealth() + player.getHealth());
                System.out.println("You have eaten " + whatToEat + " health increased to " + player.getHealth());

                // Remove the eaten item from the inventory or room
                if (itemInInventory != null) {
                    player.getInventory().remove(itemToEat);
                } else {
                    currentRoom.removeItem(itemToEat);
                }
            } else {
                System.out.println(whatToEat + " is not food. You can't eat it.");
            }
        } else {
            System.out.println("There is nothing like " + whatToEat + " to eat in your inventory or in the room.");
        }
    }

    public void equipWeapon(String input) {
        Room currentRoom = adventure.getCurrentRoom();
        Player player = adventure.getPlayer();
        Item itemInInventory = player.findItem(input);

        Item itemInRoom = null;
        for (Item item : currentRoom.getItemList()) {
            if (item.getItemName().equalsIgnoreCase(input)) {
                itemInRoom = item;
                break;
            }
        }

        if (itemInInventory != null || itemInRoom != null) {
            // Determine which item to equip (from inventory or room) - Udvidet fra original opgave.
            Item itemToEquip = (itemInInventory != null) ? itemInInventory : itemInRoom;

            if (itemToEquip instanceof Weapon weapon) {
                player.setEquippedWeapon(weapon);
                System.out.println("You have equipped " + input);

                // Remove the equipped item from the inventory or room
                if (itemInInventory != null) {
                    player.getInventory().remove(itemToEquip);
                } else {
                    currentRoom.removeItem(itemToEquip);
                }
            } else {
                System.out.println(input + " is not a weapon. You can't equip it.");
            }
        } else {
            System.out.println("There is nothing like " + input + " to equip in your inventory or in the room.");
        }
    }
        public void attack(String target) {
            Player player = adventure.getPlayer();
            Room currentRoom = adventure.getCurrentRoom();

            // Find the enemy to attack in the current room
            Enemy enemyToAttack = findEnemyInCurrentRoom(target);

            if (enemyToAttack != null) {
                if (player.getEquippedWeapon() instanceof RangedWeapon rangedWeapon) {
                    if (rangedWeapon.getAmmunition() > 0) {
                        // Perform ranged attack
                        int playerDamage = rangedWeapon.getDamage();
                        int enemyDamage = enemyToAttack.attack();  // Get enemy's damage directly
                        enemyToAttack.takeDamage(playerDamage);
                        System.out.println("You shot " + target + " using your " + rangedWeapon.getItemName() + ". " +
                                target + " took " + playerDamage + " damage.");

                        // Check if the enemy is defeated after player's attack
                        if (enemyToAttack.getHealth() <= 0) {
                            // Drop the enemy's weapon in the room (optional)
                            currentRoom.addItem(enemyToAttack.getEquippedWeapon());

                            // Remove the defeated enemy from the room
                            currentRoom.removeEnemy(enemyToAttack);
                            System.out.println("You defeated " + target + "!");
                        } else {
                            // Enemy retaliates if not defeated
                            player.takeDamage(enemyDamage);
                            System.out.println(target + " retaliated and dealt " + enemyDamage + " damage to you.");
                        }
                        rangedWeapon.decrementAmmunition();
                    } else {
                        System.out.println("You are out of ammunition for your " + rangedWeapon.getItemName() + ".");
                    }
                } else if (player.getEquippedWeapon() instanceof MeleeWeapon meleeWeapon) {
                    int playerDamage = meleeWeapon.getDamage();
                    int enemyDamage = enemyToAttack.attack();  // Get enemy's damage directly
                    enemyToAttack.takeDamage(playerDamage);
                    System.out.println("You attacked " + target + " using your " + meleeWeapon.getItemName() + ". " +
                            target + " took " + playerDamage + " damage.");

                    if (enemyToAttack.getHealth() <= 0) {
                        currentRoom.addItem(enemyToAttack.getEquippedWeapon());
                        currentRoom.removeEnemy(enemyToAttack);
                        System.out.println("You defeated " + target + "!");
                    } else {
                        player.takeDamage(enemyDamage);
                        System.out.println(target + " retaliated and dealt " + enemyDamage + " damage to you.");
                    }
                } else {
                    System.out.println("You can only use weapons to attack.");
                }
            } else {
                System.out.println("No enemy with that name found in the room.");
            }

        }
    private Enemy findEnemyInCurrentRoom(String target) {
        Room currentRoom = adventure.getCurrentRoom();
        for (Enemy enemy : currentRoom.getEnemyList()) {
            if (enemy.getName().equalsIgnoreCase(target)) {
                return enemy;
            }
        }
        return null;
    }
}



