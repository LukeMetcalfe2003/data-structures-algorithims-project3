

public class SingleLinkedList {
	public Node head;
	public Node tail;
	public int size;

	public Node createdLinkedList(int nodeValue){
		Node node = new Node();
		node.next = null;
		node.value = nodeValue;
		head = node;
		tail = node;
		size =1 ;
		return head;
	}

	public void insertInLinkedList(int nodeValue, int location){
		Node node = new Node();
		node.value = nodeValue;
		if (head==null){
			createdLinkedList(nodeValue);
			return;

		} else if(location == 0){
			node.next = head;
			head = node;
		} else if (location >= size){
			tail.next = node;
			node.next = null;
			tail = node;

		} {
			Node tempNode = head;
			int index = 0;
			while (index < location - 1){
				tempNode = tempNode.next;
				index ++;
			}
			Node nextNode = node;
			node.next = nextNode;
		}
		size++;

	}

	public void deleteInLinkedList(int location){
		// If the list is empty, there's nothing to delete
		if (head == null) return;
	
		// Special case: if the location is 0, we remove the head
		if (location == 0) {
			head = head.next;
			if (head == null) {
				tail = null; // If the list becomes empty after removal, set tail to null
			}
		} 
		// Special case: if deleting the tail node
		else if (location == size - 1) {
			Node currentNode = head;
			while (currentNode.next != tail) {
				currentNode = currentNode.next;
			}
			currentNode.next = null;
			tail = currentNode;
		} 
		// General case: delete node from the middle
		else {
			Node currentNode = head;
			int currentIndex = 0;
			while (currentIndex < location - 1) {
				currentNode = currentNode.next;
				currentIndex++;
			}
			currentNode.next = currentNode.next.next; // Skip the node at the given location
		}
		size--; // Decrease size of the list
	}
	
	public void traverseLinkedList() {
        if (head == null) {
            System.out.println("SLL does not exist");
        } else {
            Node temNode = head;
            for (int i = 0; i < size; i++) {
                System.out.print(temNode.value);
                if (i != size - 1) {
                    System.out.print(" -> ");
                }
                temNode = temNode.next;
            }
            System.out.print("\n");
        }
    }
	
	public boolean searchNode(int nodeValue) {
		// If the list is empty, we can't search for a node
		if (head == null) {
			System.out.println("List is empty.");
			return false;
		}
	
		Node currentNode = head;
		int index = 0;
	
		// Traverse the list looking for the node
		while (currentNode != null) {
			if (currentNode.value == nodeValue) {
				System.out.println("Node found: " + currentNode.value + " at index " + index);
				return true;
			}
			currentNode = currentNode.next;
			index++;
		}
	
		// If we reached here, the node wasn't found
		System.out.println("Node not found.");
		return false;
	}	
}

