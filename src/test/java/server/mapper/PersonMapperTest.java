package server.mapper;

import com.google.gson.internal.LinkedTreeMap;
import org.junit.jupiter.api.Test;
import server.model.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonMapperTest {

    @Test
    void shouldReturnValidPerson_ifJsonIsValidJson() {

        // given

        LinkedTreeMap<String, Object> json = new LinkedTreeMap<>();
        json.put("id", 1L);
        json.put("name", "John");
        json.put("lastName", "Doe");

        // when
        Person person = PersonMapper.jsonToObject(json);

        // then
        assert person.getId() == 1L;
        assert person.getFirstName().equals("John");
        assert person.getLastName().equals("Doe");
    }

    @Test
    void shouldReturnValidPerson_ifJsonIsValidJsonWithNullValues() {

        // given

        LinkedTreeMap<String, Object> json = new LinkedTreeMap<>();
        json.put("id", 1L);
        json.put("name", "John");
        json.put("lastName", null);

        // when
        Person person = PersonMapper.jsonToObject(json);

        // then
        assert person.getId() == 1L;
        assert person.getFirstName().equals("John");
        assert person.getLastName() == null;
    }

    @Test
    void shouldReturnValidPerson_ifJsonIsValidJsonWithEmptyValues() {

        // given

        LinkedTreeMap<String, Object> json = new LinkedTreeMap<>();
        json.put("id", 1L);
        json.put("name", "John");
        json.put("lastName", "");

        // when
        Person person = PersonMapper.jsonToObject(json);

        // then
        assert person.getId() == 1L;
        assert person.getFirstName().equals("John");
        assert person.getLastName().equals("");
    }

    @Test
    void shouldReturnValidPerson_ifJsonIsValidJsonWithEmptyValuesAndNullValues() {

        // given
        LinkedTreeMap<String, Object> json = new LinkedTreeMap<>();
        json.put("id", 1L);
        json.put("name", "John");
        json.put("lastName", null);

        // when
        Person person = PersonMapper.jsonToObject(json);

        // then
        assert person.getId() == 1L;
        assert person.getFirstName().equals("John");
        assert person.getLastName() == null;
    }

    @Test
    void shouldReturnValidJson_ifPersonIsValid() {

        // given
        Person person = new Person();
        person.setId(1L);
        person.setFirstName("John");
        person.setLastName("Doe");

        // when
        LinkedTreeMap<String, Object> json = PersonMapper.objectToJson(person);

        // then
        Object id = json.get("id");
        assert id.equals(1L);
        assert json.get("name").equals("John");
        assert json.get("lastName").equals("Doe");
        assert json.toString().equals("{id=1, name=John, lastName=Doe}");
    }
    

    @Test 
    void shouldReturnValidPersonList_fromValidPersonsJsonsList() {

        // given
        LinkedTreeMap<String, Object> json1 = new LinkedTreeMap<>();
        json1.put("id", 1L);
        json1.put("name", "John");
        json1.put("lastName", "Doe");

        LinkedTreeMap<String, Object> json2 = new LinkedTreeMap<>();
        json2.put("id", 2L);
        json2.put("name", "Jane");
        json2.put("lastName", "Doe");

        LinkedTreeMap<String, Object> json3 = new LinkedTreeMap<>();
        json3.put("id", 3L);
        json3.put("name", "John");
        json3.put("lastName", "Smith");

        List<LinkedTreeMap<String, Object>> jsons = new ArrayList<>();
        jsons.add(json1);
        jsons.add(json2);
        jsons.add(json3);

        // when
        List<Person> persons = PersonMapper.jsonsToObjects(jsons);

        // then
        assert persons.size() == 3;

        assert persons.get(0).getId() == 1L;
        assert persons.get(0).getFirstName().equals("John");
        assert persons.get(0).getLastName().equals("Doe");

        assert persons.get(1).getId() == 2L;
        assert persons.get(1).getFirstName().equals("Jane");
        assert persons.get(1).getLastName().equals("Doe");

        assert persons.get(2).getId() == 3L;
        assert persons.get(2).getFirstName().equals("John");
        assert persons.get(2).getLastName().equals("Smith");
    }
    
    @Test
    void shouldReturnValidPersonsJsons_fromValidPersonsList() {
            
            // given
            Person person1 = new Person();
            person1.setId(1L);
            person1.setFirstName("John");
            person1.setLastName("Doe");
    
            Person person2 = new Person();
            person2.setId(2L);
            person2.setFirstName("Jane");
            person2.setLastName("Doe");
    
            Person person3 = new Person();
            person3.setId(3L);
            person3.setFirstName("John");
            person3.setLastName("Smith");
    
            List<Person> persons = new ArrayList<>();
            persons.add(person1);
            persons.add(person2);
            persons.add(person3);
    
            // when
            List<LinkedTreeMap<String, Object>> jsons = PersonMapper.objectsToJsons(persons);
    
            // then
            assert jsons.size() == 3;
    
            assert jsons.get(0).get("id").equals(1L);
            assert jsons.get(0).get("name").equals("John");
            assert jsons.get(0).get("lastName").equals("Doe");
    
            assert jsons.get(1).get("id").equals(2L);
            assert jsons.get(1).get("name").equals("Jane");
            assert jsons.get(1).get("lastName").equals("Doe");
    
            assert jsons.get(2).get("id").equals(3L);
            assert jsons.get(2).get("name").equals("John");
            assert jsons.get(2).get("lastName").equals("Smith");
    }
}
