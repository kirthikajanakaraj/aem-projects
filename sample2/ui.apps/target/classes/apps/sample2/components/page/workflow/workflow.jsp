<%@taglib prefix="cq" uri="http://www.day.com/taglibs/cq/1.0" %>
<h1>TemplateSling Page</h1>
<%
//create a custom.sling.Query instance
custom.sling.Query wfService = sling.getService(custom.sling.Query.class);
 
%>
<h2>Use the Sling API to get title of the resource at /content/wrokflow_retrivedata/jcr:content</h2>
  
<h3>The title of the page is: <%=  wfService.getJCRData("/content/wrokflow_retrivedata/jcr:content")%></h3>