package com.data.objects;

import java.util.ArrayList;

public class Organization {
    private int id;
    private String url;
    private String name;
    private ArrayList<String> domainNames;
    private String createdAt;
    private String details;

    public Organization(OrganizationJSON jsonObject){
        this.id = jsonObject.get_id();
        this.url = jsonObject.getUrl();
        this.name = jsonObject.getName();
        this.domainNames = jsonObject.getDomain_names();
        this.createdAt = jsonObject.getCreated_at();
        this.details = jsonObject.getDetails();
    }
}
