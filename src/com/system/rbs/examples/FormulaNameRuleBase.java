
package com.system.rbs.examples;

import com.system.rbs.Action;
import com.system.rbs.Condition;
import com.system.rbs.Rule;
import com.system.rbs.RuleBase;
import com.system.rbs.WorkingMemory;

/**
 * @author wherrera
 */
public class FormulaNameRuleBase
{
    public static RuleBase create ()
    {
        RuleBase ruleBase = new RuleBase();
        
        ruleBase.Add( new Rule(new Condition[]{
            new Condition() {
                public boolean satisfies(WorkingMemory workingMemory) {
                    return workingMemory.Contains("formula") && workingMemory.Get("formula").startsWith("Na");
                }
            }
        },
            new Action[] {
                new Action() {
                    public void run(WorkingMemory workingMemory, RuleBase ruleBase) {
                        workingMemory.Set("first_chemical_name", "Sodium");
                    }
                }
            })
        );
        
        ruleBase.Add( new Rule(new Condition[]{
            new Condition() {
                public boolean satisfies(WorkingMemory workingMemory) {
                    return workingMemory.Contains("formula") && workingMemory.Get("formula").endsWith("Cl");
                }
            }
        },
            new Action[] {
                new Action() {
                    public void run(WorkingMemory workingMemory, RuleBase ruleBase) {
                        workingMemory.Set("last_chemical_name", "chloride");
                    }
                }
            })
        );
        
        ruleBase.Add( new Rule(new Condition[]{
            new Condition() {
                public boolean satisfies(WorkingMemory workingMemory) {
                    return workingMemory.Contains("formula") && workingMemory.Get("formula").endsWith("OH");
                }
            }
        },
            new Action[] {
                new Action() {
                    public void run(WorkingMemory workingMemory, RuleBase ruleBase) {
                        workingMemory.Set("last_chemical_name", "hydroxide");
                    }
                }
            })
        );
        
        ruleBase.Add( new Rule(new Condition[]{
            new Condition() {
                public boolean satisfies(WorkingMemory workingMemory) {
                    return workingMemory.Contains("first_chemical_name") && workingMemory.Contains("last_chemical_name");
                }
            }
        },
            new Action[] {
                new Action() {
                    public void run(WorkingMemory workingMemory, RuleBase ruleBase) {
                        System.out.print( "\nChemical Compound: " + workingMemory.Get("first_chemical_name") + " " + workingMemory.Get("last_chemical_name") + "\n");
                    }
                }
            })
        );
                
        ruleBase.Add( new Rule(new Condition[]{
            new Condition() {
                public boolean satisfies(WorkingMemory workingMemory) {
                    return workingMemory.Contains("first_chemical_name") && !workingMemory.Contains("last_chemical_name");
                }
            }
        },
            new Action[] {
                new Action() {
                    public void run(WorkingMemory workingMemory, RuleBase ruleBase) {
                        System.out.print( "\nChemical: " + workingMemory.Get("first_chemical_name") + "\n");
                    }
                }
            })
        );
        
        return ruleBase;
    }
}
