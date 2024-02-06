package ru.home;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

class Draft {
	public static void main(String[] args) {
		System.out.print("Good morning! It's time to breakfast\n");

		int b = 4 >> 2;
		int a = 4 << 1;
		System.out.println("a= " + a + " and b= " + b);

		try {
			System.out.println(Inet4Address.getLocalHost());
		} catch (UnknownHostException e) {
			throw new RuntimeException(e);
		}
	}
}
