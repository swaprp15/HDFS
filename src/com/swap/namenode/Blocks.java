package com.swap.namenode;

public class Blocks {
	
	private int currentFreeBlockNumber;
	
	private Object mutex;
	
	public void restore()
	{
		// read from file to find out the latest free number.
		// Or shall we move this to constructor.
	}
	
	public int getFreeBlockNumber()
	{
		// This should be synchronised
		synchronized (mutex) {
			return currentFreeBlockNumber;
		}

	}
	
	
	public void incrementFreeBlockNumber()
	{
		// Going forward we can have a mature implementaion where we take care of freed blocks as well
		
		synchronized (mutex) {
			currentFreeBlockNumber++;
		}
		
	}
}
