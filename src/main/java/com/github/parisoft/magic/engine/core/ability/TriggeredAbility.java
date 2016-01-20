package com.github.parisoft.magic.engine.core.ability;

import java.util.List;

import com.github.parisoft.magic.engine.core.effect.continuous.ContinuousEffect;
import com.github.parisoft.magic.engine.core.effect.oneshot.OneShotEffect;

public class TriggeredAbility extends Ability {
    
    protected List<OneShotEffect<?>> oneShotEffects;
    protected List<ContinuousEffect> continuousEffects;
    //TODO TriggerCondition
}
