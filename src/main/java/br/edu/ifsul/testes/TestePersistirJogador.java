/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Cidade;
import br.edu.ifsul.modelo.Estado;
import br.edu.ifsul.modelo.Jogador;
import br.edu.ifsul.modelo.Pessoa;
import br.edu.ifsul.modelo.Posicao;
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
public class TestePersistirJogador {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW2022-1-ModelPU");
        EntityManager em = emf.createEntityManager();
        
        Time t = em.find(Time.class, 1);
        Jogador j = new Jogador();
        j.setAltura(1.86);
        j.setPeso(80.0);
        j.setCpf("069.288.040-25");
        j.setNascimento(Calendar.getInstance());
        j.setNome("Antonio");
        j.setPosicao(em.find(Posicao.class, 1));
        t.adicionarJogador(j);
        
        em.getTransaction().begin();
        em.persist(t);
        em.getTransaction().commit();
        
        em.close();
        emf.close();
        
    }
    
}
