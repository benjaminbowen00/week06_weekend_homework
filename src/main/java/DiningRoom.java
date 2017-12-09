public class DiningRoom extends Room {

    private DiningRoomType type;

    public DiningRoom(String name, DiningRoomType type) {
        super(name, type.getCapacity(), type.getPrice(), type.getExclusive());
        this.type = type;
    }
}
