package com.vds.huylq33.springbootdemo.controller;

import com.vds.huylq33.springbootdemo.model.Journal;
import com.vds.huylq33.springbootdemo.service.JournalService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/journals")
public class JournalController {

    private JournalService journalService;

    @Autowired
    public void setJournalService(JournalService journalService) {
        this.journalService = journalService;
    }

    @GetMapping
    public List<Journal> allJournals() {
        return journalService.getAll();
    }

    @GetMapping("/{title}")
    public List<Journal> findByTitle(@PathVariable String title) {
        return journalService.get(title);
    }

    @PostMapping
    public ResponseEntity<Journal> addJournal(@RequestBody Journal journal) {
        journalService.add(journal);
        return new ResponseEntity<>(journal, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Journal> updateJournal(@PathVariable Long id,
        @RequestBody Journal updateJournal) {
        journalService.update(id, updateJournal);
        return new ResponseEntity<>(updateJournal, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Journal> removeJournal(@PathVariable Long id) {
        journalService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
