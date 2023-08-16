package com.sample.examplestatemachine.scenario.no_order.states;

import com.sample.examplestatemachine.generic.Context;
import com.sample.examplestatemachine.generic.State;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Saransh Kumar
 */

@Slf4j
public class CheckRiderZoneState extends State {

    public CheckRiderZoneState() {
        super(CheckRiderZoneState.class.getSimpleName());
        this.setFinal(true);
        this.setRequireUserInput(false);
    }

    @Override
    public void action(Context context) {
        log.info("State change to CheckRiderZone State");
        log.info("Context: {}", context);
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
        if (context.contains("idActive") && Boolean.TRUE.equals(context.get("idActive"))) {
            return true;
        } else {
            context.put("error", "Required id to be active");
            return false;
        }
    }
}
