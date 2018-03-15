package com.gmail.elliotthoving.mergesortproject;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.gmail.elliotthoving.util.Stopwatch;

public class MergeSortProject {

	public static void main(String[] args) {
		
		// create an ArrayList of Integer wrapper elements
		ArrayList<Integer> arr;
		
		int length = 0;
		boolean valid = false;
		
		// repeatedly ask for an ArrayList size as until number is valid
		while(valid == false) {
			try {
				length = Integer.parseInt(JOptionPane.showInputDialog("How many elements in ArrayList?"));
				valid = true;
			} catch (NumberFormatException e) {
				System.out.println("Input not an integer, must only contain integer numbers");
			}
			
		} // end while
		
		arr = new ArrayList<Integer>(length);

		// fill the ArrayList with random integer elements
		// wrapper classes automatically box primitive integer elements
		for(int i = 0; i < length; i++)
		{
			arr.add((int) (Math.random() * 10));
		} // end for
		
		// create a new MergeSort object, which handles the merge sort algorithm
		MergeSort ms = new MergeSort();
		
		// create a timer object to time
		Stopwatch timer = new Stopwatch();
		
		System.out.println("INPUT SIZE: " + length);
		System.out.println("BEFORE SORT: " + arr.toString());
		
		// start the timer
		timer.startTimer();
		
		// call the sorting algorithm on the ArrayList arr
		ms.sort(arr);
		
		// stop the timer
		timer.endTimer();
		
		System.out.println("AFTER SORT: " + arr.toString());
		
		// print the current time
		timer.printElapsedTime();

	}

}
