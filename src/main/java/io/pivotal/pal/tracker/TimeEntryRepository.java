package io.pivotal.pal.tracker;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.sql.Time;
import java.util.HashMap;
import java.util.List;

@Component
public interface TimeEntryRepository {
    TimeEntry create(TimeEntry any);

    TimeEntry find(long timeEntryId);

    List<TimeEntry> list();

    TimeEntry update(long eq, TimeEntry any);

    TimeEntry delete(long timeEntryId);

}
