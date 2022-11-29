package com.example.case_modul6.service.before.InterfaceService.All;


import com.example.case_modul6.model.before.Enterprise;
import com.example.case_modul6.model.before.FormJob;
import com.example.case_modul6.model.before.PostEnterprise;
import com.example.case_modul6.model.before.Regime;
<<<<<<< HEAD
import org.springframework.data.domain.Page;
=======
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
>>>>>>> e7d160f755e0aed3454f350899ddc8a0cd917a9c

import java.util.List;

public interface IPostEnterpriseService {

    List<PostEnterprise> findAll();
    List<PostEnterprise> getAll(Pageable pageable);


    List<PostEnterprise> findAllById(int id);

    PostEnterprise findById(int id);

    void save(PostEnterprise postEnterprise);

    void delete(int id);

    void editPost(PostEnterprise postEnterprise);
    List<FormJob> findAllFormJob();
    List<Regime> findAllRegime();
    List<PostEnterprise> findAllByIdEnterprise(int id);
    List<PostEnterprise> listPostByOderPriority(int idUserLogin,Pageable pageable);
    List<PostEnterprise> listPostVipByEnterprise(int id);
    List<PostEnterprise> listPostThuongByEnterprise(int id);

<<<<<<< HEAD

    Page<PostEnterprise> findAllPostEnterprise(int idEnterprise);
=======
    void statusPost(int id);
    void openKeyPost(int id);

//    lấy và update số lượng apply bài post
    int quantityApplyByIdPost(int id);
    void setQuantityApplyPost(int id,int quantity);
//    lấy và update điểm đề xuất
    int priorityByIdPost(int id);

    void setPriorityIdPost( int number, int id);
//Thực hiện xóa khi hết hạn
    void  deletePostExpired( );

    PostEnterprise getPostExpired( String date);


// Tìm kiếm bài viết theo tên, địa chỉ và lĩnh vực.
    List<PostEnterprise> findPostUser(String name, String address, int field);

>>>>>>> e7d160f755e0aed3454f350899ddc8a0cd917a9c
}
