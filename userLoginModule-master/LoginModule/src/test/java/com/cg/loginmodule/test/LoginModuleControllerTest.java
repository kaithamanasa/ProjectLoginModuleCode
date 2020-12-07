package com.cg.loginmodule.test;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.cg.loginmodule.controller.LoginModuleController;
import com.cg.loginmodule.entities.LoginData;
import com.cg.loginmodule.service.LoginModuleService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
/*
 * This LoginModuleControllerTest1 method for testing
 * @author MANASA KAITHA
 */
@RunWith(SpringRunner.class)
@WebMvcTest(value = LoginModuleController.class)
class LoginModuleControllerTest {
	 @Autowired
	   private MockMvc mockMvc;
	 @MockBean
	 private LoginModuleService service;
	private String jsonInput;
	
	//This testValidateUser method for validate user
	@Test
	void testValidateUser() throws Exception {
		final String uri= "/validate/Login1/{userId}/{password}/{type}";
	        LoginData data=new LoginData();
	        data.setUserId("1");
	        data.setPassword("manasa");
	        data.setType("manager");
	        setJsonInput(this.converttoJson(data));
	        Mockito.when(service.findByID((String) (Mockito.any()))).thenReturn(data);
	        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(uri,"1","manasa","manager").accept(MediaType.APPLICATION_JSON)).andReturn();
	        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	        String jsonOutput = mockHttpServletResponse.getContentAsString();
            assertThat("success login").isNotEqualTo(jsonOutput);
    
	    }
	 private String converttoJson(Object data) throws JsonProcessingException {
	        ObjectMapper objectMapper = new ObjectMapper();
	        return objectMapper.writeValueAsString(data);
	    }
	public String getJsonInput() {
		return jsonInput;
	}
	public void setJsonInput(String jsonInput) {
		this.jsonInput = jsonInput;
	}
	


}
