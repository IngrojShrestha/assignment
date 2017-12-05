package com.assignment.bst;

public class BinarySearchTree {
	private TreeNode root;

	public TreeNode find(Integer data) {
		if (root != null) {
			return root.find(data);
		}
		return null;
	}

	public Integer largest() {
		if (this.root != null)
			return root.largest();
		return null;
	}

	public Integer smallest() {
		if (this.root != null)
			return root.smallest();
		return null;
	}

	public void insert(Integer data) {
		if (root == null)
			this.root = new TreeNode(data);
		else
			root.insert(data);
	}

	public void delete(Integer data) {
		TreeNode current = this.root;
		TreeNode parent = this.root;

		boolean isLeftChild = false;
		if (current == null)
			throw new RuntimeException("Tree is empty");
		while (current != null && current.getData() != data) {
			parent = current;
			if (data < current.getData()) {
				current = current.getLeftChild();
				isLeftChild = true;
			} else {
				current = current.getRightChild();
				isLeftChild = false;
			}
		}
		if (current == null)
			return;

		// case 1: Node to be deleted is leaf node
		if (current.getLeftChild() == null && current.getRightChild() == null) {
			if (current == root) {
				root = null;
			} else {
				if (isLeftChild)
					parent.setLeftChild(null);
				else
					parent.setRightChild(null);
			}
		}

		// case 2: Node has only one child
		else if (current.getRightChild() == null) { // only left child
			if (current == root) {
				root = current.getLeftChild();
			} else if (isLeftChild) {
				parent.setLeftChild(current.getLeftChild());
			} else {
				parent.setRightChild(current.getRightChild());
			}
		} else if (current.getLeftChild() == null) {
			if (current == root) {
				root = current.getRightChild();
			} else if (isLeftChild) {
				parent.setLeftChild(current.getRightChild());
			} else {
				parent.setRightChild(current.getRightChild());
			}

		}

		// case 3: Node has 2 children
		else {
			TreeNode successor = getSuccessor(current);
			if (current == root)
				root = successor;
			else if (isLeftChild) {
				parent.setLeftChild(successor);
			} else {
				parent.setRightChild(successor);
			}
			successor.setLeftChild(current.getLeftChild());
		}
		
		System.out.println("Element " + data + " not found");

	}

	private TreeNode getSuccessor(TreeNode node) {
		TreeNode parentOfSuccessor = node;
		TreeNode successor = node;
		TreeNode current = node.getRightChild();
		while (current != null) {
			parentOfSuccessor = successor;
			successor = current;
			current = current.getLeftChild();
		}
		if (successor != node.getRightChild()) {
			parentOfSuccessor.setLeftChild(successor.getRightChild());
			successor.setRightChild(node.getRightChild());
		}
		return successor;
	}

	public static BinarySearchTree createFromSortedArray(int[] data) {
		BinarySearchTree bst = new BinarySearchTree();
		if (data != null && data.length > 0) {
			bst.root = TreeNode.addSorted(data, 0, data.length - 1);
		}
		return bst;
	}

	public void traverseInOrder() {
		if (this.root != null)
			this.root.traverseInOrder();
		System.out.println();
	}

	@Override
	public String toString() {
		return "[root:" + root + "]";
	}

}
