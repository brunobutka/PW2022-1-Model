/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Cidade;
import br.edu.ifsul.modelo.Estado;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author 20201pf.cc0033
 */
public class TestePersistirCidade {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW2022-1-ModelPU");
        EntityManager em = emf.createEntityManager();
        
        Estado e = em.find(Estado.class, 1);
        Cidade c = new Cidade();
        c.setNome("Passo Fundo");
        c.setEstado(e);
        
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
        
        em.close();
        emf.close();
        
    }
    
}
