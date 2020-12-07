package com.cg.loginmodule.controller;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.loginmodule.entities.LoginData;
import com.cg.loginmodule.exceptions.ResourceNotFoundException;
import com.cg.loginmodule.exceptions.UserValidate;
import com.cg.loginmodule.service.LoginModuleService;
/*
 * This Controller for testing in postman
 * 
 * @author MANASA KAITHA
 * 
 */
@RestController
@RequestMapping("/validate")
public class LoginModuleController {
	// creating variable
private	static LoginData data; //static data
	
	@Autowired
	private LoginModuleService service;
	
	/*
	 * This get Method for checking userId,password,userType
	 */
	@GetMapping("/Login1/{userId}/{password}/{type}")
	public ResponseEntity<String> validateUser(@PathVariable(value = "userId") String userId,@PathVariable(value="password") String password,@PathVariable(value="type") String type)
			throws ResourceNotFoundException {
		
		UserValidate validate=new UserValidate();
		boolean userValidate=validate.validateUser(userId);
		boolean passwordValidate=validate.validatePassword(password,userId); //validating password
		if(userValidate )
		{
			if(passwordValidate)
			{
		Logger logger=Logger.getLogger(LoginData.class);
			data =  service.findByID(userId);
			
			logger.info("ending services");
			logger.debug("running");
					
			if(data!=null)
			{
			if(data.getPassword().equals(password) && data.getUserId().equals(userId) && data.getType().equals(type))
			{
				logger.info("sucess");
				
				
				
				return ResponseEntity.ok().body("sucess login");
			}
			}else
			{
				throw new ResourceNotFoundException("Employee not found for this id :: " + userId);
				}
		
		return ResponseEntity.ok().body("invalid login");
	}else 
	{
		if(password.substring(0,6).equals(userId.subSequence(0,6)))
		{
			return ResponseEntity.ok().body("invalid user Id do not match with userName ");
		}
		else { 
	return ResponseEntity.ok().body("invalid Password Must contain atleast one special character");
	}
		}
		}
		else {
			
		return ResponseEntity.ok().body("invalid userId Enter Valid userId 7 ");
		}
}
	
}