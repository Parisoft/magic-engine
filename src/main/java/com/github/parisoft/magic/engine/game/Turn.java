package com.github.parisoft.magic.engine.game;

import static com.github.parisoft.magic.engine.game.Turns.newPhases;
import static org.apache.commons.collections4.CollectionUtils.isNotEmpty;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;

import com.github.parisoft.magic.engine.core.entity.Card;
import com.github.parisoft.magic.engine.core.entity.Timestamped;
import com.github.parisoft.magic.engine.game.phase.BeginningPhase;
import com.github.parisoft.magic.engine.game.phase.CombatPhase;
import com.github.parisoft.magic.engine.game.phase.MainPhase;
import com.github.parisoft.magic.engine.game.phase.Phase;

public class Turn extends Timestamped implements Runnable {

    private final Deque<BeginningPhase> beginningPhases = newPhases(BeginningPhase.class);
    private final Deque<MainPhase> preCombatMainPhases = newPhases(MainPhase.class);
    private final Deque<MainPhase> postCombatMainPhases = newPhases(MainPhase.class);
    private final Deque<CombatPhase> combatPhases = newPhases(CombatPhase.class);
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
