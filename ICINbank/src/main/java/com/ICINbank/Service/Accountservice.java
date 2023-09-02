package com.ICINbank.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ICINbank.Model.Account;
import com.ICINbank.Model.Admin;
import com.ICINbank.Repository.AccountRepository;

@Service
public class Accountservice {

	@Autowired
	AccountRepository accrepo;
	
	public Account updatestate(Account acc, String accid) {
		 Optional<Account> account = accrepo.findById(accid);
			if(account.isPresent()) {
				acc.setAccid(accid);
				acc.setActive("enable");
				 return accrepo.save(acc);
			 }
			 else {
				 return null;
			 }
	}

	public Optional<Account> getaccountById(String accid) {
		return accrepo.findById(accid);
	}
	
	public Account updatetransaction(Account acc, String accid,long balance) {
		 Optional<Account> account = accrepo.findById(accid);
			if(account.isPresent()) {
				acc.setAccid(accid);
				acc.setBalance(balance);
				 return accrepo.save(acc);
			 }
			 else {
				 return null;
			 }
	}

}
