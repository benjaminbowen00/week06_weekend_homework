
public class FunctionRoom extends Room {
    private FunctionRoomType type;

    public FunctionRoom(String name, FunctionRoomType type) {
        super(name, type.getCapacity(), type.getPrice(), type.getExclusive());
        this.type = type;
    }
}
