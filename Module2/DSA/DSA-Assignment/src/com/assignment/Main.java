package com.assignment;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

import com.assignment.algorithm.BinarySearch;
import com.assignment.algorithm.MergeSort;
import com.assignment.algorithm.Queue;
import com.assignment.algorithm.QuickSort;
import com.assignment.algorithm.Stack;
import com.assignment.bst.BinarySearchTree;
import com.assignment.doubleendedqueue.Dequeue;
import com.assignment.doublylinkedlist.DoublyEndedLinkedList;
import com.assignment.linkedlist.DoubleEndedLinkedList;
import com.assignment.util.RandomGenerator;

public class Main {

	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		Integer[] datas = RandomGenerator.generateRandomNum();

		char ch;

		do {

			System.out.println("1. Binary Search");
			System.out.println("2. Quick Sort");
			System.out.println("3. Merge Sort");
			System.out.println("4. Circular Queue");
			System.out.println("5. Double Endede Queue");
			System.out.println("6. Stack");
			System.out.println("7. Double Ended Linked List");
			System.out.println("8. Doubly Ended Linked List");
			System.out.println("9. Binary Search Tree");

			System.out.println("Please selection option (1 - 9) : ");
			int choice = in.nextInt();

			switch (choice) {
			case 1:
				binary_search(datas);
				break;

			case 2:
				quick_sort(datas);
				break;

			case 3:
				merge_sort(datas);
				break;

			case 4:
				queue_impl();
				break;

			case 5:
				dequeue_impl();
				break;

			case 6:
				stack_impl();
				break;

			case 7:
				double_ended_linked_list();
				break;

			case 8:
				doubly_ended_linked_list();
				break;

			case 9:
				binary_search_tree();
				break;

			default:
				System.out.println("Please enter valid option\n ");
				break;

			}

			System.out.println("\nDo you want to exit (Type y or n) \n");
			ch = in.next().charAt(0);
			// if (ch != 'Y' || ch != 'y' || ch != 'n' || ch != 'N') {
			// System.out.println("Please eneter valid option (y or n)");
			// ch = in.next().charAt(0);
			// }

		} while (ch == 'n' || ch == 'N');

		;

	}

	public static void binary_search(Integer[] datas) {
		long start = System.currentTimeMillis();
		Comparator<Integer> comp = new Comparator<Integer>() {
			public int compare(Integer d1, Integer d2) {
				return d1.compareTo(d2);
			}
		};

		MergeSort.mergerSort(datas, comp);
		System.out.println(Arrays.toString(datas));

		System.out.println("Enter the number to search : ");

		Integer search_data = in.nextInt();

		boolean found = BinarySearch.search(datas, search_data, 0, datas.length - 1);
		if (found)
			System.out.println("Found");
		else
			System.out.println("Not found");

		long end = System.currentTimeMillis();
		System.out.println("Algorithm Execution Time : " + (end - start) + " ms");

	}

	public static void quick_sort(Integer[] datas) {
		long start = System.currentTimeMillis();
		Comparator<Integer> comp = new Comparator<Integer>() {

			@Override
			public int compare(Integer d1, Integer d2) {
				return d1.compareTo(d2);
			}
		};
		QuickSort.quickSort(datas, comp, 0, datas.length - 1);
		System.out.println(Arrays.toString(datas));
		long end = System.currentTimeMillis();
		System.out.println("Algorithm Execution Time : " + (end - start) + "ms");
	}

	public static void merge_sort(Integer[] datas) {
		long start = System.currentTimeMillis();
		Comparator<Integer> comp = new Comparator<Integer>() {
			public int compare(Integer d1, Integer d2) {
				return d1.compareTo(d2);
			}
		};

		MergeSort.mergerSort(datas, comp);
		System.out.println(Arrays.toString(datas));
		long end = System.currentTimeMillis();

		System.out.println("Algorithm Execution Time : " + (end - start) + "ms");
	}

	public static void queue_impl() {

		Queue<Integer> queue = new Queue<>();

		char ch;

		do {

			System.out.println("\n Circular Queue Operations");

			System.out.println("1. Enqueue");
			System.out.println("2. Dequeue");
			System.out.println("3. Traverse");
			System.out.println("4. Check empty");
			System.out.println("5. Size");
			System.out.println("Please selection option (1 - 5) : ");

			int choice = in.nextInt();
			switch (choice) {
			case 1:
				try {
					System.out.println("Enter integer element to insert");
					queue.enqueue(in.nextInt());
				} catch (Exception e) {
					System.err.println("Error : " + e.getMessage());
				}

				break;
			case 2:
				try {
					queue.dequeue();
				} catch (Exception e) {
					System.err.println("Error : " + e.getMessage());
				}

				break;

			case 3:
				try {
					queue.traverse();
				} catch (Exception e) {
					System.err.println("Error : " + e.getMessage());
				}

				break;
			case 4:
				System.out.println("Empty Status : " + queue.isEmpty());
				break;
			case 5:
				System.out.println("Size = " + queue.size());
				break;
			default:
				System.out.println("Please enter valid option\n ");

				break;

			}

			// display queue
			System.out.println(queue);
			System.out.println("\nDo you want to continue (Type y or n) \n");
			ch = in.next().charAt(0);

		} while (ch == 'Y' || ch == 'y');

	}

	public static void dequeue_impl() {

		Dequeue queue = new Dequeue();
		char ch;

		do {

			System.out.println("\n Double Ended Queue Operations");
			System.out.println("1. Insert at front");
			System.out.println("2. Insert at rear");
			System.out.println("3. Delete at front");
			System.out.println("4. Delete at rear");
			System.out.println("5. Peek at front");
			System.out.println("6. Peek at rear");
			System.out.println("7. Size");
			System.out.println("8. Check empty");
			System.out.println("9. Clear");
			System.out.println("Please selection option (1 - 9) : ");
			int choice = in.nextInt();
			switch (choice) {
			case 1:

				System.out.println("Enter integer element to insert");
				queue.insertAtFront(in.nextInt());
				break;

			case 2:

				System.out.println("Enter integer element to insert");
				queue.insertAtRear(in.nextInt());
				break;

			case 3:

				try {
					System.out.println("Removed Element = " + queue.removeAtFront());
				} catch (Exception e) {
					System.err.println("Error : " + e.getMessage());
				}
				break;

			case 4:

				try {
					System.out.println("Removed Element = " + queue.removeAtRear());
				} catch (Exception e) {
					System.err.println("Error : " + e.getMessage());
				}
				break;

			case 5:

				try {
					System.out.println("Peek Element = " + queue.peekAtFront());
				} catch (Exception e) {

					System.out.println("Error : " + e.getMessage());
				}
				break;

			case 6:

				try {
					System.out.println("Peek Element = " + queue.peekAtRear());
				} catch (Exception e) {
					System.out.println("Error : " + e.getMessage());
				}
				break;

			case 7:
				System.out.println("Size = " + queue.getSize());
				break;

			case 8:
				System.out.println("Empty status = " + queue.isEmpty());
				break;

			case 9:
				System.out.println("\nDequeue Cleared\n");
				queue.clear();
				break;

			default:

				System.out.println("Please enter valid option\n ");
				break;

			}

			// display queue
			queue.display();
			System.out.println("\nDo you want to continue (Type y or n) \n");
			ch = in.next().charAt(0);

		} while (ch == 'Y' || ch == 'y');

	}

	public static void stack_impl() {
		Stack<Integer> stack = new Stack<>();
		char ch;

		do {

			System.out.println("\n Stack Operations");

			System.out.println("1. Push");
			System.out.println("2. Pop");
			System.out.println("3. Peek");
			System.out.println("4. Traverse");
			System.out.println("5. Check empty");
			System.out.println("6. Size");
			System.out.println("Please selection option (1 - 6) : ");

			int choice = in.nextInt();
			switch (choice) {
			case 1:
				try {
					System.out.println("Enter integer element to push");
					stack.push(in.nextInt());
				} catch (Exception e) {
					System.err.println("Error : " + e.getMessage());
				}
				break;

			case 2:
				try {
					stack.pop();
				} catch (Exception e) {
					System.err.println("Error : " + e.getMessage());
				}
				break;

			case 3:
				try {
					System.out.println(stack.peek());
				} catch (Exception e) {
					System.err.println("Error : " + e.getMessage());
				}
				break;

			case 4:
				try {
					stack.traverse();
				} catch (Exception e) {
					System.err.println("Error : " + e.getMessage());
				}
				break;

			case 5:
				System.out.println("Empty Status : " + stack.isEmpty());
				break;

			case 6:
				System.out.println("Size = " + stack.size());
				break;

			default:

				System.out.println("Please enter valid option\n ");
				break;

			}

			// display stack
			System.out.println(stack);
			System.out.println("\nDo you want to continue (Type y or n) \n");
			ch = in.next().charAt(0);

		} while (ch == 'Y' || ch == 'y');

		// Integer[] a = { 1, 2, 3, 4, 5 };
		// System.out.println("Array before reverse" + Arrays.toString(a));
		//
		// Stack.reverse(a);
		// System.out.println("Array after reverse" + Arrays.toString(a));

	}

	public static void double_ended_linked_list() {
		DoubleEndedLinkedList<Integer> linkedList = new DoubleEndedLinkedList<>();

		char ch;

		do {

			System.out.println("\n Double Ended Linked List Operations");

			System.out.println("1. Add at first");
			System.out.println("2. Add at last");
			System.out.println("3. Remove at first");
			System.out.println("4. Remove at last");
			System.out.println("5. Find Node");
			System.out.println("6. Add at Sepcific Position");
			System.out.println("7. Delete the Node");
			System.out.println("8. Obtain first element");
			System.out.println("9. Obtain last element");
			System.out.println("10. Size");
			System.out.println("11. Check empty");
			System.out.println("Please selection option (1 - 11) : ");

			int choice = in.nextInt();
			switch (choice) {
			case 1:
				try {
					System.out.println("Enter integer element to insert");
					linkedList.addFirst(in.nextInt());
				} catch (Exception e) {
					System.err.println("Error : " + e.getMessage());
				}

				break;
			case 2:
				try {
					System.out.println("Enter integer element to insert");
					linkedList.addLast(in.nextInt());
				} catch (Exception e) {
					System.err.println("Error : " + e.getMessage());
				}

				break;

			case 3:
				try {
					linkedList.removeFirst();
				} catch (Exception e) {
					System.err.println("Error : " + e.getMessage());
				}

				break;

			case 4:
				try {
					linkedList.removeLast();
				} catch (Exception e) {
					System.err.println("Error : " + e.getMessage());
				}

				break;

			case 5:
				System.out.println("Enter the element to search");
				System.out.println(linkedList.findNode(in.nextInt()));
				break;

			case 6:
				System.out.println("Enter the element to insert");
				Integer element = in.nextInt();
				System.out.println("Enter the position to insert");
				Integer position = in.nextInt();
				try {
					linkedList.addAtPosition(element, position);
				} catch (Exception e) {
					System.err.println("Error : " + e.getMessage());
				}
				break;

			case 7:
				System.out.println("Enter the element to delete");
				linkedList.deleteNode(in.nextInt());
				break;

			case 8:
				try {
					System.out.println("First Element : " + linkedList.first());
				} catch (Exception e) {
					System.err.println("Error : " + e.getMessage());
				}
				break;

			case 9:
				try {
					System.out.println("Last Element : " + linkedList.last());
				} catch (Exception e) {
					System.err.println("Error : " + e.getMessage());
				}
				break;

			case 10:
				System.out.println("Size = " + linkedList.size());
				break;

			case 11:
				System.out.println("Empty Status : " + linkedList.isEmpty());
				break;

			default:
				System.out.println("Please enter valid option\n ");

				break;

			}

			// display linked list
			System.out.println(linkedList);
			System.out.println("\nDo you want to continue (Type y or n) \n");
			ch = in.next().charAt(0);

		} while (ch == 'Y' || ch == 'y');

	}

	public static void doubly_ended_linked_list() {
		DoublyEndedLinkedList<Integer> linkedList = new DoublyEndedLinkedList<>();

		char ch;

		do {

			System.out.println("\n Doubly Ended Linked List Operations");

			System.out.println("1. Add at first");
			System.out.println("2. Add at last");
			System.out.println("3. Remove at first");
			System.out.println("4. Remove at last");
			System.out.println("5. Find Node");
			System.out.println("6. Add at Sepcific Position");
			System.out.println("7. Delete the Node");
			System.out.println("8. Obtain first element");
			System.out.println("9. Obtain last element");
			System.out.println("10. Size");
			System.out.println("11. Check empty");
			System.out.println("Please selection option (1 - 11) : ");

			int choice = in.nextInt();
			switch (choice) {
			case 1:
				try {
					System.out.println("Enter integer element to insert");
					linkedList.addFirst(in.nextInt());
				} catch (Exception e) {
					System.err.println("Error : " + e.getMessage());
				}

				break;
			case 2:
				try {
					System.out.println("Enter integer element to insert");
					linkedList.addLast(in.nextInt());
				} catch (Exception e) {
					System.err.println("Error : " + e.getMessage());
				}

				break;

			case 3:
				try {
					linkedList.removeFirst();
				} catch (Exception e) {
					System.err.println("Error : " + e.getMessage());
				}

				break;

			case 4:
				try {
					linkedList.removeLast();
				} catch (Exception e) {
					System.err.println("Error : " + e.getMessage());
				}

				break;

			case 5:
				System.out.println("Enter the element to search");
				System.out.println(linkedList.findNode(in.nextInt()));
				break;

			case 6:
				System.out.println("Enter the element to insert");
				Integer element = in.nextInt();
				System.out.println("Enter the position to insert");
				Integer position = in.nextInt();
				try {
					linkedList.addAtPosition(element, position);
				} catch (Exception e) {
					System.err.println("Error : " + e.getMessage());
				}
				break;

			case 7:
				System.out.println("Enter the element to delete");
				linkedList.deleteNode(in.nextInt());
				break;

			case 8:
				try {
					System.out.println("First Element : " + linkedList.first());
				} catch (Exception e) {
					System.err.println("Error : " + e.getMessage());
				}
				break;

			case 9:
				try {
					System.out.println("Last Element : " + linkedList.last());
				} catch (Exception e) {
					System.err.println("Error : " + e.getMessage());
				}
				break;

			case 10:
				System.out.println("Size = " + linkedList.size());
				break;

			case 11:
				System.out.println("Empty Status : " + linkedList.isEmpty());
				break;

			default:
				System.out.println("Please enter valid option\n ");

				break;

			}

			// display linked list
			System.out.println(linkedList);
			System.out.println("\nDo you want to continue (Type y or n) \n");
			ch = in.next().charAt(0);
		} while (ch == 'Y' || ch == 'y');
	}

	public static void binary_search_tree() {
		BinarySearchTree binarySearchTree = new BinarySearchTree();

		char ch;

		do {

			System.out.println("\n Binary Search Tree Operations");

			System.out.println("1. Insert Node");
			System.out.println("2. Delete Node");
			System.out.println("3. Find Node");
			System.out.println("4. Find largest");
			System.out.println("5. Find smallest");
			System.out.println("6. Traverse");
			System.out.println("Please selection option (1 - 6) : ");

			int choice = in.nextInt();
			switch (choice) {
			case 1:
				try {
					System.out.println("Enter integer element to insert");
					binarySearchTree.insert(in.nextInt());
				} catch (Exception e) {
					System.err.println("Error : " + e.getMessage());
				}

				break;
			case 2:
				try {
					System.out.println("Enter integer element to delete");
					binarySearchTree.delete(in.nextInt());
				} catch (Exception e) {
					System.err.println("Error : " + e.getMessage());
				}

				break;

			case 3:
				try {
					System.out.println("Enter node to search");
					System.out.println(binarySearchTree.find(in.nextInt()));
				} catch (Exception e) {
					System.err.println("Error : " + e.getMessage());
				}

				break;

			case 4:
				try {
					System.out.println("Largest element: " + binarySearchTree.largest());
				} catch (Exception e) {
					System.err.println("Error : " + e.getMessage());
				}

				break;

			case 5:
				try {
					System.out.println("Smallest element: " + binarySearchTree.smallest());
				} catch (Exception e) {
					System.err.println("Error : " + e.getMessage());
				}

				break;

			case 6:
				try {
					binarySearchTree.traverseInOrder();
				} catch (Exception e) {
					System.err.println("Error : " + e.getMessage());
				}

				break;

			default:
				System.out.println("Please enter valid option\n ");

				break;

			}

			// display binary search tree
			System.out.println();
			System.out.println("Displaying the Binary search tree");
			System.out.println(binarySearchTree);
			System.out.println("\nDo you want to continue (Type y or n) \n");
			ch = in.next().charAt(0);

		} while (ch == 'Y' || ch == 'y');

	}
}
