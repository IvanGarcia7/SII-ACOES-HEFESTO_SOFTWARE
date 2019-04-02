/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hefestosoftware;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Antonio Manuel
 * @author Iván García Aguilar
 */
public class HefestoSoftware {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HefestoSoftwarePU");
        EntityManager em = emf.createEntityManager();

        //Creamos un nuevo niño vacio con los campos obligatorios definidos y forzamos para que se
        //genere el esquema.

        Nino a = new Nino();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        a.setNombre("Jose");
        a.setApellidos("Antonio");
        a.setDireccion("Avenida Plaza");
        a.setPoblacion("Colombia");
        a.setFechaNacimiento("01/10/99");
        a.setFechaAlta("06/11/2014");


        em.persist(a);
        tx.commit();
        em.close();
        emf.close();
    }
    
}
