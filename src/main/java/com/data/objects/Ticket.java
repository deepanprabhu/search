package com.data.objects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Ticket Object - References Organization and User Objects
 */
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

    public String getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getType() {
        return type;
    }

    public String getSubject() {
        return subject;
    }

    public String getDescription() {
        return description;
    }

    public String getPriority() {
        return priority;
    }

    public String getStatus() {
        return status;
    }

    public User getSubmitter() {
        return submitter;
    }

    public User getAssignee() {
        return assignee;
    }

    public Organization getOrganization() {
        return organization;
    }

    public List<String> getTags() {
        return tags;
    }

    public boolean isHasIncidents() {
        return hasIncidents;
    }

    public String getDueAt() {
        return dueAt;
    }

    public String getVia() {
        return via;
    }

    public Ticket(TicketJSON jsonObject, Map<Integer, Organization> orgMap, Map<Integer, User> userMap){
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

    @Override
    public String toString() {
        String tagsAsString = String.join(",", this.tags);

        StringBuilder displayString = new StringBuilder();

        displayString.append("id = ").append(this.id).append("\n");
        displayString.append("url = ").append(this.url).append("\n");
        displayString.append("createdAt = ").append(this.createdAt).append("\n");
        displayString.append("type = ").append(this.type).append("\n");
        displayString.append("subject = ").append(this.subject).append("\n");
        displayString.append("description = ").append(this.description).append("\n");
        displayString.append("priority = ").append(this.priority).append("\n");
        displayString.append("status = ").append(this.status).append("\n");
        displayString.append("tags = [").append(tagsAsString).append("]\n");
        displayString.append("hasIncidents = ").append(this.hasIncidents).append("\n");
        displayString.append("dueAt = ").append(this.dueAt).append("\n");
        displayString.append("via = ").append(this.via).append("\n");
        displayString.append("\nSubmitter:\n").append(this.submitter).append("\n");
        displayString.append("\nAssignee:\n").append(this.assignee).append("\n");
        displayString.append("\nOrganization:\n").append(this.organization).append("\n");

        return displayString.toString();
    }

}
