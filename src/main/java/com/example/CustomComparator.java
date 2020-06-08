package com.example;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CustomComparator {

    public static void main(String[] args) {
        List<Task> tasks  = new ArrayList<>();
        tasks.add(new Task(State.ACTIVE));
        tasks.add(new Task(State.SUSPENDED));
        tasks.add(new Task(State.CANCELED));
        tasks.add(new Task(State.COMPLETED));
        tasks.add(new Task(State.UNDER_APPROVAL));
        tasks.add(new Task(State.CLAIMED));

        final List<Task> sorted = tasks.stream()
                                        .sorted((t1, t2) -> compare(t1, t2))
                                        .collect(Collectors.toList());

        System.out.println(sorted);
    }

    public static int compare(Task t1, Task t2) {
        if(t2.getState().equals(State.CANCELED)) {
            return -1;
        } if(t1.getState().equals(State.CANCELED)) {
            return 1;
        } else {
            return t1.getState().name().compareTo(t2.getState().name());
        }
    }
}

enum State {
    ACTIVE,
    SUSPENDED,
    COMPLETED,
    CANCELED,
    CLAIMED,
    UNDER_APPROVAL
}

class Task {
    public State state;

    public Task(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Task.class.getSimpleName() + "[", "]")
                .add("state=" + state)
                .toString();
    }
}


