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
package io.github.guisso.umparamuitos.util;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * 
 * @author Luis Guisso &lt;luis.guisso at ifnmg.edu.br&gt;
 * @see https://junit.org/junit5/
 */
public class UtilTest {

    public UtilTest() {
    }

    @Test
    public void digito0() {
        assertEquals(0, Util.obterDigito(12L, 11));
    }

    @Test
    public void digito3() {
        assertEquals(3, Util.obterDigito(12345678901L, 8));
    }

    @Test
    public void digito8() {
        assertEquals(8, Util.obterDigito(12345678901L, 3));
    }

    @Test
    public void isCpfValido() {
        assertTrue(Util.isCpfValido(8747359048L));
    }

    @Test
    public void isCpfInalido() {
        assertFalse(Util.isCpfValido(8747359049L));
    }

}
