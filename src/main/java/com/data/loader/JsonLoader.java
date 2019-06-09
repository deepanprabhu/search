package com.data.loader;

import com.data.objects.OrganizationJSON;
import com.data.objects.TicketJSON;
import com.data.objects.UserJSON;
import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class JsonLoader {

    public static OrganizationJSON[] loadOrganizations() throws FileNotFoundException{
        Gson gson = new Gson();
        return gson.fromJson(new FileReader(JsonLoader.class.getClassLoader().getResource("organizations.json").getPath()), OrganizationJSON[].class);
    }

    public static TicketJSON[] loadTickets() throws FileNotFoundException{
        Gson gson = new Gson();
        return gson.fromJson(new FileReader(JsonLoader.class.getClassLoader().getResource("organizations.json").getPath()), TicketJSON[].class);
    }

    public static UserJSON[] loadUsers() throws FileNotFoundException{
        Gson gson = new Gson();
        return gson.fromJson(new FileReader(JsonLoader.class.getClassLoader().getResource("organizations.json").getPath()), UserJSON[].class);
    }

}
