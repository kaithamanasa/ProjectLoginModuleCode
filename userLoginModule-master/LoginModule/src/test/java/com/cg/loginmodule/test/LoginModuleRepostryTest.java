package com.cg.loginmodule.test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import com.cg.loginmodule.entities.LoginData;
import com.cg.loginmodule.exceptions.ResourceNotFoundException;
import com.cg.loginmodule.repostry.LoginRepostry;
/*
 * This LoginModuleRepostryTest for testing RepostryLayer
 * @author MANASA KAITHA
 */
@RunWith(SpringRunner.class)
@DataJpaTest
class LoginModuleRepostryTest {
	@Autowired
	private  LoginRepostry lv;

	@Autowired
	private TestEntityManager test;
    
	//This validateUserData for checking for userData
	@Test
	void validateUserData() throws ResourceNotFoundException
	{
		boolean flag=false;
		LoginData data=new LoginData();
		data.setUserId("1");
		data.setPassword("manasa");
		data.setType("manager");
		test.persist(data);
		
		LoginData v;
				v=lv.findByID(data.getUserId());
					if(v.getUserId().equals("1") && v.getPassword().equals(data.getPassword()) && v.getType().equals(data.getType()))
				{
					flag=true;
				}
    assertTrue(flag);
	}

}
