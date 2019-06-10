package com.data.loader;

import com.data.objects.OrganizationJSON;
import com.data.objects.TicketJSON;
import com.data.objects.UserJSON;
import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * This class Loads JSON files from resources folder, and POJOs
 */
public class JsonLoader {

    public static final String ORGANIZATIONS_JSON = "organizations.json";
    public static final String TICKETS_JSON = "tickets.json";
    public static final String USERS_JSON = "users.json";

    private JsonLoader(){

    }

    public static OrganizationJSON[] loadOrganizations() throws FileNotFoundException{
        Gson gson = new Gson();
        return gson.fromJson(new FileReader(JsonLoader.class.getClassLoader().getResource(ORGANIZATIONS_JSON).getPath()), OrganizationJSON[].class);
    }

    public static TicketJSON[] loadTickets() throws FileNotFoundException{
        Gson gson = new Gson();
        return gson.fromJson(new FileReader(JsonLoader.class.getClassLoader().getResource(TICKETS_JSON).getPath()), TicketJSON[].class);
    }

    public static UserJSON[] loadUsers() throws FileNotFoundException{
        Gson gson = new Gson();
        return gson.fromJson(new FileReader(JsonLoader.class.getClassLoader().getResource(USERS_JSON).getPath()), UserJSON[].class);
    }

}
