package com.eya.pays.entities;


import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

@Entity
public class Pays {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPays;
    @NotNull
    @Size(min = 3, max = 20, message = "Le nom doit contenir entre 3 et 20 caractères")
    private String nomPays;
    @NotNull
    @Min(value = 1000, message = "La population doit être d'au moins 1000 habitants")
    @Max(value = 1500000000, message = "La population ne peut pas dépasser 1.5 milliard")
    private Long population;
    @NotNull
    @Size(min = 4, max = 15, message = "Le continent doit contenir entre 4 et 15 caractères")
    private String continent;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent(message = "La date d'indépendance doit être dans le passé ou aujourd'hui")
    private Date independenceDate;
    @ManyToOne
    @JoinColumn(name = "id_class")
    @JsonIgnoreProperties({"pays"})
    private Classification classification;


   

    public Pays(String nomPays, Long population, String continent, Date independenceDate) {
        super();
        this.nomPays = nomPays;
        this.population = population;
        this.continent = continent;
        this.independenceDate = independenceDate;
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
   public Long getIdPays() {
        return idPays;
    }

    public void setIdPays(Long idPays) {
        this.idPays = idPays;
    }

    public String getNomPays() {
        return nomPays;
    }

    public void setNomPays(String nomPays) {
        this.nomPays = nomPays;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public Date getIndependenceDate() {
        return independenceDate;
    }

    public void setIndependenceDate(Date independenceDate) {
        this.independenceDate = independenceDate;
    }

    @Override
    public String toString() {
        return "Pays [idPays=" + idPays + ", nomPays=" + nomPays + ", population=" + population 
               + ", continent=" + continent + ", independenceDate=" + independenceDate + "]";
    }
    public Classification getClassification() {
		return classification;
	}

	public void setClassification(Classification classification) {
		this.classification = classification;
	}

	public Pays() {
        super();
    }
}
