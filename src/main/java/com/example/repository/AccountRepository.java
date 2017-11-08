package com.example.repository;

import com.example.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


/**
 * Created by chu on 2017/11/06.
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

    @Query("SELECT coalesce(max(x.id), 0) FROM Account x")
    Integer getMaxId();

}