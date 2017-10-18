package com.github.pavelkv96.hw_09102017;

import com.github.pavelkv96.hw_09102017.http.HttpClient;
import com.github.pavelkv96.hw_09102017.http.IHttpClient;
import com.github.pavelkv96.hw_09102017.json.IAll;
import com.github.pavelkv96.hw_09102017.json.IAllList;
import com.github.pavelkv96.hw_09102017.json.UserParserFactory;
import com.github.pavelkv96.hw_09102017.mocks.Mocks;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.io.InputStream;

import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Pavel on 09.10.2017.
 */

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class HttpClientTest {

    private IHttpClient mHttpClient;
    private static final String EMAIL_TEST_ONE_OBJECT = "sheliachang@soprano.com";
    private static final String ADDRESS_TEST_ONE_OBJECT = "309 Ryder Street, Davenport, Maryland, 9562";
    private static final int SIZE_ARRAY_TEST_TWO_LIST_IN_OBJECT = 5;
    private static final String FRIEND_ID_TEST_TWO_LIST_IN_OBJECT = "59dbe0264a405e530c7f15c3";
    private static final int SIZE_ARRAY_TEST_THREE_LIST = 5;
    private static final String ID_TEST_THREE_LIST = "59dbe026b4637e74179f2121";
    private static final String ADDRESS_TEST_THREE_LIST = "309 Ryder Street, Davenport, Maryland, 9562";

    @Before
    public void setUp() throws Exception {
        mHttpClient = mock(HttpClient.class);
    }

    @Test
    public void parseUserObject() throws Exception {
        InputStream mockedInputStream = Mocks.stream("user.json");
        when(mHttpClient.request(Matchers.anyString())).thenReturn(mockedInputStream);
        InputStream response = mHttpClient.request("http://myBackend/getUserList");

        final UserParserFactory userParserFactory = new UserParserFactory();
        final IAll users = userParserFactory.createParser(response).parse();

        assertEquals(users.getEmail(), EMAIL_TEST_ONE_OBJECT);
        assertEquals(users.getAddress(), ADDRESS_TEST_ONE_OBJECT);
        assertEquals(users.getRegistered(), "09 Oct 2017, 10:52:51");
    }

    @Test
    public void parseUserListInObject() throws Exception {
        final InputStream mockedInputStream = Mocks.stream("generated_root.json");
        when(mHttpClient.request(Matchers.anyString())).thenReturn(mockedInputStream);
        final InputStream response = mHttpClient.request("http://myBackend/getUserList");

        final UserParserFactory userParserFactory = new UserParserFactory();
        final IAllList users = userParserFactory.createParserJsonListInObject(response).parse();

        assertTrue(users.getAllList().size() == SIZE_ARRAY_TEST_TWO_LIST_IN_OBJECT);
        assertTrue(users.getAllList().get(2).getId().equals(FRIEND_ID_TEST_TWO_LIST_IN_OBJECT));
    }

    @Test
    public void parseUserList() throws Exception {
        final InputStream mockedInputStream = Mocks.stream("generated.json");
        when(mHttpClient.request(Matchers.anyString())).thenReturn(mockedInputStream);
        final InputStream response = mHttpClient.request("http://myBackend/getUserList");

        final UserParserFactory userParserFactory = new UserParserFactory();
        final IAllList users = userParserFactory.createParserJsonList(response).parse();

        assertTrue(users.getAllList().size() == SIZE_ARRAY_TEST_THREE_LIST);
        assertTrue(users.getAllList().get(1).getId().equals(ID_TEST_THREE_LIST));
        assertEquals(users.getAllList().get(0).getAddress(), ADDRESS_TEST_THREE_LIST);
        assertEquals(users.getAllList().get(1).getRegistered(), "08 Oct 2017, 07:06:11");
    }

    @Test
    public void parseGsonUserObject() throws Exception {
        InputStream mockedInputStream = Mocks.stream("user.json");
        when(mHttpClient.request(Matchers.anyString())).thenReturn(mockedInputStream);
        InputStream response = mHttpClient.request("http://myBackend/getUserList");

        final UserParserFactory userParserFactory = new UserParserFactory();
        final IAll users = userParserFactory.createGsonUserParser(response).parse();

        assertEquals(users.getEmail(), EMAIL_TEST_ONE_OBJECT);
        assertEquals(users.getAddress(), ADDRESS_TEST_ONE_OBJECT);
        assertEquals(users.getRegistered(), "09 Oct 2017, 10:52:51");
    }

    @Test
    public void parseUserListGson() throws Exception {
        final InputStream mockedInputStream = Mocks.stream("generated.json");
        when(mHttpClient.request(Matchers.anyString())).thenReturn(mockedInputStream);
        final InputStream response = mHttpClient.request("http://myBackend/getUserList");

        final UserParserFactory userParserFactory = new UserParserFactory();
        final IAllList users = userParserFactory.createGsonUserListParser(response).parse();

        assertTrue(users.getAllList().size() == SIZE_ARRAY_TEST_TWO_LIST_IN_OBJECT);
        assertTrue(users.getAllList().get(2).getId().equals(FRIEND_ID_TEST_TWO_LIST_IN_OBJECT));
    }

    @Test
    public void parseUserListInObjectGson() throws Exception {
        final InputStream mockedInputStream = Mocks.stream("generated_root.json");
        when(mHttpClient.request(Matchers.anyString())).thenReturn(mockedInputStream);
        final InputStream response = mHttpClient.request("http://myBackend/getUserList");

        final UserParserFactory userParserFactory = new UserParserFactory();
        final IAllList users = userParserFactory.createUserListWithObjectGsonParser(response).parse();

        assertTrue(users.getAllList().size() == SIZE_ARRAY_TEST_THREE_LIST);
        assertTrue(users.getAllList().get(1).getId().equals(ID_TEST_THREE_LIST));
        assertEquals(users.getAllList().get(0).getAddress(), ADDRESS_TEST_THREE_LIST);
    }
}