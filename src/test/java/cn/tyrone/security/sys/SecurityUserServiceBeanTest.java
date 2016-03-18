package cn.tyrone.security.sys;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.tyrone.security.sys.bean.SecurityRole;
import cn.tyrone.security.sys.bean.SecurityUser;
import cn.tyrone.security.sys.service.ISecurityUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-*.xml")
public class SecurityUserServiceBeanTest {
	
	@Resource ISecurityUserService securityUserService;
	
	@Test
	public void getSecurityRoleById(){
		SecurityUser securityUser = securityUserService.getSecurityRoleById("1");
		List<SecurityRole> securityRoleList = securityUser.getSecurityRoleList();
		System.out.println(securityRoleList.size());
	}
	
}
