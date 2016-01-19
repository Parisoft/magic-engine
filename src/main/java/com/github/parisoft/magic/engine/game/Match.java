package com.github.parisoft.magic.engine.game;

public class Match implements Runnable {

    static final ThreadLocal<Match> instance = new ThreadLocal<Match>(){
        protected Match initialValue() {
            return new Match();
        }
    };
    
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
    
    public static Match getInstance() {
        return instance.get();
    }
}
