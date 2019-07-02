package com.regnant.sample2.models;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;


@Model(adaptables =Resource.class )
public class ImagewithLink 
{
	@Inject
	@Optional
	private String fileReference;
	@Inject
	@Optional
	private String linkURL;
	@Inject
	@Optional
	private String linktitle;
	
	public String getFileReference() {
		return fileReference;
	}
	public String getLinkURL() {
		return linkURL;
	}
	public String getLinktitle() {
		return linktitle;
	}
	
	
	
}
