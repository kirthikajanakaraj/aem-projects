package com.regnant.sample2.models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;

@Model(adaptables = Resource.class)

public class NavigationAPI {
	@Inject
	@Optional
	private String linktitle;
	@Inject
	private ResourceResolver resource;
	private List navitems;

	public List getNavitems() {
		return navitems;
	}

	@PostConstruct
	private void init() {
		if (null != linktitle) {
			navitems = new ArrayList();
			PageManager pagemanager = resource.adaptTo(PageManager.class);
			if (null != pagemanager) {
				Page page = pagemanager.getPage(linktitle);
				Iterator<Page> page124 = page.listChildren();
				while (page124.hasNext()) {
					Page childpage = page124.next();
					navitems.add(childpage);
				}

			}

		}
	}

}
