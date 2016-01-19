package com.github.parisoft.magic.engine.game;

import static com.google.common.collect.Lists.newArrayList;
import static org.apache.commons.collections4.CollectionUtils.isNotEmpty;

import java.util.List;

import com.github.parisoft.magic.engine.game.phase.BeginningPhase;
import com.github.parisoft.magic.engine.game.phase.Phase;

public class Turn implements Runnable {

    private final List<BeginningPhase> beginningPhases = newArrayList(new BeginningPhase());
    private Phase currentPhase;
    
    @Override
    public void run() {
        run(beginningPhases);
    }
    
    public Phase currentPhase() {
        return currentPhase;
    }

    private void run(List<? extends Phase> phases) {
        while (isNotEmpty(phases)) {
            currentPhase = phases.remove(0);
            currentPhase.run();
        }
    }
}
