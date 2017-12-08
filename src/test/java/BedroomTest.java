import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BedroomTest {
    Group group1;
    Guest guest1;
    Guest guest2;
    Bedroom bedroom1;


    @Before
    public void before(){
        group1 = new Group();
        guest1 = new Guest("Basil");
        guest2 = new Guest("Cybil");
        group1.addGuestToGroup(guest1);
        group1.addGuestToGroup(guest2);
        bedroom1 = new Bedroom("Room 1", BedroomType.DOUBLE);
    }

    @Test
    public void canAddGroups(){
        assertEquals(0, bedroom1.getNumberOfGuests());
        bedroom1.addGroupToRoom(group1);
        assertEquals(2, bedroom1.getNumberOfGuests());
    }

    @Test
    public void canCheckEmpty(){
        assertEquals(true, bedroom1.roomIsEmpty());
        bedroom1.addGroupToRoom(group1);
        assertEquals(false, bedroom1.roomIsEmpty());
    }



}
