package com.regnant.javapractise;

public class Threads123 extends Thread
{
	public static void main(String[] args) 
	{
	Thread  t= Thread.currentThread();
	System.out.println("Cuttenr thread--->"+t.getName());
	t.setName("pandi");
	System.out.println("After changing--->"+t.getName());
	t.setPriority(NORM_PRIORITY);
	System.out.println("Priority------>"+t.getPriority());
	
	}
}
