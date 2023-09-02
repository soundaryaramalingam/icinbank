package com.ICINbank.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ICINbank.Model.User;
import com.ICINbank.Repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userrepo;
	
	public User getuserById(String emailid) {
		System.out.println("entered user service.... ");
		 Optional<User> usr = userrepo.findById(emailid);
			if(usr.isPresent()) {
				 return usr.get();
			 }
			 else {
				 return null;
			 }
		
	}
	
public List<User> ListUser(){
		
		return (List<User>) userrepo.findAll();
	}
	
	
}