package com.github.parisoft.magic.engine.game;

public class Match implements Runnable {

    private Game currentGame;

    @Override
    public void run() {
        while (isNotEnded()) {
            currentGame = nextGame();
            currentGame.run();
        }
    }
    
    public Game getCurrentGame() {
        return currentGame;
    }
    
    public boolean isNotEnded() {
        return true;
    }
    
    public Game nextGame() {
        return currentGame = new Game();
    }

}
