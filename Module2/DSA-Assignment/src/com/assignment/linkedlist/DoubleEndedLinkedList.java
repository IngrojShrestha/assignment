package com.assignment.linkedlist;

public class DoubleEndedLinkedList<E> {

	private Node<E> head = null;
	private Node<E> tail = null;
	private int size = 0;

	public DoubleEndedLinkedList() {

	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public E first() {
		if (isEmpty())
			return null;
		return head.getElement();
	}

	public E last() {
		if (isEmpty())
			return null;
		return tail.getElement();
	}

	public void addFirst(E e) {
		head = new Node<>(e, head);
		if (size == 0)
			tail = head;
		size++;

	}

	public void addLast(E e) {
		Node<E> newest = new Node<>(e, null);
		if (isEmpty())
			head = newest;
		else {
			tail.setNext(newest);

		}
		tail = newest;
		size++;

	}

	public E removeFirst() {
		if (isEmpty())
			return null;
		E answer = head.getElement();
		head = head.getNext();
		size--;
		if (size == 0)
			tail = null;
		return answer;
	}

	public E removeLast() {
		if (isEmpty())
			return null;
		Node<E> hold = this.head;

		while (hold.getNext().getNext() != null) {
			hold = hold.getNext();
		}
		E answer = hold.getNext().getElement();
		hold.setNext(null);
		return answer;

	}

	public String findNode(int element) {
		Node<E> current = this.head;
		int i = 0;
		while (current != null) {
			if (current.getElement().equals(Integer.valueOf(element))) {
				return "Found at positon " + i;
			}
			current = current.getNext();
			i++;
		}
		return "Not found";
	}

	public void addAtPosition(E e, int position) {
		Node<E> q = this.head;
		for (int i = 0; i < position - 1; i++) {
			q = q.getNext();
			if (q == null) {
				System.out.println(String.format("There are less than %d elements", position));
				return;
			}
		}

		Node<E> newNode = new Node<E>(e, q.getNext());
		q.setNext(newNode);
		size++;

	}

	public void deleteNode(int element) {
		// remove at the start
		Node<E> start = this.head;
		if (start.getElement().equals(element)) {
			this.head = start.getNext();
			return;
		}

		// remove in between
		Node<E> hold = this.head;

		while (hold.getNext().getNext() != null) {
			if (hold.getNext().getElement().equals(element)) {
				Node<E> temp = hold.getNext();
				hold.setNext(temp.getNext());
				temp = null;
				return;
			}
			hold = hold.getNext();
		}

		// remove from the end
		if (hold.getNext().getElement().equals(element)) {
			hold.setNext(null);
			return;
		}
		System.out.println("Element " + element + " not found");
	}

	@Override
	public String toString() {
		Node<E> current = this.head;
		String result = "{";
		while (current != null) {
			result += " " + current.toString() + ",";
			current = current.getNext();
		}
		result += "}";
		return result;
	}

}
