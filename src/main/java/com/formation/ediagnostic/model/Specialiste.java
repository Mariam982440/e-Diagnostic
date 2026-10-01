package com.formation.ediagnostic.model;

import com.formation.ediagnostic.enums.Specialite;
import jakarta.persistence.*;

@Entity
public class Specialiste {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;

    @Enumerated(EnumType.STRING)
    private Specialite specialite;
    private Double tarif;

    public Specialiste() {
    }

    public Specialiste(Long id,
                       Utilisateur utilisateur,
                       Specialite specialite,
                       Double tarif) {
        this.id = id;
        this.utilisateur = utilisateur;
        this.specialite = specialite;
        this.tarif = tarif;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Specialite getSpecialite() {
        return specialite;
    }

    public void setSpecialite(Specialite specialite) {
        this.specialite = specialite;
    }

    public Double getTarif() {
        return tarif;
    }

    public void setTarif(Double tarif) {
        this.tarif = tarif;
    }
}
