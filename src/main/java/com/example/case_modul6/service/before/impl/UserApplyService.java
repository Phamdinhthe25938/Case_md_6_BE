package com.example.case_modul6.service.before.impl;

import com.example.case_modul6.model.before.CvUser;
import com.example.case_modul6.model.before.UserApply;
import com.example.case_modul6.repository.before.IUserApplyRepo;
import com.example.case_modul6.service.before.InterfaceService.All.ICvUserService;
import com.example.case_modul6.service.before.InterfaceService.All.IPostEnterpriseService;
import com.example.case_modul6.service.before.InterfaceService.All.IUserApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserApplyService implements IUserApplyService {

    @Autowired
    IUserApplyRepo userApplyRepo;
    @Autowired
    ICvUserService cvUserService;
    @Autowired
    IPostEnterpriseService postEnterpriseService;

    @Override
    public void save(UserApply userApply){
        int idPost = userApply.getPostEnterprise().getIdPostEnterprise();
        CvUser cvUser =   cvUserService.findByIdAppUser((int) userApply.getAppUser().getId());
        userApply.setNameCV(cvUser.getName());
        userApply.setMailCv(cvUser.getMail());
        userApply.setNumberCV(cvUser.getTelephone());
        userApply.setImgCV(cvUser.getImgCV());
        userApplyRepo.save(userApply);
        int quantity = postEnterpriseService.quantityApplyByIdPost(idPost)+1;
        postEnterpriseService.setQuantityApplyPost(idPost,quantity);
    }

    @Override
    public UserApply  findByIdAppUserAndIdPost(String imgcv,String mail,String numberTelephone,int idAppUser, int idPost) {
        return userApplyRepo.findByIdAppUserAndIdPost(imgcv,mail,numberTelephone,idAppUser,idPost);
    }
}
