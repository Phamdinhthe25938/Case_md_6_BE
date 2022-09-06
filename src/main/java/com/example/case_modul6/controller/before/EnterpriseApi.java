package com.example.case_modul6.controller.before;

import com.example.case_modul6.model.before.PostEnterprise;
import com.example.case_modul6.repository.before.IPostEnterpriseRepo;
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

    @GetMapping("/findAll")
    public ResponseEntity<List<PostEnterprise>> findAllPostEnterprise(){
         return new ResponseEntity<>(postEnterpriseService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/findAll/{id}")
    public  ResponseEntity<List<PostEnterprise>> findAllPostEnterpriseById(@PathVariable int id){
        return new ResponseEntity<>(postEnterpriseService.findAllById(id),HttpStatus.OK);
    }

    @GetMapping("/findAllEnterprise/{id}")
    public  ResponseEntity<List<PostEnterprise>> findAllPostEnterpriseByEnterprise(@PathVariable int id){
        return new ResponseEntity<>(postEnterpriseService.findAllById(id),HttpStatus.OK);
    }
    @PostMapping("/save")
    public ResponseEntity<PostEnterprise> savePostEnterprise(@RequestBody PostEnterprise postEnterprise){
        postEnterpriseService.save(postEnterprise);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
