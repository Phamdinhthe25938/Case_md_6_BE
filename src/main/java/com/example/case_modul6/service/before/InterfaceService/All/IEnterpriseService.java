package com.example.case_modul6.service.before.InterfaceService.All;

import com.example.case_modul6.model.before.Enterprise;

import java.util.List;

public interface IEnterpriseService {

    void save(Enterprise enterprise);
    List<Enterprise> getAllEnterprise();
     List<Enterprise> getAllEnterpriseNotConfirmOrderByTime();
    List<Enterprise> getAllEnterpriseOrderByVi();
    Enterprise findEnterpriseById(int id);
    Enterprise findByGmailEnterprise(String name);
    double findViByIdEnterprise(int id);
    void confirmRegisterEnterprise(String password,String codeVi,int status,int id);
    void delete(int id);
    void rechargeWallet(int id,double numberMoney);
    double getMoneyViEnterpriseById(int id);

    //Tuấn: search công ty theo địa chỉ chính và tên công ty
    List<Enterprise> findByNameEnterprise(String name);

    List<Enterprise> findByMainAddress(String address);
//    the

//    tuan

//    song

//    hai

//    duc

}
