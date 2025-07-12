package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.IPLTeam;
import com.nt.exception.TeamNotFoundException;
import com.nt.repository.IPLTeamRepository;
@Service
public class IPLTeamMgmtService implements IIPLMgmtService {
	
	@Autowired
	private IPLTeamRepository teamRepo;

	@Override
	public String registerIPLTeam(IPLTeam team) {
		int id=teamRepo.save(team).getTeamId();
		
		return "Team register with Id::"+id;
	}

	@Override
	public List<IPLTeam> getAllTeams() {
		
		return teamRepo.findAll();
	}

	@Override
	public IPLTeam getTeamById(int teamid) throws Exception {
		
		
		return teamRepo.findById(teamid)
                .orElseThrow(() -> new TeamNotFoundException("Invalid Id"));
	}

}
