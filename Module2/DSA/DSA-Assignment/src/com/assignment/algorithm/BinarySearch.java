package com.assignment.algorithm;

public class BinarySearch {

	public static boolean search(Integer[] datas, Integer search_data, int low, int high) {
		if (low > high)
			return false;
		else {
			int mid = (int) Math.floor((low + high) / 2);
			if (Integer.valueOf(datas[mid]).equals(search_data)) {
				return true;
			} else if (search_data < datas[mid]) {
				return search(datas, search_data, low, mid - 1);
			} else {
				return search(datas, search_data, mid + 1, high);
			}

		}
	}
}
