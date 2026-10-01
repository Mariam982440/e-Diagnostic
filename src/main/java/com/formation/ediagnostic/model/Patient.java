package com.formation.ediagnostic.model;


import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String prenom;
    private LocalDate dateNaissance;
    private String numeroSecuriteSociale;
    private String telephone;
    private String adresse;
    private String antecedents;
    private String allergies;
    private String traitementsEnCours;

    public Patient() {
    }

    public Patient(Long id, String nom, String prenom,
                   LocalDate dateNaissance,
                   String numeroSecuriteSociale,
                   String telephone,
                   String adresse,
                   String antecedents,
                   String allergies,
                   String traitementsEnCours) {

        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.numeroSecuriteSociale = numeroSecuriteSociale;
        this.telephone = telephone;
        this.adresse = adresse;
        this.antecedents = antecedents;
        this.allergies = allergies;
        this.traitementsEnCours = traitementsEnCours;
    }

}
