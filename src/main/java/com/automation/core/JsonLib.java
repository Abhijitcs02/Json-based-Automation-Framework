package com.automation.core;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

/**
 * json library
 * functions to convert json to map and vice versa
 */
public class JsonLib {
    ObjectMapper mapper = new ObjectMapper();


    /**
     * Read JSON from a file into a Map
     *
     * @return
     */
    public Map<String, Object> jsonToMap(String fileName) {
        File file = new File(fileName);
        try {
            return mapper.readValue(file, HashMap.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Convert map to a JSON String
     *
     * @return
     */
    public void mapToJsonString(String filename , Map<String, Object> map) {
        try {
//            mapper.writeValue(new File(filename) , map);
            DefaultPrettyPrinter pp = new DefaultPrettyPrinter();
//            pp.indentArraysWith(new Lf2SpacesIndenter());
            mapper.writer(pp).writeValue(new File(filename) , map);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Convert map to a JSON String
     *
     * @return
     */
    public String mapToJsonString(Map<String, Object> map) {
        try {
            return mapper.writeValueAsString(map);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

//    public static void main(String[] args) {
//        Map<String, Object> result = new JsonLib().jsonToMap("src/test/resources/testcaseBank/poc/testcase1.json");
//        System.out.println(result.get("description"));
//        System.out.println(result.get("steps"));
//
//        System.out.println(new JsonLib().mapToJsonString(result));
//    }
}
