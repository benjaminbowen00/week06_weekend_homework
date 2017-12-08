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

    public ArrayList<Guest> getGuests() {
        return guests;
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

    public void removeGroupFromRoom(){
        this.guests.clear();
    }

    public boolean groupFitsInRoom(Group group){
        return group.getSize() <= this.getCapacity();
    }
    public boolean isGroupInRoom(Group group){
        return group.getGuests().equals(this.getGuests());
//        return group.getGuests() == this.getGuests();
//        this didn't pass the same test when using ==

    }
}
