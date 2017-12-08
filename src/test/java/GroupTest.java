import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GroupTest {
    Group group1;
    Guest guest1;
    Guest guest2;

    @Before
    public void before(){
        group1 = new Group();
        guest1 = new Guest("Basil");
        guest2 = new Guest("Cybil");
    }

    @Test
    public void canAddGuests(){
        group1.addGuestToGroup(guest1);
        group1.addGuestToGroup(guest2);
        assertEquals(2, group1.getSize());
    }
}
