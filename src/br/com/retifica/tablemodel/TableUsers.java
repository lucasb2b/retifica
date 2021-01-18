/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.retifica.tablemodel;

import br.com.retifica.model.User;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author LUCAS
 */
public class TableUsers extends AbstractTableModel {

    private ArrayList<User> userList;
    private String[] columns = {"ID Usuário", "Nome Completo", "Email", "Senha", "Data de Cadastro", "Situação" ,"Nível de Acesso", "Retífica"};

    public TableUsers(ArrayList<User> user) {
        this.userList = user;
    }

    public void addUser(User u) {
        this.userList.add(u);
        fireTableDataChanged();
    }

    public void removeUser(int rowIndex) {
        this.userList.remove(rowIndex);
        fireTableDataChanged();
    }

    public User getUser(int rowIndex) {
        return this.userList.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return this.userList.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return this.userList.get(rowIndex).getIdUser();
            case 1:
                return this.userList.get(rowIndex).getFullName();
            case 2:
                return this.userList.get(rowIndex).getEmail();
            case 3:
                return this.userList.get(rowIndex).getPassword();
            case 4:
                return this.userList.get(rowIndex).getJoinDate();
            case 5:
                return this.userList.get(rowIndex).getSituation_user();
            case 6:
                return this.userList.get(rowIndex).getAccessLevel();
            case 7:
                return this.userList.get(rowIndex).getTbRetificaIdRetifica();
            default:
                return this.userList.get(rowIndex);
        }
    }

    @Override
    public String getColumnName(int columnIndex) {
        return this.columns[columnIndex];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

}
