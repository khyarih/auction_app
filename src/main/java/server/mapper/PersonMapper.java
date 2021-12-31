package server.mapper;

import com.google.gson.internal.LinkedTreeMap;
import server.model.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonMapper {

    public static List<Person> jsonsToObjects(List<LinkedTreeMap<String, Object>> jsons) {
        List<Person> persons = new ArrayList<Person>();

        for (LinkedTreeMap<String, Object> json : jsons) {
            Person person = new Person();
            person.setId((Long) json.get("id"));
            person.setFirstName((String) json.get("name"));
            person.setLastName((String) json.get("lastName"));
            persons.add(person);
        }

        return persons;
    }
    
    public static Person jsonToObject(LinkedTreeMap<String, Object> json) {
        Person person = new Person();
        person.setId((Long) json.get("id"));
        person.setFirstName((String) json.get("name"));
        person.setLastName((String) json.get("lastName"));

        return person;
    }

    public static List<LinkedTreeMap<String, Object>> objectsToJsons(List<Person> persons) {
        List<LinkedTreeMap<String, Object>> jsons = new ArrayList<LinkedTreeMap<String, Object>>();

        for (Person person : persons) {
            LinkedTreeMap<String, Object> json = new LinkedTreeMap<String, Object>();
            json.put("id", person.getId());
            json.put("name", person.getFirstName());
            json.put("lastName", person.getLastName());

            jsons.add(json);
        }

        return jsons;
    }

    public static LinkedTreeMap<String, Object> objectToJson(Person person) {
        LinkedTreeMap<String, Object> json = new LinkedTreeMap<String, Object>();
        json.put("id", person.getId());
        json.put("name", person.getFirstName());
        json.put("lastName", person.getLastName());

        return json;
    }

}
