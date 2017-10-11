package com.github.pavelkv96.hw_09102017.json;

import java.io.InputStream;

/**
 * Created by Pavel on 10.10.2017.
 */

public class UserParserFactory {
    public IAllParser createParser(InputStream pSource) {
        return new UserJSONObjectParser(pSource);
    }

    public IAllListParser createParserJsonListInObject(InputStream pSource) {
        return new UsersJsonListInObjectParser(pSource);
    }

    public IAllListParser createParserJsonList(final InputStream pSource){
        return new UserJSONListParser(pSource);
    }
}
