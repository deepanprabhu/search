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
}
