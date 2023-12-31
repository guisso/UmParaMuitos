/*
 * CC BY-NC-SA 4.0
 *
 * Copyright 2022 Luis Guisso &lt;luis dot guisso at ifnmg dot edu dot br&gt;.
 *
 * Attribution-NonCommercial-ShareAlike 4.0 International (CC BY-NC-SA 4.0)
 *
 * You are free to:
 *   Share - copy and redistribute the material in any medium or format
 *   Adapt - remix, transform, and build upon the material
 *
 * Under the following terms:
 *   Attribution - You must give appropriate credit, provide 
 *   a link to the license, and indicate if changes were made.
 *   You may do so in any reasonable manner, but not in any 
 *   way that suggests the licensor endorses you or your use.
 *   NonCommercial - You may not use the material for commercial purposes.
 *   ShareAlike - If you remix, transform, or build upon the 
 *   material, you must distribute your contributions under 
 *   the same license as the original.
 *   No additional restrictions - You may not apply legal 
 *   terms or technological measures that legally restrict 
 *   others from doing anything the license permits.
 *
 * Notices:
 *   You do not have to comply with the license for elements 
 *   of the material in the public domain or where your use 
 *   is permitted by an applicable exception or limitation.
 *   No warranties are given. The license may not give you 
 *   all of the permissions necessary for your intended use. 
 *   For example, other rights such as publicity, privacy, 
 *   or moral rights may limit how you use the material.
 */
package io.github.guisso.umparamuitos.cliente;

import io.github.guisso.umparamuitos.util.UtilTest;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Luis Guisso &lt;luis.guisso at ifnmg.edu.br&gt;
 */
public class ClienteTest {

    public ClienteTest() {
    }

    /**
     * https://www.baeldung.com/junit-assert-exception
     */
    @Test
    public void clienteCpfInvalido() {
        Exception ex = assertThrows(Exception.class, () -> {
            new Cliente(null, 12345678901L, "Ana Zaira");
        });
    }

    @Test
    public void clientesIguais() {
        try {
            Cliente c1 = new Cliente(0L, 27339913025L, "Luis Guisso");
            Cliente c2 = new Cliente(0L, 27339913025L, "Luis Guisso");

            assertEquals(c1, c2);
        } catch (Exception ex) {
            Logger.getLogger(UtilTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void clientesDiferentesId() {
        try {
            Cliente c1 = new Cliente(0L, 27339913025L, "Luis Guisso");
            Cliente c2 = new Cliente(1L, 27339913025L, "Luis Guisso");

            assertNotEquals(c1, c2);
        } catch (Exception ex) {
            Logger.getLogger(UtilTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void clientesDiferentesCpf() {
        try {
            Cliente c1 = new Cliente(0L, 14948020079L, "Luis Guisso");
            Cliente c2 = new Cliente(0L, 27339913025L, "Luis Guisso");

            assertNotEquals(c1, c2);
        } catch (Exception ex) {
            Logger.getLogger(UtilTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void clientesDiferentesNome() {
        try {
            Cliente c1 = new Cliente(0L, 27339913025L, "Luis GuissoX");
            Cliente c2 = new Cliente(0L, 27339913025L, "Luis Guisso");

            assertNotEquals(c1, c2);
        } catch (Exception ex) {
            Logger.getLogger(UtilTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void persistenciaCliente() {
        Cliente c1, c2, c3;

        try {
            c1 = new Cliente(null, 12868356079L, "Luis Guisso");

            long id = new ClienteDao().saveOrUpdate(c1);

            // Cliente persistido em tese
            c2 = new Cliente(id, 12868356079L, "Luis Guisso");

            // Cliente persistido de fato
            c3 = new ClienteDao().findById(id);

            assertEquals(c2, c3);

        } catch (Exception ex) {
            Logger.getLogger(ClienteTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
