package com.regnant.services;

import com.adobe.cq.sightly.WCMUsePojo;

public class Mycomponentpojo extends WCMUsePojo {

	private String Mytitle;

	@Override
	public void activate() throws Exception {
		Mytitle = "mama" + getCurrentPage().getTitle();
	}

	public String getMytitle() {
		return Mytitle;
	}

}
