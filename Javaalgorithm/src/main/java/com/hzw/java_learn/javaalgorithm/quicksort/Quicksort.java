package com.hzw.java_learn.javaalgorithm.quicksort;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Quicksort {
	
	
	public static List<Integer> sort(List<Integer> list){
		if(list.isEmpty())
			return null;
		
		sort(list, 0, list.size() - 1);
		
		return list;
	};
	
	private static void sort(List<Integer> list, Integer low, Integer high){
		
		Integer start = low;
		Integer end  = high;
		Integer key = list.get(start);
		
		while(start < end){
			while(end > start && key <= list.get(end))
				end--;
			if(key > list.get(end)){
				list.set(start, list.get(end));
				list.set(end, key);
				System.out.println(list);
			}
			
			
			while(end > start && key >= list.get(start))
				start ++;
			if(key < list.get(start)){
				list.set(end, list.get(start));
				list.set(start, key);
				System.out.println(list);
			}
			
		}
		
		System.out.println("--------------------------------------------");
		if(start > low) 
			sort(list, low, start - 1);
		if(end < high)
			sort(list, end + 1, high);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	static List<Integer> getRandowmIntList(Integer size, Integer min, Integer max){
		
		List<Integer> intList = new ArrayList<Integer>();
		
		Random random = new Random();
		for (int i = 0; i < size; i++) {
			int temp = random.nextInt(max - min);
			intList.add(temp + min);
		}
		
		return intList;
		
	}
}
