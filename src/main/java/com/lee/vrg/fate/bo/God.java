package com.lee.vrg.fate.bo;

import java.util.Random;

/**
 * 上帝摇色子
 * @author dell
 *
 */
public class God {
	private static Random random = new Random(System.currentTimeMillis());// 指定种子数100

	public static int randomInt(int max) {
		return random.nextInt(max);
	}

}
