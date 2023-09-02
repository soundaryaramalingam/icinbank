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
import com.ICINbank.Model.Admin;
import com.ICINbank.Model.cheque;
import com.ICINbank.Repository.ChequeRepository;
import com.ICINbank.Service.Accountservice;
import com.ICINbank.Service.AdminService;
import com.ICINbank.Service.ChequeService;



@RestController
@CrossOrigin(origins="http://localhost:4200")
public class AdminController {
	@Autowired
	AdminService adminserv;

	@Autowired
	Accountservice accserv;
	
	@Autowired
	ChequeService chequeserv;
	
	@GetMapping("/listadmin")
	public ResponseEntity<List<Admin>> listadmin(){
		
		List<Admin> admin=adminserv.listadmin();
		return new ResponseEntity<List<Admin>>(admin,HttpStatus.OK);
		
		
	}
	
	@GetMapping("/adminlogin/{emailid},{pass}")
	public Admin getvalidate(@PathVariable("emailid") String emailid ,@PathVariable("pass") String pass ) {
		System.out.println("entered ...   "+emailid);
		Admin admin=new Admin();
		admin=adminserv.getAdminById(emailid);
		if(admin!=null) {
			System.out.println(admin.getPass()+","+pass);
			if((admin.getEmailid().equals(emailid))&&(admin.getPass().equals(pass))) {
				System.out.println("entered for admin validation");
				return admin;
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
	
	@PostMapping("/updatestate/{accid}")
	public Account updatestate(@RequestBody Account acc, @PathVariable("accid") String accid) {
		System.out.println("entered update backend"+accid);
		return accserv.updatestate(acc, accid);
	}
	
	@GetMapping("/{accid}")
	public Account getaccountById(@PathVariable("accid") String accid) {
		System.out.println("Entered get account by id");
		return accserv.getaccountById(accid).get();
	}
	
	@GetMapping("/cheque/{accid}")
	public cheque getchequeById(@PathVariable("accid") String accid) {
		System.out.println("Entered get account by id");
		return chequeserv.getchequeById(accid).get();
	}
	@PostMapping("/updatecheque/{accid}")
	public cheque updatecheque(@RequestBody cheque acc, @PathVariable("accid") String accid) {
		System.out.println("entered update backend"+accid);
		return chequeserv.updatecheque(acc, accid);
	}
	
	@GetMapping("/listcheque")
	public ResponseEntity<List<cheque>> listcheque(){
		
		List<cheque> che=chequeserv.listcheque();
		return new ResponseEntity<List<cheque>>(che,HttpStatus.OK);
		
		
	}
}
