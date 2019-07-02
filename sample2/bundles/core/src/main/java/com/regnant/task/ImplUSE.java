package com.regnant.task;

import javax.script.Bindings;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.scripting.sightly.pojo.Use;

public class ImplUSE implements Use
{
	private String value;

	@Override
	public void init(Bindings bindings) 
	{
		// TODO Auto-generated method stub
		Resource resource=(Resource) bindings.get("resource");
		 String param1 = (String) bindings.get("param1");
	        String param2 = (String) bindings.get("param2");

	        value = resource.getPath() + param1 + param2;
	}
	public String Calculatedvalue()
	{
		return value;
		
	}

}
