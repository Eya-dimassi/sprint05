package com.eya.pays.dto;

import java.util.Date;

import com.eya.pays.entities.Classification;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaysDTO {
	private Long idPays;
    private String nomPays;
    private Long population;
    private String continent;
    private Date independenceDate;
    private Classification classification;

}
