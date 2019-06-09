package com.data.mapper;

import com.data.Organization;
import com.data.Ticket;
import com.data.User;
import com.data.loader.JsonLoader;

import java.io.FileNotFoundException;
import java.util.HashMap;

public class MapData {
    final HashMap<Integer, Organization> orgMap = new HashMap<Integer, Organization>();
    final HashMap<Integer, User> userMap = new HashMap<Integer, User>();
    final HashMap<String, Ticket> ticketMap = new HashMap<String, Ticket>();

    public MapData() throws FileNotFoundException {
        Organization[] organizations = JsonLoader.loadOrganizations();
        Ticket[] tickets = JsonLoader.loadTickets();
        User[] users = JsonLoader.loadUsers();

        for(Organization organization : organizations)
            orgMap.put(organization.get_id(), organization);

        for(User user : users)
            userMap.put(user.get_id(), user);

        for(Ticket ticket : tickets)
            ticketMap.put(ticket.get_id(), ticket);

    }
}
