package dataStructure.linkedList;

public class LinkedList {

	/**
	 * @param args
	 */
	Node head;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList linkList = new LinkedList();
		linkList.head = new Node(1);
		Node second = new Node(2);
		Node third = new Node(3);
		linkList.head.next = second;
		second.next = third;
		third.next = new Node(2);
		printLinkList(linkList);
		System.out.println("Reverse List");
		printReverseList(linkList.head);
		linkList = push(linkList, 4);
		printLinkList(linkList);
		linkList = insertAfter(linkList, second, 6);
		printLinkList(linkList);
		linkList = append(linkList, 8);
		printLinkList(linkList);
		System.out.println("After Duplicate Removal");
		removeDuplicates(linkList);
		linkList = deleteKey(linkList, 6);
		printLinkList(linkList);
		linkList = deletePosition(linkList, 0);
		printLinkList(linkList);
		swap(linkList, 8, 9);
		printLinkList(linkList);
		getNNode(linkList, 3);
		getMidNode(linkList);
		getNEndNode(linkList, 5);
		getValueCount(linkList, 0);
		linkList = reverseList(linkList);
		printLinkList(linkList);
		LinkedList lList = new LinkedList();
		Node n = new Node(5);
		lList.head = n;
		n.next = new Node(4);
		n.next.next = n;
		loopSearch(lList);
		mergeLinkList();
	}

	private static void printLinkList(LinkedList linkList) {
		// TODO Auto-generated method stub
		Node n = linkList.head;
		int count = 0;
		while (n != null) {
			System.out.println(n.data);
			n = n.next;
			count++;
		}
		System.out.println("Yo" + count);
	}

	public static LinkedList push(LinkedList lList, int d) {
		Node n = new Node(d);
		n.next = lList.head;
		lList.head = n;
		return lList;
	}

	public static LinkedList insertAfter(LinkedList lList, Node n, int data) {
		Node n1 = new Node(data);
		n1.next = n.next;
		n.next = n1;
		return lList;
	}

	public static LinkedList append(LinkedList lList, int data) {
		Node n = new Node(data);
		if (lList.head == null) {
			lList.head = n;
		} else {
			Node n1 = lList.head;
			while (n1.next != null) {
				n1 = n1.next;
			}
			n1.next = n;
		}
		return lList;
	}

	public static LinkedList deleteKey(LinkedList lList, int key) {
		Node n1 = lList.head;
		if (n1 == null) {
			System.out.println("List Empty");
		} else if (n1.data == key) {
			lList.head = n1.next;
		} else {
			while (n1.next != null && n1.next.data != key) {
				n1 = n1.next;
			}
			if (n1.next == null) {
				System.out.println("No Value Deleted");
			} else if (n1.next.data == key) {
				n1.next = n1.next.next;
			}
		}
		return lList;
	}

	public static LinkedList deletePosition(LinkedList lList, int pos) {
		Node n1 = lList.head;
		if (n1 == null) {
			System.out.println("List Empty");
		} else if (pos == 0) {
			lList.head = n1.next;
		} else {
			while (n1.next != null && pos > 1) {
				n1 = n1.next;
				pos--;
			}
			if (n1.next == null) {
				System.out.println("No Value Deleted");
			} else if (pos == 1) {
				n1.next = n1.next.next;
			}
		}
		return lList;
	}

	public static LinkedList swap(LinkedList lList, int x, int y) {
		Node currY = lList.head;
		Node currX = lList.head;
		Node prevX = null;
		Node prevY = null;
		if (x == y) {
			return lList;
		}

		while (currX != null && currX.data != x) {
			prevX = currX;
			currX = currX.next;
		}
		while (currY != null && currY.data != y) {
			prevY = currY;
			currY = currY.next;
		}
		if (currX == null || currY == null) {
			System.out
					.println("Swap Not Possible,either of element not in list");
			return lList;
		}
		if (prevX != null) {
			prevX.next = currY;
		} else {
			lList.head = currY;
		}
		if (prevY != null) {
			prevY.next = currX;
		} else {
			lList.head = currX;
		}
		Node temp = currX.next;
		currX.next = currY.next;
		currY.next = temp;

		return lList;
	}

	public static void getNNode(LinkedList lList, int N) {
		int count = 0;

		Node n = lList.head;
		int data = n.data;
		while (count != N && n != null) {
			n = n.next;
			data = n.data;
			count++;
		}
		if (count != N) {
			System.out.println("List does not have N nodes");
			return;
		}
		System.out.println("Nth Node has " + data);
	}

	public static void getMidNode(LinkedList lList) {
		int count = 0;
		Node n = lList.head;
		while (n != null) {
			count++;
			n = n.next;
		}
		getNNode(lList, count / 2);
	}

	public static void getNEndNode(LinkedList lList, int l) {
		int count = 0;
		Node n = lList.head;
		while (n != null) {
			count++;
			n = n.next;
		}
		if (count - l < 0) {
			System.out.println("List has less number of nodes");
			return;
		}
		getNNode(lList, count - l);
	}

	public static void getValueCount(LinkedList lList, int l) {
		int count = 0;
		Node n = lList.head;
		while (n != null) {
			if (n.data == l)
				count++;
			n = n.next;
		}
		System.out.println(count);
	}

	public static LinkedList reverseList(LinkedList lList) {
		Node current = lList.head;
		Node next = null;
		Node previous = null;
		while (current != null) {
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		lList.head = previous;
		return lList;
	}

	public static void loopSearch(LinkedList lList) {
		Node n = lList.head;
		Node n1 = lList.head;
		while (n.next != null && n1.next != null && n1.next.next != null) {
			n = n.next;
			n1 = n1.next.next;
			if (n == n1) {
				System.out.println("Found Loop");
				return;
			}
		}
		System.out.println("No Loop");
	}

	public static void mergeLinkList() {
		LinkedList lList1 = new LinkedList();
		lList1.head = new Node(1);
		lList1.head.next = new Node(2);
		lList1.head.next.next = new Node(7);
		LinkedList lList2 = new LinkedList();
		lList2.head = new Node(4);
		lList2.head.next = new Node(6);
		lList2.head.next.next = new Node(7);
		/*
		 * intersectionPoint(lList1, lList2); return;
		 */
		intersectionList(lList1,lList2);
		LinkedList lList = new LinkedList();
		Node n1 = lList1.head;
		Node n2 = lList2.head;
		if (n1.data > n2.data) {
			lList.head = n2;
			n2 = n2.next;
		} else {
			lList.head = n1;
			n1 = n1.next;
		}
		Node n = lList.head;
		while (n1 != null && n2 != null) {
			if (n1.data > n2.data) {
				n.next = n2;
				n2 = n2.next;
				n = n.next;
			} else {
				n.next = n1;
				n1 = n1.next;
				n = n.next;
			}
		}
		if (n1 == null) {
			n.next = n2;
		} else {
			n.next = n1;
		}
		printLinkList(lList);
		removeDuplicates(lList);
		/*LinkedList lList4 = new LinkedList();
		insertSortedList(lList4, 9);*/

	}

	public static void insertSortedList(LinkedList lList, int data) {
		Node n = lList.head;
		Node n1 = new Node(data);
		if (n == null || n.data > data) {
			lList.head = n1;
			n1.next = n;
		} else {
			while (n.next != null && n.next.data < data) {
				n = n.next;
			}
			if (n.next == null) {
				n.next = n1;
			} else {
				n1.next = n.next;
				n.next = n1;
			}
		}
		printLinkList(lList);
		checkPalindrome();
	}

	public static void checkPalindrome() {
		LinkedList lList = new LinkedList();
		lList.head = new Node(1);
		lList.head.next = new Node(3);
		lList.head.next.next = new Node(4);
		lList.head.next.next.next = new Node(3);
		lList.head.next.next.next.next = new Node(2);
		Node n = lList.head;
		LinkedList lList1 = reverseList(lList);
		Node n1 = lList1.head;
		while (n != null) {
			if (n.data != n1.data) {
				System.out.println("Not Palindrome");
				return;
			}
			n = n.next;
			n1 = n1.next;
		}
		System.out.println("Palindrome");

	}

	public static void intersectionPoint(LinkedList lList1, LinkedList lList2) {
		Node node1 = lList1.head;
		Node node2 = lList2.head;
		int count1 = 0;
		int count2 = 0;
		while (node1 != null) {
			count1++;
			node1 = node1.next;
		}
		while (node2 != null) {
			count2++;
			node2 = node2.next;
		}
		if (count1 > count2) {
			node1 = lList1.head;
			node2 = lList2.head;
			int ahead = count1 - count2;
			while (ahead != 0) {
				node1 = node1.next;
				ahead--;
			}
			while (node1 != null) {
				if (node1 == node2) {
					System.out.println(node1.data);
					return;
				}
				node1 = node1.next;
				node2 = node2.next;
			}
		} else {
			node1 = lList1.head;
			node2 = lList2.head;
			int ahead = count2 - count1;
			while (ahead != 0) {
				node2 = node2.next;
				ahead--;
			}
			while (node1 != null) {
				if (node1 == node2) {
					System.out.println(node1.data);
					return;
				}
				node1 = node1.next;
				node2 = node2.next;
			}
		}
		System.out.println("No Intersection");
	}

	public static void printReverseList(Node n) {
		if (n.next != null) {
			printReverseList(n.next);
		}
		System.out.println(n.data);
	}
	
	public static void removeDuplicatesSortedList(LinkedList lList){
		Node n = lList.head;
		if(n==null){
			return;
		}
		while(n.next!=null){
			Node temp = n.next;
			if(n.data==temp.data){
				n.next=temp.next;
			}
			else{
				n=n.next;
			}
		}
		printLinkList(lList);
	}

	public static void removeDuplicates(LinkedList lList){
		Node n = lList.head;
		Node n1;
		if(n==null){
			return;
		}
		while(n.next!=null){
			n1=n;
			while(n1.next!=null){
				Node temp = n1.next;
				if(n.data==temp.data){
					n1.next=temp.next;
				}
				else{
					n1=n1.next;
				}
			}
			n=n.next;
			if(n==null){
				break;
			}
		}
		printLinkList(lList);
		swapElements(lList);
	}
	
	public static void swapElements(LinkedList lList){
		Node n = lList.head;
		while(n!=null && n.next!=null){
			int k = n.data;
			n.data = n.next.data;
			n.next.data = k;
			n=n.next.next;
		}
		printLinkList(lList);
		modifyHead(lList);
	}
	
	public static void modifyHead(LinkedList lList){
		Node n = lList.head;
		if(n==null || n.next==null){
			return;
		}
		while(n.next.next!=null){
			n=n.next;
		}
		Node temp = n.next;
		Node temp2 = lList.head;
		temp.next=temp2;
		lList.head=temp;
		n.next=null;
		System.out.println("Modify Head");
		printLinkList(lList);
	}
	
	public static void intersectionList(LinkedList lList1,LinkedList lList2){
		Node n = lList1.head;
		Node n1 = lList2.head;
		LinkedList lList = new LinkedList();
		Node n2 = null;
		while(n.next!=null && n1.next!=null){
			if(n.data<n1.data){
				if(n2==null){
					n2 = new Node(n.data);
					lList.head=n2;
				}
				else{
					Node temp = new Node(n.data);
					n2.next=temp;
					n2=n2.next;
				}
				n=n.next;
			}
			else if(n1.data<n.data){
				if(n2==null){
					n2 = new Node(n1.data);
					lList.head = n2;
				}
				else{
					Node temp = new Node(n1.data);
					n2.next=temp;
					n2=n2.next;
				}
				n1=n1.next;
			}
			else{
				n1=n1.next;
				n=n.next;
			}
		}
		if(n1.next!=null){
			while(n1.next!=null){
				Node temp = new Node(n1.data);
				n2.next=temp;
				n2=n2.next;
				n1=n1.next;
			}
		}
		else{
			while(n.next!=null){
				Node temp = new Node(n.data);
				n2.next=temp;
				n2=n2.next;
				n=n.next;
			}
		}
		System.out.println("lList1");
		printLinkList(lList1);
		System.out.println("lList2");
		printLinkList(lList2);
		System.out.println("lList");
		printLinkList(lList);
		separateList(lList);
		deleteAlternate(lList);
		separateList(lList);
	}
	
	public static void deleteAlternate(LinkedList lList){
		Node n = lList.head;
		while(n!=null && n.next!=null){
			n.next=n.next.next;
			n=n.next;
		}
		printLinkList(lList);
	}
	
	public static void separateList(LinkedList lList){
		System.out.println("Main List");
		printLinkList(lList);
		Node n = lList.head;
		LinkedList lList1 = new LinkedList();
		LinkedList lList2 = new LinkedList();
		Node n1 = lList1.head;
		Node n2 = lList2.head;
		while(n!=null && n.next!=null){
			if(lList1.head==null){
				System.out.println("In IF");
				lList1.head=n;
				lList2.head=n.next;
				n1=lList1.head;
				n2=lList2.head;
			}
			else{
				n1=n;
				n2=n.next;	
			}
			n1=n1.next;
			n2=n2.next;
			n=n.next.next;
		}
		if(n!=null){
			n1.next=n;
		}
		lList1.head=n1;
		lList2.head=n2;
		System.out.println("First List");
		printLinkList(lList1);
		System.out.println("Second List");
		printLinkList(lList2);
	}
	
	static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
		}
	}
}