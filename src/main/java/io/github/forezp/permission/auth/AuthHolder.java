package io.github.forezp.permission.auth;

import io.jsonwebtoken.Claims;

/**
 * Created by forezp on 2018/8/6.
 */
public class AuthHolder {

    private static ThreadLocal<Claims> claimsThreadLocal = new ThreadLocal<>();

    public static void set(Claims claims) {
        claimsThreadLocal.set(claims);
    }

    public static Claims get() {
        return claimsThreadLocal.get();
    }

    public static void remove() {
        claimsThreadLocal.remove();
    }
}
