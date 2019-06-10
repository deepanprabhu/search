package com.data.mapper;

import com.data.objects.*;
import com.data.loader.JsonLoader;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * This class creates Actual Java Objects from JSON POJOs, and resolves references
 **/
public class MapData {

    Organization[] organizations;
    User[] users;
    Ticket[] tickets;

    final HashMap<Integer, Organization> orgMap = new HashMap<Integer, Organization>();
    final HashMap<Integer, User> userMap = new HashMap<Integer, User>();
    final HashMap<String, Ticket> ticketMap = new HashMap<String, Ticket>();

    public Organization[] getOrganizations() {
        return organizations;
    }

    public User[] getUsers() {
        return users;
    }

    public Ticket[] getTickets() {
        return tickets;
    }

    /**
     * Load Jsons, Resolve References and Create Java Objects for Querying
     * @throws FileNotFoundException
     */
    public MapData() throws FileNotFoundException {
        OrganizationJSON[] organizationsJsons = JsonLoader.loadOrganizations();
        TicketJSON[] ticketsJsons = JsonLoader.loadTickets();
        UserJSON[] usersJsons = JsonLoader.loadUsers();

        ArrayList<Organization> orgList = new ArrayList<Organization>();

        //  From Json Objects - Create Main Organization Objects
        for(OrganizationJSON organizationJson : organizationsJsons){
            Organization organization = new Organization(organizationJson);
            orgMap.put(organizationJson.get_id(), organization);
            orgList.add(organization);
        }

        //  From Json Objects - Create Main User Objects
        ArrayList<User> userList = new ArrayList<User>();
        for(UserJSON userJson : usersJsons) {
            User user = new User(userJson, orgMap);
            userMap.put(userJson.get_id(), user);
            userList.add(user);

        }

        //  From Json Objects - Create Main Ticket Objects
        ArrayList<Ticket> ticketList = new ArrayList<Ticket>();
        for(TicketJSON ticketJson : ticketsJsons) {
            Ticket ticket = new Ticket(ticketJson, orgMap, userMap);
            ticketMap.put(ticketJson.get_id(), ticket);
            ticketList.add(ticket);
        }

        organizations = orgList.toArray(new Organization[0]);
        users = userList.toArray(new User[0]);
        tickets = ticketList.toArray(new Ticket[0]);
    }
}
