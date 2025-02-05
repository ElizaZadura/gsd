package workshop.gsd;

import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class AppUserTest {

    @Test
    void getUsername() {
        AppUser appUser = new AppUser("test", "test", AppRole.ROLE_APP_USER);
        assertEquals("test", appUser.getUsername());
    }

    @Test
    void getRole() {
        AppUser appUser = new AppUser("test", "test", AppRole.ROLE_APP_USER);
        assertEquals(AppRole.ROLE_APP_USER, appUser.getRole());
    }

    @Test
    void setUsername() {
        AppUser appUser = new AppUser("test", "test", AppRole.ROLE_APP_USER);
        appUser.setUsername("newTest");
        assertEquals("newTest", appUser.getUsername());
    }

    @Test
    void setPassword() {
        AppUser appUser = new AppUser("test", "test", AppRole.ROLE_APP_USER);
        appUser.setPassword("<PASSWORD>");
        assertEquals("<PASSWORD>", appUser.getPassword());
    }

    @Test
    void setRole() {
        AppUser appUser = new AppUser("test", "test", AppRole.ROLE_APP_USER);
        appUser.setRole(AppRole.ROLE_APP_ADMIN);
        assertEquals(AppRole.ROLE_APP_ADMIN, appUser.getRole());
        assertNotEquals(AppRole.ROLE_APP_USER, appUser.getRole());
    }

    @Test
    void testToString() {
        AppUser appUser = new AppUser("test", "test", AppRole.ROLE_APP_USER);
        assertEquals("AppUser{username='test', role=ROLE_APP_USER}", appUser.toString());
    }


    @Test
    void testHashCode() {
        AppUser appUser = new AppUser("test", "test", AppRole.ROLE_APP_USER);

        // Calculate expected hash code using the same method as in the AppUser class
        int expectedHashCode = Objects.hash(appUser.getUsername(), appUser.getRole());

        // Assert that the hashCode method returns the expected value
        assertEquals(expectedHashCode, appUser.hashCode());

        // Assert that the hash code is not equal to an arbitrary value
        assertNotEquals(expectedHashCode + 1, appUser.hashCode());
    }


    @Test
    void testEquals() {
        AppUser appUser = new AppUser("test", "test", AppRole.ROLE_APP_USER);
        AppUser appUser2 = new AppUser("test", "test", AppRole.ROLE_APP_USER);
        assertEquals(appUser, appUser2);
        assertNotEquals(null, appUser);
        assertNotEquals(new Object(), appUser);
        assertNotEquals(new AppUser("test2", "test", AppRole.ROLE_APP_USER), appUser);
    }
}
