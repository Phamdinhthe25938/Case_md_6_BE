package com.example.case_modul6.repository.before;

import com.example.case_modul6.model.before.AppUser;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface IAppUserRepo extends CrudRepository<AppUser, Long> {
    AppUser findByUsername(String username);
//    @Modifying
//    @Transactional
//    @Query(nativeQuery = true,value = "update case_module_6.app_user set password=:codeVi where id_enterprise=:id")
//    void changeCodeVi(@Param("id") int id, @Param("codeVi") String codeVi);
}
