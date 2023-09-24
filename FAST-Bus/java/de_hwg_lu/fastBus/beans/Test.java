//package de_hwg_lu.fastBus.beans;
package de_hwg_lu.fastBus.beans;

import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

public class Test {

	public static void main(String[] args) {
//		String myString = "a long sentence that repeats itself = 1 and = 2 and = 3 again";
//		String removeFromThisPart = " and";
//
//		myString = myString.substring(0, myString.lastIndexOf(removeFromThisPart));
//		String str = "word1 word2 word3 word4";
//		String subStr1 = myString.substring(0, 12);
//		String subStr2 = myString.substring(12);

		String html = "a long sentence that rFrankfurtepeats itself = 1 and = 2 and = 3 again";
		String Stadt = "Frankfurt";

		boolean richtig = false;
		int splitstelle=0;
		for (int i = 0; i < html.length(); i++) {

			if (html.charAt(i) == Stadt.charAt(0)) {
				for (int j = 0; j < Stadt.length(); i++) {
					if (html.charAt(i + j) == Stadt.charAt(j)) {
						richtig = true;
						splitstelle=i + j;
					} else {
						richtig = false;
						splitstelle=0;
						break;
					}		
				}
				if (richtig == true&&splitstelle!=0) {
					String subStr11 = html.substring(0, splitstelle+1);
					String subStr22 = html.substring(splitstelle+1);
					subStr11+="selected";
					html=subStr11+subStr22;
				}

			}
			if(richtig==true) {
				break;
			}
		}
		System.out.println(html);
		
	}
}
