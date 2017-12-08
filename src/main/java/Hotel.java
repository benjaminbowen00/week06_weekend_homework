import java.util.ArrayList;

public class Hotel {
    String name;
    ArrayList<Room> rooms;

    public Hotel(String name){
        this.name = name;
        this.rooms = new ArrayList<>();
    }

    public int numberOfRooms(){
        return rooms.size();
    }

    public void addRoom(Room room){
        rooms.add(room);
    }

    public boolean hasRoom(Room room){
        return rooms.contains(room);
    }

    public boolean groupFitsInRoom(Group group, Room room){
        return group.getSize() <= room.getCapacity();
    }




//    public void checkInGroupBedroom(Group group, Bedroom bedroom){
//        if (rooms.contains(bedroom) && group.getSize() <= bedroom.getCapacity()) {
//
//        }
//    }

}
