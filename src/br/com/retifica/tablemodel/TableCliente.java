/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.retifica.tablemodel;

import br.com.retifica.model.Cliente;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author LUCAS
 */
public class TableCliente extends AbstractTableModel{

    private ArrayList<Cliente> clienteLista;
    private String[] colunas = {"ID Cliente", "Nome Completo", "CPF/CNPJ", "RG/IE", "Telefone 1", "Telefone 2", "Logradouro", "Nº", "Bairro", "CEP", "UF", "Cidade", "Situação"};
    
    public TableCliente(ArrayList<Cliente> cliente){
        this.clienteLista = cliente;
    }
    
    public void addCliente(Cliente c){
        this.clienteLista.add(c);
        fireTableDataChanged();
    }
    
    public void removeCliente(int rowIndex){
        this.clienteLista.remove(rowIndex);
        fireTableDataChanged();
    }
    
    public Cliente getCliente(int rowIndex){
        return this.clienteLista.get(rowIndex);
    }
    
    @Override
    public int getRowCount() {
        return this.clienteLista.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        switch(columnIndex){
            
            case 0:
                return this.clienteLista.get(rowIndex).getIdClient();
            case 1:
                return this.clienteLista.get(rowIndex).getFullName();
            case 2:
                return this.clienteLista.get(rowIndex).getCpf();
            case 3:
                return this.clienteLista.get(rowIndex).getRg();
            case 4:
                return this.clienteLista.get(rowIndex).getTel();
            case 5:
                return this.clienteLista.get(rowIndex).getTel2();
            case 6:
                return this.clienteLista.get(rowIndex).getStreet();
            case 7:
                return this.clienteLista.get(rowIndex).getNumber();
            case 8:
                return this.clienteLista.get(rowIndex).getDistrict();
            case 9:
                return this.clienteLista.get(rowIndex).getZipCode();
            case 10:
                return this.clienteLista.get(rowIndex).getState();
            case 11:
                return this.clienteLista.get(rowIndex).getCity();
            case 12:
                return this.clienteLista.get(rowIndex).getSituationClient();
            case 13:
                return this.clienteLista.get(rowIndex).getTbRetificaIdRetifica();
            default:
                return this.clienteLista.get(rowIndex);
                
        }
        
    }
    
    @Override
    public String getColumnName(int columnIndex){
        return this.colunas[columnIndex];
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }
    
}
