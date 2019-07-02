package com.regnant.scheduler;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.sling.commons.scheduler.Scheduler;
import org.osgi.framework.BundleContext;
import org.osgi.service.component.ComponentContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;            

public class Schedlingmail implements Runnable {
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	private BundleContext bcontext;
	private Scheduler scheduler;

	@Override
	public void run() {
		logger.info("Running mail thread!!!!!!!!");
	}

	protected void activate(ComponentContext ctx) {
		this.bcontext = ctx.getBundleContext();
	

	String jobName = "case";
	String schedulingExpression = "0 15 10 ? * MON-FRI";
	final Date firedate = new Date();
	Map<String, Serializable> config = new HashMap<String, Serializable>();
//	final Runnable job = new Runnable() 
//	{
//
//		public void run() 
//		{
//			int staleitems = checkstaleItems();
//			if (staleitems > 6) 
//			{
//				sendmail(staleitems);
//			}
//
//		}
//	};
//	this.scheduler.schedule(arg0, arg1)("myJob",job,null,schedulingExpression,true);
	}
	
	
}
