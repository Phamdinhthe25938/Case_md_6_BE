package com.example.case_modul6.repository.before;

import com.example.case_modul6.model.before.PostEnterprise;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IPostEnterpriseRepo extends CrudRepository<PostEnterprise,Integer> {

    @Query(nativeQuery = true,value = "select  * from case_module_6.post_enterprise where id_post_enterprise=:id")
    List<PostEnterprise> findAllById(@Param("id") int id);
}
