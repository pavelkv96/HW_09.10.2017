package com.github.pavelkv96.hw_09102017.http;

import java.io.InputStream;

/**
 * Created by Pavel on 09.10.2017.
 */

public interface IHttpClient {
    InputStream request(String url);
}
