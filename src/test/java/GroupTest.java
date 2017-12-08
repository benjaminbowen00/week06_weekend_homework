import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GroupTest {
    Group group1;
    Group group2;
    Guest guest1;
    Guest guest2;
    Guest guest3;

    @Before
    public void before(){
        group1 = new Group();
        guest1 = new Guest("Basil", 200);
        guest2 = new Guest("Cybil", 100);
        guest3 = new Guest("Manuel", 10);
        group1.addGuestToGroup(guest1);
        group1.addGuestToGroup(guest2);
        group1.addGuestToGroup(guest3);
        group2.addGuestToGroup(guest1);
        group2.addGuestToGroup(guest2);
    }

    @Test
    public void canAddGuests(){
        assertEquals(2, group1.getSize());
    }

    @Test
    public void canGetTotalMoney(){
        assertEquals(300, group1.groupTotalMoney(), 0.001);
    }
}
