package com.example.case_modul6.service.before.InterfaceService.All;

import com.example.case_modul6.model.before.UserApply;

import java.util.List;

public interface IUserApplyService {

   void save(UserApply userApply);
  UserApply  findByIdAppUserAndIdPost(String imgcv,String mail,String numberTelephone,int idAppUser, int idPost);
    void updateStatusConfirmUserApply(int id);
}
