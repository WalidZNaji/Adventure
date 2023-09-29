public class Player {

    private Room currentRoom;

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room room) {
        currentRoom = room;
    }

    public void move(String direction) {

        Room nextRoom = switch (direction) {
            case "north" -> currentRoom.getGoNorth();
            case "east" -> currentRoom.getGoEast();
            case "south" -> currentRoom.getGoSouth();
            case "west" -> currentRoom.getGoWest();
            default -> null;
        };

        if (nextRoom != null) {
            currentRoom = nextRoom;
        } else {
            System.out.print("You can't go that way. Try again. ");
        }
    }

}