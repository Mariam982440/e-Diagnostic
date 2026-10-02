package com.formation.ediagnostic.dao;


import com.formation.ediagnostic.model.Consultation;
import com.formation.ediagnostic.util.JPAUtil;
import jakarta.persistence.EntityManager;

import java.util.List;

public class ConsultationDAO {

    public void save(Consultation consultation) {
        EntityManager em = JPAUtil.getEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(consultation);
            em.getTransaction().commit();

        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;

        } finally {
            em.close();
        }
    }

    public Consultation findById(Long id) {
        EntityManager em = JPAUtil.getEntityManager();

        try {
            return em.find(Consultation.class, id);
        } finally {
            em.close();
        }
    }

    public List<Consultation> findByPatient(Long patientId) {
        EntityManager em = JPAUtil.getEntityManager();

        try {
            return em.createQuery(
                            """
                            SELECT c
                            FROM Consultation c
                            WHERE c.patient.id = :patientId
                            ORDER BY c.date DESC
                            """,
                            Consultation.class
                    )
                    .setParameter("patientId", patientId)
                    .getResultList();

        } finally {
            em.close();
        }
    }

    public Consultation update(Consultation consultation) {
        EntityManager em = JPAUtil.getEntityManager();

        try {
            em.getTransaction().begin();

            Consultation updated = em.merge(consultation);

            em.getTransaction().commit();

            return updated;

        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;

        } finally {
            em.close();
        }
    }
}