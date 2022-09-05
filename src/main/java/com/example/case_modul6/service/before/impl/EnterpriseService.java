package com.example.case_modul6.service.before.impl;

import com.example.case_modul6.model.before.Enterprise;
import com.example.case_modul6.repository.before.IEnterpriseRepo;
import com.example.case_modul6.service.before.InterfaceService.All.IEnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnterpriseService implements IEnterpriseService {
    @Autowired
    IEnterpriseRepo enterpriseRepo;


    @Override
    public void save(Enterprise enterprise){
          enterpriseRepo.save(enterprise);
    }

    @Override
    public List<Enterprise> getAllEnterprise() {
       return (List<Enterprise>) enterpriseRepo.findAll();
    }

    @Override
    public List<Enterprise> getAllEnterpriseNotConfirmOrderByTime() {
        return enterpriseRepo.getAllEnterpriseNotConfirmOrderByTime();
    }

    @Override
    public List<Enterprise> getAllEnterpriseOrderByVi() {
        return enterpriseRepo.getAllEnterpriseOrderByVi();
    }

    @Override
    public Enterprise findEnterpriseById(int id) {
        return enterpriseRepo.findById(id).get();
    }

    @Override
    public void confirmRegisterEnterprise(String password, String codeVi, int status, int id) {
        enterpriseRepo.confirmRegisterEnterprise(password,codeVi,status,id);
    }

    @Override
    public void delete(int id){
        enterpriseRepo.deleteById(id);
    }

    @Override
    public void rechargeWallet(int id, double numberMoney){
         enterpriseRepo.rechargeWallet(id,numberMoney);
    }

    @Override
    public double getMoneyViEnterpriseById(int id) {
        return enterpriseRepo.getMoneyViEnterpriseById(id);
    }

    @Override
    public Enterprise findByGmailEnterprise(String name){
        return enterpriseRepo.findByGmailEnterprise(name);
    }

    @Override
    public double findViByIdEnterprise(int id) {
        return enterpriseRepo.findViByIdEnterprise(id);
    }
//Tuấn: search công ty theo địa chỉ chính và tên công ty
    @Override
    public List<Enterprise> findByNameEnterprise(String name){
        return enterpriseRepo.findByNameEnterprise(name);
    }
    @Override
    public List<Enterprise> findByMainAddress(String address){
        return enterpriseRepo.findByMainAddress(address);
    }
}
