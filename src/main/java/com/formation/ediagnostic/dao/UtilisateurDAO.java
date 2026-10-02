package com.formation.ediagnostic.dao;




import com.formation.ediagnostic.model.Utilisateur;
import com.formation.ediagnostic.util.JPAUtil;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;

import java.util.List;

public class UtilisateurDAO {

    public void save(Utilisateur utilisateur){
        EntityManager em = JPAUtil.getEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(utilisateur);
            em.getTransaction().commit();
        } catch (Exception e){
            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
            throw e;

        } finally {
            em.close();
        }
    }

    public Utilisateur findById(Long id){
        EntityManager em = JPAUtil.getEntityManager();

        try{
            return em.find(Utilisateur.class,id);
        } finally {
            em.close();
        }
    }
    public List<Utilisateur> findAll(){
        EntityManager em = JPAUtil.getEntityManager();

        try {
            return em.createQuery("SELECT u FROM Utilisateur u",
                    Utilisateur.class
            ).getResultList();
        } finally {
            em.close();
        }
    }


    public Utilisateur findByEmail(String email){
        EntityManager em = JPAUtil.getEntityManager();

        try {
            return em.createQuery("SELECT u FROM Utilisateur WHERE u.email = :email",
                    Utilisateur.class
                    )
                    .setParameter("email",email)
                    .getResultStream()
                    .findFirst()
                    .orElse(null);

        } finally {
            em.close();
        }
    }
    public Utilisateur update (Utilisateur utilisateur){
        EntityManager em = JPAUtil.getEntityManager();

        try {

            em.getTransaction().begin();
            Utilisateur updated = em.merge(utilisateur);
            em.getTransaction().commit();
            return updated;

        } catch (Exception e){

            if (em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }

    public void delete(Long id){
        EntityManager em = JPAUtil.getEntityManager();

        try {

            em.getTransaction().begin();
            Utilisateur utilisateur = findById(id);
            if (utilisateur!=null){
                em.remove(utilisateur);
            }

            em.getTransaction().commit();

        } catch (Exception e){

            if (em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }

            throw e;

        } finally {
            em.close();
        }
    }
}









