package com.rakesh.home.test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CustomSSOTempCacheManager {
	 private static CustomSSOTempCacheManager instance;
	    private Map<String, Object> cache = Collections.synchronizedMap(new HashMap<String, Object>());

	    private CustomSSOTempCacheManager() {
	    }

	    public void put(String cacheKey, Object value) {
	        cache.put(cacheKey, value);
	    }

	    public Object get(String cacheKey) {
	        return cache.get(cacheKey);
	    }

	    public void clear(String cacheKey) {
	        cache.put(cacheKey, null);
	    }

	    public void clear() {
	        cache.clear();
	    }

	    public static CustomSSOTempCacheManager getInstance() {
	    	
	                if (instance == null) {
	                    instance = new CustomSSOTempCacheManager();
	                }
	            
	        
	        return instance;
	    }

}
