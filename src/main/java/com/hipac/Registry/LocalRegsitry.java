package com.hipac.Registry;

import com.hipac.Framework.URL;

import java.util.HashMap;
import java.util.List;

public interface LocalRegsitry {

    void cache(String interfaceName, List<URL> url);

    List<URL> getURL(String interfaceName);
}
