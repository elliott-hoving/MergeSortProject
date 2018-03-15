package com.gmail.elliotthoving.util;

public class Stopwatch {
	
	private long startTime;
	private long endTime;

	public Stopwatch() {
		startTime = 0;
		endTime = 0;
	} // end zero-arg constructor

	public void startTimer() {
		startTime = System.nanoTime();
	} // end method startTimer

	public void endTimer() {
		endTime = System.nanoTime();
	} // end method endTimer

	public void printElapsedTime() {
		System.out.println( "Elapsed time in nanoseconds is: " + (endTime - startTime) );
	} // end method printElapsedTime

} // end class Stopwatch
