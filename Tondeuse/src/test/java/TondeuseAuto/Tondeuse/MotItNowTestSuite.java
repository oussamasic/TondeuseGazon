package TondeuseAuto.Tondeuse;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	MowersConfiguratorTest.class,
	TondeuseTest.class
})

public class MotItNowTestSuite {

	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(MotItNowTestSuite.class);
	    for (Failure failure : result.getFailures()) {
	       System.out.println(failure.toString());
	    }
	    System.out.println(result.wasSuccessful());
	}
}
