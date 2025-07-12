package com.nt.entity;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="IPL_PLAYER_INFO")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IPLPlayer {
	@Id
	@SequenceGenerator(name="gen1",initialValue = 1000,allocationSize =1,sequenceName = "PID_SEQ" )
	@GeneratedValue(generator =" gen1",strategy = GenerationType.SEQUENCE)
	private Integer pid;
	
	@Column(length=30)
	private String name;
	
	private Integer age;
	
	@Column(length=30)
	private String role;
	
	@ManyToOne(cascade = CascadeType.MERGE,targetEntity = IPLTeam.class,fetch = FetchType.EAGER)
	@JoinColumn(referencedColumnName ="teamid",name="t_id" )
	private IPLTeam iplteam;

	@Override
	public String toString() {
		return "IPLPlayer [pid=" + pid + ", name=" + name + ", age=" + age + ", role=" + role + "]";
	}
	
	

}
