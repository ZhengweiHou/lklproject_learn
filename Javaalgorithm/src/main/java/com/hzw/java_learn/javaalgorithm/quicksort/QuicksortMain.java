package com.hzw.java_learn.javaalgorithm.quicksort;

import java.util.Arrays;
import java.util.List;

public class QuicksortMain {
	
	public static void main(String[] args) {
		List<Integer> intList = Quicksort.getRandowmIntList(20, 0, 40);
		System.out.println(intList);
		
		Quicksort.sort(intList);
		
		System.out.println(intList);
		
	}
	
}	


