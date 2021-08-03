package com.codingdojo.dll;

public class DLL {
	public Node head;
    public Node tail;
    
    public DLL() {
        this.head = null;
        this.tail = null;
    }
    
    public void push(Node newNode) {
        if(this.head == null) {
            this.head = newNode;
            this.tail = newNode;
            return;
        }
        Node lastNode = this.tail;
        lastNode.next = newNode;
        newNode.previous = lastNode;
        this.tail = newNode;
    }
    
    public Node pop() {
    	if(this.tail==null) {
    		return null;
    	} else if (this.tail==this.head){
    		Node removedNode = this.tail;
    		this.tail=null;
    		this.head=null;
    		removedNode.previous=null;
    		return removedNode;
    	} else {
    		Node removedNode = this.tail;
    		this.tail = this.tail.previous;
    		this.tail.next=null;
    		removedNode.previous = null;
    		return removedNode;
    	}
    }
    
    public void printValuesForward() {
        Node current = this.head;
        while(current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }
    
    public void printValuesBackward() {
    	Node current = this.tail;
        while(current != null) {
            System.out.println(current.value);
            current = current.previous;
        }
    }
    
    public boolean contains(Integer value) {
    	Node current = this.head;
    	while(current != null) {
    		if(current.value == value) {
    			return true;
    		}
    		current = current.next;
    	}
    	return false;
    }
    
    public int size() {
    	Node current = this.head;
    	int count=0;
    	while(current!=null) {
    		current = current.next;
    		count++;
    	}
    	return count;
    }
    
    public void insertAt(Node newNode, int index) {
    	Node current = this.head;
    	if(index == 0) {
    		this.head.previous = newNode;
    		newNode.next = this.head;
    		this.head = newNode;
    	} else {    		
    		int i=0;
    		while(i<index && current!=null) {
    			current = current.next;
    			i++;
    		}
    		if(current!=null) {    		
    			Node nextNode = current.next;
    			current.next = newNode;
    			newNode.previous = current;
    			newNode.next = nextNode;
    			nextNode.previous = newNode;
    		}
    	}
    }
    
    public void removeAt(int index) {
    	if(index==0) {
    		this.head = this.head.next;
    		this.head.previous = null;
    	} else {
    		Node current = this.head;
    		int i = 0;
    		while(i<index && current!=null) {
    			current = current.next;
    			i++;
    		}
    		if(current!=null) {
    			current.previous.next = current.next;
    			if(current.next==null) {
    				this.tail = current.previous;
    			} else {
    				current.next.previous = null;
    			}
    		}
    	}
    }
    
    public boolean isPalindrome() {
    	double mid = this.size()/2;
    	int i = 0;
    	Node head = this.head;
    	Node tail = this.tail;
    	while(i<mid) {
    		if(head.value != tail.value) {
    			return false;
    		}
    		i++;
    	}
    	return true;
    }
}
