package workshop.gsd.sequencers;

import java.util.concurrent.atomic.AtomicInteger;

public class PersonIdSequencer implements Sequencer {
    private static final AtomicInteger nextId = new AtomicInteger(1);
    private static PersonIdSequencer instance;

    private PersonIdSequencer() {
    }

    public static PersonIdSequencer getInstance() {
        if (instance == null) {
            instance = new PersonIdSequencer();
        }
        return instance;
    }

    @Override
    public int nextId() {
        return nextId.getAndIncrement();
    }

    @Override
    public int getCurrentId() {
        return 0;
    }

}
