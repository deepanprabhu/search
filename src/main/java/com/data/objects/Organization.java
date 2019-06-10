package com.data.objects;

import java.util.ArrayList;
import java.util.List;

/**
 * Organization Object
 */
public class Organization {
    private int id;
    private String url;
    private String name;
    private ArrayList<String> domainNames;
    private String createdAt;
    private String details;

    public int getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public String getName() {
        return name;
    }

    public List<String> getDomainNames() {
        return domainNames;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getDetails() {
        return details;
    }

    public Organization(OrganizationJSON jsonObject){
        this.id = jsonObject.get_id();
        this.url = jsonObject.getUrl();
        this.name = jsonObject.getName();
        this.domainNames = jsonObject.getDomain_names();
        this.createdAt = jsonObject.getCreated_at();
        this.details = jsonObject.getDetails();
    }

    @Override
    public String toString() {
        String domainNamesAsString = String.join(",", this.domainNames);

        StringBuilder displayString = new StringBuilder();

        displayString.append("id = ").append(this.id).append("\n");
        displayString.append("url = ").append(this.url).append("\n");
        displayString.append("name = ").append(this.name).append("\n");
        displayString.append("domainNames = [").append(domainNamesAsString).append("]\n");
        displayString.append("createdAt = ").append(this.createdAt).append("\n");
        displayString.append("details = ").append(this.details).append("\n");

        return displayString.toString();
    }
}
