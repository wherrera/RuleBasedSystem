
package com.system.rbs;

import java.util.ArrayList;

/**
 * @author wherrera
 */
public class Rule
{    
    private final Condition[] conditions;
    private final ArrayList actions;
    
    public Rule(Condition[] conditions, Action[] actions) {
        this.conditions = conditions;        
        this.actions = new ArrayList();        
        for(int i=0; i < actions.length; i++) {
            this.actions.add( actions[i] );
        }
    }
    
    public ArrayList actions () {
        return actions;
    }
    
    public boolean match (WorkingMemory workingMemory) {
        for( int i=0; i < conditions.length; i++ ) {
            if(!conditions[i].satisfies(workingMemory))
                return false;
        }
        return true;
    }
}
