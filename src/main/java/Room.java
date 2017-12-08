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

    public int getNumberOfGuests(){
        return this.guests.size();
    }

    public boolean roomIsEmpty(){
        return this.getNumberOfGuests() == 0;
    }

    public void addGroupToRoom(Group group){
        this.guests.addAll(group.getGuests());
    }
}
