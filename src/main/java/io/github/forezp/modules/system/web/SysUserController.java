package io.github.forezp.modules.system.web;


import io.github.forezp.common.constant.JWTConstant;
import io.github.forezp.common.dto.RespDTO;
import io.github.forezp.common.util.JWTUtils;
import io.github.forezp.modules.system.entity.SysUser;
import io.github.forezp.modules.system.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 用户 前端控制器
 * </p>
 *
 * @author forezp
 * @since 2018-08-03
 */
@RestController
@RequestMapping("/sysUser")
public class SysUserController {

    @Autowired
    SysUserService sysUserService;

    @GetMapping("/list")
    public RespDTO getUserList() {
        List<SysUser> sysUsers = sysUserService.selectList(null);

        return RespDTO.onSuc(sysUsers);
    }

    @PostMapping("/login")
    public RespDTO login(@RequestParam String userName, @RequestParam String password) {

        //登录成功
        String jwt = null;

        try {
            jwt = JWTUtils.createJWT("userId", "username", JWTConstant.HALF_DAY);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return RespDTO.onSuc(jwt);

    }

}

