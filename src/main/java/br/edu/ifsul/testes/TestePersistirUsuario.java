/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Estado;
import br.edu.ifsul.modelo.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author 20201pf.cc0033
 */
public class TestePersistirUsuario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW2022-1-ModelPU");
        EntityManager em = emf.createEntityManager();
        
        Usuario u = new Usuario();
        u.setAtivo(true);
        /*u.setEmail("brunobutka@gmail.com");
        u.setNome("Bruno Butka");
        u.setNomeUsuario("brunobutka");
        u.setSenha("123456");*/
        u.setEmail("breneroliveira@gmail.com");
        u.setNome("Brener Augusto De Oliveira");
        u.setNomeUsuario("breneroliveira");
        u.setSenha("1234567");
        
        em.getTransaction().begin();
        em.persist(u);
        em.getTransaction().commit();
        
        em.close();
        emf.close();
        
    }
    
}
