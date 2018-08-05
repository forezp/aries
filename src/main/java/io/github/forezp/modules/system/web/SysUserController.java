package io.github.forezp.modules.system.web;


import com.baomidou.mybatisplus.mapper.Condition;
import io.github.forezp.common.dto.RespDTO;
import io.github.forezp.modules.system.entity.SysUser;
import io.github.forezp.modules.system.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}

