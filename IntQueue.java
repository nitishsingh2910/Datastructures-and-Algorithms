package hw03;

public class IntQueue {
	
	//defining data members
	private int front;
    private int rear;
    int size;				
    int capacity;
    int queue[];
    
    //Constructor call
    public IntQueue(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        front = 0;
        size = 0;
        rear = capacity-1;
    }
    
    //to check if the queue is empty
    public boolean isEmpty() {
        return size==0;
    }
    
    //to check if the queue is full
    public boolean isFull() {
    	return size==capacity;
    }
    
    //To enqueue an element
    public void enQueue(int value) {
        if(isFull())
        	System.out.println("Queue is Full");
        else {
        	rear = (rear+1) % capacity;
        	queue[rear] = value;
        	size++;
        }	
    }
    
    //To dequeue an element
    public int deQueue() {
        if(isEmpty())
        	return -1;
        else {
        	int item = queue[front];
        	front = (front+1) % capacity;
        	size--;
        	return item;
        }
    }
    
    //to show the contents of the queue
    public void show() {
		for(int i=0; i<queue.length; i++) {
			System.out.print(queue[i]+" ");
		}
		System.out.println();
	}
}

