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

import io.github.guisso.umparamuitos.entidade.Entidade;
import io.github.guisso.umparamuitos.util.Util;
import java.util.Objects;

/**
 *
 * @author Luis Guisso &lt;luis.guisso at ifnmg.edu.br&gt;
 */
public class Cliente
        extends Entidade {

    private Long cpf;
    private String nome;

    //<editor-fold defaultstate="collapsed" desc="Constructors">
    public Cliente() {
    }

    public Cliente(Long id, Long cpf, String nome)
            throws Exception {
        super(id);
        setCpf(cpf);
        setNome(nome);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public Long getCpf() {
        return cpf;
    }

    public final void setCpf(Long cpf)
            throws Exception {
        if (!Util.isCpfValido(cpf)) {
            throw new Exception("CPF inválido");
        }

        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public final void setNome(String nome)
            throws Exception {
        if (nome.length() > 45) {
            throw new Exception("Nome não pode ter mais do que 45 caracteres");
        }

        this.nome = nome;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="hashCode/equals/toString">
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(getId());
        hash = 89 * hash + Objects.hashCode(this.cpf);
        hash = 89 * hash + Objects.hashCode(this.nome);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;

        return this.hashCode() == other.hashCode();
    }

    @Override
    public String toString() {
        return nome + '[' + cpf + ']';
    }
    //</editor-fold>

}
