import java.util.ArrayList;

public class Room {
    String name;
    ArrayList<Guest> guests;
    int capacity;
    double price;

    public Room(String name, int capacity, double price ){
        this.name = name;
        this.guests = new ArrayList<>();
        this.capacity = capacity;
        this.price = price;
    }

    public int getCapacity(){
        return this.capacity;
    }

    public double getPrice(){
        return this.price;
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

    public boolean groupFitsInRoom(Group group){
        return group.getSize() <= this.getCapacity();
    }
}
