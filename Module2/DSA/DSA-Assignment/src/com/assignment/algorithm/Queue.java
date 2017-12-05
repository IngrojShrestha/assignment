package com.assignment.algorithm;

import java.util.Arrays;

public class Queue<E> {

	private final int size;
	private E[] data;

	private int front = 0; // index of head element
	private int current_data_size = 0; // current #elements

	@SuppressWarnings("unchecked")
	public Queue() {
		this.size = 5;
		data = (E[]) new Object[size];
	}

	public int size() {
		return current_data_size;
	}

	public boolean isEmpty() {
		return current_data_size == 0;
	}

	public void enqueue(E e) {
		if (current_data_size == data.length)
			throw new RuntimeException("Queue is full");
		int avail = (front + current_data_size) % data.length;
		data[avail] = e;
		current_data_size++;
	}

	public E dequeue() {
		if (isEmpty())
			throw new RuntimeException("Queue is empty");
		E element = data[front];
		data[front] = null;
		front = (front + 1) % data.length;
		current_data_size--;
		return element;
	}

	public void traverse() {
		if (isEmpty())
			throw new RuntimeException("Queue is empty");
		for (int i = 0; i <= current_data_size; i++) {
			if (data[i]!=null)
				System.out.println(data[i]);
		}
	}

	@Override
	public String toString() {
		return "QueueGeneric [data=" + Arrays.toString(data) + "]";
	}

}
