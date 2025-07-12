package com.nt.entity;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="IPL_TEAM_INFO")
@AllArgsConstructor
@NoArgsConstructor
public class IPLTeam {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer teamId;
	
	@Column(length=30)
	private String teamName;
	@Column(length=30)
	private String area;
	@Column(length=30)
	private String owner;

}
