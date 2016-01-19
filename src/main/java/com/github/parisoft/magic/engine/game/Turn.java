package com.github.parisoft.magic.engine.game;

import static org.apache.commons.collections4.CollectionUtils.isNotEmpty;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

import com.github.parisoft.magic.engine.game.phase.BeginningPhase;
import com.github.parisoft.magic.engine.game.phase.MainPhase;
import com.github.parisoft.magic.engine.game.phase.Phase;

public class Turn implements Runnable {

    private final Deque<Phase> beginningPhases = new ArrayDeque<>(Arrays.asList(new BeginningPhase()));
    private final Deque<Phase> preCombatMainPhases = new ArrayDeque<>(Arrays.asList(new MainPhase()));
    private final Deque<Phase> postCombatMainPhases = new ArrayDeque<>(Arrays.asList(new MainPhase()));
    
    private Phase currentPhase;
    
    @Override
    public void run() {
        run(beginningPhases);
        run(preCombatMainPhases);
        
        run(postCombatMainPhases);
    }
    
    public Phase getCurrentPhase() {
        return currentPhase;
    }

    private void run(Deque<? extends Phase> phases) {
        while (isNotEmpty(phases)) {
            currentPhase = phases.pop();
            currentPhase.run();
        }
    }
}
