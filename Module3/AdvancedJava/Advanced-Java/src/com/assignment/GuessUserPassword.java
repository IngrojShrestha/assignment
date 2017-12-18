package com.assignment;

import com.fm.login.Authentication;

public class GuessUserPassword extends Thread {
	private Thread t;
	private String threadName;
	private int start;
	private int end;

	long n1 = 9841000000L;
	long n2 = 9848000000L;
	long n3 = 9849000000L;
	private static int guess;

	public GuessUserPassword(String name) {
		this.threadName = name;
		// System.out.println("Creating : " + threadName + " " + this.getName());
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public void run() {

		// System.out.println("Running " + threadName);
		if (checkUserPasswordPair(n1, threadName, start, end) || checkUserPasswordPair(n2, threadName, start, end)
				|| checkUserPasswordPair(n3, threadName, start, end)) {

			System.exit(0);
		}
	}

	public void start() {
		// System.out.println("Starting " + threadName);
		if (t == null) {
			t = new Thread(this, threadName);
			t.start();
		}
	}

	public static boolean checkUserPasswordPair(long num, String name, int start, int end) {
		Authentication a = new Authentication();
		long temp = num;
		for (int i = end; i >= start; i--) {
			guess++;
			num += Long.valueOf(i);
			// System.out.println(name + " guesses " + num);
			boolean access = a.login(name, String.valueOf(num));
			if (access) {
				System.out
						.println("** Correct! username:" + name + " password:" + num + " in " + guess + " guesses.**");
				return true;
			}
			num = temp;
		}

		return false;
	}

}
