
package com.system.rbs;

import com.system.rbs.examples.FormulaNameRuleBase;

/**
 * @author wherrera
 */
public class RuleBasedSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        System.out.print("Rule based System");
        

        //
        // Chemical Formula Example
        //        
        {
            //initialize
            WorkingMemory memory        = new WorkingMemory();
            InferenceEngine engine      = new InferenceEngine(memory, FormulaNameRuleBase.create() );

            //set the formula
            memory.Set("formula", "NaOH");

            //run inference engine
            engine.run();
        }
        
        
        
    }    
}