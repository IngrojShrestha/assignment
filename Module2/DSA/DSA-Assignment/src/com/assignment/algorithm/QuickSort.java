package com.assignment.algorithm;

import java.util.Arrays;
import java.util.Comparator;

import com.assignment.util.RandomGenerator;

public class QuickSort {
	public static void main(String[] args) {
		Integer[] datas = RandomGenerator.generateRandomNum();
		Comparator<Integer> comp = new Comparator<Integer>() {

			@Override
			public int compare(Integer d1, Integer d2) {
				return d1.compareTo(d2);
			}
		};
		QuickSort.quickSort(datas, comp, 0, datas.length - 1);
		System.out.println(Arrays.toString(datas));
	}

	public static <K> void quickSort(K[] S, Comparator<K> comp, int a, int b) {
		if (a >= b)
			return;
		int left = a;
		int right = b - 1;

		K pivot = S[b];
		K temp;
		while (left <= right) {
			while (left <= right && comp.compare(S[left], pivot) < 0)
				left++;

			while (left <= right && comp.compare(S[right], pivot) > 0)
				right--;
			
			if (left <= right) {
				temp = S[left];
				S[left] = S[right];
				S[right] = temp;
				left++;
				right--;
			}
		}

		temp = S[left];
		S[left] = S[b];
		S[b] = temp;

		quickSort(S, comp, a, left - 1);
		quickSort(S, comp, left + 1, b);

	}

}
