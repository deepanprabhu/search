package com.schema;

import com.data.Organization;
import com.data.Ticket;
import com.data.User;

import java.util.ArrayList;

public class Document {
    private String orgName;
    private ArrayList<String> orgDomainNames;
    private String orgDetails;
    private ArrayList<String> tags;
    private boolean sharedTickets;

    public static class DocumentUser {
        private String userName;
        private String userAlias;
        private boolean isActive;
        private boolean isVerified;
        private boolean isShared;
        private String locale;
        private String timeZone;
        private String email;
        private String phone;
        private String signature;
        private int organizationId;
        private ArrayList<String> tags;
        private boolean isSuspended;
        private String role;

        public DocumentUser(User user){

        }
    }

    public Document(Ticket ticket, Organization organization, User submitter, User assigner) {
    }
}
