package com.ICINbank.Model.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ICINbank.Model.Account;
import com.ICINbank.Model.User;
import com.ICINbank.Model.cheque;
import com.ICINbank.Service.Accountservice;
import com.ICINbank.Service.ChequeService;
import com.ICINbank.Service.UserService;


@RestController
@CrossOrigin(origins="http://localhost:4200")
public class UserController {
	
	@Autowired
	UserService userserv;
	
	@Autowired
	Accountservice accserv;
	
	@Autowired
	ChequeService cheserv;
	
	@GetMapping("/listusers")
	public ResponseEntity<List<User>> listUsers() {
		
		List<User> user=userserv.ListUser();
		return new ResponseEntity<List<User>>(user,HttpStatus.OK);
		
	}
	
	@GetMapping("/userlogin/{emailid},{pass}")
	public User getvalidateuser(@PathVariable("emailid") String emailid ,@PathVariable("pass") String pass ) {
		System.out.println("entered ...   "+emailid+"   "+pass);
		User usr=new User();
		usr=userserv.getuserById(emailid);
	//	System.out.println(usr.getPass());
		if(usr!=null) {
			System.out.println(usr.getPass()+","+pass);
			if((usr.getEmailid().equals(emailid))&&(usr.getPass().equals(pass))) {
				System.out.println("entered for user validation");
				return usr;
			}
			else {
				System.out.println("noo....");
				return null;
			}
			
		}
		else {
			System.out.println("no...");
			return null;
		}
	}
	@PostMapping("/transaction/{accid}/{balance}")
	public Account updatestate(@RequestBody Account acc, @PathVariable("accid") String accid,
			@PathVariable("balance") long balance) {
		System.out.println("entered update backend"+accid);
		return accserv.updatetransaction(acc, accid,balance);
	}
	@PostMapping("/requestcheque/{accid}")
	public cheque updatecheque(@RequestBody cheque acc, @PathVariable("accid") String accid) {
		System.out.println("entered update backend"+accid);
		return cheserv.updatecheque(acc, accid);
	}
}