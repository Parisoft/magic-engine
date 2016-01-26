package com.github.parisoft.magic.engine.core.event;

import static com.github.parisoft.magic.engine.game.Games.currentTurn;

import com.github.parisoft.magic.engine.core.entity.Card;

public class DeclareBlockerEvent extends Event {

    private final Card blocker;
    private final Card blocked;

    public DeclareBlockerEvent(Card blocker, Card blocked) {
        this.blocker = blocker;
        this.blocked = blocked;
    }

    @Override
    public void perform() {
        blocked.getBlockedBy().put(blocker, 0);
        blocker.getAttackedBy().put(blocked, 0);
        currentTurn().getBlockers().add(blocker);
    }

    public Card getBlocker() {
        return blocker;
    }

    public Card getBlocked() {
        return blocked;
    }
    
}
