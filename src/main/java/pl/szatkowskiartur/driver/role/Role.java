package pl.szatkowskiartur.driver.role;

public enum Role {

    USER("ROLE_USER"),
    ADMIN("ROLE_ADMIN");

    private final String presentation;

    Role(String presentation) {
        this.presentation = presentation;
    }

}
