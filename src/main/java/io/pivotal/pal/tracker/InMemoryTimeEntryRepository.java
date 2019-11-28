package io.pivotal.pal.tracker;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;

@Repository
@Primary
public class InMemoryTimeEntryRepository implements TimeEntryRepository {

    HashMap<Long, TimeEntry> repo = new HashMap();
    long counter = 1L;

    public TimeEntry create(TimeEntry timeEntry) {
        timeEntry.setId(counter);
        repo.put(counter, timeEntry);
        ++counter;
        return timeEntry;
    }

    public TimeEntry find(long id) {
        return repo.get(id);

    }

    public TimeEntry update(long id, TimeEntry timeEntry) {
        timeEntry.setId(id);
        repo.replace(id, timeEntry);
        return repo.get(id);
    }

    @Override
    public void delete(long id) {

        repo.remove(id);


        /*  return find(timeEntryId);*/
    }


    public ArrayList<TimeEntry> list() {
      /*  ArrayList<TimeEntry> entries = new ArrayList<>();
        repo.forEach((k, v) -> entries.add(v));
        return entries;*/
        return new ArrayList<>(repo.values());
    }
}
