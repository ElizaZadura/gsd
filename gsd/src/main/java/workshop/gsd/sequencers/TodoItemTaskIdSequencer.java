package workshop.gsd.sequencers;

import java.util.concurrent.atomic.AtomicInteger;

public class TodoItemTaskIdSequencer implements Sequencer {
    private static final AtomicInteger nextId = new AtomicInteger(100);
    private static TodoItemTaskIdSequencer instance;

    public static TodoItemTaskIdSequencer getInstance() {
        if (instance == null) {
            instance = new TodoItemTaskIdSequencer();
        }
        return instance;
    }

    @Override
    public int nextId() {
        return nextId.getAndIncrement();
    }

    @Override
    public int getCurrentId() {
        return nextId.get();
    }

}
