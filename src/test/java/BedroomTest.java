import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BedroomTest {
    Group group1;
    Group group2;
    Guest guest1;
    Guest guest2;
    Guest guest3;
    Bedroom bedroom1;


    @Before
    public void before(){
        group1 = new Group();
        group2 = new Group();
        guest1 = new Guest("Basil", 200);
        guest2 = new Guest("Cybil", 100);
        guest3 = new Guest("Manuel", 10);
        group1.addGuestToGroup(guest1);
        group1.addGuestToGroup(guest2);
        group1.addGuestToGroup(guest3);
        group2.addGuestToGroup(guest1);
        group2.addGuestToGroup(guest2);
        bedroom1 = new Bedroom("Room 1", BedroomType.DOUBLE);
    }

    @Test
    public void canAddGroups(){
        assertEquals(0, bedroom1.getNumberOfGuests());
        bedroom1.addGroupToRoom(group1);
        assertEquals(3, bedroom1.getNumberOfGuests());
    }

    @Test
    public void canCheckEmpty(){
        assertEquals(true, bedroom1.roomIsEmpty());
        bedroom1.addGroupToRoom(group1);
        assertEquals(false, bedroom1.roomIsEmpty());
    }

    @Test
    public void roomLimitworks(){

        assertEquals(false, bedroom1.groupFitsInRoom(group1));
        assertEquals(true, bedroom1.groupFitsInRoom(group2));
    }



}
