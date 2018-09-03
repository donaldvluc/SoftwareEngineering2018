// Author: Donald Luc

package edu.nd.se2018.homework.hwk1;
import java.lang.reflect.Array;
import java.lang.Boolean;

public class Question3 {
	
	public Question3(){}	
	
    public int getMirrorCount(int[] numbers){
    	int len = Array.getLength(numbers);
    	int right = len-1;
    	int mirrorCount = 0;
    	Boolean continuous = true;
    	for (int i = 0; i < len/2; i++) {
    		if (numbers[i] == numbers[right]) {
    			mirrorCount++;
    			right--;
    		} else {
    			continuous = false;
    			break;
    		}
    	}

    	if (continuous) {
    		if ((len%2) == 0) {
    			mirrorCount *= 2;
    		} else {
    			mirrorCount = mirrorCount*2 + 1;
    		}
    	}
    	
    	if ((len != 0) && (mirrorCount == 0)) {
    		mirrorCount = 1;
    	}

		return mirrorCount;
	}
}
