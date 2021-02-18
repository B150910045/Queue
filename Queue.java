import java.util.*;

public class Queue {

	Object[] array;
	int size1;
	int head;
	int capacity;
	
	public Queue(int capacity) {
		this.capacity = capacity;
		array = new Object[capacity];
		head = 0;
		size = 0;
	}
	
	public boolean isEmpty() {
		if(size == 0)
			return true;
		else
			return false;
	}
	
	public boolean isFull() {
		if(size == capacity)
			return true;
		else 
			return false;
	}
	
	public String toString() {
		return Arrays.toString(array);
	}
	
	public Object peek() {
		return array[head];
	}
	
	public Object peekTail() {
		return array[size - 1];
	}
	
	public Object add(Object item) {
		if(isFull())
			return "The queue is full";
		size++;
		array[size-1] = item;
		return item;
	}
	
	public Object remove() {
		if(isEmpty())
			return "The queue is empty";
		Object removedItem = array[head];
		for(int i = 1; i < size; i++) {
			array[i-1] = array[i];
			array[i] = null;
		}
		return removedItem;
	}
	
	public static void main(String[] args) {
		Queue que = null;
		Scanner scn = new Scanner(System.in);
		boolean bool = true;
		int input;
        int size = 0;
			
		while(bool) {
			
			System.out.println("1. create queue");
			System.out.println("2. add item");
			System.out.println("3. get first item");
			System.out.println("4. get last item");
			System.out.println("5. remove item");
			System.out.println("6. check if empty");
			System.out.println("7. check if full");
			System.out.println("8. exit");
			
            try{
                input = scn.nextInt();		
                switch(input) {
                case 1:
                    System.out.println("Queue size:");
                    size = scn.nextInt();
                    que = new Queue(size);
                    break;
                case 2:
                    Object item;
                    for(int i=1;i<=size;i++) {
                        System.out.println("input item number " + i + " : ");
                        item = scn.next();
                        que.add(item);
                    }
                    System.out.println(que.toString());
                    break;
                case 3: 
                    System.out.println("first item is : " + que.peek());
                    break;
                case 4:
                    System.out.println("last item is : " + que.peekTail());
                    break;
                case 5:
                    System.out.println("removed " + que.remove());
                    System.out.println(que.toString());
                    break;
                case 6:
                    System.out.println(que.isEmpty());
                    break;
                case 7:
                    System.out.println(que.isFull());
                    break;
                case 8:
                    bool = false;
                    scn.close();
                    break;
                default:
                    System.out.println("Input only the numbers 1-8");
                }
            }catch(InputMismatchException e){bool = false;}
		}
	}

}
