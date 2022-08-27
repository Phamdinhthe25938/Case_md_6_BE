package com.example.case_modul6.service.before.impl;

import com.example.case_modul6.model.before.Enterprise;
import com.example.case_modul6.service.before.InterfaceService.All.IEnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnterpriseService implements IEnterpriseService {
    @Autowired
    EnterpriseService enterpriseService;

    @Override
    public void save(Enterprise enterprise) {
          enterpriseService.save(enterprise);
    }

    @Override
    public void delete(int id) {
        enterpriseService.delete(id);
    }
}
