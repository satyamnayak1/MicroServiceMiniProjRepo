package com.nt.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.nt.entity.IPLTeam;

@FeignClient("IPLTeamMs")
public interface IIPLTeamMsClient {
	
	@GetMapping("/team//find/{id}")
	public IPLTeam getIPLTeam(@PathVariable int id);

}
