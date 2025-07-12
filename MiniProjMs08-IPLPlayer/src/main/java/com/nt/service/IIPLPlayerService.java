package com.nt.service;

import java.util.List;

import com.nt.entity.IPLPlayer;

public interface IIPLPlayerService {
	
	public String registerPlayer(IPLPlayer player);
	
	public IPLPlayer findPlayerById(int id)throws Exception;
	
	public List<IPLPlayer> findAllPlayer();
	

}
