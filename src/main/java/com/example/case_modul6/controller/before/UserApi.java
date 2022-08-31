package com.example.case_modul6.controller.before;

import com.example.case_modul6.model.before.PostEnterprise;
import com.example.case_modul6.service.before.impl.PostEnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class UserApi {

    @Autowired
    PostEnterpriseService postEnterpriseService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<PostEnterprise>> findAll() {
        return new ResponseEntity<>(postEnterpriseService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/findAddress/{address}")

    public ResponseEntity<List<PostEnterprise>> findByAddress(@PathVariable String address) {

        return new ResponseEntity<>(postEnterpriseService.findByAddress(address), HttpStatus.OK);
    }

    @GetMapping("/findByNamePost/{name}")
    public ResponseEntity<List<PostEnterprise>> findByNamePost(@PathVariable String name) {
        return new ResponseEntity<>(postEnterpriseService.findByNamePost(name), HttpStatus.OK);
    }

    @GetMapping("/findByEnterprise/{id}")
    public ResponseEntity<List<PostEnterprise>> findByEnterprise(@PathVariable int id) {
        return new ResponseEntity<>(postEnterpriseService.findByEnterprise(id), HttpStatus.OK);
    }
    @GetMapping("/findSalary/{salary}")
    public ResponseEntity<List<PostEnterprise>> findBySalary(@PathVariable double salary) {
        return new ResponseEntity<>(postEnterpriseService.findSalary(salary), HttpStatus.OK);
    }

}
