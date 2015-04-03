package stackdemo;

import java.util.EmptyStackException;

public class StringStack {
	private String[] array;
	private int size;
	
	public StringStack() {
		array = new String[8];
		size = 0;
	}
	
	//Data Invarient
		public boolean isConsistent(){
			return array!= null && size >=0 && size<=array.length;
		}
	
	public StringStack(StringStack other) {
		this.array = new String[other.array.length];
		this.size = other.size;
		for (int i = 0; i < size; i++) {
			this.array[i] = other.array[i];
		}
	}
	
	public String pop() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		
		return array[--size];
	}
	
	public void push(String s) {
		if (size == array.length) {
			String[] oldArray = array;
			array = new String[array.length * 2];
			for (int i = 0; i < size; i++) {
				array[i] = oldArray[i];
			}
		}
		array[size++] = s;
	}
	
	public String peek() {return peekBelow(0);}
	
	public String peekBelow(int i) {
		return array[size - 1 - i];
	}
	
	public int size() {return size;}
	
	public boolean isEmpty() {
		return size == 0;
	}
}
