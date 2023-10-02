import java.util.ArrayList;
import java.util.Scanner;

public class Ui {

    private static Adventure adventure;
    private Scanner scan;

    public Ui(Adventure adventure) {
        this.adventure = adventure;
    }

    public void startProgram() {

        scan = new Scanner(System.in);

        printStartMessage();

        printRoomInfo();

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
                case "look" -> {
                    printDescription();
                }
                case "help" -> printHelp();
                case "take" -> {
                    System.out.println("what would you like to pick up?");
                    String itemName = scan.nextLine();
                    takeItem(itemName);
                }
                case "drop" -> {
                    System.out.println("What would you like to drop?");
                    String itemName = scan.nextLine();
                    dropItem(itemName);
                }
                case "inventory", "inv" -> showInventory();
                case "exit" -> {
                    System.out.println("Game has been quit. Thank you for playing");
                    return;
                }
            }
        }

    }

    public static void printStartMessage() {
        System.out.println("\nWelcome to The Adventure!\n");

        System.out.println("The Adventure consists of 9 different rooms.\n" +
                "All the rooms are different. Have a look around.\n" +
                "See if you can find room 5.. \n");

        System.out.println("You are able to move around by typing \"go north/south/east/west\" or \"go n/s/e/w\"\n" +
                "If you need anything type \"help\"\n");
    }

    public static void  printRoomInfo() {

        System.out.println("Currently you're in " + adventure.getCurrentRoom() );
        System.out.println(adventure.getCurrentRoom().getDescription());

        ArrayList<Item> itemsInRoom = adventure.getCurrentRoom().getItemList();

        if (itemsInRoom != null && !itemsInRoom.isEmpty()){
            System.out.println("Items in this room: ");
            for (Item item : itemsInRoom) {
                System.out.println(item.getItemName() + " " + item.getItemDescription());
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
        System.out.println("\"take\"  - Pick up item ");
        System.out.println("\"drop\" - drop item ");
        System.out.println("exit - Quit the game.");
    }

    public static void printDescription() {

        Room currentRoom = adventure.getCurrentRoom();
        ArrayList<Item> itemsInRoom = currentRoom.getItemList();

        System.out.println(currentRoom.getDescription());

        if (itemsInRoom != null && !itemsInRoom.isEmpty()) {
            System.out.println("Items in this room: ");
            for (Item item : itemsInRoom) {
                System.out.println(item.getItemName() + " " + item.getItemDescription());
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

    /*public void takeItem(String itemName) { Oprindelig takeItem.
        Player player = adventure.getPlayer();
        Room currentRoom = adventure.getCurrentRoom();
        Item item = player.findItem(itemName);

        if (item != null) {
            currentRoom.removeItem(item);
            player.takeItem(item);

            System.out.println("You have picked up the " + item.getItemName() + ".");
        } else {
            System.out.println("There is nothing like " + itemName + " to pick up around here.");
        }
    }
*/
    public void dropItem(String itemName) {
        Player player = adventure.getPlayer();
        Room currentRoom = adventure.getCurrentRoom();
        Item item = player.findItem(itemName);

        if (item != null) {
            player.dropItem(item);
            currentRoom.addItem(item);
            System.out.println("You have dropped " + item.getItemName());
        } else System.out.println("There is nothing like " + itemName + " in your inventory");
    }
    public void showInventory() {
        Player player = adventure.getPlayer();
        ArrayList<Item> inventory = player.getInventory();

        if (inventory.isEmpty()) {
            System.out.println("Your inventory is empty.");
        } else
            System.out.println("Inventory: ");
        for (Item item : inventory) {
            System.out.println(item.getItemName() + " " + item.getItemDescription());
        }



    }




}