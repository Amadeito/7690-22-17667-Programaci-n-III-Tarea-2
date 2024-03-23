package Metodos_de_Ordenamiento;
//Esta clase es para la lista
class LinkedList {
	static class Node{
		int data;
		Node next;
		
		Node(int data){
			this.data=data;
			this.next=null;
		}
	}
	
	Node head;
	
	LinkedList(){
		this.head = null;
	}
	
	void insert(int data) {
		Node newNode = new Node(data);
		if(head == null) {
			head = newNode;
			
		}else {
			Node current = head;
			while(current.next != null) {
				current = current.next;
			}
			current.next = newNode;
		}
	}
	
	void display() {
		Node current = head;
		while(current != null) {
			System.out.println(current.data + " ");
			current = current.next;
		}
		System.out.println();
	}
	
	void merge(LinkedList otherList) {
        if (otherList.head == null) {
            return;
        }
        
        if (head == null) {
            head = otherList.head;
            return;
        }
        
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = otherList.head;
    }

}
