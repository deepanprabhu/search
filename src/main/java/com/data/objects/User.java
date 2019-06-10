package com.data.objects;

import java.util.ArrayList;
import java.util.HashMap;

public class User {
    private int id;
    private String url;
    private String name;
    private String alias;
    private String createdAt;
    private boolean active;
    private boolean verified;
    private boolean shared;
    private String locale;
    private String timezone;
    private String lastLoginAt;
    private String email;
    private String signature;
    private Organization organization;
    private ArrayList<String> tags;
    private boolean suspended;
    private String role;

    public int getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public String getName() {
        return name;
    }

    public String getAlias() {
        return alias;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public boolean isActive() {
        return active;
    }

    public boolean isVerified() {
        return verified;
    }

    public boolean isShared() {
        return shared;
    }

    public String getLocale() {
        return locale;
    }

    public String getTimezone() {
        return timezone;
    }

    public String getLastLoginAt() {
        return lastLoginAt;
    }

    public String getEmail() {
        return email;
    }

    public String getSignature() {
        return signature;
    }

    public Organization getOrganization() {
        return organization;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public boolean isSuspended() {
        return suspended;
    }

    public String getRole() {
        return role;
    }

    public User(UserJSON jsonObject, HashMap<Integer, Organization> orgMap){
        this.id = jsonObject.get_id();
        this.url = jsonObject.getUrl();
        this.name = jsonObject.getName();
        this.alias = jsonObject.getAlias();
        this.createdAt = jsonObject.getCreated_at();
        this.active = jsonObject.isActive();
        this.verified = jsonObject.isVerified();
        this.shared = jsonObject.isShared();
        this.locale = jsonObject.getLocale();
        this.timezone = jsonObject.getTimezone();
        this.lastLoginAt = jsonObject.getLast_login_at();
        this.email = jsonObject.getEmail();
        this.signature = jsonObject.getSignature();
        this.tags = jsonObject.getTags();
        this.suspended = jsonObject.isSuspended();
        this.role = jsonObject.getRole();

        this.organization = orgMap.get(jsonObject.getOrganization_id());
    }

    @Override
    public String toString() {
        String tagsAsString = String.join(",", this.tags);

        StringBuilder displayString = new StringBuilder();

        displayString.append("id = ").append(this.id).append("\n");
        displayString.append("url = ").append(this.url).append("\n");
        displayString.append("createdAt = ").append(this.createdAt).append("\n");
        displayString.append("name = ").append(this.name).append("\n");
        displayString.append("alias = ").append(this.alias).append("\n");
        displayString.append("verified = ").append(this.verified).append("\n");
        displayString.append("shared = ").append(this.shared).append("\n");
        displayString.append("locale = ").append(locale).append("\n");
        displayString.append("timezone = ").append(this.timezone).append("\n");
        displayString.append("lastLoginAt = ").append(this.lastLoginAt).append("\n");
        displayString.append("email = ").append(this.email).append("\n");
        displayString.append("signature = ").append(this.signature).append("\n");
        displayString.append("suspended = ").append(this.suspended).append("\n");
        displayString.append("role = ").append(this.role).append("\n");
        displayString.append("tags = [").append(tagsAsString).append("]\n");
        displayString.append("\nUser's organization:\n").append(this.organization).append("\n");

        return displayString.toString();
    }

}
