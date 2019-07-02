package com.regnant.sample2.models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;

@Model(adaptables = Resource.class)
public class MultifieldTask {
	@Inject
	@Optional
	private Resource multifield;
	private List<Multifield> mfield;

	@PostConstruct
	public void init() {
		if (multifield != null && multifield.hasChildren()) {
			mfield = new ArrayList();
			Iterator<Resource> itr = multifield.listChildren();
			while (itr.hasNext()) {
				Resource r = itr.next();
				ValueMap vmap = r.getValueMap();
				Multifield mf = new Multifield();
				mf.setLinktitle(vmap.get("linktitle", String.class));
				mf.setLinkURL(vmap.get("linkURL", String.class));
				mfield.add(mf);
			}

		}
	}

	class Multifield {
		private String linktitle;
		private String linkURL;

		public String getLinktitle() {
			return linktitle;
		}

		public void setLinktitle(String linktitle) {
			this.linktitle = linktitle;
		}

		public String getLinkURL() {
			return linkURL;
		}

		public void setLinkURL(String linkURL) {
			this.linkURL = linkURL;
		}
	}
}
