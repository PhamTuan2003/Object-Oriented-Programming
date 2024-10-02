package com.vds.huylq33.springbootdemo.service;

import com.vds.huylq33.springbootdemo.model.Journal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class JournalServiceImpl implements JournalService {

    private static final List<Journal> journals = Arrays.asList(
        new Journal(1L, "Get to know Spring Boot", "Today I will learn Spring Boot"),
        new Journal(2L, "Simple Spring Boot Project", "I will do my first Spring Boot Project"),
        new Journal(3L, "Spring Boot Reading", "Read more about Spring Boot"),
        new Journal(4L, "Spring Boot in the Cloud", "Spring Boot using Cloud Foundry")
    );

    @Override
    public List<Journal> getAll() {
        return journals;
    }

    @Override
    public List<Journal> get(String title) {
        return journals.stream()
            .filter(journal -> journal.getTitle().toLowerCase().contains(title.toLowerCase()))
            .collect(Collectors.toList());
    }

    @Override
    public void add(Journal journal) {
        journals.add(journal);
    }

    @Override
    public void update(Long id, Journal updateJournal) {
        journals.replaceAll(journal -> journal.getId().equals(id) ? updateJournal : journal);
    }

    @Override
    public void delete(Long id) {
        journals.removeIf(journal -> journal.getId().equals(id));
    }
}
