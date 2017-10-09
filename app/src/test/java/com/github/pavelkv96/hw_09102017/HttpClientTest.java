package com.github.pavelkv96.hw_09102017;

import com.github.pavelkv96.hw_09102017.http.HttpClient;
import com.github.pavelkv96.hw_09102017.http.IHttpClient;
import com.github.pavelkv96.hw_09102017.mocks.Mocks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;

import java.io.InputStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Pavel on 09.10.2017.
 */
public class HttpClientTest {

    private IHttpClient mHttpClient;

    @Before
    public void setUp() throws Exception {
        mHttpClient = mock(HttpClient.class);
    }

    @Test
    public void parser() throws Exception
    {
        InputStream mockedInputStream = Mocks.stream("user/user_list.json");
        when(mHttpClient.request(Matchers.anyString())).thenReturn(mockedInputStream);
    }

}