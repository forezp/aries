package io.github.forezp.web;


import io.github.forezp.entity.SysUserEntity;
import io.github.forezp.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.Map;


@RestController
@RequestMapping("/sysuser")
public class SysUserController  {
	@Autowired
	private SysUserService sysUserService;


	/**
	 * 所有用户列表
	 */
	@GetMapping("/list")
	public void list(@RequestParam Map<String, Object> params){
		//只有超级管理员，才能查看所有管理员列表
		SysUserEntity sysUserEntity=sysUserService.queryByUserName("admin");
		if(sysUserEntity!=null){

		}
	}
}
