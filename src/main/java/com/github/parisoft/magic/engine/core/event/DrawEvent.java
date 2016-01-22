package com.github.parisoft.magic.engine.core.event;

import static com.github.parisoft.magic.engine.game.Games.currentGame;

import com.github.parisoft.magic.engine.core.entity.Player;

public class DrawEvent extends Event {

    private Player player;
    private int qty;

    public DrawEvent(Player player, int qty) {
        this.player = player;
        this.qty = qty;
    }

    @Override
    public void perform() {
        for (int i = 0; i < qty; i++) {
            currentGame().perform(new ZoneChangeEvent(player.getLibrary().peek(), player.getLibrary(), player.getHand()));
        }
    }

}
