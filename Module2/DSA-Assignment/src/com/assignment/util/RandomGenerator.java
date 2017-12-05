package com.assignment.util;

import java.util.Random;

public class RandomGenerator {

	public static Integer[] generateRandomNum() {
		Random rand = new Random();

		Integer[] num = new Integer[10];

		for (int i = 0; i < 10; i++) {
			num[i] = rand.nextInt(1000);
		}

		return num;
	}

	public static int[] generateRandomNumPrimitive() {
		Random rand = new Random();

		int[] num = new int[10];

		for (int i = 0; i < 10; i++) {
			num[i] = rand.nextInt(1000);
		}

		return num;
	}
}
