package com.jxpath;

import com.data.mapper.MapData;
import org.apache.commons.jxpath.Container;

import java.io.FileNotFoundException;
import java.util.HashMap;

// TODO: Directly load from JSON files - But not sure how references would work

/**
 * JXPath JSON Container Implementation - Refer Container implementation in JXPath
 */
public class JsonContainer implements Container {

    MapData mapData;

    /**
     * Constructor begins by mapping json files and resolving references.
     */
    public JsonContainer() {
        try {
            mapData = new MapData();
        } catch (FileNotFoundException e) {
            System.err.println("JSON File not Found - Please Check");
        }
    }

    /**
     * @return Object Hashmap - Referring users, tickets and organizations
     */
    public Object getValue() {
        HashMap<String, Object> objects = new HashMap<String, Object>();
        objects.put("users", mapData.getUsers());
        objects.put("tickets", mapData.getTickets());
        objects.put("organizations", mapData.getOrganizations());
        return objects;
    }

    public void setValue(Object o) {
    }
}
