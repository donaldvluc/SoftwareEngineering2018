// Author: Donald Luc

package edu.nd.se2018.homework.hwk1;

import java.util.HashSet;
import java.util.Set;


public class Question1 {

	public Question1(){}

	public int getSumWithoutDuplicates(int[] numbers){
		int total = 0;
		Set<Integer> seen = new HashSet<>();
		for (Integer n : numbers) {
			if (!seen.contains(n)) {
				total += n;
				seen.add(n);
			}
		}
		return total;
	}
}
