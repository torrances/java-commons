package com.trimc.blogger.commons.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public final class BigDecimalUtils {

	public static String toString(BigDecimal bd, Integer precision) {
		bd = bd.setScale(2, BigDecimal.ROUND_DOWN);

		DecimalFormat df = new DecimalFormat();

		df.setMaximumFractionDigits(2);

		df.setMinimumFractionDigits(0);

		df.setGroupingUsed(false);

		return df.format(bd);
	}
}
