package com.sample.examplestatemachine.scenario.no_order.states;

import com.sample.examplestatemachine.generic.Context;
import com.sample.examplestatemachine.generic.State;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Saransh Kumar
 */

@Slf4j
public class CheckReasonForIdBlockState extends State {


    public CheckReasonForIdBlockState() {
        super(CheckReasonForIdBlockState.class.getSimpleName());
        this.setFinal(true);
        this.setRequireUserInput(false);
    }

    @Override
    public void action(Context context) {
        log.info("State change to CheckReasonForIdBlock State");
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
        if (context.contains("idBlock") && Boolean.TRUE.equals(context.get("idBlock"))) {
            return true;
        } else {
            context.put("error", "Required id to be blocked");
            return false;
        }
    }
}
