import java.util.ArrayList;

public class Group {
    private ArrayList<Guest> guests;

    public Group(){
        this.guests = new ArrayList<>();
    }

    public ArrayList<Guest> getGuests() {
        return guests;
    }

    public void addGuestToGroup(Guest guest){
        this.guests.add(guest);
    }

    public int getSize(){
        return this.guests.size();
    }

    public double groupTotalMoney(){
        double total = 0;
        for (Guest guest : guests) {
            total += guest.getMoney();
        }
        return total;
    }

    public boolean groupHasMoneyForRoom(Room room){
        return this.groupTotalMoney() >= room.getPrice();
    }

    public Room findRoom(Hotel hotel){
        for (Room room : hotel.getRooms()){
            if (room.isGroupInRoom(this)){
                return room;
            }
        }
        return null;
    }

}
