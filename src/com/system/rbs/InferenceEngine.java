
package com.system.rbs;

import java.util.ArrayList;

/**
 * @author wherrera
 */
public class InferenceEngine implements Runnable {
    
    private final WorkingMemory workingMemory;
    private final RuleBase ruleBase;
    
    public InferenceEngine (WorkingMemory workingMemory, RuleBase ruleBase) {
        this.workingMemory = workingMemory;
        this.ruleBase = ruleBase;
    }
    
    public void run () {        
        while(!ruleBase.IsEmpty())
        {
            ArrayList actions = new ArrayList ();
            Rule[] rules = ruleBase.toArray();
            for (int i=0; i < rules.length; i++) {
                if(rules[i].match(workingMemory)) {
                    ruleBase.Remove(rules[i]);
                    actions.addAll( rules[i].actions() );
                }
            }
            if(actions.isEmpty()) {
                break;
            }
            for (int i=0; i < actions.size(); i++) {
                Action action = (Action) actions.get(i);
                action.run(workingMemory, ruleBase);
            }
        }
    }
}
