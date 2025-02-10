package workshop.gsd.sequencers;

import java.util.concurrent.atomic.AtomicInteger;

public class TodoItemTaskIdSequencer implements Sequencer {
    private static final AtomicInteger nextId = new AtomicInteger(10);
    private static TodoItemTaskIdSequencer instance;

    @Override
    public int nextId() {
        return nextId.getAndIncrement();
    }
}
