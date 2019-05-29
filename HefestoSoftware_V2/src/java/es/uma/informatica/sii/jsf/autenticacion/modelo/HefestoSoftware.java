/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.jsf.autenticacion.modelo;

import java.util.Calendar;
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
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HefestoBD");
        EntityManager em = emf.createEntityManager();

        //Creamos un nuevo niño vacio con los campos obligatorios definidos y forzamos para que se
        //genere el esquema.
        Usuario test = new Usuario();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        test.setUsuario("Andrea_99");
        test.setContraseña("Contraseña123");
        test.setNombre("Andrea");
        test.setApellidos("Galvez");
        test.setDni("65667687g");
        test.setDireccion("Callejon 4");
        test.setPoblacion("Cuevas");
        test.setCodigoPostal(29837);
        test.setProvincia("Malaga");
        test.setTelefono("656767872");
        test.setCorreoElectronico("aa6@hotmail.com");
        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        test.setFechaAlta(date);

        em.persist(test);

        Niño nn = new Niño();
        nn.setUsuario("AngelSS");
        nn.setNombre("Angel");
        nn.setApellidos("Sanchez Sanchez");
        nn.setDireccion("Calle Madrid 2");
        nn.setPoblacion("Madrid");
        nn.setFechaNacimiento(date);
        nn.setFechaAlta(date);

        em.persist(nn);

        HistorialPadrinos inserta = new HistorialPadrinos();
        inserta.setFechaApadrinamiento(date);
        inserta.setDescripcion("Nuevo Apadrinamiento");
        inserta.setNiño(nn);
        inserta.setUsuario(test);

        em.persist(inserta);
        tx.commit();
        em.close();
        emf.close();

    }

}
