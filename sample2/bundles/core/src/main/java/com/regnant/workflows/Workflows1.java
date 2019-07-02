package com.regnant.workflows;

import javax.jcr.Node;
import javax.jcr.PathNotFoundException;
import javax.jcr.Property;
import javax.jcr.RepositoryException;
import javax.jcr.Session;

import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.granite.workflow.WorkflowException;
import com.adobe.granite.workflow.WorkflowSession;
import com.adobe.granite.workflow.exec.WorkItem;
import com.adobe.granite.workflow.exec.WorkflowData;
import com.adobe.granite.workflow.exec.WorkflowProcess;
import com.adobe.granite.workflow.metadata.MetaDataMap;


@Component(service=WorkflowProcess.class,property={
		Constants.SERVICE_VENDOR+"=Pandi",
		Constants.SERVICE_DESCRIPTION+"=First Worlflow Program","process.label=Worflow1"})
public class Workflows1 implements WorkflowProcess 
{
	protected final Logger logger=LoggerFactory.getLogger(this.getClass());
	@Override
	public void execute(WorkItem item, WorkflowSession session, MetaDataMap metadata) throws WorkflowException 
	{
		Session jcrsession = session.adaptTo(Session.class);
		WorkflowData workflowData = item.getWorkflowData();
		String payloadpath = workflowData.getPayload().toString();
		logger.info("payloadpath{}",payloadpath);
		System.out.println("pandi(Hemanth)---------->"+payloadpath);
		try {
			Node node = jcrsession.getNode(payloadpath);
			if(null!=node)
			{
				node=node.hasNode("jcr:content")?node.getNode("jcr:content"):node;
				Property setProperty = node.setProperty("name", "value");
				jcrsession.save();
			}
		} catch (PathNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RepositoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
