package com.github.parisoft.magic.engine.core.effect.oneshot;

import java.util.List;

import com.github.parisoft.magic.engine.core.effect.Effect;
import com.github.parisoft.magic.engine.core.event.Event;

public class OneShotEffect<E extends Event> extends Effect {

    protected List<E> events;
}
