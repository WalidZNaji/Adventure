import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Adventure adventure = new Adventure();
        Scanner scan = new Scanner(System.in);

        printStartMessage();

        String input = "";

        printRoomInfo();

        while (!input.equalsIgnoreCase("exit")) {

            input = scan.nextLine();

            switch (input) {
                case "go north":
                case "go n":
                    adventure.move("north");
                    break;
                case "go south":
                case "go s":
                    adventure.move("south");
                    break;
                case "go east":
                case "go e":
                    adventure.move("east");
                    break;
                case "go west":
                case "go w":
                    adventure.move("west");
                    break;
                case "look":
                    break;
                case "help":
                    printHelp();
                    break;
                case "exit":
                    System.out.println("Game has been quit. Thank you for playing");
                    input = "exit";
                    break;
            }
        }

    }

    public static void printStartMessage() {
        System.out.println("\nWelcome to The Adventure!\n");

        System.out.println("The Adventure consists of 9 different rooms.\n" +
                "All the rooms are different. Have a look around.\n" +
                "See if you can find room 5.. \n");

        System.out.println("You are able to move around my typing \"go north/south/east/west\" or \"go n/s/e/w\"\n" +
                "If you need anything type \"help\"\n");
    } // TODO static?

    public static void printRoomInfo() {
        Adventure adventure = new Adventure();
        System.out.println("Currently you're in " + adventure.getCurrentRoom() );
        System.out.println(adventure.getCurrentRoom().getDescription());

        System.out.print("\nWhich direction would you like to go: ");
    }

    public static void printHelp() {
            System.out.println("Available commands:");
            System.out.println("go north/ go n - Move to the room to the north.");
            System.out.println("go east/ go e - Move to the room to the east.");
            System.out.println("go south/ go s - Move to the room to the south.");
            System.out.println("go west/ go w - Move to the room to the west.");
            System.out.println("\"look\" - Show description of current room.");
            System.out.println("help - Show this help message.");
            System.out.println("exit - Quit the game.");
        }


}




