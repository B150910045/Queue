import java.util.*;

class Queue {
	class Node{
		Object data;
		Node next;
		Node(Object x){
			data = x;
			next = null;
		}
	}

	Node front, rear;

	public Queue(){
		front = rear = null;
	}

	public boolean isEmpty(){
		return (front == null);
	}

    public Object getFront(){
        return front.data;
    }

    public Object getRear(){
        return rear.data;
    }

	public Object remove(){
		if(isEmpty()){
			System.out.printlm("empty");
			return null;
		}
		Node temp = front;
		front = front.next;
		return temp.data;
	}

	public void insert(Object item){
		Node temp = new Node(item);
		if(isEmpty()){
			front = rear = temp;
		}else{
			rear = temp;
			rear.next = temp;
		}
	}
	
    public void print(){
        Node temp = front;
        StringBuilder str = new StringBuilder("[");
        for(int i=0;i<3;i++){
            if(temp != null){
                str.append(temp.data);
                str.append(", ");
                temp = temp.next;
            }
        }
        str.append("]");
        System.out.println(str);
    }
	public static void main(String[] args){
        Queue que = new Queue();
        Scanner scn;
        Boolean bool = true;
		int input;

        while(bool){
            System.out.println("1 - insert");
            System.out.println("2 - remove");
            System.out.println("3 - get front");
            System.out.println("4 - get rear");
            System.out.println("5 - print");
            System.out.println("6 - exit");
			try{
				scn = new Scanner(System.in);
				input = scn.nextInt();

				switch(input){
					case 1: 
						Object item;
						System.out.println("insert item :");
						item = scn.next();
						que.insert(item);
						break;
					case 2:
						que.remove();
						break;
					case 3:
						System.out.println(que.getFront());
						break;
					case 4:
						System.out.println(que.getRear());
						break;
					case 5:
						que.print();
						break;
					case 6:
						bool = false;
						break;
					default :
						System.out.println("Zuvhun 1-6 toonuud!");
				}
			}catch(InputMismatchException e){System.out.println("zuvhun 1-6 toonuud");}
        }
    }
}
