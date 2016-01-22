package com.github.parisoft.magic.engine.game;

import static org.apache.commons.collections4.CollectionUtils.isNotEmpty;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Deque;

import com.github.parisoft.magic.engine.core.entity.Card;
import com.github.parisoft.magic.engine.core.entity.Timestampable;
import com.github.parisoft.magic.engine.game.phase.BeginningPhase;
import com.github.parisoft.magic.engine.game.phase.CombatPhase;
import com.github.parisoft.magic.engine.game.phase.MainPhase;
import com.github.parisoft.magic.engine.game.phase.Phase;

public class Turn extends Timestampable implements Runnable {

    private final Deque<Phase> beginningPhases = new ArrayDeque<>(Arrays.asList(new BeginningPhase()));
    private final Deque<Phase> preCombatMainPhases = new ArrayDeque<>(Arrays.asList(new MainPhase()));
    private final Deque<Phase> postCombatMainPhases = new ArrayDeque<>(Arrays.asList(new MainPhase()));
    private final Deque<Phase> combatPhases = new ArrayDeque<>(Arrays.asList(new CombatPhase()));
    private final Collection<Card> attackers = new ArrayList<>();
    private final Collection<Card> blockers = new ArrayList<>();
    
    private Phase currentPhase;
    
    @Override
    public void run() {
        run(beginningPhases);
        run(preCombatMainPhases);
        run(combatPhases);
        run(postCombatMainPhases);
    }
    
    public Phase getCurrentPhase() {
        return currentPhase;
    }

    public Collection<Card> getAttackers() {
        return attackers;
    }
    
    public Collection<Card> getBlockers() {
        return blockers;
    }
    
    private void run(Deque<? extends Phase> phases) {
        while (isNotEmpty(phases)) {
            currentPhase = phases.pop();
            currentPhase.run();
        }
    }
}
