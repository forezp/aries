package io.github.forezp.permission;

/**
 * Created by forezp on 2018/8/5.
 */
public @interface HasPermission {

    String value() default "";

    String hasRole() default "";

    String hasPermission() default "";

}
