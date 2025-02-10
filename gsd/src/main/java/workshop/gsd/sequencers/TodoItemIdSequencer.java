package workshop.gsd.sequencers;

import java.util.concurrent.atomic.AtomicInteger;

public class TodoItemIdSequencer implements Sequencer {
    private static final AtomicInteger nextId = new AtomicInteger(100);
    private static TodoItemIdSequencer instance;

    public static TodoItemIdSequencer getInstance() {
        if (instance == null) {
            instance = new TodoItemIdSequencer();
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
