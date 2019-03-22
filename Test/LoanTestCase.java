import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.Collection;

import static junit.framework.TestCase.assertEquals;

@RunWith(Enclosed.class)
public class LoanTestCase
{

    @RunWith(value = Parameterized.class)

    public static class pTests
    {
        private double expectedRes;
        private double loanAmount;
        private int TPeriod;

        public pTests(double expectedRes,double loanAmount,int TPeriod)
        {
            this.expectedRes = expectedRes;
            this.loanAmount = loanAmount;
            this.TPeriod = TPeriod;
        }

        @Parameterized.Parameters(name = "{index}: checkMonthlyPayment({1})={0}")
        public static Collection<Object[]> getTParam()
        {
            return Arrays.asList(new Object[][]{
                    {10,500,1},     //test case 1
                    {6,500,5},       //test case 2
                    {5,10000,5},     //test case 4
                    {8,5001,3},     //code coverage tests
                    {6,5000,4},      //code coverage tests

                                        //assuming you cant take out €5000.50
            });
        }
        @Test
        public void testCaseRun()
        {
            Loan loanTestParam = new Loan(loanAmount,TPeriod);
            assertEquals(expectedRes, loanTestParam.getRate());
        }
    }

    public static class noParam
    {
        @Test(expected = IllegalArgumentException.class)
        public void testCase5()
        {
            Loan loanNoParams = new Loan(60,67);
            assertEquals(0,loanNoParams.getRate(),.01);
        }
    }

}
