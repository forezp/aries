package io.github.forezp.service;



import com.baomidou.mybatisplus.service.IService;
import io.github.forezp.entity.SysUserEntity;
import java.util.List;

public interface SysUserService extends IService<SysUserEntity> {




	List<String> queryAllPerms(Long userId);
	

	List<Long> queryAllMenuId(Long userId);


	SysUserEntity queryByUserName(String username);

	void save(SysUserEntity user);
	

	void update(SysUserEntity user);
	

	void deleteBatch(Long[] userIds);


	boolean updatePassword(Long userId, String password, String newPassword);
}
