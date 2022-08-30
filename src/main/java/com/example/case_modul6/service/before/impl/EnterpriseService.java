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
}
