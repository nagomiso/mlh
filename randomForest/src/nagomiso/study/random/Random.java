package nagomiso.study.random;

import gilberthouse.random.RandomGenerator;
import gilberthouse.random.SFMT19937;

public class Random {
	private static final RandomGenerator rg = new SFMT19937(12345);

	/**
	 * [0, max]の整数乱数を生成する
	 * @param max 最大値
	 * @return [0, max]の整数乱数
	 */
	public static int nextInt(int max) {
		return nextInt(0, max);
	}

	/**
	 * [min, max]の整数乱数を生成する
	 * @param min 最小値
	 * @param max 最大値
	 * @return [min, max]の整数乱数
	 */
	public static int nextInt(int min, int max) {
		return (int) Math.floor(rg.nextUniform() * (max - min + 1) + min);
	}

	/**
	 * 一様乱数を生成する
	 * @return 一様乱数
	 */
	public static double nextUniform() {
		return rg.nextUniform();
	}
}
