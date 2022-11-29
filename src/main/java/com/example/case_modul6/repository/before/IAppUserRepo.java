package com.example.case_modul6.repository.before;

import com.example.case_modul6.model.before.AppUser;
import org.springframework.data.repository.CrudRepository;

public interface IAppUserRepo extends CrudRepository<AppUser, Long> {
    AppUser findByUsername(String username);
}
