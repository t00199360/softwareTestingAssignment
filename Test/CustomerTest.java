import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.runners.model.TestTimedOutException;
import java.util.concurrent.TimeoutException;
import static org.junit.Assert.*;
import org.junit.ComparisonFailure;

public class CustomerTest
{
    @Rule
    public Timeout globalTimeout = Timeout.millis(900);

    Customer customer1 = new Customer("Jeff",1);

    @Test
    public void testCustomer1()     //tests the get name code
    {
        assertEquals("Jeff",customer1.getName());
    }

    @Test
    public void testCustomer2()
    {
        assertEquals(1,customer1.getMonthlypayments(),0.1);
    }

    @Test
    public void testCustomer3()
    {
        assertEquals("Name: Jeff Payments: 1.0",customer1.toString());
    }

}