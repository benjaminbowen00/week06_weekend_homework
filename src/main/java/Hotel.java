import java.util.ArrayList;

public class Hotel {
    private String name;
    private ArrayList<Room> rooms;

    public Hotel(String name){
        this.name = name;
        this.rooms = new ArrayList<>();
    }

    public int numberOfRooms(){
        return rooms.size();
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public void addRoom(Room room){
        rooms.add(room);
    }

    public boolean hasRoom(Room room){
        return rooms.contains(room);
    }

    public int totalGuests(){
        int total = 0;
        for (Room room : rooms){
            total += room.getNumberOfGuests();
        }
        return total;
    }


    public void checkInGroup(Group group, Room room) {
        if (this.hasRoom(room) && room.groupFitsInRoom(group) &&  group.groupHasMoneyForRoom(room)) {
            group.deductMoneyFromGroup(room.getPrice());
            room.addGroupToRoom(group);
        }
    }

    public void checkOutGroup(Group group){
        group.findRoom(this).removeGroupFromRoom(group);
    }

    public ArrayList<Guest> getGuests(Room room){
        if (this.hasRoom(room)){
        return room.getGuests();}
        else return null;
    }

    public Room getRoomOfGuest(Guest guest){
        for(Room room : this.rooms){
            if( room.getGuests().contains(guest)){
                return room;
            }
        }
        return null;
    }

    public ArrayList<Room> getEmptyRooms(){
        ArrayList<Room> emptyRooms = new ArrayList<>();
        for(Room room : this.rooms){
            if(room.roomIsEmpty()){
                emptyRooms.add(room);
            }

        }
        return emptyRooms;
    }
}
