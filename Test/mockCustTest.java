import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.PowerMock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.junit.Assert.assertEquals;
import static org.powermock.api.easymock.PowerMock.verify;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Customer.class)
public class mockCustTest
{
    @Test
    public void customerTakeoutTest() throws Exception
    {
        System.out.println("test started");
        Customer mockTest = new Customer("Jeff Goldblum");

        Loan powermockLoan = createMock(Loan.class);

        PowerMock.expectNew(Loan.class,5000.0,5).andReturn(powermockLoan);          //test case was provided in customer class

        expect(powermockLoan.getMonthlyPayment()).andReturn(96.66);

        PowerMock.replay(powermockLoan,Loan.class);

        double resultExpected = 96.66;

        mockTest.takeoutloan();

        double res = mockTest.getMonthlypayments();

        assertEquals(resultExpected,res,0.05);

        verify(powermockLoan,Loan.class);
    }
}
