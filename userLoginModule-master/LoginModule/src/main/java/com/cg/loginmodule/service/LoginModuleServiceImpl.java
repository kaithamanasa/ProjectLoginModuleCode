package com.cg.loginmodule.service;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.loginmodule.entities.LoginData;
import com.cg.loginmodule.repostry.LoginRepostry;
/*
 * This service for sending request to DAO
 * 
 *@author MANASA KAITHA
 */
@Service
public class LoginModuleServiceImpl implements LoginModuleService{
@Autowired
private LoginRepostry repostry;

//This method for validating userId is present or not
public LoginData findByID(String userId) {
	Logger logger=Logger.getLogger(LoginModuleServiceImpl.class);
	logger.info("entering services");
	return repostry.findByID(userId);	
}




}
