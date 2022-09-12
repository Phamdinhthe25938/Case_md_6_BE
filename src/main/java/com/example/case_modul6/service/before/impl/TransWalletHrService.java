package com.example.case_modul6.service.before.impl;

import com.example.case_modul6.model.before.TransWalletHr;
import com.example.case_modul6.repository.before.ITransWalletHrRepo;
import com.example.case_modul6.service.before.InterfaceService.All.ITransWalletHrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TransWalletHrService implements ITransWalletHrService {

    @Autowired
    ITransWalletHrRepo transWalletHrRepo;
    @Override
    public void save(TransWalletHr transWalletHr) {
        transWalletHrRepo.save(transWalletHr);
    }

    @Override
    public List<TransWalletHr> findAllTransWalletHr() {
        return (List<TransWalletHr>) transWalletHrRepo.findAll();
    }
}
