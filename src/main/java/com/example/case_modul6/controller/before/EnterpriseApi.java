package com.example.case_modul6.controller.before;

import com.example.case_modul6.model.before.*;
import com.example.case_modul6.repository.before.IPostEnterpriseRepo;
import com.example.case_modul6.service.before.InterfaceService.All.IEnterpriseService;
import com.example.case_modul6.service.before.InterfaceService.All.IPostEnterpriseService;
import com.example.case_modul6.service.before.InterfaceService.All.ITransactionHistoryService;
import com.example.case_modul6.service.before.impl.AppUserService;
import com.example.case_modul6.service.before.impl.TransactionHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/enterprise")
public class EnterpriseApi {
    @Autowired
    IPostEnterpriseService postEnterpriseService;

    @Autowired
    IEnterpriseService enterpriseService;

    @Autowired
    ITransactionHistoryService transactionHistoryService;

    @Autowired
    AppUserService appUserService;

    @GetMapping("/findAll")
    public ResponseEntity<List<PostEnterprise>> findAllPostEnterprise(){
         return new ResponseEntity<>(postEnterpriseService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/findAllByIdEnterprise/{id}")
    public  ResponseEntity<List<PostEnterprise>> findAllByIdEnterprise(@PathVariable int id){
        return new ResponseEntity<>(postEnterpriseService.findAllByIdEnterprise(id),HttpStatus.OK);
    }
    @PostMapping("/savePost")
    public ResponseEntity<PostEnterprise> savePostEnterprise(@RequestBody PostEnterprise postEnterprise){
       if(enterpriseService.findEnterpriseById(postEnterprise.getEnterprise().getIdEnterprise()).isStatusEnterprise()){
           Time timeNow =Time.valueOf(java.time.LocalTime.now());
           postEnterprise.setTimePostEnterprise(timeNow);
           long millis=System.currentTimeMillis();
           java.sql.Date date=new java.sql.Date(millis);
           postEnterprise.setDatePostEnterprise(date);
           postEnterprise.setStatusPostEnterprise(true);
           if(postEnterprise.getRegime().getIdRegime()==1){
               postEnterprise.setPriorityPostEnterprise(100);
               double money = enterpriseService.getMoneyViEnterpriseById(postEnterprise.getEnterprise().getIdEnterprise())-2;
               enterpriseService.setViEnterprise(postEnterprise.getEnterprise().getIdEnterprise(),money);
               transactionHistoryService.save(new TransactionHistory(enterpriseService.findEnterpriseById(postEnterprise.getEnterprise().getIdEnterprise()),timeNow,date,2));
           }else if(postEnterprise.getRegime().getIdRegime()==2){
               double money = enterpriseService.getMoneyViEnterpriseById(postEnterprise.getEnterprise().getIdEnterprise())-1;
               enterpriseService.setViEnterprise(postEnterprise.getEnterprise().getIdEnterprise(),money);
               postEnterprise.setPriorityPostEnterprise(20);
               transactionHistoryService.save(new TransactionHistory(enterpriseService.findEnterpriseById(postEnterprise.getEnterprise().getIdEnterprise()),timeNow,date,1));
           }
           postEnterpriseService.save(postEnterprise);
           int totalTransaction = transactionHistoryService.totalTransaction();
           int totalMoneyTransactionByEnterprise = transactionHistoryService.totalTransactionByEnterprise(postEnterprise.getEnterprise().getIdEnterprise());
           double rates = (totalMoneyTransactionByEnterprise / totalTransaction)*100;
           enterpriseService.setRatesByEnterprise(postEnterprise.getEnterprise().getIdEnterprise(),rates);
           return new ResponseEntity<>(HttpStatus.OK);
       }
       return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    @GetMapping("/vi/{id}")
    public ResponseEntity<Double> getViEnterprise(@PathVariable int id){
        return new ResponseEntity<>(enterpriseService.findViByIdEnterprise(id),HttpStatus.OK);
    }
    @GetMapping("/findEnterpriseId/{id}")
    public ResponseEntity<Enterprise> getEnterpriseById(@PathVariable int id){
        return new ResponseEntity<>(enterpriseService.findEnterpriseById(id),HttpStatus.OK);
    }
    @GetMapping("/findEnterprise/{name}")
    public ResponseEntity<Enterprise> getEnterpriseByName(@PathVariable String name){
          return new ResponseEntity<>(enterpriseService.findByGmailEnterprise(name),HttpStatus.OK);
    }
    @PostMapping("/rechargeWallet/{id}/{numberMoney}")
    public ResponseEntity<Double> rechargeWallet(@PathVariable int id,@PathVariable double numberMoney ){
        double money = enterpriseService.getMoneyViEnterpriseById(id)+numberMoney;
        enterpriseService.rechargeWallet(id,money);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/findAllFormJob")
    public ResponseEntity<List<FormJob>> listFormJob(){
        return new ResponseEntity<>(postEnterpriseService.findAllFormJob(),HttpStatus.OK);
    }
    @GetMapping("/findAllRegime")
    public ResponseEntity<List<Regime>> listRegime(){
        return new ResponseEntity<>(postEnterpriseService.findAllRegime(),HttpStatus.OK);
    }
    @PostMapping("/changeCodeVi/{id}/{codeVi}")
    public ResponseEntity<Double> changeCodeVi(@PathVariable int id,@PathVariable String codeVi ){
        enterpriseService.changeCodeVi(id,codeVi);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/listPostVipByEnterprise/{id}")
    public ResponseEntity<List<PostEnterprise>> listPostVipByEnterprise(@PathVariable int id){
        return new ResponseEntity<>(postEnterpriseService.listPostVipByEnterprise(id),HttpStatus.OK);
    }
    @GetMapping("listPostThuongByEnterprise/{id}")
    public ResponseEntity<List<PostEnterprise>> listThuongVipByEnterprise(@PathVariable int id){
        return new ResponseEntity<>(postEnterpriseService.listPostThuongByEnterprise(id),HttpStatus.OK);
    }
}
