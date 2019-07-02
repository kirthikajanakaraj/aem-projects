package com.regnant.servlets;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.ServletResolverConstants;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.regnant.services.TestService;

@Component(service = { Servlet.class }, property = { ServletResolverConstants.SLING_SERVLET_PATHS + "=/bin/osgi",
		ServletResolverConstants.SLING_SERVLET_NAME + "=osgitest",
		ServletResolverConstants.SLING_SERVLET_METHODS + "=GET" })
public class OsgiTest extends SlingSafeMethodsServlet {
	@Reference
	TestService testservice;

	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().write(testservice.getmessage("It's kirthika janakarajan!!!!"));
		response.getWriter().write(testservice.getmessage());
		// TODO Auto-generated method stub
		//response.getWriter().write("kirthi!!!");

	}

}
