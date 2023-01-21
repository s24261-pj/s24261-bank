package com.example.s24261bank.service;

import com.example.s24261bank.model.User;
import com.example.s24261bank.storage.UserStorage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceMockTest {
    @Mock
    private UserStorage userStorage;

    @InjectMocks
    private UserService userService;

    @Test
    void shouldReturnUserList() {
        when(userStorage.getUserList()).thenReturn(List.of(
            new User("10", "Martyna", 500)
        ));

        assertThat(userService.getUserList()).isNotEmpty();
    }

    @Test
    void getUserByUuid() {
        User user = new User("11", "Marek", 1500);
        when(userStorage.getUserByUuid(any())).thenReturn(user);

        userService.getUserByUuid(user.getUuid());

        assertThat(user).isNotNull();
    }

    @Test
    void shouldRegisterUser() {
        when(userStorage.getUserList()).thenReturn(List.of(
            new User("10", "Martyna", 500)
        ));

        userService.registerUser("Marek", 1500);

        assertThat(userService.getUserList().size()).isEqualTo(userStorage.getUserList().size());
    }
}