package org.eclipse.moquette.spi.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.moquette.spi.impl.subscriptions.*;

/**
 * Utility static methods, like Map get with default value, or elvis operator.
 */
public class Utils {
    public static <T, K> T defaultGet(Map<K, T> map, K key, T defaultValue) {
        T value = map.get(key);
        if (value != null) {
            return value;
        }
        return defaultValue;
    }
    
    
//    public static ArrayList<String> compareSubscriptions(List<Subscription> arg0, List<Subscription> arg1, String clientID) {
//    	ArrayList<String> ret = new ArrayList<>();
//    	
//    	ArrayList<Subscription> toRemove = new ArrayList<>();
//    	
//    	for (Subscription s : arg0) {
//    		if (!s.getClientId().equals(clientID)) {
//    			toRemove.add(s);
//    		}
//    	}
//    	for (Subscription s : toRemove) {
//    		arg0.remove(s);
//    	}
//    	toRemove.clear();
//    	
//    	for (Subscription s : arg1) {
//    		if (!s.getClientId().equals(clientID)) {
//    			toRemove.add(s);
//    		}
//    	}
//    	for (Subscription s : toRemove) {
//    		arg1.remove(s);
//    	}
//    	
//    	for (Subscription s0 : arg0) {
//    		ret.add(s0.getTopicFilter());
//    	}
//    	
//    	for (Subscription s0 : arg0) {
//    		for (Subscription s1 : arg1) {
//    			if (s1.getTopicFilter().equals(s0.getTopicFilter())) {
//    				ret.remove(s0.getTopicFilter());
//    			}
//    		}
//    	}
//    	return ret;
//    }
    
    public static Set<String> compareSubscriptions(Set<Subscription> arg0, Set<Subscription> arg1) {
    	Set<String> ret = new HashSet<>();
    	
    	for (Subscription s0 : arg0) {
    		ret.add(s0.getTopicFilter());
    	}
    	
		for (Subscription s1 : arg1) {
			if (ret.contains(s1.getTopicFilter())) {
				ret.remove(s1.getTopicFilter());
    		}
    	}
    	return ret;
    }
}
