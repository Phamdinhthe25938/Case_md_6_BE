package com.example.case_modul6.controller.before;

import com.example.case_modul6.model.before.Enterprise;
import com.example.case_modul6.model.before.PostEnterprise;
import com.example.case_modul6.repository.before.IPostEnterpriseRepo;
import com.example.case_modul6.service.before.InterfaceService.All.IEnterpriseService;
import com.example.case_modul6.service.before.InterfaceService.All.IPostEnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/enterprise")
public class EnterpriseApi {
    @Autowired
    IPostEnterpriseService postEnterpriseService;

    @Autowired
    IEnterpriseService enterpriseService;

    @GetMapping("/findAll")
    public ResponseEntity<List<PostEnterprise>> findAllPostEnterprise(){
         return new ResponseEntity<>(postEnterpriseService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/findAll/{id}")
    public  ResponseEntity<List<PostEnterprise>> findAllPostEnterpriseById(@PathVariable int id){
        return new ResponseEntity<>(postEnterpriseService.findAllById(id),HttpStatus.OK);
    }
    @PostMapping("/save")
    public ResponseEntity<PostEnterprise> savePostEnterprise(@RequestBody PostEnterprise postEnterprise){
        postEnterpriseService.save(postEnterprise);
        return new ResponseEntity<>(HttpStatus.OK);
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
//Tuấn: tìm công ty theo địa chỉ chính và tên công ty
   @GetMapping("/findNameEnterprises/{name}")
    public ResponseEntity<List<Enterprise>> getEnterpriseByNameEnterprise(@PathVariable String name){
        return new ResponseEntity<>(enterpriseService.findByNameEnterprise(name),HttpStatus.OK);
    }
    @GetMapping("/findEnterpriseMainAddress/{address}")
    public ResponseEntity<List<Enterprise>> getEnterpriseByMainAddress(@PathVariable String address){
        return new ResponseEntity<>(enterpriseService.findByMainAddress(address),HttpStatus.OK);
    }
}
