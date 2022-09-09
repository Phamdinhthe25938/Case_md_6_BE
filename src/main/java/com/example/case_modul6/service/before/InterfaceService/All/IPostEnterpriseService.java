package com.example.case_modul6.service.before.InterfaceService.All;


import com.example.case_modul6.model.before.FormJob;
import com.example.case_modul6.model.before.PostEnterprise;
import com.example.case_modul6.model.before.Regime;

import java.util.List;

public interface IPostEnterpriseService {

    List<PostEnterprise> findAll();

    List<PostEnterprise> findAllById(int id);

    PostEnterprise findById(int id);

    void save(PostEnterprise postEnterprise);

    void delete(int id);

    void editPost(PostEnterprise postEnterprise);
    List<FormJob> findAllFormJob();
    List<Regime> findAllRegime();
    List<PostEnterprise> findAllByIdEnterprise(int id);
    List<PostEnterprise> listPostByOderPriority();
    List<PostEnterprise> listPostVipByEnterprise(int id);
    List<PostEnterprise> listPostThuongByEnterprise(int id);

    void statusPost(int id);
    void openKeyPost(int id);
}
