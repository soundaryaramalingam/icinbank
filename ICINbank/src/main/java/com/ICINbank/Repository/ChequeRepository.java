package com.ICINbank.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ICINbank.Model.Account;
import com.ICINbank.Model.cheque;

@Repository
public interface ChequeRepository extends JpaRepository<cheque, String>{

}
