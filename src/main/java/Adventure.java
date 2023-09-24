public class Adventure {


    private Room currentRoom;

    public Adventure() {

        Room room1 = new Room("Room 1", "Big empty room with dark lighting");
        Room room2 = new Room("Room 2", "Small room filled with trash");
        Room room3 = new Room("Room 3", "Forrest room filled with green trees");
        Room room4 = new Room("Room 4", "Big white room with a single chair in the middle");
        Room room5 = new Room("Room 5", "Treassure room! THE ROOM IS FILLING UP WITH WATER FAST! Look for a way out.");
        Room room6 = new Room("Room 6", "Slaughter room with bags hanging from the ceiling ");
        Room room7 = new Room("Room 7", "Playroom filled with colours and childrens toys");
        Room room8 = new Room("Room 8", "Disco room with different coloured tiles and a huge discoball");
        Room room9 = new Room("Room 9", "Sleeper room, 9 beds, 9 people sleeping");

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

        currentRoom = room1;
    }


    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void move(String direction) {

        Room nextRoom = null;
        switch (direction) {
            case "north":
                nextRoom = currentRoom.getGoNorth();
                break;
            case "east":
                nextRoom = currentRoom.getGoEast();
                break;
            case "south":
                nextRoom = currentRoom.getGoSouth();
                break;
            case "west":
                nextRoom = currentRoom.getGoWest();
                break;
        }

        if (nextRoom != null) {
            currentRoom = nextRoom;
        } else {
            System.out.print("You can't go that way. Try again. ");
        }
    }

}

