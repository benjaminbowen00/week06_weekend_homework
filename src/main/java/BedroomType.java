public enum BedroomType {
    SINGLE(50, 1),
    DOUBLE(80, 2),
    FAMILY(90, 4);

    private final double price;
    private final int capacity;

    private BedroomType(double price, int capacity) {
        this.price = price;
        this.capacity = capacity;
    }

    public double getPrice(){
        return this.price;
    }

    public int getCapacity(){
        return this.capacity;
    }
}
