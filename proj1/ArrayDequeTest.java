/**
 * Created by juanyan.li on 1/8/17.
 */
import junit.framework.*;

public class ArrayDequeTest extends TestCase {
	protected ArrayDeque<String> deque;

	// Methods run before each unit test case.
	protected void setUp() {
		this.deque = new ArrayDeque<>();
	}

	// method can be run after each unit test is
	// protected void tearDown() {}

	// Unit test for init queue has zero length.
	// Notice all the unit test should
	// start will test then + other words.
	public void testInitSizeZero() {
		assertEquals(deque.size(), 0);
		assertEquals(true, deque.isEmpty());
	}

	public void testOperationOnEmptyDeque() {
		assertEquals(null, deque.removeFirst());
		assertEquals(null, deque.removeLast());
		assertEquals(null, deque.get(0));
		assertEquals(deque.size(), 0);
		assertEquals(true, deque.isEmpty());
	}

	/**
	 * Test case when we first add 51, the queue
	 * performs good. Then we add 31, the queue
	 * performs good too.
	 **/
	public void testAddFirst() {
		deque.addFirst("51");
		assertEquals(1, deque.size());
		assertEquals(false, deque.isEmpty());
		assertEquals("51", deque.get(0));

		deque.addFirst("31");
		assertEquals(2, deque.size());
		assertEquals(false, deque.isEmpty());
		assertEquals("51", deque.get(1));
		assertEquals("31", deque.get(0));
		assertEquals(null, deque.get(2));
	}

	public void testAddLast() {
		deque.addLast("67");
		assertEquals(1, deque.size());
		assertEquals(false, deque.isEmpty());
		assertEquals("67", deque.get(0));

		deque.addLast("59");
		assertEquals(2, deque.size());
		assertEquals(false, deque.isEmpty());
		assertEquals("67", deque.get(0));
		assertEquals("59", deque.get(1));

		deque.addFirst("88");
		assertEquals(3, deque.size());
		assertEquals(false, deque.isEmpty());
		assertEquals("88", deque.get(0));
		assertEquals("67", deque.get(1));
		assertEquals("59", deque.get(2));
	}

	public void testRemoveFirst() {
		deque.addLast("UI");
		assertEquals(deque.removeFirst(), "UI");
		assertEquals(0, deque.size());
		assertEquals(true, deque.isEmpty());
		assertEquals(null, deque.removeFirst());

		deque.addLast("kl");
		deque.addLast("jk");
		assertEquals(2, deque.size());
		assertEquals("kl", deque.removeFirst());
		assertEquals(1, deque.size());
		assertEquals(false, deque.isEmpty());
	}

	public void testRemoveLast() {
		deque.addLast("UI");
		assertEquals(deque.removeLast(), "UI");
		assertEquals(0, deque.size());
		assertEquals(true, deque.isEmpty());
		assertEquals(null, deque.removeFirst());

		deque.addLast("kl");
		deque.addLast("jk");
		assertEquals(2, deque.size());
		assertEquals("jk", deque.removeLast());
		assertEquals(1, deque.size());
		assertEquals(false, deque.isEmpty());
	}

	public void testGet() {
		assertEquals(null, deque.get(2));
		assertEquals(null, deque.get(-1));

		deque.addLast("90");
		assertEquals("90", deque.get(0));
		assertEquals(null, deque.get(-1));
	}

	public void testPressAdd() {
		int totalLength = 50;
		for (int i = 0; i < totalLength; i += 1) {
			deque.addLast("ab" + i);
		}
		assertEquals(totalLength, deque.size());
		deque.printDeque();
		int i = 0;
		while (i < totalLength) {
			assertEquals("ab" + i, deque.removeFirst());
			i += 1;
		}
	}
}
