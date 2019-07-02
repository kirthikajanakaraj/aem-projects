package com.regnant.services;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name="pandi")

public @interface TestConfiguration {

	@AttributeDefinition(name="Message",description="this is sample pandi message")
	String getMessage();
}

