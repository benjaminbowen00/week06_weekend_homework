import java.util.ArrayList;

public class Room {
    private String name;
    private ArrayList<Guest> guests;
    private int capacity;
    private double price;
    private boolean exclusive;

    public Room(String name, int capacity, double price, boolean exclusive ){
        this.name = name;
        this.guests = new ArrayList<>();
        this.capacity = capacity;
        this.price = price;
        this.exclusive = exclusive;
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

//    public void removeGroupFromRoom(){
//        this.guests.clear();
//    }

    public void removeGroupFromRoom(Group group){
        for (Guest guest : group.getGuests())
            {this.guests.remove(guest);}
    }

    public boolean isExclusive() {
        return exclusive;
    }


    public int canTakeNumberOfGuests(){
    if (this.isExclusive())
        {if (this.roomIsEmpty())
            {return this.getCapacity();}
        else {return 0;}
        }
    else{
        return this.getCapacity() - this.getNumberOfGuests();
        }
    }

    public boolean groupFitsInRoom(Group group){
        return group.getSize() <= this.canTakeNumberOfGuests();
    }

//    public boolean isGroupInRoom(Group group) {
//        return group.getGuests().equals(this.getGuests());
//    }
//        return group.getGuests() == this.getGuests();
//        this didn't pass the same test when using ==

    public boolean isGroupInRoom(Group group) {
        return this.getGuests().containsAll(group.getGuests());
    }
}
