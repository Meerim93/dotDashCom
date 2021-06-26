package BasePage;

import org.junit.After;
import org.junit.Before;
;

public class Hooks {
    @Before
    public void before() {
        System.out.println("Hook - Before Annotation");
    }

    @After
    public void after() {
        System.out.println("Hook - After Annotation");
    }
}
