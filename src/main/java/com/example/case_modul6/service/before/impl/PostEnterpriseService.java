package com.example.case_modul6.service.before.impl;

import com.example.case_modul6.model.before.PostEnterprise;
import com.example.case_modul6.repository.before.IPostEnterpriseRepo;
import com.example.case_modul6.service.before.InterfaceService.All.IPostEnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PostEnterpriseService implements IPostEnterpriseService {

    @Autowired
    IPostEnterpriseRepo postEnterpriseRepo;
    @Override
    public List<PostEnterprise> findAll() {
        return (List<PostEnterprise>) postEnterpriseRepo.findAll();
    }

    @Override
    public List<PostEnterprise> findAllById(int id) {
        return postEnterpriseRepo.findAllById(id);
    }

    @Override
    public PostEnterprise findById(int id) {
        return postEnterpriseRepo.findById(id).get();
    }

    @Override
    public void save(PostEnterprise postEnterprise) {
         postEnterpriseRepo.save(postEnterprise);
    }

    @Override
    public void delete(int id) {
        postEnterpriseRepo.deleteById(id);
    }

    @Override
    public void edit(PostEnterprise postEnterprise) {
        postEnterpriseRepo.save(postEnterprise);
    }
}
