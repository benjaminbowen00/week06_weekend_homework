public enum DiningRoomType {
    BREAKFAST(25, 0, false),
    DINNER(20, 0, false),
    BAR(50, 0, false);

    private final int capacity;
    private final double price;
    private final boolean exclusive;

    private DiningRoomType(int capacity, int price, boolean exclusive) {
        this.capacity = capacity;
        this.price = price;
        this.exclusive = exclusive;
    }

    public int getCapacity(){
        return this.capacity;
    }
    public double getPrice(){ return this.price; }
    public boolean getExclusive(){return this.exclusive;}

}
