package de.blogspot.mszalbach.iss.domain;

import org.squirrelframework.foundation.fsm.annotation.StateMachineParameters;
import org.squirrelframework.foundation.fsm.annotation.Transit;
import org.squirrelframework.foundation.fsm.annotation.Transitions;
import org.squirrelframework.foundation.fsm.impl.AbstractUntypedStateMachine;

/**
 * Created by ms on 24.11.16.
 */
//Can not use Enums because they have different hashCode in StateMachieneContext and current loaded Enum
@StateMachineParameters( stateType = String.class, eventType = String.class, contextType = Integer.class )
@Transitions( {
        @Transit( from = "Open", to = "Requested", on = "request" ),
        @Transit( from = "Requested", to = "Accepted", on = "accept" ),
        @Transit( from = "Requested", to = "Open", on = "cancel" )
} )
public class SecurityStateConfig
        extends AbstractUntypedStateMachine {

}

