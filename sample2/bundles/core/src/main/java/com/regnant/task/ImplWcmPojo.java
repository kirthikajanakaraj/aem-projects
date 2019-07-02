package com.regnant.task;

import org.apache.sling.api.resource.Resource;

import com.adobe.cq.sightly.WCMUsePojo;

public class ImplWcmPojo extends WCMUsePojo
{
	private String value;
	@Override
	public void activate() throws Exception 
	{
		// TODO Auto-generated method stub
		Resource resource=getResource();
		String param1=get("param1", String.class);
		String param2=get("param2",String.class);
		value=resource.getPath()+param1+param2;
		
		
	}
	public String getcalculatedValue()
	{
		return value;
		
	}

}
