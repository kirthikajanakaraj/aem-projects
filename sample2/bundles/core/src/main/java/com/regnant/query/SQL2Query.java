package com.regnant.query;

import java.io.IOException;
import java.util.Iterator;

import javax.jcr.query.Query;
import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.servlets.ServletResolverConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.service.component.annotations.Component;

@Component(service=Servlet.class,property={ServletResolverConstants.SLING_SERVLET_PATHS+"=/pandi/sql2",ServletResolverConstants.
		SLING_SERVLET_NAME+"=Sqlquery",ServletResolverConstants.SLING_SERVLET_METHODS+"=GET"})
public class SQL2Query extends SlingAllMethodsServlet
{
	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException 
	{
		String query="SELECT * FROM [nt:base] AS s WHERE ISDESCENDANTNODE([/content]) and CONTAINS(s.*, 'homepage')";
	
		Iterator<Resource> findResources = request.getResourceResolver().findResources(query,Query.JCR_SQL2);
		while (findResources.hasNext()) {
			Resource resource = (Resource) findResources.next();
			response.getWriter().write(resource.getPath()+"\n");
		}
	}
}
