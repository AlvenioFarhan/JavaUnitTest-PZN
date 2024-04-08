package service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import programmer.zaman.now.test.data.Person;
import programmer.zaman.now.test.repository.PersonRepository;
import programmer.zaman.now.test.service.PersonService;

@Extensions({
        @ExtendWith(MockitoExtension.class)
})
public class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    private PersonService personService;

    @BeforeEach
    void setUp() {
        personService = new PersonService(personRepository);
    }

    @Test
    void testNotFound() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            personService.get("not found");
        });
    }

    @Test
    void testGetPersonSuccess() {
        //menambah behavior ke mock object
        Mockito.when(personRepository.selectById("al"))
                .thenReturn(new Person("al", "Alvenio"));


        Person person = personService.get("al");

        Assertions.assertNotNull(person);
        Assertions.assertEquals("al", person.getId());
        Assertions.assertEquals("Alvenio", person.getName());
    }

    @Test
    void testRegisterSuccess() {
        Person person = personService.register("Alvenio");
        Assertions.assertNotNull(person);
        Assertions.assertEquals("Alvenio", person.getName());
        Assertions.assertNotNull(person.getId());

        Mockito.verify(personRepository, Mockito.times(1))
                .insert(new Person(person.getId(), "Alvenio"));
    }
}
