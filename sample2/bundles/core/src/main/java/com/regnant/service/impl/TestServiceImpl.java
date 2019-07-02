package com.regnant.service.impl;

import org.osgi.framework.Constants;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.Designate;

import com.regnant.services.TestConfiguration;
import com.regnant.services.TestService;
@Component(service=TestService.class,immediate=true,property={
Constants.SERVICE_VENDOR+"=REGNANT SOFTWARE SOLUTIONS",
Constants.SERVICE_DESCRIPTION+"=This is sample description."
})
@Designate(ocd=TestConfiguration.class)
public class TestServiceImpl implements TestService {
	private String message;
	@Override
	public String getmessage() {
		// TODO Auto-generated method stub
		return "Test message"+message;
	}

	@Override
	public String getmessage(String message) {
		// TODO Auto-generated method stub
		return message;
	}
	protected void activate(ComponentContext componentcontext,TestConfiguration testconfig)
	{
		message=testconfig.getMessage();
	}

}


