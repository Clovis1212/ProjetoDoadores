/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projdoad;

import Usuario.ConexaoDB;
import Usuario.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author clovis
 */
public class Hospitalbd {
    public void insert(Hospital hosp) {
      String sql =   "INSERT INTO hospital (nomhosp,emailfunc,emailsup,senha,confsenha,cnpj,cep,telefone,endereço,CET,lat,log) VALUES ('"
      +hosp.getNomehosp() + "','"
      + hosp.getEmailfunc()+ "','"
      + hosp.getEmailsup() + "','"
      + hosp.getSenha()+ "','"
      + hosp.getConfsenha()+ "','"
      + hosp.getCnpj()+ "','"
      + hosp.getCep()+ "','"
      + hosp.getTelef()+ "','"
      + hosp.getEndereço()+ "','"
      + hosp.getCET()+ "','"
      + hosp.getLat()+ "','"
      + hosp.getLon()+ "')";
      
         
     /* String sql =   "INSERT INTO usuario (nome,senha) VALUES ('"
       +usuario.getNome() + "','"
       + usuario.getSenha() + "')";*/
      
       System.out.println(sql);
       try {
        Connection c = ConexaoDB.obtemConexao();
        PreparedStatement ps = c.prepareStatement(sql);
        ps.execute();
        JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");	
        ps.close();
        c.close();               

        } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erros na Transação");
        e.printStackTrace();
        }
    }
    
    public boolean altenticarUsuarioHosp(Hospital hosp) {
        String sql = "SELECT * from hospital where emailfunc= '" + hosp.getEmailfunc()+ "' AND senha= '" + hosp.getSenha()+"' ;";
        System.out.println(sql);
        try {  Connection c = ConexaoDB.obtemConexao();
        PreparedStatement ps = c.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            return true;
        }
        
        
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return false;}
    
}
