package login_details;

import lombok.Getter;
import org.mindrot.jbcrypt.BCrypt;

public class login_details {
    @Getter
    private static String USERNAME = "admin";
    private static String PASSWORD_HASH = BCrypt.hashpw("root", BCrypt.gensalt());

    public static boolean checkPassword(String password) {
        return BCrypt.checkpw(password, PASSWORD_HASH);
    }

    public static void updatePassword(String newPassword) {
        PASSWORD_HASH = BCrypt.hashpw(newPassword, BCrypt.gensalt());
    }

    public static String getPASSWORD() {
        return PASSWORD_HASH;
    }

    public static void setPASSWORD(String newPassword) {
        if (newPassword!=null){
            PASSWORD_HASH = BCrypt.hashpw(newPassword, BCrypt.gensalt());
        }
    }
}
