package com.regnant.sample2.models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceMetadata;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;

@Model(adaptables = Resource.class)
public class Navigation {
	@Inject
	@Optional
	private Resource navitems;

	private List<Multifields> multifields;

	@PostConstruct
	public void init() {
		if (navitems != null && navitems.hasChildren()) {
			multifields = new ArrayList();
			Iterator<Resource> listofitems = navitems.listChildren();
			while (listofitems.hasNext()) {
				Resource r = listofitems.next();
				Multifields field = new Multifields();
				ValueMap vmap = r.getValueMap();
				field.setLinktitle(vmap.get("linktitle", String.class));
				field.setLinkURL(vmap.get("linkURL", String.class));
				multifields.add(field);
			}

		}
	}

	public List<Multifields> getMultifields() {
		return multifields;
	}

	class Multifields 
	{
		private String linktitle;
		private String linkURL;

		public String getLinkURL() {
			return linkURL;
		}

		public void setLinkURL(String linkURL) {
			this.linkURL = linkURL;
		}

		public String getLinktitle() {
			return linktitle;
		}

		public void setLinktitle(String linktitle) {
			this.linktitle = linktitle;
		}

	}
}