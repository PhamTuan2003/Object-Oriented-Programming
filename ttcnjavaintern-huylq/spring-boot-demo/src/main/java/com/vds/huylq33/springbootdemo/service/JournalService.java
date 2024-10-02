package com.vds.huylq33.springbootdemo.service;

import com.vds.huylq33.springbootdemo.model.Journal;
import java.util.List;

public interface JournalService {

    List<Journal> getAll();

    List<Journal> get(String title);

    void add(Journal journal);

    void update(Long id, Journal updateJournal);

    void delete(Long id);
}
