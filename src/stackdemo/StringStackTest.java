package stackdemo;

import static org.junit.Assert.*;

import java.util.EmptyStackException;

import org.junit.Test;

public class StringStackTest {
	
	void checkPush(StringStack s, String value) {
		StringStack old = new StringStack(s);
		s.push(value);
		for (int i = 0; i < old.size(); i++) {
			assertEquals(old.peekBelow(i), s.peekBelow(i+1));
		}
		assertEquals(old.size() + 1, s.size());
		assertEquals(value, s.peek());
	}
	
	void checkPop(StringStack s) {
		StringStack old = new StringStack(s);
		assertEquals(old.peek(), s.pop());
		assertEquals(old.size() - 1, s.size());
		for (int i = 0; i < old.size() - 1; i++) {
			assertEquals(old.peekBelow(i+1), s.peekBelow(i));
		}
	}

	@Test(expected=EmptyStackException.class)
	public void test() {
		StringStack stack = new StringStack();
		assertTrue(stack.isEmpty());
		
		checkPush(stack, "a");
		
		for (int i = 0; i < 8; i++) {
			checkPush(stack, Integer.toString(i));
		}
		
		while (!stack.isEmpty()) {
			checkPop(stack);
		}
		
		assertTrue(stack.isEmpty());
		stack.pop();
	}
	
	

}
 