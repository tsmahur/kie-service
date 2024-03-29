package com.tsm.workitemhandler;

import org.jbpm.process.workitem.email.Email;
import org.jbpm.process.workitem.email.EmailWorkItemHandler;
import org.jbpm.process.workitem.email.SendHtml;
import org.kie.api.runtime.process.WorkItem;
import org.kie.api.runtime.process.WorkItemManager;

import java.util.Map;

public class CustomEmailWorkItemHandler extends EmailWorkItemHandler {

    public CustomEmailWorkItemHandler(){}
    public CustomEmailWorkItemHandler(String host, String port, String userName, String password) {
//        this.setConnection(host, port, userName, password);
        super(host, port, userName, password);
    }

    /*
    Refer parent executeWorkItem method of parent class EmailWorkItemHandler
    * */
    public void executeWorkItem(WorkItem workItem, WorkItemManager workItemManager) {
//        try {
//            Email email = this.createEmail(workItem, this.connection);
//            SendHtml.sendHtml(email, this.getDebugFlag(workItem));
//            if (manager != null) {
//                manager.completeWorkItem(workItem.getId(), (Map)null);
//            }
//        } catch (Exception var4) {
//            this.handleException(var4);
//        }
        boolean mailSendEnabled= Boolean.parseBoolean(System.getProperty("jbpmn.mail.send.enabled","false"));
        if(mailSendEnabled) {
            super.executeWorkItem(workItem, workItemManager);
        }else{
            workItemManager.completeWorkItem(workItem.getId(), null);
        }

    }

}
