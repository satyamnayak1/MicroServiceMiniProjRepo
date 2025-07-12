package com.nt.ms;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.entity.IPLTeam;
import com.nt.service.IIPLMgmtService;

@RestController
@RequestMapping("/team")
public class IPLTeamController {
	
	@Autowired
	private IIPLMgmtService teamService;
	
	@PostMapping("/save")
	public ResponseEntity<String> registerTeam(@RequestBody IPLTeam iplteam){
		//register the team
		String msg=teamService.registerIPLTeam(iplteam);
		
		return new ResponseEntity<String>(msg,HttpStatus.CREATED);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<IPLTeam>> knowAllIPLTeam(){
		
		//give all the available ipl team
		List<IPLTeam> list=teamService.getAllTeams();
		
		return new ResponseEntity<List<IPLTeam>>(list,HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<IPLTeam> findIPLTeam(@PathVariable int id) throws Exception{
		
		IPLTeam team=teamService.getTeamById(id);
		
		return new ResponseEntity<IPLTeam>(team,HttpStatus.OK);
		
	}
	
	
	

}
