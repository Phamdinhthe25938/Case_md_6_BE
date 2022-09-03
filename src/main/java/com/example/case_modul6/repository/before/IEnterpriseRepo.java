package com.example.case_modul6.repository.before;

import com.example.case_modul6.model.before.Enterprise;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface IEnterpriseRepo extends CrudRepository<Enterprise,Integer>{

    @Transactional
    @Modifying
    @Query(nativeQuery = true,value = "update enterprise set password_enterprise=:password,code_vi_enterprise=:codeVi,status_confirm=:status where id_enterprise=:id")
    void confirmRegisterEnterprise(@Param("password") String password,@Param("codeVi") String codeVi,@Param("status") int status,@Param("id")int id);
    @Query(nativeQuery = true,value = "SELECT * FROM case_module_6.enterprise where status_confirm=0 ORDER BY time_register_enterprise DESC, date_register_enterprise DESC")
    List<Enterprise> getAllEnterpriseNotConfirmOrderByTime();
    @Query(nativeQuery = true,value = "SELECT * FROM case_module_6.enterprise where status_confirm=1 ORDER BY time_register_enterprise DESC, date_register_enterprise DESC")
    List<Enterprise> getAllEnterpriseOrderByVi();

    @Query(nativeQuery = true,value = "SELECT vi_enterprise FROM case_module_6.enterprise where id_enterprise=:id")
    double findViByIdEnterprise(@Param("id") int id);
    @Query(nativeQuery = true,value = "SELECT * FROM case_module_6.enterprise where gmail_enterprise=:gmail")
    Enterprise findByGmailEnterprise(@Param("gmail") String name);

    @Modifying
    @Transactional
    @Query(nativeQuery = true,value = "update case_module_6.enterprise set vi_enterprise=:numberMoney where id_enterprise=:id")
   void rechargeWallet(@Param("id") int id,@Param("numberMoney") double numberMoney);

    @Query(nativeQuery = true,value = "SELECT vi_enterprise FROM case_module_6.enterprise  where id_enterprise=:id")
    double getMoneyViEnterpriseById(@Param("id")int id);
}
