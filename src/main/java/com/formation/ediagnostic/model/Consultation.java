package com.formation.ediagnostic.model;

import com.formation.ediagnostic.enums.StatutConsultation;
import jakarta.persistence.*;

import java.time.LocalDateTime;
@Entity

public class Consultation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id1;
    private Long id;
    private LocalDateTime date;

    private String motif;
    private String observations;
    private String diagnostic;
    private String traitement;

    private Double cout;

    @Enumerated(EnumType.STRING)
    private StatutConsultation statut;

    @ManyToOne
    private Patient patient;
    @ManyToOne
    private Utilisateur generaliste;

    public Consultation() {
    }

    public Consultation(Long id,
                        LocalDateTime date,
                        String motif,
                        String observations,
                        String diagnostic,
                        String traitement,
                        Double cout,
                        StatutConsultation statut,
                        Patient patient,
                        Utilisateur generaliste) {

        this.id = id;
        this.date = date;
        this.motif = motif;
        this.observations = observations;
        this.diagnostic = diagnostic;
        this.traitement = traitement;
        this.cout = cout;
        this.statut = statut;
        this.patient = patient;
        this.generaliste = generaliste;
    }

    public Long getId1() {
        return id1;
    }

    public void setId1(Long id1) {
        this.id1 = id1;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public String getDiagnostic() {
        return diagnostic;
    }

    public void setDiagnostic(String diagnostic) {
        this.diagnostic = diagnostic;
    }

    public String getTraitement() {
        return traitement;
    }

    public void setTraitement(String traitement) {
        this.traitement = traitement;
    }

    public Double getCout() {
        return cout;
    }

    public void setCout(Double cout) {
        this.cout = cout;
    }

    public StatutConsultation getStatut() {
        return statut;
    }

    public void setStatut(StatutConsultation statut) {
        this.statut = statut;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Utilisateur getGeneraliste() {
        return generaliste;
    }

    public void setGeneraliste(Utilisateur generaliste) {
        this.generaliste = generaliste;
    }
}