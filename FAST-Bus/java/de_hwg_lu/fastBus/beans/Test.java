//package de_hwg_lu.fastBus.beans;
package de_hwg_lu.fastBus.beans;

import java.text.NumberFormat;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Locale;

public class Test {

	public static void main(String[] args) {
		Locale locale = Locale.GERMANY;
		NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale); // die euro währung
		String s = numberFormat.format(2.5);
		String res;
		res = s.substring(0, s.length() - 1);
		System.out.println(res);
	}
}