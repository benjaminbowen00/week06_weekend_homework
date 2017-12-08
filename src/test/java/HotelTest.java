import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HotelTest {

    Hotel hotel1;
    Bedroom bedroom1;
    Bedroom bedroom2;
    Bedroom bedroom3;
    Group group1;
    Group group2;
    Group group3;
    Group group4;
    Guest guest1;
    Guest guest2;
    Guest guest3;
    Guest guest4;
    Guest guest5;

    @Before
    public void before(){
        hotel1 = new Hotel("CodeClan Towers");
        bedroom1 = new Bedroom("Room 1", BedroomType.DOUBLE);
        bedroom2 = new Bedroom("Room 2", BedroomType.FAMILY);
        bedroom3 = new Bedroom("Room 3", BedroomType.FAMILY);
        hotel1.addRoom(bedroom1);
        hotel1.addRoom(bedroom2);

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
    }

//    @Test
//    public void hotelStartsNoRooms(){
//        assertEquals(0, hotel1.numberOfRooms());
//    }

    @Test
    public void canAddRoom(){
        assertEquals(2, hotel1.numberOfRooms());
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

}
