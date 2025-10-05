package login_details;

import lombok.Getter;

public class login_details {
    // In real use: store hashes, not plaintext.
    @Getter
    private static final String USERNAME = "admin";
    @Getter
    private static final String PASSWORD = "root";

}
