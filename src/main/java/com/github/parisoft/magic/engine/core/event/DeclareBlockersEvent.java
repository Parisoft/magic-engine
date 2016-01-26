package com.github.parisoft.magic.engine.core.event;

import static com.github.parisoft.magic.engine.game.Games.currentGame;
import static org.apache.commons.collections4.CollectionUtils.emptyIfNull;

import java.util.ArrayList;
import java.util.List;

import com.github.parisoft.magic.engine.core.entity.Card;
import com.github.parisoft.magic.engine.core.entity.Entity;
import com.github.parisoft.magic.engine.game.question.combat.Block;
import com.github.parisoft.magic.engine.game.question.combat.DeclareBlockersQuestion;

public class DeclareBlockersEvent extends Event {

    private final List<Block> blockList = new ArrayList<>();
    
    public DeclareBlockersEvent(List<Block> blockList) {
        this.blockList.addAll(emptyIfNull(blockList));
    }
    
    public DeclareBlockersEvent(DeclareBlockersQuestion question) {
        blockList.addAll(emptyIfNull(question.getAnswer()));
    }
    
    public DeclareBlockersEvent(Entity blocker, Entity blocked) {
        blockList.add(new Block(blocker, blocked));
    }
    
    @Override
    public void perform() {
        for (Block block : blockList) {
            Card blocker = (Card) block.getBlocker();
            Card blocked = (Card) block.getBlocked();
            
            currentGame().perform(new DeclareBlockerEvent(blocker, blocked));
        }
    }

    public List<Block> getBlockList() {
        return blockList;
    }
}
