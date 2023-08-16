package com.sample.examplestatemachine.scenario.no_order.states;

import com.sample.examplestatemachine.generic.Context;
import com.sample.examplestatemachine.generic.State;

/**
 * @author Saransh Kumar
 */

public class CheckRiderUndertakingAndDepositStatusState extends State {


    public CheckRiderUndertakingAndDepositStatusState() {
        super(CheckRiderUndertakingAndDepositStatusState.class.getSimpleName());
        this.setFinal(true);
        this.setRequireUserInput(false);
    }

    @Override
    public void action(Context context) {

    }

    @Override
    public State transition(Context context) {
        return null;
    }

    @Override
    public boolean guard(Context context) {
        return false;
    }
}
