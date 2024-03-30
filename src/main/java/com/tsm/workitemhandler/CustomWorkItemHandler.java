package com.tsm.workitemhandler;

//import org.drools.core.process.instance.WorkItemHandler; //this is extending org.kie.api.runtime.process.WorkItemHandler
//import org.jbpm.process.workitem.core.util.Wid;
//import org.jbpm.process.workitem.core.util.WidMavenDepends;
//import org.jbpm.process.workitem.core.util.WidParameter;
//import org.jbpm.process.workitem.core.util.service.WidAction;
//import org.jbpm.process.workitem.core.util.service.WidAuth;
//import org.jbpm.process.workitem.core.util.service.WidService;

import org.kie.api.runtime.process.WorkItemHandler; //
import org.kie.api.runtime.process.WorkItem;
import org.kie.api.runtime.process.WorkItemManager;

//This was created from ArchiveDefinitions.wid
/*@Wid(widfile = "CustomWorkItemDefinitions.wid", name = "CustomWorkItem",
        displayName = "CustomWorkItem",
        defaultHandler = "mvel: new com.tsm.workitemhandler.CustomWorkItemHandler()",
        documentation = "${artifactId}/index.html",
        category = "${artifactId}",
        icon = "CustomWorkItem.png",
        parameters = {
                @WidParameter(name = "Archive", required = true),
                @WidParameter(name = "Files", runtimeType = "java.util.List")
        },
        mavenDepends = {
                @WidMavenDepends(group = "${groupId}", artifact = "${artifactId}", version = "${version}")
        },
        serviceInfo = @WidService(category = "${name}", description = "${description}",
                keywords = "archive,file,files,zip",
                action = @WidAction(title = "CustomWorkItem implementation example"),
                authinfo = @WidAuth
        )
)*/
public class CustomWorkItemHandler implements WorkItemHandler { //extends AbstractLogOrThrowWorkItemHandler
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
