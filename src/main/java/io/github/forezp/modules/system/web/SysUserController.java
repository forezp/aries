package io.github.forezp.modules.system.web;



import io.github.forezp.common.dto.PageResultsDTO;
import io.github.forezp.common.dto.RespDTO;
import io.github.forezp.common.util.JWTUtils;
import io.github.forezp.common.util.PageUtils;
import io.github.forezp.modules.system.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * <p>
 * 用户 前端控制器
 * </p>
 *
 * @author forezp
 * @since 2018-08-03
 */
@RestController
@RequestMapping("/user")
public class SysUserController {

    @Autowired
    SysUserService sysUserService;

    @GetMapping("/pagelist")
    public RespDTO searchUsers(@RequestParam int page, @RequestParam int pageSize) {
        PageUtils.check( page, pageSize );
        PageResultsDTO sysUsers = sysUserService.searchUsers( page, pageSize);

        return RespDTO.onSuc( sysUsers );
    }

    @PostMapping("/login")
    public RespDTO login(@RequestParam String userName, @RequestParam String password) {


        //登录成功
        String jwt = null;

        try {
            jwt = JWTUtils.createJWT( "userId", "username", 599999999L );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return RespDTO.onSuc( jwt );

    }

}

