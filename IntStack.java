package hw03;

public class IntStack {
	//defining data members
	private int top;
	private int size;
	int stack[];
	
	//defining constructor
	public IntStack(int stackSize){
		size= stackSize;
		top= -1;
		stack = new int[size];
	}
	
	//checking if the stack is empty
	public boolean isEmpty() {
		return top == -1;	
	}
	
	//checking if the stack is full
	public boolean isFull() {
		return (top+1)==size;
	}
	
	//Pushing an element onto the stack
	public void push(int x){
		if(!isFull()) {
			top++;
			stack[top]= x;
		}
		else {
		System.out.println("Stack is Full");
		}
	}
	
	//popping an element out of stack
	public int pop() {
		if(!isEmpty()) {
				top--;
				return (stack[top+1]);
		}
		else {
			System.out.println("Stack is Empty");
			return -1;
		}
	}
	
	//peeking an element on top of stack
	public int peek() {
		if(!isEmpty()) {
			return stack[top];
		}
		else {
			System.out.println("Stack is Empty");
			return -1;
		}
	}
	
	//To show the elements on the stack
	public void show() {
		for(int i=0; i<stack.length; i++) {
			System.out.println(stack[i]);
		}
	}
}
