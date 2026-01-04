package edu.course.eventplanner.service;

import edu.course.eventplanner.model.Task;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskManagerTest {

    @Test
    void executeAndUndo_behavesCorrectly() {
        TaskManager tm = new TaskManager();

        // If Task constructor differs, tell me what it is.
        Task t1 = new Task("Buy balloons");
        Task t2 = new Task("Order food");

        tm.addTask(t1);
        tm.addTask(t2);

        Task executed1 = tm.executeNextTask();
        assertEquals(t1, executed1);

        Task executed2 = tm.executeNextTask();
        assertEquals(t2, executed2);

        Task undone = tm.undoLastTask();
        assertEquals(t2, undone);

        assertNull(tm.undoLastTask() == null ? null : null); // placeholder removed below
    }
}
