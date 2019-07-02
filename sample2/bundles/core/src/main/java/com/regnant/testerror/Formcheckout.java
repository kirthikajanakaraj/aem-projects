package com.regnant.testerror;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.ServletResolverConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.service.component.annotations.Component;

@Component(service={Servlet.class},property={ServletResolverConstants.SLING_SERVLET_PATHS+"=/bin/checkbox",
		ServletResolverConstants.SLING_SERVLET_NAME+"=From servlets",
		ServletResolverConstants.SLING_SERVLET_METHODS+"=GET"})
public class Formcheckout extends SlingAllMethodsServlet
{
	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException 
	{
		response.getWriter().write("My From CheckoutList");
		String Firstname=request.getParameter("First Name");
		String Lastname=request.getParameter("Last Name");
		String genderChoice=request.getParameter("genderChoice");
		String Email=request.getParameter("Email");
		String Password=request.getParameter("Password");
		String month=request.getParameter("month");
		String checkbox=request.getParameter("checkbox");
		System.out.println(Firstname+" "+Lastname+" "+genderChoice+" "+Email+" "+Password+" "+month+" "+checkbox);
		
	}
}
