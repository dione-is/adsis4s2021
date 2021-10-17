package br.unicesumar.adsis4s2021.DioneADS2021.minhaBase;

import java.util.UUID;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;



@MappedSuperclass
public class MinhaBaseEntity {
	
	@Id
	private String id;
	
	public MinhaBaseEntity() {
		this.id = UUID.randomUUID().toString();
	}
	
	public MinhaBaseEntity(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	
	

}
