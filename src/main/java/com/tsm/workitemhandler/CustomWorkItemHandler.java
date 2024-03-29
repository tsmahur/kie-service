package com.tsm.workitemhandler;

//import org.kie.api.runtime.process.WorkItemHandler;

import org.drools.core.process.instance.WorkItemHandler;
import org.kie.api.runtime.process.WorkItem;
import org.kie.api.runtime.process.WorkItemManager;

public class CustomWorkItemHandler implements WorkItemHandler {
    public CustomWorkItemHandler(){}
    @Override
    public void executeWorkItem(WorkItem workItem, WorkItemManager workItemManager) {

        System.out.println("--------------START : CustomWorkItemHandler----------");

        if(workItemManager!=null){
            workItemManager.completeWorkItem(workItem.getId(), null);
        }

        System.out.println("--------------END : CustomWorkItemHandler----------");

    }

    @Override
    public void abortWorkItem(WorkItem workItem, WorkItemManager workItemManager) {

    }
}
