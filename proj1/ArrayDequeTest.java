/**
 * Created by juanyan.li on 1/8/17.
 */
import static org.junit.Assert.assertEquals;
import junit.framework.*;

public class ArrayDequeTest extends TestCase {
	protected ArrayDeque<Integer> deque;

	// Methods run before each unit test case.
	protected void setUp() {
		this.deque = new ArrayDeque<Integer>();
	}

	// method can be run after each unit test is
	// protected void tearDown() {}

	// Unit test for init queue has zero length.
	// Notice all the unit test should
	// start will test then + other words.
	public void testInitSizeZero() {
		assertEquals(deque.size(), 0);
	}
}
