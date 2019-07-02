package com.regnant.EventhandlersandListners;

import java.sql.Array;

import javax.jcr.LoginException;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.observation.Event;
import javax.jcr.observation.EventIterator;
import javax.jcr.observation.EventListener;
import javax.jcr.observation.ObservationManager;

import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.jcr.api.SlingRepository;
import org.osgi.framework.BundleContext;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(immediate = true)
public class Listeners implements EventListener, Runnable {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private BundleContext bundlecontext;
	@Reference
	private SlingRepository repository;
	private ResourceResolverFactory resolverFactory;
	private Session session;
	private ObservationManager observationmanager;

	@Override
	public void run() {
		logger.info("Running!!!!!!!!!!!!!!");

	}

	protected void activate(ComponentContext ctx) throws LoginException, RepositoryException 
	{
		this.bundlecontext=ctx.getBundleContext();
		session=repository.loginService(null, null);
		observationmanager=session.getWorkspace().getObservationManager();
		final String[] types={"nt:unstructured","sling:Folder"};
		final String path="/content";
		observationmanager.addEventListener(this, Event.NODE_ADDED, path, true, null, null, false);
		logger.info("Observation property changes to {} node under{}");
	}
	protected void deactivate(ComponentContext ccxt) throws RepositoryException
	{
		if(observationmanager !=null)
		{
			observationmanager.removeEventListener(this);
		}
		if(session !=null)
		{
			session.logout();
			session=null;
		}
	}

	@Override
	public void onEvent(EventIterator itr) 
	{
		logger.info("A new node was added to content");
	}

}
