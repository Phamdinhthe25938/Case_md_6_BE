package com.example.case_modul6.repository.before;

import com.example.case_modul6.model.before.UserApply;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IUserApplyRepo extends CrudRepository<UserApply,Integer> {

    @Query(nativeQuery = true,value = "select * from case_module_6.user_apply where (imgcv=:imgcv or  mail_cv=:mail_cv or  numbercv=:numbercv) and  app_user_id=:idAppUser and post_enterprise_id_post_enterprise=:idPost")
     UserApply findByIdAppUserAndIdPost(@Param("imgcv")String imgcv,@Param("mail_cv") String mail_cv,@Param("numbercv") String number_cv,@Param("idAppUser") int idAppUser, @Param("idPost") int idPost);
}
