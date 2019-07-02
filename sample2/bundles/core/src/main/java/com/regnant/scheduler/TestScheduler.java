package com.regnant.scheduler;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(service=Runnable.class,immediate=true)
@Designate(ocd=TestScheduler.Configuration.class)
public class TestScheduler implements Runnable
{	
	private String path;
	@Activate
	protected void activate(Configuration configuration)
	{
		//log.info("Inside Activate");
		log.info("PATH");
		 path = configuration.path();
	}
	@ObjectClassDefinition(name="Test Scheduler Configuration")
	public @interface Configuration 
	{
		@AttributeDefinition(name="CRON Expressions")
		String scheduler_expression() default "0 0 1/2 ? * *";
		@AttributeDefinition(name="Path Expressions")
		String path() default "/content";
	}

	Logger log=LoggerFactory.getLogger(TestScheduler.class);
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		log.info("Schedular is called");
	}
	
}
