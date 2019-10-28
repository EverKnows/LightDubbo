package com.hipac.Registry.Impl;

import com.google.common.collect.Lists;
import com.hipac.Framework.URL;
import com.hipac.Registry.LocalRegsitry;
import java.util.HashMap;
import java.util.List;

public class LocalRegistryImpl implements LocalRegsitry {


    private HashMap<String, List<URL>> map = new HashMap<String, List<URL>>();

    public void cache(String interfaceName, List<URL> url) {
        if (map.get(interfaceName) == null) {

            map.put(interfaceName, url);
        } else {
            map.get(interfaceName).addAll(url);
        }
    }

    public List<URL> getURL(String interfaceName) {
        return map.get(interfaceName);
    }
}
