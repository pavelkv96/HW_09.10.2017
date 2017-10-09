package com.github.pavelkv96.hw_09102017.mocks;

import junit.framework.Assert;

import java.io.InputStream;

/**
 * Created by Pavel on 09.10.2017.
 */

public class Mocks {
    public static InputStream stream(final String pName){
        final InputStream resourceAsStream = Mocks.class.getClassLoader().getResourceAsStream(pName);
        Assert.assertNotNull("resource it's null",resourceAsStream);
        return resourceAsStream;
    }
}
