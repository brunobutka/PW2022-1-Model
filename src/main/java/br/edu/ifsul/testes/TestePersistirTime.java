/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Cidade;
import br.edu.ifsul.modelo.Estado;
import br.edu.ifsul.modelo.Pessoa;
import br.edu.ifsul.modelo.Time;
import br.edu.ifsul.modelo.Usuario;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author 20201pf.cc0033
 */
public class TestePersistirTime {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW2022-1-ModelPU");
        EntityManager em = emf.createEntityManager();
        
        Time t = new Time();
        t.setNome("Gaucho de Passo Fundo");
        t.setDataFundacao(Calendar.getInstance());
        t.setHistoria("Time da cidade de Passo Fundo");
        t.setCidade(em.find(Cidade.class, 1));
        t.setTecnico(em.find(Pessoa.class, 1));
        t.setUsuario(em.find(Usuario.class, "brunobutka"));
        
        em.getTransaction().begin();
        em.persist(t);
        em.getTransaction().commit();
        
        em.close();
        emf.close();
        
    }
    
}
