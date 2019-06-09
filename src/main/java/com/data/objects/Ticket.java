package com.data.objects;

import java.util.ArrayList;
import java.util.HashMap;

public class Ticket {
    private String id;
    private String url;
    private String createdAt;
    private String type;
    private String subject;
    private String description;
    private String priority;
    private String status;
    private User submitter;
    private User assignee;
    private Organization organization;
    private ArrayList<String> tags;
    private boolean hasIncidents;
    private String dueAt;
    private String via;

    public Ticket(TicketJSON jsonObject, HashMap<Integer, Organization> orgMap, HashMap<Integer, User> userMap){
        this.id = jsonObject.get_id();
        this.url = jsonObject.getUrl();
        this.createdAt = jsonObject.getCreated_at();
        this.type = jsonObject.getType();
        this.subject = jsonObject.getSubject();
        this.description = jsonObject.getDescription();
        this.priority = jsonObject.getPriority();
        this.status = jsonObject.getStatus();
        this.tags = jsonObject.getTags();
        this.hasIncidents = jsonObject.isHas_incidents();
        this.dueAt = jsonObject.getDue_at();
        this.via = jsonObject.getVia();

        this.submitter = userMap.get(jsonObject.getSubmitter_id());
        this.assignee = userMap.get(jsonObject.getAssignee_id());
        this.organization = orgMap.get(jsonObject.getOrganization_id());
    }
}
