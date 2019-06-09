package com.schema;

import com.data.Organization;
import com.data.Ticket;
import com.data.User;

import java.util.ArrayList;

public class Document {

    //  Organization values
    private String orgName;
    private ArrayList<String> orgDomainNames;
    private String orgDetails;
    private ArrayList<String> tags;
    private boolean sharedTickets;

    //  Ticket values
    private String ticketType;
    private String ticketSubject;
    private String ticketDescription;
    private String ticketPriority;
    private String ticketStatus;
    private Organization ticketOrganization;
    private boolean hasIncidents;
    private String ticketDueDate;
    private String ticketVia;

    //  Users
    private String submitterName;
    private String submitterAlias;
    private boolean submitterIsActive;
    private boolean submitterIsVerified;
    private boolean submitterIsShared;
    private String submitterLocale;
    private String submitterTimeZone;
    private String submitterEmail;
    private String submitterPhone;
    private String submitterSignature;
    private boolean isSuspended;
    private String role;


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
        private Organization organization;
        private ArrayList<String> tags;
        private boolean isSuspended;
        private String role;

        public DocumentUser(User user){
        }
    }

    public Document(Ticket ticket, Organization organization, User submitter, User assigner) {
    }
}
