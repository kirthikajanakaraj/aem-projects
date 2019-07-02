


package com.regnant.servlets;

import java.io.IOException;

import javax.jcr.Node;
import javax.jcr.PathNotFoundException;
import javax.jcr.PropertyIterator;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.ServletResolverConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(service={Servlet.class},property={ServletResolverConstants.SLING_SERVLET_PATHS+"=/bin/node",
ServletResolverConstants.SLING_SERVLET_NAME+"=nodeapiservlet",
ServletResolverConstants.SLING_SERVLET_METHODS+"=GET"
})
public class NodeAPI extends SlingSafeMethodsServlet
{
	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String parameter=request.getParameter("path");
		if(null!=parameter)
		{
			Session session=request.getResourceResolver().adaptTo(Session.class);
			try {
				Node node=session.getNode(parameter);
				if(null!=node)
				{
					PropertyIterator propertyiterator=node.getProperties();
					while(propertyiterator.hasNext())
					{
						response.getWriter().write(propertyiterator.nextProperty().getValue().toString()+"\n");
					}
				}
			} catch (PathNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RepositoryException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	

}
