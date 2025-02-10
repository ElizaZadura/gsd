package workshop.gsd.sequencers;

import java.util.concurrent.atomic.AtomicInteger;

public class TodoItemIdSequencer implements Sequencer {
    private static final AtomicInteger nextId = new AtomicInteger(100);
    private static TodoItemIdSequencer instance;

    @Override
    public int nextId() {
        return nextId.getAndIncrement();
    }
}
