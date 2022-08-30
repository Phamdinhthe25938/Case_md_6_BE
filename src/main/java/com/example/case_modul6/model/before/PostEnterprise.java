package com.example.case_modul6.model.before;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.sql.Date;
import java.sql.Time;

@Data
@Entity
public class PostEnterprise {
    @Id
    private int idPostEnterprise;

    private int namePostEnterprise;

    private int addressMainEnterprise;

    private Time timePostEnterprise;

    private Date datePostEnterprise;

    private boolean statusPostEnterprise;

    private double salarySmallPostEnterprise;

    private double salaryBigPostEnterprise;

    private int priorityPostEnterprise;

    private String describePostEnterprise;
    @ManyToOne
    private Regime regime;
    @ManyToOne
    private Enterprise enterprise;
}
