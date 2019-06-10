package com.data.loader;

import com.data.objects.OrganizationJSON;
import com.data.objects.TicketJSON;
import com.data.objects.UserJSON;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

/**
 * This class Loads JSON files from resources folder, and POJOs
 */
public class JsonLoader {

    public static final String ORGANIZATIONS_JSON = "organizations.json";
    public static final String TICKETS_JSON = "tickets.json";
    public static final String USERS_JSON = "users.json";

    private JsonLoader() {

    }

    public static String getResourceFileAsString(String fileName) {
        ClassLoader classLoader = JsonLoader.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream(fileName);
        if (is != null) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            return reader.lines().collect(Collectors.joining(System.lineSeparator()));
        }
        return null;
    }

    public static OrganizationJSON[] loadOrganizations() throws FileNotFoundException {
        Gson gson = new Gson();
        return gson.fromJson(getResourceFileAsString(ORGANIZATIONS_JSON), OrganizationJSON[].class);
    }

    public static TicketJSON[] loadTickets() throws FileNotFoundException {
        Gson gson = new Gson();
        return gson.fromJson(getResourceFileAsString(TICKETS_JSON), TicketJSON[].class);
    }

    public static UserJSON[] loadUsers() throws FileNotFoundException {
        Gson gson = new Gson();
        return gson.fromJson(getResourceFileAsString(USERS_JSON), UserJSON[].class);
    }

}
