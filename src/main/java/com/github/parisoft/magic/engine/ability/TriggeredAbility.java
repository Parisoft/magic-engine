package com.github.parisoft.magic.engine.ability;

import java.util.List;

import com.github.parisoft.magic.engine.effect.continuous.ContinuousEffect;
import com.github.parisoft.magic.engine.effect.oneshot.OneShotEffect;

public class TriggeredAbility extends Ability {
    
    protected List<OneShotEffect<?>> oneShotEffects;
    protected List<ContinuousEffect> continuousEffects;
    //TODO TriggerCondition
}
