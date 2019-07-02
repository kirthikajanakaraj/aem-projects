package com.regnant.javapractise;

public class ThreadMethods implements Runnable
{

	@Override
	public void run() 
	{
		try {
			Thread.sleep(1000);
		} 
		catch (InterruptedException e)
		{
			//System.out.println("Threads------------>"+);

			e.printStackTrace();
		}
		
	}

}
