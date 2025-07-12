package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nt.entity.IPLPlayer;
import com.nt.repository.IIPLPlayerRepository;

@Service
public class IPLPlayerMgmtService implements IIPLPlayerService {
	
	@Autowired
	private IIPLPlayerRepository playerRepo;
	

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public String registerPlayer(IPLPlayer player) {
		
		return "Player register with id::"+playerRepo.save(player).getPid();
	}

	@Override
	public IPLPlayer findPlayerById(int id) throws Exception {
		
		return playerRepo.findById(id).orElseThrow(()->new IllegalArgumentException("Invalid Id"));
	}

	@Override
	public List<IPLPlayer> findAllPlayer() {
		
		return playerRepo.findAll();
	}

}
