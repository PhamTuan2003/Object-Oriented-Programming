package com.vds.huylq33.service.impl;

import com.vds.huylq33.model.Person;
import com.vds.huylq33.model.Wallet;
import com.vds.huylq33.repository.PersonRepository;
import com.vds.huylq33.repository.WalletRepository;
import com.vds.huylq33.service.PersonService;
import com.vds.huylq33.service.WalletService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PersonServiceImpl implements PersonService {

    private PersonRepository personRepository;
    private WalletRepository walletRepository;
    private WalletService walletService;

    @Autowired
    public void setPersonRepository(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Autowired
    public void setWalletRepository(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    @Autowired
    public void setWalletService(WalletService walletService) {
        this.walletService = walletService;
    }

    @Override
    public List<Person> getAll() {
        return personRepository.findAll();
    }

    @Override
    public Person get(int id) {
        return personRepository.getById(id);
    }

    @Override
    public void add(Person person) {
        personRepository.save(person);
    }

    @Override
    public void update(Person person) {
        personRepository.save(person);
    }

    @Override
    public void delete(int id) {
        personRepository.delete(personRepository.getById(id));
    }

    @Override
    public int createPerson(String name) {
        Person person = new Person(name);
        personRepository.save(person);

        Wallet wallet = walletService
            .createNewWalletAndAttachToPerson(person);

/*
        Wallet wallet = walletService.createEmptyWallet();
        walletRepository.save(wallet);
        person.setWallet(wallet);
*/

        return person.getId();
    }
}



