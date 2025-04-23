package com.eya.pays.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "nomPays", types = { Pays.class })
public interface PaysProjection {
	public String getNomPays();


}
