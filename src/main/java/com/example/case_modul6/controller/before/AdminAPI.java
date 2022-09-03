package com.example.case_modul6.controller.before;

import com.example.case_modul6.model.before.AppUser;
import com.example.case_modul6.model.before.Enterprise;
import com.example.case_modul6.model.before.Role;
import com.example.case_modul6.service.before.InterfaceService.All.IEnterpriseService;

import com.example.case_modul6.service.before.SendMailService;
import com.example.case_modul6.service.before.impl.AppUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/admin")
public class AdminAPI {
    @Autowired
    IEnterpriseService enterpriseService;

    @Autowired
    SendMailService sendMailService;

    @Autowired
    AppUserService appUserService;
    @GetMapping("/getAllNotConfirm")
    public ResponseEntity<List<Enterprise>> getAllEnterpriseNotConfirm(){
         return new ResponseEntity<>(enterpriseService.getAllEnterpriseNotConfirmOrderByTime(), HttpStatus.OK);
    }
    @GetMapping("/getAllConfirm")
    public ResponseEntity<List<Enterprise>> getAllEnterpriseConfirm(){
        return new ResponseEntity<>(enterpriseService.getAllEnterpriseOrderByVi(), HttpStatus.OK);
    }
    @GetMapping("/findEnterprise/{id}")
    public ResponseEntity<Enterprise> findById(@PathVariable int id){
        return new ResponseEntity<>(enterpriseService.findEnterpriseById(id), HttpStatus.OK);
    }

    @PostMapping("/confirm/{id}")
    public ResponseEntity<Enterprise> confirmEnterprise(@PathVariable int id){
        String password = sendMailService.createCode();
        String codeVi = sendMailService.createCode();
        String numberVi = sendMailService.createNumberVi();
        String mail = enterpriseService.findEnterpriseById(id).getGmailEnterprise();
        sendMailService.sendMail(mail,"Thông tin xác thực","Việc làm  24 đã xác thực yêu cầu của bạn :\n\t\t-Số ví :"+numberVi+"\n\t\t- Mã ví điện tử  :"+codeVi+"\n\t\t- Mật khẩu :"+password+"\nLưu ý  :" +
                "\n\t\t\t - Để bảo mật đổi mật khẩu ứng dụng trước khi sử dụng ! \n\t\t\t- Để hoạt động trước tiên vui lòng nạp tiền vào ví điện tử !\n\t Xin cảm ơn !");
        enterpriseService.confirmRegisterEnterprise(password,codeVi,numberVi,1,id);
        AppUser appUser = new AppUser();
        appUser.setUsername(enterpriseService.findEnterpriseById(id).getGmailEnterprise());
//        Chỉnh sửa password
        appUser.setPassword(password);
        appUser.setEmail(enterpriseService.findEnterpriseById(id).getGmailEnterprise());
        Role role = new Role();
        role.setId(2);
        appUser.setRoles(role);
        appUserService.save(appUser);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping("/refuseConfirm/{id}/{reasonRefuse}")
    public  ResponseEntity<Enterprise> refuseConfirmEnterprise(@PathVariable int id,@PathVariable String reasonRefuse){
        String mail = enterpriseService.findEnterpriseById(id).getGmailEnterprise();
        sendMailService.sendMail(mail,"Thông báo ","Việc làm  24 thông báo :\n\t\t\t Công ty của bạn không đủ điều kiện để chúng tôi xác thực !\n\t\t\tLý do : "+reasonRefuse+"\n\t\tXin cảm ơn !");
        enterpriseService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
