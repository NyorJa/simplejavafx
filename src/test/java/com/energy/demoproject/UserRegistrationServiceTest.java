package com.energy.demoproject;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

class UserRegistrationServiceTest {

    private UserRegistrationService userRegistrationService;

    @BeforeEach
    public void setupBefore() {
        userRegistrationService = new UserRegistrationService();
    }

    @AfterEach
    public void teardown() {
        userRegistrationService = null;
    }

    @DisplayName("Load default users, it will be dependent on the file")
    @Test
    void testLoadUsers() {
        // since there is a default data
        List<User> userList = userRegistrationService.loadUsers();
        assertFalse(userList.isEmpty());
    }
}
