public enum BedroomType {
    SINGLE(50, 1, true),
    DOUBLE(80, 2, true),
    FAMILY(90, 4, true);

    private final double price;
    private final int capacity;
    private final boolean exclusive;

    private BedroomType(double price, int capacity, boolean exclusive) {
        this.price = price;
        this.capacity = capacity;
        this.exclusive = exclusive;
    }

    public double getPrice(){
        return this.price;
    }

    public int getCapacity(){
        return this.capacity;
    }

    public boolean getExclusive() {return this.exclusive;}
}
