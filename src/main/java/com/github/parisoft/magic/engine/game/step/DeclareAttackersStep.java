package com.github.parisoft.magic.engine.game.step;

import static com.github.parisoft.magic.engine.game.Games.activePlayer;
import static com.github.parisoft.magic.engine.game.Games.currentGame;
import static com.github.parisoft.magic.engine.game.Games.currentTurn;
import static org.apache.commons.collections4.CollectionUtils.isNotEmpty;

import com.github.parisoft.magic.engine.core.ability.statik.AttackIfAble;
import com.github.parisoft.magic.engine.core.entity.Card;
import com.github.parisoft.magic.engine.core.event.DeclareAttackersEvent;
import com.github.parisoft.magic.engine.core.event.TapEvent;

public class DeclareAttackersStep extends Step {

    public DeclareAttackersStep() {
        super(StepName.DECLARE_ATTACKERS);
    }

    @Override
    protected void runStep() {
        declareOptionalAttackers();
        declareMandatoryAttackers();
        tapAttackers();
        currentGame().givePriority();
    }

    private void declareOptionalAttackers() {
        DeclareAttackersEvent event;
        
        do {
            event = new DeclareAttackersEvent(activePlayer().declareAttackers());
            currentGame().perform(event);
        } while (event.isIllegal());
    }

    private void declareMandatoryAttackers() {
        for (Card card : activePlayer().getPermanents()) {
            if (card.isAttacking()) {
                continue;
            }
            
            if (isNotEmpty(card.getAbilities(AttackIfAble.class))) {
                currentGame().perform(new DeclareAttackersEvent(card, activePlayer().getOpponent()));//TODO ask for attacking planeswalker or opponent
            }
        }
    }

    private void tapAttackers() {
        for (Card attacker : currentTurn().getAttackers()) {
            currentGame().perform(new TapEvent(attacker));
        }
    }

}
