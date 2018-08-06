package io.github.forezp.permission.store;

import java.util.List;

/**
 * Created by forezp on 2018/8/6.
 */
public interface PermissionManager {

    void store(String userId, List<String> permissions);

    List<String> getPermissions(String userId);

    void expirePermission(String userId);
}
