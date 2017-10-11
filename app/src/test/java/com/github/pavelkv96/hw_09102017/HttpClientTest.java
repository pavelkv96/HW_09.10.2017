package com.github.pavelkv96.hw_09102017;

import com.github.pavelkv96.hw_09102017.http.HttpClient;
import com.github.pavelkv96.hw_09102017.http.IHttpClient;
import com.github.pavelkv96.hw_09102017.json.IAll;
import com.github.pavelkv96.hw_09102017.json.IAllParser;
import com.github.pavelkv96.hw_09102017.json.IFriends;
import com.github.pavelkv96.hw_09102017.json.UserParserFactory;
import com.github.pavelkv96.hw_09102017.mocks.Mocks;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

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
        final IAll userAllParser = userParserFactory.createParser(response).parse();

        assertEquals(userAllParser.getEmail(),"sheliachang@soprano.com");
        assertEquals(userAllParser.getAddress(),"309 Ryder Street, Davenport, Maryland, 9562");
        assertEquals(userAllParser.getFriends().get(0).getNameFriends(1),"Powers Terrell");

        //assertEquals("Shelia Chang",userAllParser.getName());
        //throw new IllegalStateException(userAllParser.getGreeting());
        //assertEquals(userAllParser.getId(),"59dbe02684a66bbe143b20d1");
        //assertTrue(userList.getUsersList().get(0).getId() == 1);
        //assertEquals(userList.getUsersList().get(0).getName(), "First Name and Last Name");


        //InputStream mockedInputStreamWithObject = Mocks.stream("user/user_list_with_root_object.json");
        //when(mHttpClient.request(Matchers.anyString())).thenReturn(mockedInputStreamWithObject);
        //InputStream responseWithObject = mHttpClient.request("http://myBackend/getUserListWithObject");

        //final IUsersList userListWithObject = usersListParserFactory.createParserForResponceWithObject(responseWithObject).parse();
        //assertTrue(userListWithObject.getUsersList().size() == 2);
    }

}