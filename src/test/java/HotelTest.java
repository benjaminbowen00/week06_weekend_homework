import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class HotelTest {

    Hotel hotel1;
    Bedroom bedroom1;
    Bedroom bedroom2;
    Bedroom bedroom3;
    DiningRoom diningRoom1;
    FunctionRoom functionRoom1;
    Group group1;
    Group group2;
    Group group3;
    Group group4;
    Guest guest1;
    Guest guest2;
    Guest guest3;
    Guest guest4;
    Guest guest5;
    ArrayList<Guest> restaurantGuests;
    ArrayList<Room> unoccupiedRooms;


    @Before
    public void before(){
        hotel1 = new Hotel("CodeClan Towers");
        bedroom1 = new Bedroom("Room 1", BedroomType.DOUBLE);
        bedroom2 = new Bedroom("Room 2", BedroomType.FAMILY);
        bedroom3 = new Bedroom("Room 3", BedroomType.FAMILY);
        diningRoom1 = new DiningRoom("Restaurant", DiningRoomType.DINNER);
        functionRoom1 = new FunctionRoom("Wedding Room", FunctionRoomType.PARTY);
        hotel1.addRoom(bedroom1);
        hotel1.addRoom(bedroom2);
        hotel1.addRoom(diningRoom1);
        hotel1.addRoom(functionRoom1);

        group1 = new Group();
        group2 = new Group();
        group3 = new Group();
        group4 = new Group();
        guest1 = new Guest("Basil", 200);
        guest2 = new Guest("Cybil", 100);
        guest3 = new Guest("Manuel", 10);
        guest4 = new Guest("Polly", 25);
        guest5 = new Guest("The Colonel", 1000);
        group1.addGuestToGroup(guest1);
        group1.addGuestToGroup(guest2);
        group1.addGuestToGroup(guest3);
        group2.addGuestToGroup(guest1);
        group2.addGuestToGroup(guest2);
        group3.addGuestToGroup(guest3);
        group3.addGuestToGroup(guest4);
        group4.addGuestToGroup(guest5);

        restaurantGuests = new ArrayList<>();
        unoccupiedRooms = new ArrayList<>();
    }

//    @Test
//    public void hotelStartsNoRooms(){
//        assertEquals(0, hotel1.numberOfRooms());
//    }

    @Test
    public void canAddRoom(){
        assertEquals(4, hotel1.numberOfRooms());
    }

    @Test
    public void canCheckForRooms(){
        assertEquals(true, hotel1.hasRoom(bedroom1));
        assertEquals(false, hotel1.hasRoom(bedroom3));
    }

    @Test
    public void canCheckInGroup(){
        hotel1.checkInGroup(group2, bedroom1);
        assertEquals(2, hotel1.totalGuests());
    }

    @Test
    public void canCheckInMultipleGroups(){
        hotel1.checkInGroup(group2, bedroom1);
        hotel1.checkInGroup(group4, bedroom2);
        assertEquals(3, hotel1.totalGuests());
    }

    @Test
    public void cantCheckInGuestRoomNotInHotel(){
        hotel1.checkInGroup(group2, bedroom3);
        assertEquals(0, hotel1.totalGuests());
    }

    @Test
    public void cantCheckInGuestTooManyGuestsForRoom(){
        hotel1.checkInGroup(group1, bedroom1);
        assertEquals(0, hotel1.totalGuests());
    }

    @Test
    public void cantCheckInGuestTooExpensive(){
        hotel1.checkInGroup(group3, bedroom1);
        assertEquals(0, hotel1.totalGuests());
    }

    @Test
    public void cantCheckInGuestRoomOccupied(){
        hotel1.checkInGroup(group4, bedroom2);
        hotel1.checkInGroup(group2, bedroom2);
        assertEquals(1, hotel1.totalGuests());
    }

    @Test
    public void canFindRoomOfGroup() {
        hotel1.checkInGroup(group2, bedroom1);
        hotel1.checkInGroup(group4, bedroom2);
        assertEquals(bedroom1, group2.findRoom(hotel1));
        assertEquals(bedroom2, group4.findRoom(hotel1));
        assertEquals(null, group3.findRoom(hotel1));
    }

    @Test
    public void canCheckoutGroup(){
        hotel1.checkInGroup(group2, bedroom1);
        hotel1.checkInGroup(group4, bedroom2);
        hotel1.checkOutGroup(group4);
        assertEquals(2, hotel1.totalGuests());

    }

    @Test
    public void canCheckMultipleGroupsToDiningRoom(){
        hotel1.checkInGroup(group1, diningRoom1);
        hotel1.checkInGroup(group2, diningRoom1);
        hotel1.checkInGroup(group4, diningRoom1);
        assertEquals(6, diningRoom1.getNumberOfGuests());
    }

    @Test
    public void canCheckoutSingleGroupFromNonExclusiveRoom(){
        hotel1.checkInGroup(group1, diningRoom1);
        hotel1.checkInGroup(group2, diningRoom1);
        hotel1.checkInGroup(group4, diningRoom1);
        hotel1.checkOutGroup(group1);
        assertEquals(3, diningRoom1.getNumberOfGuests());
    }

    @Test
    public void canGetGuestsInRoom(){
        hotel1.checkInGroup(group2, bedroom1);
        assertEquals(group2.getGuests(), hotel1.getGuests(bedroom1));
    }

    @Test
    public void canGetGuestsInNonExclusiveRoom(){
        hotel1.checkInGroup(group1, diningRoom1);
        hotel1.checkInGroup(group4, diningRoom1);
        restaurantGuests.add(guest1);
        restaurantGuests.add(guest2);
        restaurantGuests.add(guest3);
        restaurantGuests.add(guest5);
        assertEquals(restaurantGuests, hotel1.getGuests(diningRoom1));

    }

    @Test
    public void canGetRoomOfGuest(){
        hotel1.checkInGroup(group2, bedroom1);
        assertEquals(bedroom1, hotel1.getRoomOfGuest(guest1));
    }

    @Test
    public void cantGetRoomOfGuestIfCouldntCheckIn(){
        hotel1.checkInGroup(group1, bedroom1);
        assertEquals(null, hotel1.getRoomOfGuest(guest1));
    }

    @Test
    public void canGetRoomOfGuestInNonExclusiveRoom(){
        hotel1.checkInGroup(group1, diningRoom1);
        hotel1.checkInGroup(group4, diningRoom1);
        assertEquals(diningRoom1, hotel1.getRoomOfGuest(guest2));
    }

    @Test
    public void canGetEmptyRoomsNoneOccupied(){
        assertEquals(4, hotel1.getEmptyRooms().size());
    }

    @Test
    public void canGetEmptyRoomsSomeOccupied(){
        hotel1.checkInGroup(group1, diningRoom1);
        hotel1.checkInGroup(group4, bedroom1);
        unoccupiedRooms.add(bedroom2);
        unoccupiedRooms.add(functionRoom1);
        assertEquals(2, hotel1.getEmptyRooms().size());
        assertEquals(unoccupiedRooms, hotel1.getEmptyRooms());
    }

    @Test
    public void canDeductWhenCheckIn() {
        hotel1.checkInGroup(group2, bedroom1);
        assertEquals(146.67, guest1.getMoney(), 0.01);
        assertEquals(73.33, guest2.getMoney(), 0.01);
    }

    @Test
    public void noDeductFromNonExclusiveRoom(){
        hotel1.checkInGroup(group1, diningRoom1);
        assertEquals(200, guest1.getMoney(), 0.01);
    }




}
