package com.regnant.servlets;

import java.io.IOException;

import javax.jcr.Node;
import javax.jcr.PathNotFoundException;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.ServletResolverConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.service.component.annotations.Component;

@Component(service={Servlet.class},property={ServletResolverConstants.SLING_SERVLET_PATHS+"=/bin/nodepost",
ServletResolverConstants.SLING_SERVLET_NAME+"=nodeapipostservlet",
ServletResolverConstants.SLING_SERVLET_METHODS+"=POST"
})

public class NodeAPIPOST extends SlingAllMethodsServlet
{
	@Override
	protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name=request.getParameter("name");
		String parameter=request.getParameter("path");
		String value=request.getParameter("value");
		if(null!=parameter&&null!=name&&null!=value)
		{
			Session session=request.
					getResourceResolver().adaptTo(Session.class);
			try {
				Node node=session.getNode(parameter);
				if(node!=null)
				{
					node.setProperty(name,value);
					session.save();
					response.getWriter().write("Sucessfull!!!!!");
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

