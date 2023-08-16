package com.sample.examplestatemachine.scenario.no_order.states;

import com.sample.examplestatemachine.generic.Context;
import com.sample.examplestatemachine.generic.State;
import lombok.extern.slf4j.Slf4j;

import static com.sample.examplestatemachine.scenario.no_order.events.NoOrderEvents.ID_BLOCK;

/**
 * @author Saransh Kumar
 */

@Slf4j
public final class CheckRiderIDState extends State {

    public CheckRiderIDState() {
        super(CheckRiderIDState.class.getSimpleName());
        this.setFinal(false);
        this.setRequireUserInput(false);
    }

    @Override
    public void action(Context context) {
        log.info("State change to CheckRiderID State");
        context.put("idBlock", Boolean.TRUE);
        context.put("nextEvent", ID_BLOCK.name());
    }

    @Override
    public State transition(Context context) {
        if (this.guard(context)) {
            return this;
        }
        return null;
    }

    @Override
    public boolean guard(Context context) {
        if (context.contains("userId")) {
            return true;
        } else {
            context.put("error", "User ID required");
            return false;
        }
    }
}
