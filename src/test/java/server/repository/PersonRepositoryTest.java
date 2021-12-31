package server.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import server.exception.SirJpaAddException;
import server.model.Person;

public class PersonRepositoryTest {
    private static SirJpaRepository<Long, Person> repository;
    // Add Person

    @BeforeAll
    static void init(){
        repository = new SirJpaRepositoryImpl<>();
    }

    @Test
    void shouldThrowSirJpaAddException_ifObjectIsNull() {
        Assertions.assertThrows(SirJpaAddException.class,()->repository.add(1L,null));
    }

    @Test
    void shouldInsertNewPerson_ifPersonIsNotNull() {
        String firstName = "jilali";
        String lastName = "taher";

        Person person = new Person(firstName, lastName);

        Assertions.assertDoesNotThrow(() -> repository.add(person.getId(), person));
    }

}
