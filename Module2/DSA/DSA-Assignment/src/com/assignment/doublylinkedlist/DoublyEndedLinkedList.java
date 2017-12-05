package com.assignment.doublylinkedlist;

public class DoublyEndedLinkedList<E> {

	private Node<E> header = null;
	private Node<E> trailer = null;
	private int size = 0;

	public DoublyEndedLinkedList() {
		header = new Node<>(null, null, null);
		trailer = new Node<>(null, null, null);
		header.setNext(trailer);
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
		return header.getNext().getElement();
	}

	public E last() {
		if (isEmpty())
			return null;
		return trailer.getPrev().getElement();
	}

	public void addFirst(E e) {
		addBetween(e, header, header.getNext());

	}

	public void addLast(E e) {
		addBetween(e, trailer.getPrev(), trailer);
	}

	public E removeFirst() {
		if (isEmpty())
			return null;
		return remove(header.getNext());
	}

	public E removeLast() {
		if (isEmpty())
			return null;
		return remove(trailer.getPrev());
	}

	private E remove(Node<E> node) {
		Node<E> predecessor = node.getPrev();
		Node<E> successor = node.getNext();
		predecessor.setNext(successor);
		successor.setPrev(predecessor);
		size--;
		return node.getElement();
	}

	private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
		Node<E> newest = new Node<>(e, predecessor, successor);
		predecessor.setNext(newest);
		successor.setPrev(newest);
		size++;
	}

	public void addAtPosition(E e, int position) {
		Node<E> q = this.header;
		for (int i = 0; i < position - 1; i++) {
			q = q.getNext();
			if (q == null) {
				System.out.println(String.format("There are less than %d elements", position));
				return;
			}
		}

		Node<E> newest = new Node<>(e, q, q.getNext());
		q.setNext(newest);
		q.getNext().setPrev(newest);

	}

	public void deleteNode(int element) {
		// first element deleted
		Node<E> start = this.header.getNext();
		if (start.getElement().equals(element)) {
			this.header.setNext(start.getNext());
			start.getNext().setPrev(this.header);
			return;
		}

		// element deleted in between
		Node<E> q = this.header.getNext();
		while (q.getNext().getNext() != null) {
			if (q.getNext().getElement().equals(element)) {
				Node<E> temp = q.getNext();
				q.setNext(temp.getNext());
				temp.getNext().setPrev(q);
				temp = null;
				return;
			}
			q = q.getNext();
		}

		// last element deleted
		if (q.getElement().equals(element)) {
			q.setNext(trailer);
			trailer.setPrev(q);
			return;
		}

		System.out.println("Element " + element + " not found");

	}

	public String findNode(int element) {
		Node<E> current = this.header;
		int i = 0;
		while (current.getNext() != null) {
			if (current.getNext().getElement().equals(element)) {
				return "Found at position " + i;
			}
			current = current.getNext();
			i++;
		}
		return "Not found";
	}

	@Override
	public String toString() {
		Node<E> current = this.header;
		String result = "{";
		while (current.getNext().getElement() != null) {
			result += " " + current.getNext().toString() + ",";
			current = current.getNext();
		}
		result += "}";
		return result;
	}

}
