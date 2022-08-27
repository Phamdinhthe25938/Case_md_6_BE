package com.example.case_modul6.model.before;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Enterprise {
    @Id
    private int idEnterprise;

    private String nameEnterprise;

    private String  imgEnterprise;

    private String gmailEnterprise;

    private String passwordEnterprise;

    private String codeConfirmEnterprise;

    private String describeEnterprise;

    private double viEnterprise;

    private boolean statusEnterprise=false;

//    @ManyToMany(fetch = FetchType.EAGER)
    @OneToOne
    private Role roles;
}
