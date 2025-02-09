package com.Lalitdk.LinkUp.user_service.Utils;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class PasswordUtils {

    //hash the password for the first time
    public static String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    //check that the plain text password match the previously hashed password
    public static boolean checkPassword(String password, String hashedPassword) {
        return BCrypt.checkpw(password, hashedPassword);
    }
}
