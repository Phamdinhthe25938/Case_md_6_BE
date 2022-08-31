package com.example.case_modul6.model.before;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Data
@Entity
public class PostEnterprise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEnterprise;

    private String nameEnterprise;

    private String codeConfirmEnterprise;

    private String gmailEnterprise;

    private String  imgEnterprise;

    private String addressMainEnterprise;

    @ManyToOne
    private Field fieldEnterprise;

    private String describeEnterprise;

    private Time timeRegisterEnterprise;

    private Date dateRegisterEnterprise;

    private String passwordEnterprise;

    private String codeViEnterprise;

    private double viEnterprise=0;

    private boolean statusEnterprise=false;

    private boolean statusConfirm =false;
}
