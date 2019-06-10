package com.jxpath;

import com.data.mapper.MapData;
import org.apache.commons.jxpath.Container;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.FileNotFoundException;
import java.util.HashMap;

// TODO: Directly load from JSON files - But not sure how references would work

/**
 * JXPath JSON Container Implementation
 */
public class JsonContainer implements Container {

    MapData mapData;

    public JsonContainer(){
        try{
            mapData = new MapData();
        }
        catch(FileNotFoundException e){
            System.err.println("JSON File not Found - Please Check");
        }
    }

    HashMap<String, Object> objects = new HashMap<String, Object>();

    public Object getValue() {
        objects.put("users", mapData.getUsers());
        objects.put("tickets", mapData.getTickets());
        objects.put("organizations", mapData.getOrganizations());
        return objects;
    }

    public void setValue(Object o) {
        throw new NotImplementedException();
    }
}
