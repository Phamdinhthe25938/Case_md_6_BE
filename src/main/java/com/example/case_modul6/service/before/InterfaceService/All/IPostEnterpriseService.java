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

    void edit(PostEnterprise postEnterprise);
    List<FormJob> findAllFormJob();
    List<Regime> findAllRegime();
}
