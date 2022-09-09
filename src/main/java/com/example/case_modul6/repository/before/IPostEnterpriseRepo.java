package com.example.case_modul6.repository.before;

import com.example.case_modul6.model.before.Enterprise;
import com.example.case_modul6.model.before.PostEnterprise;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface IPostEnterpriseRepo extends CrudRepository<PostEnterprise, Integer> {

    @Query(nativeQuery = true, value = "select  * from case_module_6.post_enterprise where id_post_enterprise=:id")
    List<PostEnterprise> findAllById(@Param("id") int id);

    @Query(nativeQuery = true, value = "select  * from case_module_6.post_enterprise where enterprise_id_enterprise=:id")
    List<PostEnterprise> findAllByIdEnterprise(@Param("id") int id);

    @Query(nativeQuery = true, value = "select   * from case_module_6.post_enterprise where status_post_enterprise=1 order by priority_post_enterprise DESC limit 4")
    List<PostEnterprise> listPostByOderPriority();

    @Query(nativeQuery = true, value = "select  * from case_module_6.post_enterprise where enterprise_id_enterprise=:id and regime_id_regime=1")
    List<PostEnterprise> listPostVipByEnterprise(@Param("id") int id);

    @Query(nativeQuery = true, value = "select  * from case_module_6.post_enterprise where enterprise_id_enterprise=:id and regime_id_regime=2")
    List<PostEnterprise> listPostThuongByEnterprise(@Param("id") int id);

    // Song Đạt tìm kiếm bài đăng theo địa chỉ và công ty
    @Query(nativeQuery = true, value = "select * from case_module_6.post_enterprise where address_main_enterprise LIKE %:address% ")
    List<PostEnterprise> findByAddress(@Param("address") String address);

    @Query(nativeQuery = true, value = "select * from case_module_6.post_enterprise where enterprise_id_enterprise=:id_enterprise")
    List<PostEnterprise> findByEnterprise(@Param("id_enterprise") int id);

    @Query(nativeQuery = true, value = "select * from case_module_6.post_enterprise where name_post_enterprise LIKE %:name%")
    List<PostEnterprise> findByNamePost(@Param("name") String name);

    @Query(nativeQuery = true, value = "select * from case_module_6.post_enterprise where salary_big_post_enterprise between  salary_small_post_enterprise AND  salary_big_post_enterprise ")
    List<PostEnterprise> findSalary(double salary);
    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "update post_enterprise set status_post_enterprise = 0 where  id_post_enterprise=:id ")
    void statusPost( @Param("id") int id);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "update post_enterprise set status_post_enterprise = 1 where  id_post_enterprise=:id ")
    void openKeyPost( @Param("id") int id);


    //edit bài viết
    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "UPDATE post_enterprise SET address_main_enterprise =:addressMainEnterprise, describe_post_enterprise =:describePostEnterprise, name_post_enterprise =:namePostEnterprise, salary_big_post_enterprise =:salaryBigPostEnterprise, salary_small_post_enterprise =:salarySmallPostEnterprise, vacancies_post_enterprise =:vacanciesPostEnterprise, field_id_field =:id, form_job_post_enterprise_id_form_job =:formJobPostEnterpriseid WHERE id_post_enterprise =:idPostEnterprise ")
    void editPost( @Param("addressMainEnterprise") String addressMainEnterprise,@Param("describePostEnterprise") String describePostEnterprise,@Param("namePostEnterprise") String namePostEnterprise,@Param("salaryBigPostEnterprise") double salaryBigPostEnterprise,@Param("salarySmallPostEnterprise") double salarySmallPostEnterprise,@Param("vacanciesPostEnterprise") String vacanciesPostEnterprise,@Param("id") int idfield,@Param("formJobPostEnterpriseid") int formJobPostEnterpriseid,@Param("idPostEnterprise") int idPostEnterprise);
}
