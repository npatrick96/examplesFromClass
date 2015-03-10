package examples;

import static org.junit.Assert.*;

import org.junit.Test;

public class StackTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	@Test
	public void emptyBad(){
		Stack<String> s= new Stack<String>();
		assertTrue(s.isEmpty());
		s.top();
	}

}
