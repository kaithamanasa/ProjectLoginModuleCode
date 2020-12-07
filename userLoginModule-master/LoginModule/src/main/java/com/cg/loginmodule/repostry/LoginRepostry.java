package com.cg.loginmodule.repostry;
/**
 * @author MANASA KAITHA
 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.cg.loginmodule.entities.LoginData;
/*
 * This LoginRepostry method for checking validate users
 */
@Repository
public interface LoginRepostry extends JpaRepository<LoginData, String>
{ 
	/*
	 * This method for checking whether userId present in database or not
	 */
	
@Query("select t from LoginData t where t.userId=:userId")
LoginData findByID(@Param("userId") String userId);


}
