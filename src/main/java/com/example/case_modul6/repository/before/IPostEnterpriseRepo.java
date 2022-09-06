package com.example.case_modul6.repository.before;

import com.example.case_modul6.model.before.PostEnterprise;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IPostEnterpriseRepo extends PagingAndSortingRepository<PostEnterprise,Integer> {

    @Query(nativeQuery = true,value = "select  * from case_module_6.post_enterprise where id_post_enterprise=:id")
    List<PostEnterprise> findAllById(@Param("id") int id);

    @Query(nativeQuery = true, value = "select * from student order by enterprise_id_enterprise")
    public Page<PostEnterprise> findAllOrderByEnterprise(Pageable pageable);

}
