

package com.system.rbs;

import java.util.HashMap;

/**
 * @author wherrera
 */
public class WorkingMemory {
    private HashMap hashMap = new HashMap ();
    
    public void Set (String name, String value) {
        if( hashMap.containsKey(name) ) {
            hashMap.remove(name);
        }
        hashMap.put(name, value);
    }
    
    public String Get (String name) {
        if(hashMap.containsKey(name)) {
            return hashMap.get(name).toString();
        }
        return null;
    }
    
    public boolean Contains (String name) {
        return hashMap.containsKey(name);
    }
}
