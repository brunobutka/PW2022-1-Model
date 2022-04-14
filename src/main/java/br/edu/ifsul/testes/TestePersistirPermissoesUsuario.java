/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Estado;
import br.edu.ifsul.modelo.Permissao;
import br.edu.ifsul.modelo.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author 20201pf.cc0033
 */
public class TestePersistirPermissoesUsuario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW2022-1-ModelPU");
        EntityManager em = emf.createEntityManager();
        
        Usuario u = em.find(Usuario.class, "brunobutka");
        Permissao pusuario = em.find(Permissao.class, "USUARIO");
        Permissao padmin = em.find(Permissao.class, "ADMINISTRADOR");
        u.getPermissoes().add(padmin);
        u.getPermissoes().add(pusuario);
        em.getTransaction().begin();
        em.persist(u);
        em.getTransaction().commit();
        
        em.close();
        emf.close();
        
    }
    
}
