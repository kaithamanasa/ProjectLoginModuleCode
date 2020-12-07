package com.cg.loginmodule.test;
/**
 * @author MANASA KAITHA
 */
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.cg.loginmodule.entities.LoginData;

class LoginDataTest {
LoginData  v=new LoginData();
	@Test
	void testUserId() {
	v.setUserId("manasa");
	assertNotNull(v.getUserId());
	}
	@Test
	void testPassword() {
	v.setPassword("Manasa@22");
	assertNotNull(v.getPassword());
	}
	@Test
	void testType() {
	v.setType("manager");
	assertNotNull(v.getType());
	}
	@Test
	void testNullType()
	{
		v.setType(null);
		assertNull(v.getType());
	}
	@Test
	void testNullPassword()
	{
		v.setPassword(null);
		assertNull(v.getPassword());
	}
	@Test
	void testNullUserid()
	{
		v.setUserId(null);
		assertNull(v.getUserId());
	}
	
	@Test
	void testData()
	{
		v.setUserId("manasa");
		v.setType("manager");
		v.setPassword("manasa");
		assertNotNull(v.getType());
		assertNotNull(v.getUserId());
		assertNotNull(v.getPassword());
	}
}
