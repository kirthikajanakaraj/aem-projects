package com.regnant.task;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Model;

@Model(adaptables = SlingHttpServletRequest.class)
public class ImplRequest
{
//	@Inject
//	private SlingHttpServletRequest request;
//	@Inject
//	private MyService myservice;
//	private String value;
//	@PostConstruct
//	protected void call()
//	{
//		value=myservice.ex
//	}
}
