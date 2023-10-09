import java.util.ArrayList;

public class MapBuilder {

    private Room initialRoom;

    public void createMap() {

        Item axe = new Item("Axe", "Heavy wooden axe");
        Item flashlight = new Item("Flashlight", "A weak flashlight");
        Item extinguisher = new Item("Extinguisher", "fire extinguisher is (1/2) parts to put out fire ");
        Item hose = new Item("Hose", "(1/2) parts to put out fire");
        Food apple = new Food("apple", "big red apple", 25);
        Food bread = new Food("bread", "a loaf of bread", 50);
        Weapon pistol = new RangedWeapon("glock", "saf - small arms fire", "weapon is not equipped", 10);
        Weapon sword = new MeleeWeapon("sword", "long shiny sword", "weapon is not equipped");



        ArrayList<Item> itemsInRoom1 = new ArrayList<>();
        itemsInRoom1.add(flashlight);

        ArrayList<Item> itemsInRoom2 = new ArrayList<>();
        itemsInRoom2.add(apple);

        ArrayList<Item> itemsInRoom3 = new ArrayList<>();
        itemsInRoom3.add(axe);

        ArrayList<Item> itemsInRoom4 = new ArrayList<>();
        itemsInRoom4.add(bread);

        ArrayList<Item> itemsInRoom6 = new ArrayList<>();
        itemsInRoom6.add(sword);

        ArrayList<Item> itemsInRoom7 = new ArrayList<>();
        itemsInRoom7.add(extinguisher);

        ArrayList<Item> itemsInRoom8 = new ArrayList<>();
        itemsInRoom8.add(pistol);

        ArrayList<Item> itemsInRoom9 = new ArrayList<>();
        itemsInRoom9.add(hose);


        Room room1 = new Room("Room 1", "Big empty room with dark lighting", itemsInRoom1);
        Room room2 = new Room("Room 2", "Small room filled with trash", itemsInRoom2);
        Room room3 = new Room("Room 3", "Forrest room filled with green trees", itemsInRoom3);
        Room room4 = new Room("Room 4", "Big white room with a single chair in the middle", itemsInRoom4);
        Room room5 = new Room("Room 5", "Treassure room! THE ROOM IS ON FIRE\nFind something to put it out with.");
        Room room6 = new Room("Room 6", "Slaughter room with bags hanging from the ceiling", itemsInRoom6);
        Room room7 = new Room("Room 7", "Playroom filled with colours and childrens toys", itemsInRoom7);
        Room room8 = new Room("Room 8", "Disco room with different coloured tiles and a huge discoball", itemsInRoom8);
        Room room9 = new Room("Room 9", "Sleeper room, 9 beds, 9 people sleeping", itemsInRoom9);

        room1.setGoEast(room2);
        room2.setGoWest(room1);
        room2.setGoEast(room3);
        room3.setGoWest(room2);
        room3.setGoSouth(room6);
        room6.setGoNorth(room3);
        room6.setGoSouth(room9);
        room9.setGoNorth(room6);
        room9.setGoWest(room8);
        room8.setGoEast(room9);
        room8.setGoNorth(room5);
        room5.setGoSouth(room8);
        room8.setGoWest(room7);
        room7.setGoEast(room8);
        room7.setGoNorth(room4);
        room4.setGoSouth(room7);
        room4.setGoNorth(room1);
        room1.setGoSouth(room4);

        initialRoom = room1;
    }

    public Room getStartingRoom() {
        return initialRoom;
    }


}