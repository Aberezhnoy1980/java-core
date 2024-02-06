package ru.sergeyarchipov.ideadebug;

public class RandomGenerator {
	public static void main(String[] args) {
		int rnd1 = randomize(Integer.parseInt(args[0]), Integer.parseInt(args[2]));
		int rnd2 = randomize(Integer.parseInt(args[1]), Integer.parseInt(args[2]));
		System.out.printf("Two random values: %d, %d%n", rnd1, rnd2);
	}

	private static int randomize(int maxValue, int currentRandomValue) {
		currentRandomValue *= 1103515245 + 12345;
		return Math.abs(currentRandomValue / 65536) % (maxValue + 1);
	}
}
