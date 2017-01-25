import com.phanimahesh.springboot.TestController;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Amma on 1/25/2017.
 */
public class CardValidatorTest {

    @Test
    public void test() {

        TestController testController  = new TestController();
        //System.out.println(testController.restTest("1234567890123456"));
        Assert.assertEquals( testController.restTest("1234567890123456") ,"<html><h1>The payment has been processed for ************345</h1></html>");
    }

}
