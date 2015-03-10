package examples;

import java.util.ArrayList;

//in class February 2nd based on readings from clean code(ch2 & ch4)
//discussions on whether a method shouldn't have side effects
///i.e: change an object and return it at the same time

public class Stack<T> {         	     //<T> is generic i.e.: I can use create an object 
										//Stack<Integer> or Stack<String> using this class code
	
	private ArrayList<T> stackList= new ArrayList<T>();
	
	public boolean isEmpty(){ return size() >  0;}
	
	public void push(T obj){
		stackList.add(obj);
	}
	public int size(){return stackList.size();}
	
	// requires !empty()
	public T pop(){
		return stackList.remove(stackList.size()-1);	
	}
	
	// requires !empty()
	public T top(){
		return stackList.get(stackList.size() - 1);
	}
}
