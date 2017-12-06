package com.assignment.bst;

public class TreeNode {
	private Integer data;
	private TreeNode leftChild;
	private TreeNode rightChild;

	public TreeNode(Integer data) {
		this.data = data;
	}

	public TreeNode find(Integer data) {
		if (this.data == data)
			return this;
		if (data < this.data && leftChild != null)
			return leftChild.find(data);
		if (data > this.data && rightChild != null)
			return rightChild.find(data);
		return null;
	}

	public Integer largest() {
		if (this.rightChild == null)
			return this.data;
		return this.rightChild.largest();
	}

	public Integer smallest() {
		if (this.leftChild == null)
			return this.data;
		return this.leftChild.smallest();
	}

	public void insert(Integer data) {
		if (data >= this.data) { // insert in right subtree
			if (this.rightChild == null)
				this.rightChild = new TreeNode(data);
			else
				this.rightChild.insert(data);
		} else { // insert in left subtree
			if (this.leftChild == null)
				this.leftChild = new TreeNode(data);
			else
				this.leftChild.insert(data);
		}
	}

	public static TreeNode addSorted(int[] data, int start, int end) {
		if (end >= start) {
			int mid = (start + end) / 2;
			TreeNode newNode = new TreeNode(data[mid]);
			newNode.leftChild = addSorted(data, start, mid - 1);
			newNode.rightChild = addSorted(data, mid + 1, end);
			return newNode;
		}
		return null;
	}

	public void traverseInOrder() {
		if (this.leftChild != null)
			this.leftChild.traverseInOrder();
		System.out.print(this + " ");
		if (this.rightChild != null)
			this.rightChild.traverseInOrder();
	}

	public Integer getData() {
		return data;
	}

	public void setData(Integer data) {
		this.data = data;
	}

	public TreeNode getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(TreeNode leftChild) {
		this.leftChild = leftChild;
	}

	public TreeNode getRightChild() {
		return rightChild;
	}

	public void setRightChild(TreeNode rightChild) {
		this.rightChild = rightChild;
	}

	@Override
	public String toString() {
		String result = "[" + data;
		if (leftChild != null)
			result += ", leftChild=" + leftChild;
		if (rightChild != null)
			result += ", rightChild=" + rightChild;
		result += "]";
		return result;

		// return "[data=" + data + ", leftChild=" + leftChild + ", rightChild=" +
		// rightChild + "]";
	}

}
