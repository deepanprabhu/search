package com.data.objects;

import java.util.ArrayList;

/**
 * Organization JSON POJO
 */
public class OrganizationJSON {

    private int _id;
    private String url;
    private String external_id;
    private String name;
    private ArrayList<String> domain_names;
    private String created_at;
    private String details;
    private boolean shared_tickets;
    private ArrayList<String> tags;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getExternal_id() {
        return external_id;
    }

    public void setExternal_id(String external_id) {
        this.external_id = external_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getDomain_names() {
        return domain_names;
    }

    public void setDomain_names(ArrayList<String> domain_names) {
        this.domain_names = domain_names;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public boolean isShared_tickets() {
        return shared_tickets;
    }

    public void setShared_tickets(boolean shared_tickets) {
        this.shared_tickets = shared_tickets;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }
}
