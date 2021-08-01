package com.boneto.personapi.service;

import static com.boneto.personapi.util.PersonUtils.createFakeDTO;
import static com.boneto.personapi.util.PersonUtils.createFakeEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.boneto.personapi.dto.request.PersonDTO;
import com.boneto.personapi.dto.response.MessageResponseDTO;
import com.boneto.personapi.entities.Person;
import com.boneto.personapi.repository.PersonRepository;
import com.boneto.personapi.services.PersonService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

  @Mock
  private PersonRepository personRepository;

  @InjectMocks
  private PersonService personService;

  @Test
  void testGivenPersonDTOThenReturnSavedMessage() {
    PersonDTO personDTO = createFakeDTO();
    Person expectedSavedPerson = createFakeEntity();

    when(personRepository.save(any(Person.class))).thenReturn(expectedSavedPerson);

    MessageResponseDTO expectedSuccessMessage = createExpectedMessageResponse(expectedSavedPerson.getId());
    MessageResponseDTO succesMessage = personService.create(personDTO);

    assertEquals(expectedSuccessMessage, succesMessage);
  }

  private MessageResponseDTO createExpectedMessageResponse(Long id) {
    return MessageResponseDTO
        .builder()
        .message("Created person with ID " + id)
        .build();
  }
}
