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

import io.github.guisso.umparamuitos.repositorio.Dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luis Guisso &lt;luis.guisso at ifnmg.edu.br&gt;
 */
public class ClienteDao
        extends Dao<Cliente> {

    public static final String TABLE = "cliente";

    @Override
    public String getSaveStatement() {
        return "insert into " + TABLE + " (id, cpf, nome)"
                + " values (default, ?, ?)";
    }

    @Override
    public String getUpdateStatement() {
        return "update " + TABLE
                + " set cpf = ?, nome = ?"
                + " where id = ?";
    }

    @Override
    public void composeSaveOrUpdateStatement(PreparedStatement pstmt, Cliente e) {
        try {
            pstmt.setLong(1, e.getCpf());
            pstmt.setString(2, e.getNome());

            if (e.getId() != null) {
                pstmt.setLong(3, e.getId());
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getFindByIdStatement() {
        return "select id, cpf, nome"
                + " from " + TABLE
                + " where id = ?";
    }

    @Override
    public String getFindAllStatement() {
        return "select id, cpf, nome"
                + " from " + TABLE;
    }

    @Override
    public String getMoveToTrashStatement() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void moveToTrash(Cliente e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getRestoreFromTrashStatement() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void restoreFromTrash(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getFindAllOnTrashStatement() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Cliente> findAllOnTrash() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Cliente extractObject(ResultSet resultSet) {
        Cliente c = null;

        try {
            c = new Cliente();

            c.setId(resultSet.getLong("id"));
            c.setCpf(resultSet.getLong("cpf"));
            c.setNome(resultSet.getString("nome"));

            return c;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return c;
    }

}
