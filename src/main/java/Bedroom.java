public class Bedroom extends Room {

    private BedroomType type;

    public Bedroom(String name, BedroomType type) {
        super(name, type.getCapacity(), type.getPrice(), type.getExclusive());
        this.type = type;
    }







}
