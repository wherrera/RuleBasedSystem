
package com.system.rbs;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author wherrera
 */
public class RuleBase {
    public final ArrayList rules = new ArrayList();
    
    public RuleBase () { }
    
    public boolean IsEmpty () {
        return rules.isEmpty();
    }
    
    public void Add (Rule rule) {
        rules.add(rule);
    }
    
    public void Remove (Rule rule) {
        if(rules.contains(rule)) rules.remove(rule);
    }
    
    public int Count () {
        return rules.size();
    }
    
    public Rule[] toArray()
    {
        return (Rule[]) rules.toArray(new Rule[Count()]);
    }
}
