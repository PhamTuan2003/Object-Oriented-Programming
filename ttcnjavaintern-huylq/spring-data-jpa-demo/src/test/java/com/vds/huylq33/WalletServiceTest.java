package com.vds.huylq33;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.vds.huylq33.config.PersistenceContext;
import com.vds.huylq33.model.Person;
import com.vds.huylq33.model.Wallet;
import com.vds.huylq33.repository.PersonRepository;
import com.vds.huylq33.repository.WalletRepository;
import com.vds.huylq33.service.WalletService;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = PersistenceContext.class)
public class WalletServiceTest {

    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private WalletRepository walletRepository;
    @Autowired
    private WalletService walletService;

    @Test
    public void shouldCreateAndAddEmptyWalletToPerson() {
        // given
        Person thomas = personRepository.save(new Person("Thomas"));

        // when
        Integer walletId = walletService.createNewWalletAndAttachToPerson(thomas).getId();

        // then
        Optional<Wallet> dbWallet = walletRepository.findById(walletId);
        assertTrue(dbWallet.isPresent());

        Optional<Person> dbThomas = personRepository.findById(thomas.getId());
        assertTrue(dbThomas.isPresent());

        Wallet thomasWallet = dbThomas.get().getWallet();
        // person.setWallet() wasn't propagated to db --> null
        // person was in a new transaction
        assertNotNull(thomasWallet);
    }
}
