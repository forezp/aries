package io.github.forezp.permission.auth;

/**
 * Created by forezp on 2018/8/6.
 */
public class AuthHolder {

    private static ThreadLocal<String> currentUser = new ThreadLocal<>();

    public static void setCurrentUser(String userId) {
        currentUser.set(userId);
    }

    public static String getCurrentUser() {
        return currentUser.get();
    }

    public static void removeCurrentUser() {
        currentUser.remove();
    }
}
