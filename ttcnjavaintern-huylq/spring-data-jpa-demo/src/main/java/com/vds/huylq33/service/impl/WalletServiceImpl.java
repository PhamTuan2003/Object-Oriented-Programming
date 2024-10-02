package com.vds.huylq33.service.impl;

import com.vds.huylq33.model.Person;
import com.vds.huylq33.model.Wallet;
import com.vds.huylq33.repository.PersonRepository;
import com.vds.huylq33.repository.WalletRepository;
import com.vds.huylq33.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class WalletServiceImpl implements WalletService {

    private WalletRepository walletRepository;
    private PersonRepository personRepository;

    @Autowired
    public void setWalletRepository(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    @Autowired
    public void setPersonRepository(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Wallet createEmptyWallet() {
        Wallet emptyWallet = new Wallet();
        walletRepository.save(emptyWallet);
        return emptyWallet;
    }

    @Override
    public Wallet createNewWalletAndAttachToPerson(Person person) {
        Wallet emptyWallet = new Wallet();
        walletRepository.save(emptyWallet);

        person.setWallet(emptyWallet);

        return emptyWallet;
    }

    @Override
    public Wallet createNewWalletAndAttachToPerson(int personId) {
        Wallet emptyWallet = new Wallet();
        walletRepository.save(emptyWallet);

        Person person = personRepository.findById(personId).orElseThrow(() -> new RuntimeException("Person not found"));
        person.setWallet(emptyWallet);

        return emptyWallet;
    }
}
