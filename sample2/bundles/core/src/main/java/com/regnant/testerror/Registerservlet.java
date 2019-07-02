package com.regnant.testerror;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.ServletResolverConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.regnant.DATASOURCEPOOL.Userregistrationinterface;

@Component(service = { Servlet.class }, property = { ServletResolverConstants.SLING_SERVLET_PATHS + "=/bin/testservlet",
		ServletResolverConstants.SLING_SERVLET_NAME + "=Registerationnnn servlet",
		ServletResolverConstants.SLING_SERVLET_METHODS + "=GET" })

public class Registerservlet extends SlingAllMethodsServlet {

	@Reference
	Userregistrationinterface uri;

	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().write("first------------->");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String email = request.getParameter("email");

		//response.getWriter().write("last" + name);
		System.out.println(name + "  " + password + "  " + email);
		uri.insertuser(name, password, email);

	}

}
