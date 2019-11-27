package io.pivotal.pal.tracker;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/time-entries")
public class TimeEntryController {
    private TimeEntryRepository timeEntryRepository;

    public TimeEntryController(TimeEntryRepository timeEntryRepository) {
        this.timeEntryRepository = timeEntryRepository;
    }

    @PostMapping
    public ResponseEntity create(@RequestBody TimeEntry timeEntryToCreate) {
        return new ResponseEntity(timeEntryRepository.create(timeEntryToCreate), HttpStatus.CREATED);

    }

    @GetMapping("{id}")
    public ResponseEntity<TimeEntry> read(@PathVariable long id) {
        TimeEntry entry = timeEntryRepository.find(id);
        if (entry == null)
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        return new ResponseEntity(entry, HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity<List<TimeEntry>> list() {
        return new ResponseEntity<>(timeEntryRepository.list(), HttpStatus.OK);
    }

    @PutMapping("{timeEntryId}")
    public ResponseEntity update(@PathVariable long timeEntryId, @RequestBody TimeEntry expected) {
        TimeEntry entryToBeUpdated = timeEntryRepository.update(timeEntryId, expected);
        if (entryToBeUpdated == null)
            return new ResponseEntity(entryToBeUpdated, HttpStatus.NOT_FOUND);

        return new ResponseEntity(entryToBeUpdated, HttpStatus.OK);

    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable long id) {
        return new ResponseEntity(timeEntryRepository.delete(id), HttpStatus.NO_CONTENT);
    }

}
