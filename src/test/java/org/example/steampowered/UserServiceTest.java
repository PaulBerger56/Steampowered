package org.example.steampowered;

import org.example.steampowered.pojo.User;
import org.example.steampowered.repository.UserRepository;
import org.example.steampowered.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void getUserFromRepoTest() {
        when(userRepository.getUser()).thenReturn(new User("test", "test", "test"));

        User user = userService.getUser();

        System.out.println(user);
        Assert.assertEquals("test", user.getSteamUserName());
        Assert.assertEquals("test", user.getSteamID());
        Assert.assertEquals("test", user.getProfileImage());
        System.out.println();
    }

    @Test
    public void nullUserFromRepoTest() {
        when(userRepository.getUser()).thenReturn(new User("test", "test", "test"));
        User user = userService.getUser();
        userService.nullUser();

        System.out.println(user);
        Assert.assertEquals("", user.getSteamUserName());
        Assert.assertEquals("", user.getSteamID());
        Assert.assertEquals("", user.getProfileImage());
    }
    
}
