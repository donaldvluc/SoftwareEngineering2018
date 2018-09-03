// Author: Donald Luc

package edu.nd.se2018.homework.hwk1;
import java.util.HashMap;
import java.util.Map;

public class Question2 {

	public Question2(){}
	
	public String getMostFrequentWord(String input, String stopwords) {
		Map<String, Integer> freq = new HashMap<>();
		String[] words = input.split("\\s+"); // Splits whitespace.
		for (String word : words) {
			if (!stopwords.contains(word)) {
				freq.putIfAbsent(word, 0);
				freq.put(word, freq.get(word)+1);
			}
		}
		
		int max = -1;
		String freqWord = null;
		for (Map.Entry<String, Integer> entry : freq.entrySet()) {
			if (max < entry.getValue()) {
				max = entry.getValue();
				freqWord = entry.getKey();
			}
			else if (max == entry.getValue()) {
				freqWord = null;
			}
		}
		return freqWord;
	}
}
