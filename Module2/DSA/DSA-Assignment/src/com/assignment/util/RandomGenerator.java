package com.assignment.util;

import java.util.Random;

public class RandomGenerator {

	public static Integer[] generateRandomNum() {
		Random rand = new Random();

		Integer[] num = new Integer[1000];

		for (int i = 0; i < 1000; i++) {
			num[i] = rand.nextInt(1000);
		}

		return num;
	}
}
