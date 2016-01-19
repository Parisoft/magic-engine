package com.github.parisoft.magic.engine.game.step;

import static com.github.parisoft.magic.engine.game.Games.activePlayer;
import static com.github.parisoft.magic.engine.game.Games.currentGame;
import static org.apache.commons.collections4.CollectionUtils.isNotEmpty;

import com.github.parisoft.magic.engine.ability.statik.Phasing;
import com.github.parisoft.magic.engine.entity.Card;
import com.github.parisoft.magic.engine.event.PhaseInEvent;
import com.github.parisoft.magic.engine.event.PhaseOutEvent;
import com.github.parisoft.magic.engine.event.UntapEvent;

public class UntapStep extends Step {

    public UntapStep() {
        super(StepName.UNTAP);
    }

    @Override
    protected void runStep() {
        phasePermanents();
        untapPermanents();
    }

    private void phasePermanents() {
        for (Card card : activePlayer().getPermanents()) {
            if (isNotEmpty(card.getAbilities(Phasing.class))) {
                if (card.isPhased()) {
                    currentGame().perform(new PhaseInEvent(card));
                } else {
                    currentGame().perform(new PhaseOutEvent(card));
                }
            }
        }
    }

    private void untapPermanents() {
        for (Card card : activePlayer().getPermanents()) {
            if (card.isTapped()) {
                currentGame().perform(new UntapEvent(card));
            }
        }
    }

}
