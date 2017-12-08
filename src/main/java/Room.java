import java.util.ArrayList;

public class Room {
    String name;
    ArrayList<Guest> guests;
    int capacity;

    public Room(String name, int capacity){
        this.name = name;
        this.guests = new ArrayList<>();
        this.capacity = capacity;
    }

    public int getCapacity(){
        return this.capacity;
    }
}
