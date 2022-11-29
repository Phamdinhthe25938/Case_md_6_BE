package com.example.case_modul6.repository.before;

import com.example.case_modul6.model.before.Enterprise;
import com.example.case_modul6.model.before.PostEnterprise;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;

import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;


import javax.transaction.Transactional;
import java.util.List;

