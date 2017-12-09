import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RoomTest {

    Group group1;
    Group group2;
    Group group3;
    Guest guest1;
    Guest guest2;
    Guest guest3;
    DiningRoom diningroom1;
    FunctionRoom functionroom1;


    @Before
    public void before() {
        group1 = new Group();
        group2 = new Group();
        group3 = new Group();
        guest1 = new Guest("Basil", 200);
        guest2 = new Guest("Cybil", 100);
        guest3 = new Guest("Manuel", 10);
        group1.addGuestToGroup(guest1);
        group1.addGuestToGroup(guest2);
        group1.addGuestToGroup(guest3);
        group2.addGuestToGroup(guest1);
        group2.addGuestToGroup(guest2);
        functionroom1 = new FunctionRoom("Wedding Room 1", FunctionRoomType.PARTY);
        diningroom1 = new DiningRoom("Restaurant 1", DiningRoomType.DINNER);

    }

    @Test
    public void canAddGroups(){
        int i = 0;
        while (i < 25){group3.addGuestToGroup(guest1);
        i++;}
        assertEquals(0, functionroom1.getNumberOfGuests());
        functionroom1.addGroupToRoom(group3);
        assertEquals(25, functionroom1.getNumberOfGuests());
    }

    @Test
    public void canGetExclusivity(){
        assertEquals(true, functionroom1.isExclusive());
        assertEquals(false, diningroom1.isExclusive());
    }

    @Test
    public void canCheckSpaceExclusiveRoom(){
        int i = 0;
        while (i < 25){group3.addGuestToGroup(guest1);
            i++;}
        assertEquals(100, functionroom1.canTakeNumberOfGuests());
        functionroom1.addGroupToRoom(group3);
        assertEquals(0, functionroom1.canTakeNumberOfGuests());
    }

    @Test

    public void canCheckSpaceNotExclsuiveRoom(){
        diningroom1.addGroupToRoom(group1);
        assertEquals(17, diningroom1.canTakeNumberOfGuests());
    }
}
