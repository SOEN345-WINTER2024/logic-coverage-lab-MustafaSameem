import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class CheckItTest {
    private final PrintStream out = System.out;
    private final ByteArrayOutputStream test = new ByteArrayOutputStream();

    @Before
    public void before() {
        System.setOut(new PrintStream(test));
    }
    @After
    public void after() {
        System.setOut(out);
        test.reset();
    }

    //clause coverage
    @Test
    public void clause_coverage_true() {
        CheckIt.checkIt(true, true, true);
        assertEquals("P is true", test.toString().trim());
    }
    @Test
    public void clause_coverage_false() {
        CheckIt.checkIt(false, false, false);
        assertEquals("P isn't true", test.toString().trim());
    }

    //predicate coverage
    @Test
    public void predicate_coverage_true() {
        CheckIt.checkIt(true, false, true);
        assertEquals("P is true", test.toString().trim());
    }
    @Test
    public void predicate_coverage_false() {
        CheckIt.checkIt(false, true, false);
        assertEquals("P isn't true", test.toString().trim());
    }

    //cacc coverage
    @Test
    public void cacc_coverage_true() {
        CheckIt.checkIt(true, true, false);
        assertEquals("P is true", test.toString().trim());
    }
    @Test
    public void cacc_coverage_false() {
        CheckIt.checkIt(false, true, false);
        assertEquals("P isn't true", test.toString().trim());
    }

    //racc coverage
    @Test
    public void racc_coverage_true() {
        CheckIt.checkIt(true, false, true);
        assertEquals("P is true", test.toString().trim());
    }
    @Test
    public void racc_coverage_false() {
        CheckIt.checkIt(false, false, true);
        assertEquals("P isn't true", test.toString().trim());
    }
}