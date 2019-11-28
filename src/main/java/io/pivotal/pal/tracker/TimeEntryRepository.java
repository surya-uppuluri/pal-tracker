package io.pivotal.pal.tracker;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TimeEntryRepository {
    TimeEntry create(TimeEntry any);

    TimeEntry find(long id);

    List<TimeEntry> list();

    TimeEntry update(long eq, TimeEntry any);

    void delete(long id);

}
