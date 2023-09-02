package com.ICINbank.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ICINbank.Model.Admin;
import com.ICINbank.Repository.AdminRepository;

@Service
public class AdminService {
	@Autowired
	AdminRepository adminrepo;
	
	public Admin getAdminById(String emailid) {
		 Optional<Admin> admin = adminrepo.findById(emailid);
		if(admin.isPresent()) {
			 return admin.get();
		 }
		 else {
			 return null;
		 }
	}
	public List<Admin> listadmin(){
		return adminrepo.findAll();
	}
}
