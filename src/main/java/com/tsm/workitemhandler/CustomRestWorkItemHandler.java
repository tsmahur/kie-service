package com.tsm.workitemhandler;

import org.jbpm.process.workitem.rest.RESTWorkItemHandler;
import org.kie.api.runtime.process.WorkItem;
import org.kie.api.runtime.process.WorkItemManager;

public class CustomRestWorkItemHandler extends RESTWorkItemHandler {
    public CustomRestWorkItemHandler(){}

    /*
     Refer parent executeWorkItem method of parent class RESTWorkItemHandler
    * */
    @Override
    public void executeWorkItem(WorkItem workItem, WorkItemManager workItemManager){
        System.out.println("--------------START : CustomRestWorkItemHandler----------");
        String urlStr = (String) workItem.getParameter("Url");
        String method = (String) workItem.getParameter("Method");
        String handleExceptionStr = (String) workItem.getParameter("HandleResponseErrors");
        String resultClass = (String) workItem.getParameter("ResultClass");
        String acceptHeader = (String) workItem.getParameter("AcceptHeader");
        String acceptCharset = (String) workItem.getParameter("AcceptCharset");
        String headers = (String) workItem.getParameter(PARAM_HEADERS);

        if(workItemManager!=null){
            workItemManager.completeWorkItem(workItem.getId(), null);
        }
        System.out.println("--------------END : CustomRestWorkItemHandler----------");
    }
}
