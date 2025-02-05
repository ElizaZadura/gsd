package workshop.gsd;

import java.util.Objects;

public class AppUser {
    private String username; // acts as the id of AppUser
    private String password; // contains the password
    private AppRole role; // enumerated type for user role

    /**
     * Constructs an AppUser object.
     *
     * @param username The username of the AppUser. Must not be null or empty.
     * @param password The password of the AppUser. Must not be null or empty.
     * @param role     The role of the AppUser. Must not be null.
     * @throws IllegalArgumentException If username, password, or role is invalid.
     */
    public AppUser(String username, String password, AppRole role) {

        if (username == null || username.isEmpty()) {
            throw new IllegalArgumentException("Username cannot be null or empty.");
        }
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Password cannot be null or empty.");
        }
        if (role == null) {
            throw new IllegalArgumentException("Role cannot be null.");
        }

        this.username = username;
        this.password = password;
        this.role = role;
    }

    // Getters
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password; // Consider returning a hashed version instead for security
    }

    public AppRole getRole() {
        return role;
    }

    // Setters
    public void setUsername(String username) {
        if (username == null || username.isEmpty()) {
            throw new IllegalArgumentException("Username cannot be null or empty.");
        }
        this.username = username;
    }

    public void setPassword(String password) {
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Password cannot be null or empty.");
        }
        this.password = password;
    }

    public void setRole(AppRole role) {
        if (role == null) {
            throw new IllegalArgumentException("Role cannot be null.");
        }
        this.role = role;
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "username='" + username + '\'' +
                ", role=" + role +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, role);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof AppUser other)) return false;
        return Objects.equals(username, other.username) &&
                role == other.role;
    }
}
