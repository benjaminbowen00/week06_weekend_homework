import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GuestTest {

    Guest guest1;

    @Before
    public void before(){
        guest1 = new Guest("Basil", 200);
    }

    @Test
    public void canCheckMoney(){
        assertEquals(200, guest1.getMoney(),0.01);
    }

    @Test
    public void canDeductMoney(){
        guest1.deductMoney(150);
        assertEquals(50, guest1.getMoney(), 0.01);
    }
}
