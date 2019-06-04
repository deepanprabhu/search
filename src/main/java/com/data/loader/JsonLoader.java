package com.data.loader;

import com.data.Organization;
import com.data.Ticket;
import com.data.User;
import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class JsonLoader {

    public static Organization[] loadOrganizations() throws FileNotFoundException{
        Gson gson = new Gson();
        return gson.fromJson(new FileReader(JsonLoader.class.getClassLoader().getResource("organizations.json").getPath()), Organization[].class);
    }

    public static Ticket[] loadTickets() throws FileNotFoundException{
        Gson gson = new Gson();
        return gson.fromJson(new FileReader(JsonLoader.class.getClassLoader().getResource("organizations.json").getPath()), Ticket[].class);
    }

    public static User[] loadUsers() throws FileNotFoundException{
        Gson gson = new Gson();
        return gson.fromJson(new FileReader(JsonLoader.class.getClassLoader().getResource("organizations.json").getPath()), User[].class);
    }

}
