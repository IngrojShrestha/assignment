package com.assignment.algorithm;

import java.util.Arrays;

public class Stack<E> {

	private final int size;
	private int top;

	private E[] item;

	@SuppressWarnings("unchecked")
	public Stack() {
		this.size = 10;
		top = -1;

		item = (E[]) new Object[size];
	}

	public boolean isEmpty() {
		return top == -1;
	}

	public int size() {
		return top + 1;
	}

	public void push(E e) {
		if (size() == item.length)
			throw new RuntimeException("Stack is full");
		item[++top] = e;
	}

	public E pop() {
		if (isEmpty())
			throw new RuntimeException("Stack is empty");
		E data = item[top];
		item[top] = null;
		top--;
		return data;
	}

	public E peek() {
		if (isEmpty())
			throw new RuntimeException("Stack is empty");
		return item[top];

	}

	public static <E> void reverse(E[] a) {
		Stack<E> stackGeneric = new Stack<>();
		for (int i = 0; i < a.length; i++) {
			stackGeneric.push(a[i]);
		}
		for (int i = 0; i < a.length; i++) {
			a[i] = stackGeneric.pop();
		}

	}

	public void traverse() {
		if (isEmpty())
			throw new RuntimeException("Stack is empty");
		for (int i = item.length - 1; i >= 0; i--) {

			if (item[i] != null)
				System.out.println(item[i]);
		}

	}

	@Override
	public String toString() {
		return "StackGeneric [item=" + Arrays.toString(item) + "]";
	}

}
