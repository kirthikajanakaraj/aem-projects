package com.regnant.task;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;

@Model(adaptables = Resource.class)
public class ImplResource {
	@Inject
	private String text;
	private String Modifiedtext;

	@PostConstruct
	protected void call() {
		Modifiedtext = text + "World";
	}

	public String Modifiedtext() {
		return Modifiedtext;

	}

}
