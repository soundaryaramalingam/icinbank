package com.ICINbank.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ICINbank.Model.Account;
import com.ICINbank.Model.Admin;
import com.ICINbank.Model.cheque;
import com.ICINbank.Repository.ChequeRepository;

@Service
public class ChequeService {

	@Autowired
	ChequeRepository chequerepo;
	
	public cheque updatecheque(cheque acc, String accid) {
		 Optional<cheque> account = chequerepo.findById(accid);
			if(account.isPresent()) {
				acc.setAccid(accid);
				acc.setStatus("granted");
				acc.setUser_name(account.get().getUser_name());
				 return chequerepo.save(acc);
			 }
			 else {
				 return null;
			 }
	}

	public Optional<cheque> getchequeById(String accid) {
		return chequerepo.findById(accid);
	}
	public List<cheque> listcheque(){
		return chequerepo.findAll();
	}
}
