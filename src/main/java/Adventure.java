public class Adventure {

    private MapBuilder mapBuilder;
    private Player player;
    private Enemy enemy;

    public Adventure() {
        mapBuilder = new MapBuilder();
        player = new Player();
        mapBuilder.createMap();
        player.setCurrentRoom(mapBuilder.getStartingRoom());
        enemy = new Enemy("dragon", "baby dragon", 50, 25);
    }

    public Room getCurrentRoom() {
        return player.getCurrentRoom();
    }
    public void move(String direction) {
        player.move(direction);
    }

    public Player getPlayer() {
        return player;
    }

    public Enemy getEnemy() {
        return enemy;
    }

}
