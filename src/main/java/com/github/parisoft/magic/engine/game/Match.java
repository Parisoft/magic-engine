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
    
    public static Game currentGame() {
        return instance.get().currentGame;
    }
    
    public boolean isNotEnded() {
        return true;
    }
    
    public Game nextGame() {
        return new Game();
    }
    
}
