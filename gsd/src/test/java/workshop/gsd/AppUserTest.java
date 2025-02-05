package workshop.gsd;

import org.junit.jupiter.api.Test;

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
        assertEquals("AppUser - Details:\n{\n" +
                "  \"username\": \"test\",\n" +
                "  \"role\": \"ROLE_APP_USER\"\n" +
                "}", appUser.toString());
    }

    @Test
    void testHashCode() {
        AppUser appUser = new AppUser("test", "test", AppRole.ROLE_APP_USER);
        assertEquals(appUser.getUsername().hashCode() + appUser.getRole().hashCode(), appUser.hashCode());
        assertNotEquals(appUser.getUsername().hashCode() + appUser.getRole().hashCode() + 1, appUser.hashCode());
    }

    @Test
    void testEquals() {
        AppUser appUser = new AppUser("test", "test", AppRole.ROLE_APP_USER);
        AppUser appUser2 = new AppUser("test", "test", AppRole.ROLE_APP_USER);
        assertEquals(appUser, appUser2);
        assertNotEquals(null, appUser);
        assertNotEquals(new Object(), appUser);
        assertNotEquals(new AppUser("test2", "test", AppRole.ROLE_APP_USER), appUser);
        assertNotEquals(new AppUser("test", "test2", AppRole.ROLE_APP_USER), appUser);
        assertNotEquals(new AppUser("test", "test", AppRole.ROLE_APP_ADMIN), appUser);
        assertEquals(appUser, appUser);
        assertEquals(appUser.hashCode(), appUser2.hashCode());
        appUser2.setRole(AppRole.ROLE_APP_ADMIN);
        assertNotEquals(appUser, appUser2);
        assertNotEquals(appUser.hashCode(), appUser2.hashCode());
        appUser2.setUsername("test2");
        assertNotEquals(appUser, appUser2);
        assertNotEquals(appUser.hashCode(), appUser2.hashCode());
        appUser2.setPassword("<PASSWORD>");
        assertNotEquals(appUser, appUser2);
    }
}
