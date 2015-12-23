package com.github.parisoft.magic.engine.effect.oneshot;

import java.util.List;

import com.github.parisoft.magic.engine.effect.Effect;
import com.github.parisoft.magic.engine.event.Event;

public class OneShotEffect<E extends Event> extends Effect {

    protected List<E> events;
}
