public class Adventure {

    private MapBuilder mapBuilder;
    private Player player;

    public Adventure() {
        mapBuilder = new MapBuilder();
        player = new Player();
        mapBuilder.createMap();
        player.setCurrentRoom(mapBuilder.getStartingRoom());
    }

    public Room getCurrentRoom() {
        return player.getCurrentRoom();
    }
    public void move(String direction) {
        player.move(direction);
    }
}
