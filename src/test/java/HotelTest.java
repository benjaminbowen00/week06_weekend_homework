import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HotelTest {

    Hotel hotel1;
    Bedroom bedroom1;
    Bedroom bedroom2;
    Group group1;
    Group group2;
    Guest guest1;
    Guest guest2;
    Guest guest3;

    @Before
    public void before(){
        hotel1 = new Hotel("CodeClan Towers");
        bedroom1 = new Bedroom("Room 1", BedroomType.DOUBLE);
        bedroom2 = new Bedroom("Room 2", BedroomType.FAMILY);
        group1 = new Group();
        group2 = new Group();
        guest1 = new Guest("Basil");
        guest2 = new Guest("Cybil");
        guest2 = new Guest("Manuel");
        group1.addGuestToGroup(guest1);
        group1.addGuestToGroup(guest2);
        group1.addGuestToGroup(guest3);
        group2.addGuestToGroup(guest1);
        group2.addGuestToGroup(guest2);

    }

    @Test
    public void hotelStartsNoRooms(){
        assertEquals(0, hotel1.numberOfRooms());
    }

    @Test
    public void canAddRoom(){
        hotel1.addRoom(bedroom1);
        assertEquals(1, hotel1.numberOfRooms());
    }

    @Test
    public void canCheckForRooms(){
        hotel1.addRoom(bedroom1);
        assertEquals(true, hotel1.hasRoom(bedroom1));
        assertEquals(false, hotel1.hasRoom(bedroom2));
    }

    @Test
    public void roomLimitworks(){
    hotel1.addRoom(bedroom1);
    assertEquals(false, hotel1.groupFitsInRoom(group1, bedroom1));
    assertEquals(true, hotel1.groupFitsInRoom(group2, bedroom1));
    }


}
