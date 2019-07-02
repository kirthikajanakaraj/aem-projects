package com.regnant.query;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.ServletResolverConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.service.component.annotations.Component;

import com.day.cq.search.PredicateGroup;
import com.day.cq.search.Query;
import com.day.cq.search.QueryBuilder;
import com.day.cq.search.result.SearchResult;
@Component(service=Servlet.class,property={ServletResolverConstants.SLING_SERVLET_PATHS+"=/pandi/xtype",ServletResolverConstants.
		SLING_SERVLET_NAME+"=X_typequery",ServletResolverConstants.SLING_SERVLET_METHODS+"=GET"})
public class X_TypeQuery extends SlingAllMethodsServlet
{
	
	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException 
	{
		
		QueryBuilder querybuilder=request.getResourceResolver().adaptTo(QueryBuilder.class);
		Map<String,String> querymap= new HashMap<>();
		querymap.put("path","/content/testing");
		querymap.put("type","cq:PageContent");
		Query createQuery = querybuilder.createQuery(PredicateGroup.create(querymap),request.getResourceResolver().adaptTo(Session.class));
		SearchResult result = createQuery.getResult();
		if(result!=null)
		{
			Iterator<Node> nodes = result.getNodes();
			while (nodes.hasNext()) {
				Node node = (Node) nodes.next();
				try {
					response.getWriter().write(node.getPath());
				} catch (RepositoryException e) {
					response.getWriter().write("Exception------> "+e);
				}
			}
		}
	}
	
}
