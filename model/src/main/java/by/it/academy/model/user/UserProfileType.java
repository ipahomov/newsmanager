package by.it.academy.model.user;

/**
 * Enum class for define users role.
 * Can be user, author or admin.
 */
public enum UserProfileType {
    USER("USER"),
    AUTHOR("AUTHOR"),
    ADMIN("ADMIN");

    String type;

    UserProfileType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return this.name();
    }

    @Override
    public String toString() {
        return this.type;
    }
}
