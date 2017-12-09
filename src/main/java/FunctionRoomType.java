public enum FunctionRoomType {
    PARTY(5000, 100, true),
    CONFERENCE(1000, 100, true),
    MEETING(100, 10, true);

    private final double price;
    private final int capacity;
    private final boolean exclusive;

    private FunctionRoomType(double price, int capacity, boolean exclusive) {
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
