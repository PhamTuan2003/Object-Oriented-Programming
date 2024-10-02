package com.vds.huylq33;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.vds.huylq33.config.PersistenceContext;
import com.vds.huylq33.model.Person;
import com.vds.huylq33.model.Wallet;
import com.vds.huylq33.repository.PersonRepository;
import com.vds.huylq33.service.PersonService;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {PersistenceContext.class})
public class PersonServiceTest {
    @Autowired
    private PersonService personService;
    @Autowired
    private PersonRepository personRepository;

    @Test
    public void shouldCreatePersonWithEmptyWallet() {
        int thomasId = personService.createPerson("Thomas");

        Optional<Person> thomas = personRepository.findById(thomasId);
        assertTrue(thomas.isPresent());

        Wallet wallet = thomas.get().getWallet();
        // Not null but its a auto-generated wallet with id = 2
        assertNotNull(wallet.getId());
    }
}
