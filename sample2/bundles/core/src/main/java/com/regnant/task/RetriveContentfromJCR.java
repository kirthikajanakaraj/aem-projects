package com.regnant.task;

import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.annotations.Component;

import com.day.cq.wcm.api.Page;

@Component(service=Query.class)
public class RetriveContentfromJCR implements Query
{
	private ResourceResolverFactory resolverfactory;

	@Override
	public String getJCRData(String Location) {
		// TODO Auto-generated method stub
		try {
			ResourceResolver resourceresolver=resolverfactory.getServiceResourceResolver(null);
			Resource res=resourceresolver.getResource(Location);
			Page page = res.adaptTo(Page.class);
			String title=page.getTitle();
			return title;
		} catch (LoginException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
}
