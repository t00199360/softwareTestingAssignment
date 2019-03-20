import static org.junit.Assert.*;
import org.junit.ComparisonFailure;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.runners.model.TestTimedOutException;
import java.util.concurrent.TimeoutException;

public class LoanTest
{

    //when ran with coverage it misses two lines but its just an empty section after the data members

    @Rule
    public Timeout globalTimeout = Timeout.millis(900);

    Loan loan1 = new Loan(550,2);

                                                //all SOUT code is debug and should be ignored
    @Test
    public void testLoan1()     //tests the getAmount code
    {
        assertEquals(550,loan1.getAmount(),0.1);
    }
    @Test
    public void testLoan2()     //tests the getPeriod code
    {
        assertEquals(2,loan1.getPeriod(),0.1);
    }
    @Test
    public void testLoan3()     //tests the getMonthlyPayment code
    {
        assertEquals(25.37,loan1.getMonthlyPayment(),0.01);
        //System.out.println(loan1.getMonthlyPayment());
    }
    @Test
    public void testLoan4()     //tests the getRate code
    {
        assertEquals(10,loan1.getRate(),0.1);
        //System.out.println(loan1.getRate());
    }
    @Test
    public void testLoan5()
    {
        assertEquals(609.11,loan1.getTotalPayment(),0.01);
        //System.out.println(loan1.getTotalPayment());
    }

    @Test   (expected=IllegalArgumentException.class)
    public void testLoan6()     //tests the getAmount code and should crash as 0 is not valid
    {
        Loan loan2 = new Loan(0,3);
        //System.out.println(loan2.getAmount());
        assertEquals(50,loan2.getAmount(),0.1);
    }
    @Test
    public void testLoan7()     //tests the getPeriod code
    {
        Loan loan3 = new Loan (550,5);
        //System.out.println(loan3.getTotalPayment());
        assertEquals(637.98,loan3.getTotalPayment(),0.01);
    }
    @Test
    public void testLoan8()     //tests the getMonthlyPayment code
    {
        Loan loan4 = new Loan(5500,2);
        assertEquals(5970.00,loan4.getTotalPayment(),0.01);
        //System.out.println(loan4.getTotalPayment());
    }
    @Test
    public void testLoan9()     //tests the getRate code
    {
        Loan loan5 = new Loan(5500,4);
        assertEquals(6079.73,loan5.getTotalPayment(),0.01);
        //System.out.println(loan5.getTotalPayment());
    }
    @Test       (expected=IllegalArgumentException.class)
    public void testLoan10()
    {
        Loan loan6 = new Loan(120000,2);
        assertEquals(5970.00,loan6.getTotalPayment(),0.01);
        //System.out.println(loan6.getTotalPayment());
    }

    @Test         (expected=IllegalArgumentException.class) //test case 4
    public void testLoan11()
    {
        Loan loan7 = new Loan(750000,67);
        assertEquals(10101010.01,loan7.getTotalPayment(),0.01);
    }

}