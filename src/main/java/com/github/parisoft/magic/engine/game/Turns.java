package com.github.parisoft.magic.engine.game;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

import com.github.parisoft.magic.engine.game.phase.Phase;
import com.github.parisoft.magic.engine.game.step.Step;

public class Turns {

    public static <S extends Step> Deque<S> newSteps(Class<S> stepClass) {
        try {
            return new ArrayDeque<>(Arrays.asList(stepClass.newInstance()));
        } catch (InstantiationException | IllegalAccessException e) {
            return new ArrayDeque<>();
        }
    }
    
    public static <P extends Phase> Deque<P> newPhases(Class<P> phaseClass) {
        try {
            return new ArrayDeque<>(Arrays.asList(phaseClass.newInstance()));
        } catch (InstantiationException | IllegalAccessException e) {
            return new ArrayDeque<>();
        }
    }
}
