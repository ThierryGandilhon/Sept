package sept.sept;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestEval.class, 
				TestCombine.class,
				TestEquals.class})
public class AllTests {

}
