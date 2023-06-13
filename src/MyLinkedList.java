
//Author: Stipan Madzar

import java.util.*;


public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	public MyLinkedList() {
		size = 0;
		head = new LLNode<E>(null);
		tail = new LLNode<E>(null);
	    head.next = tail;
	    tail.prev = head;   	
	}
    
    //Add an element to the list
	public boolean add(E element ) 
	{
		if(element == null) {
			throw new NullPointerException();
		}
		if(size == 0) {
			LLNode<E> node = new LLNode<E>(element);
			node.next = tail;
			node.prev = head;
			tail.prev = node;
			head.next = node;	
		}
		else {
			LLNode<E> node = new LLNode<E>(element);
			node.next = tail;
			node.prev = tail.prev;
			tail.prev.next = node;
			tail.prev = node;	
		}
		size++;
		return false;
	}

    //Get the data from the list node
	public E get(int index) 
	{

		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		
		LLNode<E> getNode = head;
		
		for(int i = 0; i <= index; i++) {
			getNode = getNode.next;
		}
		return getNode.data;
	}

    //Add an element to the list at the specific index
	public void add(int index, E element ) 
	{
		
		if(element == null) {
			throw new NullPointerException();
		}
		
		if(index > size || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		
		LLNode<E> right = head;
		LLNode<E> left = head;
		
		for(int i = 0; i <= index; ++i) {
			
			if(i != index) {
				left = left.next;
			}
			right = right.next;
		}
		
		LLNode<E> node = new LLNode<E>(element);
		node.next = right;
		node.prev = left;
		left.next = node;
	    right.prev = node;	
	    
		size++;
	}


	//Returns the size of the list
	public int size() 
	{
		return this.size;
	}

    //Remove a node at the specified index and return its data element
	public E remove(int index) 
	{
		
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		
		LLNode<E> right = head;
		LLNode<E> left = head;
		
        for(int i = 0; i <= index + 1; ++i) {
			
			if(i < index) {
				left = left.next;
			}
			right = right.next;
		}
        E elem = right.prev.data;
        
        left.next = right;
        right.prev = left;
		
        size--;
		return elem;
	}

    //Set an index position in the list to a new element
	public E set(int index, E element) 
	{
		
		if(element == null) {
			throw new NullPointerException();
		}
		
		if(index < 0 || !(index < size)) {
			throw new IndexOutOfBoundsException();
		}

		LLNode<E> node = head;

        for(int i = 0; i <= index; ++i) {
			
			node = node.next;
		}
        E data = node.data;
        node.data = element;

		return data;
	}   

}



