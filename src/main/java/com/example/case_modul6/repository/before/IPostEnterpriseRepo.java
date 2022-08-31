package com.example.case_modul6.repository.before;

import com.example.case_modul6.model.before.Enterprise;
import com.example.case_modul6.model.before.PostEnterprise;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IPostEnterpriseRepo extends CrudRepository<PostEnterprise, Integer> {

    @Query(nativeQuery = true, value = "select  * from case_module_6.post_enterprise where id_post_enterprise=:id")
    List<PostEnterprise> findAllById(@Param("id") int id);


    // Song Đạt tìm kiếm bài đăng theo địa chỉ và công ty

    @Query(nativeQuery = true, value = "select * from case_module_6.post_enterprise where address_main_enterprise LIKE %:address% ")
    List<PostEnterprise> findByAddress(@Param("address") String address);

    @Query(nativeQuery = true, value = "select * from case_module_6.post_enterprise where enterprise_id_enterprise=:id_enterprise")
    List<PostEnterprise> findByEnterprise(@Param("id_enterprise") int id);

    @Query(nativeQuery = true, value = "select * from case_module_6.post_enterprise where name_post_enterprise LIKE %:name%")
    List<PostEnterprise> findByNamePost(@Param("name") String name);

    @Query(nativeQuery = true, value = "select * from case_module_6.post_enterprise where salary_big_post_enterprise between  salary_small_post_enterprise AND  salary_big_post_enterprise ")
    List<PostEnterprise> findSalary(double salary);

}
