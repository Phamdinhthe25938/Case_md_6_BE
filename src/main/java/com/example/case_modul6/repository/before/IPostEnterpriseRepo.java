package com.example.case_modul6.repository.before;

import com.example.case_modul6.model.before.Enterprise;
import com.example.case_modul6.model.before.PostEnterprise;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.parameters.P;

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

//     số lượng apply theo post
    @Query(nativeQuery = true,value = "select quantity_apply_post from case_module_6.post_enterprise where  id_post_enterprise=:id ")
    int quantityApplyByIdPost(@Param("id") int id);

//    update số lượng apply theo post
     @Modifying
     @Transactional
     @Query(nativeQuery = true,value = "update post_enterprise set quantity_apply_post=:quantity where id_post_enterprise=:id ")
    void setQuantityApplyPost(@Param("id") int id,@Param("quantity") int quantity);
}
