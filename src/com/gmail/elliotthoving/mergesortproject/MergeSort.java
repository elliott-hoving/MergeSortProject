package com.gmail.elliotthoving.mergesortproject;

import java.util.ArrayList;

public class MergeSort {

	private ArrayList<Integer> numbers;
	private ArrayList<Integer> helper;

	private int number;

	/**
	 * Initializes instance variables and calls internal mergeSort() method
	 * 
	 * @param values ArrayList of values to be sorted
	 */
	public void sort(ArrayList<Integer> values) {
		
		this.numbers = values;
		this.helper = new ArrayList<Integer>();
		
		for(int i = 0; i < values.size(); i++)
			helper.add(null);
		
		number = values.size();
		mergeSort(0, number - 1);
		
	}

	/**
	 * Breaks the original array into arrays of length 1
	 * <p> Recursively breaks the original array into n sublists, by redefining low and high pointers
	 * 
	 * @param low Left pointer in array
	 * @param high Right pointer in array
	 */
	private void mergeSort(int low, int high) {
		// check if low is smaller than high, if not then the array is sorted
		if (low < high) {
			// Get the index of the element which is in the middle
			int middle = low + (high - low) / 2;
			// Sort the left side of the array
			mergeSort(low, middle);
			// Sort the right side of the array
			mergeSort(middle + 1, high);
			// Combine them both
			merge(low, middle, high);
		}
	}

	/**
	 * 
	 * @param low
	 * @param middle
	 * @param high
	 */
	private void merge(int low, int middle, int high) {

		// Copy the elements between low (inclusive) and high (inclusive)
		for (int i = low; i <= high; i++) {
			helper.set(i, numbers.get(i));
		}

		/* these variables track the pointers for comparing integers in the sublists
		 * 
		 * Example:
		 * 
		 *   i,k              j
		 * {  5,  2,  4,  7,  9,  10,  12 }
		 * 
		 */
		
		int i = low;
		int j = middle + 1;
		int k = low;
		// Copy the smallest values from either the left or the right side back
		// to the original array
		while (i <= middle && j <= high) {
			if (helper.get(i) <= helper.get(j)) {
				numbers.set(k, helper.get(i));
				i++;
			} else {
				numbers.set(k, helper.get(j));
				j++;
			}
			k++;
		}
		// Copy the rest of the left side of the array into the target array
		while (i <= middle) {
			numbers.set(k, helper.get(i));
			k++;
			i++;
		}
		// Since we are sorting in-place any leftover elements from the right side
		// are already at the right position.

	}
}
