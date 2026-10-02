package com.formation.ediagnostic.dao;

import com.formation.ediagnostic.model.Patient;
import com.formation.ediagnostic.util.JPAUtil;
import jakarta.persistence.EntityManager;

import java.util.List;

public class PatientDAO {

    public void save(Patient patient) {

        EntityManager em = JPAUtil.getEntityManager();

        try {
            em.getTransaction().begin();

            em.persist(patient);

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

    public Patient findById(Long id) {

        EntityManager em = JPAUtil.getEntityManager();

        try {
            return em.find(Patient.class, id);
        } finally {
            em.close();
        }
    }

    public List<Patient> findAll() {

        EntityManager em = JPAUtil.getEntityManager();

        try {
            return em.createQuery(
                    "SELECT p FROM Patient p",
                    Patient.class
            ).getResultList();

        } finally {
            em.close();
        }
    }

    public Patient update(Patient patient) {

        EntityManager em = JPAUtil.getEntityManager();

        try {
            em.getTransaction().begin();

            Patient updatedPatient = em.merge(patient);

            em.getTransaction().commit();

            return updatedPatient;

        } catch (Exception e) {

            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }

            throw e;

        } finally {
            em.close();
        }
    }

    public void delete(Long id) {

        EntityManager em = JPAUtil.getEntityManager();

        try {
            em.getTransaction().begin();

            Patient patient = em.find(Patient.class, id);

            if (patient != null) {
                em.remove(patient);
            }

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
}