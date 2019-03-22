import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static junit.framework.TestCase.assertEquals;

@RunWith(Enclosed.class)
public class LoanTestCaseNegative
{

    @RunWith(value = Parameterized.class)

    public static class pTests
    {
        //private double expectedRes;
        private double loanAmount;
        private int TPeriod;

        public pTests(double loanAmount,int TPeriod)
        {
            //this.expectedRes = expectedRes;
            this.loanAmount = loanAmount;
            this.TPeriod = TPeriod;
        }

        @Parameterized.Parameters(name = "{index}: checkMonthlyPayment({1})={0}")
        public static Collection<Object[]> getTParam()
        {
            return Arrays.asList(new Object[][]{
                    {1001,0},     //test case 1  warns not errors
                    {0,' '},      //test case 2
                    {499,6},      //test case 3
                    {' ', 'T'},   //test case 4
                    {"o",3},      //this errors even though its expected
                                        //assuming you cant take out €5000.50
            });
        }
        @Test (expected = IllegalArgumentException.class)
        public void testCaseRun()
        {
            Loan loanTestParam = new Loan(loanAmount,TPeriod);
            //assertEquals(/*expectedRes, */loanTestParam.getRate());
        }
    }

}
