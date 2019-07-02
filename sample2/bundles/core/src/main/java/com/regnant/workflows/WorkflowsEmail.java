package com.regnant.workflows;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.granite.workflow.WorkflowException;
import com.adobe.granite.workflow.WorkflowSession;
import com.adobe.granite.workflow.exec.WorkItem;
import com.adobe.granite.workflow.exec.WorkflowProcess;
import com.adobe.granite.workflow.metadata.MetaDataMap;
import com.day.cq.mailer.MessageGateway;
import com.day.cq.mailer.MessageGatewayService;

@Component(service = WorkflowProcess.class, property = {

		Constants.SERVICE_DESCRIPTION + "=Test email workflow process", Constants.SERVICE_VENDOR + "=Adobe",
		"process.label=Email for workflow" })
public class WorkflowsEmail implements WorkflowProcess {
	Logger logger=LoggerFactory.getLogger(this.getClass());
	@Reference
	private MessageGatewayService msggatewayservice;
	@Override
	public void execute(WorkItem arg0, WorkflowSession arg1, MetaDataMap arg2) throws WorkflowException {
		logger.info("We are in execute method");
		MessageGateway<Email> msggateway;
		Email email=new SimpleEmail();
		String To="shkumar.1993@gmail.com";
		String CC="b.sairavichandra@gmail.com";
		try {
			email.addTo(To);
			email.addCc(CC);
			email.setSubject("Email workflow");
			email.setFrom("kirthikajanakarajan@gmail.com");
			email.setMsg("<-----Pandi-->Weds<--Donkey------->");
			msggateway = msggatewayservice.getGateway(Email.class);
			msggateway.send(email);
		} catch (EmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
	}

}
