package com.trimc.blogger.commons.utils;

import java.math.BigDecimal;
import java.util.Random;

import org.junit.Test;

public final class MathUtils {

	/* maximum precision for a BigDecimal */
	public static final Integer	BD_DISPLAY_MAX	= 10;

	public static String format(BigDecimal bd) {
		return format(bd, BD_DISPLAY_MAX);
	}

	/**
	 * @param bd		a Big Decimal
	 * @param precision	the desired precision
	 * @return			formatted String
	 */
	public static String format(BigDecimal bd, Integer precision) {
		String sBd = bd.toPlainString();
		return (sBd.length() > 10 ? sBd.substring(0, BD_DISPLAY_MAX) : sBd);
	}

	public static double random(double min, double max) {
		return Math.floor(Math.random() * (max - min + 1) + min);
	}

	public static int random(int min, int max) {
		return (int) random((double) min, (double) max);
	}

	public static long random(long min, long max) {
		return (long) Math.floor(Math.random() * (max - min + 1) + min);
	}

	public static int random(Object[] arr) {
		return random(0, arr.length - 1);
	}

	public static double randomDouble() {
		return random(Double.MIN_VALUE, Double.MAX_VALUE);
	}

	public static int randomInt() {
		return (int) random((double) Integer.MIN_VALUE, (double) Integer.MAX_VALUE);
	}

	public static double randomNegDouble() {
		return random(0, Double.MIN_VALUE);
	}

	public static int randomNegInt() {
		return (int) random((double) Integer.MIN_VALUE, (double) 0);
	}

	public static double randomPosDouble() {
		return random(0, Double.MAX_VALUE);
	}

	public static int randomPosInt() {
		return (int) random((double) 0, (double) Integer.MAX_VALUE);
	}

	public static long randomPosLong() {
		return random(0, Long.MAX_VALUE);
	}

	/**
	 * 	Purpose:
	 * 	Fisher–Yates shuffle array function
	 * 	<http://stackoverflow.com/questions/1519736/random-shuffling-of-an-array>
	 * 	This is better than using Collections.shuffle(...) to avoid the cost of wrapping each primitive in an object which is costly both in memory and in CPU.
	 * @param array
	 * @return			a shuffled array
	 */
	public static int[] shuffle(int[] array) {
		int index;
		Random random = new Random();
		for (int i = array.length - 1; i > 0; i--) {
			index = random.nextInt(i + 1);
			if (index != i) {
				array[index] ^= array[i];
				array[i] ^= array[index];
				array[index] ^= array[i];
			}
		}

		return array;
	}

	@Test
	public void random1() throws Throwable {
		double max = Math.pow(2d, 10d);
		for (int i = 0; i < max; i++) {
			System.err.println(random(0, (int) max));
		}
	}
}
