/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Estado;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author 20201pf.cc0033
 */
public class TesteListarEstado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW2022-1-ModelPU");
        EntityManager em = emf.createEntityManager();
        
       List<Estado> lista = em.createQuery("from Estado order by id").getResultList(); //select e from Estado e...
       for(Estado e : lista){
           System.out.println("ID: " + e.getId() + " Nome: " + e.getNome() + " UF: " + e.getUf());
       }
        
        em.close();
        emf.close();
        
    }
    
}
