package com.assignment;

public class Main {
	public static void main(String[] args) {
		String[] threads = { "prajwal", "roshan", "sita", "ram" };
		System.out.println("Searching username and password pairs....");
		for (String threadName : threads) {
			int start = 900000;
			int end = 999999;
			for (int i = 1; i <= 100; i++) {
				GuessUserPassword guessUserPassword = new GuessUserPassword(threadName);
				guessUserPassword.setStart(start);
				guessUserPassword.setEnd(end);
				guessUserPassword.start();

				start -= 10000;
				end -= 10000;
			}

		}

	}
}
