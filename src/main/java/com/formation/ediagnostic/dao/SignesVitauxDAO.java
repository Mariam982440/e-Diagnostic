package com.formation.ediagnostic.dao;


import com.formation.ediagnostic.model.SignesVitaux;
import com.formation.ediagnostic.util.JPAUtil;
import jakarta.persistence.EntityManager;

import java.util.List;

public class SignesVitauxDAO {

    public void save(SignesVitaux signesVitaux) {
        EntityManager em = JPAUtil.getEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(signesVitaux);
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

    public List<SignesVitaux> findByPatient(Long patientId) {
        EntityManager em = JPAUtil.getEntityManager();

        try {
            return em.createQuery(
                            """
                            SELECT s
                            FROM SignesVitaux s
                            WHERE s.patient.id = :patientId
                            ORDER BY s.dateMesure DESC
                            """,
                            SignesVitaux.class
                    )
                    .setParameter("patientId", patientId)
                    .getResultList();

        } finally {
            em.close();
        }
    }
}