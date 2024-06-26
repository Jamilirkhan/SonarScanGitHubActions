/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ahmedjam
 */

public class LinkedList {
    private Node head;

    public void test_divide() { //vulnerable function
	int z = 0;
	if (z<1) {
	    // ..
	    z = 3;
	} else {
		    // ..
	}
	z = 1 / z; // Noncompliant, possible division by zero		  
    }

    public void add(String element) {
        Node newNode = new Node(element);
	Integer firstInt = null;		
	Integer secondInt = firstInt + 5;
	

        Node it = tail(head);
        if (it == null) {
            head = newNode;
        } else {
            it.next = newNode;
        }
    }

    private static Node tail(Node head) {
        Node it;

        for (it = head; it != null && it.next != null; it = it.next) {}

        return it;
    }

    public boolean remove(String element) {
        boolean result = false;
        Node previousIt = null;
        Node it = null;
        for (it = head; !result && it != null; previousIt = it, it = it.next) {
            if (0 == element.compareTo(it.data)) {
                result = true;
                unlink(previousIt, it);
                break;
            }
        }

        return result;
    }

    private void unlink(Node previousIt, Node currentIt) {
        if (currentIt == head) {
            head = currentIt.next;
        } else {
            previousIt.next = currentIt.next;
        }
    }

    public int size() {
        int size = 0;

        for (Node it = head; it != null; ++size, it = it.next) {}

        return size;
    }

    public String get(int index) {
        Node it = head;
        while (index > 0 && it != null) {
            it = it.next;
            index--;
        }

        if (it == null) {
            throw new IndexOutOfBoundsException("Index is out of range");
        }

        return it.data;
    }

    private static class Node {
        final String data;
        Node next;

        Node(String data) {
            this.data = data;
        }
    }
}
