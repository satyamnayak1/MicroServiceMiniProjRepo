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

import com.nt.client.IIPLTeamMsClient;
import com.nt.entity.IPLPlayer;
import com.nt.entity.IPLTeam;
import com.nt.service.IIPLPlayerService;

@RestController
@RequestMapping("/player")
public class IPLPlayerController {
	
	@Autowired
	private IIPLPlayerService playerService;
	@Autowired
	private IIPLTeamMsClient client;
	
	@PostMapping("/save")
	public ResponseEntity<String> registerIPLPlayer(@RequestBody IPLPlayer player){
		int id=player.getIplteam().getTeamId();
		
		IPLTeam team=client.getIPLTeam(id);
		
		player.setIplteam(team);
		
		String msg=playerService.registerPlayer(player);
		return new ResponseEntity<String>(msg,HttpStatus.CREATED);
		
	}
	@GetMapping("/all")
	public ResponseEntity<List<IPLPlayer>> findAllPLayers(){
		
		return new ResponseEntity<List<IPLPlayer>>(playerService.findAllPlayer(),HttpStatus.OK);
		
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<IPLPlayer> getPlayerById(@PathVariable int id) throws Exception{
		IPLPlayer player=playerService.findPlayerById(id);
		
		return new ResponseEntity<IPLPlayer>(player,HttpStatus.OK);
	}
}
