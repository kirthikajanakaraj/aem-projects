package com.regnant.dropdown;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceMetadata;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.api.wrappers.ValueMapDecorator;
import org.apache.sling.models.annotations.Model;
import org.osgi.service.component.annotations.Component;

import com.adobe.granite.ui.components.ds.DataSource;
import com.adobe.granite.ui.components.ds.EmptyDataSource;
import com.adobe.granite.ui.components.ds.SimpleDataSource;
import com.adobe.granite.ui.components.ds.ValueMapResource;


@Model(adaptables =Resource.class )
public class DropDown 
{
	@PostConstruct
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException 
	{
		
		request.setAttribute(DataSource.class.getName(), EmptyDataSource.instance());
		  
		Resource resource = null;
		ResourceResolver resolver = resource.getResourceResolver();
		 
		//Create an ArrayList to hold data
		List<Resource> fakeResourceList = new ArrayList<Resource>();
		 
		ValueMap vm = null; 

		 
		//Add 5 values to drop down! 
		for (int i=0; i<5; i++)
		{
		 
		    //allocate memory to the Map instance
		 vm = new ValueMapDecorator(new HashMap<String, Object>());   
		 
		 
		 // Specify the value and text values
		 String Value = "value"+i ;
		 String Text = "text"+i ; 
		 
		    //populate the map
		 vm.put("value",Value);
		 vm.put("text",Text);
		 
		 fakeResourceList.add(new ValueMapResource(resolver, new ResourceMetadata(), "nt:unstructured", vm));
		}
		 
		 
		//Create a DataSource that is used to populate the drop-down control
		DataSource ds = new SimpleDataSource(fakeResourceList.iterator());
		request.setAttribute(DataSource.class.getName(), ds);
		 
		
		
		
	}
}
