/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usuario;

import Usuario.ConexaoDB;
import Usuario.Usuario;
import Usuario.UsuarioAc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author clovis
 */
public class Usuariobd {

 
   
    
    
    
        public void insert(Usuario usuario) {
      String sql =   "INSERT INTO usuariodoador (nome,cpf,email,telefone,senha,confsenha,rua,numero,cep,lat,lon) VALUES ('"
      + usuario.getNome() + "','"
      + usuario.getCpf()+ "','"
      + usuario.getEmail() + "','"
      + usuario.getTelefone()+ "','"
      + usuario.getSenha()+ "','"
      + usuario.getConfSenha() + "','"
      + usuario.getRua()+ "','"
      + usuario.getNum()+ "','"
      + usuario.getCep()+ "','"
      + usuario.getLat()+ "','"
      + usuario.getLog()+ "')";
      
         
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


    public boolean altenticarUsuario(Usuario usuario) {
        String sql = "SELECT * from usuariodoador where email= '" + usuario.getEmail() + "' AND senha= '" + usuario.getSenha()+"' ;";
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
    
     
   
       
      

    public void consultareInserirOrgaoFal(String email, List<UsuarioAc> fal,Orgao org) throws SQLException {
        String query = "SELECT * FROM usuariodoador WHERE email='"+email+"';";
        
        try (Connection conn = ConexaoDB.obtemConexao();
                PreparedStatement stmt = conn.prepareStatement(query)) {
                        ResultSet rs = stmt.executeQuery();
            System.out.println(query);
            while (rs.next()) {
                int id = rs.getInt("cadastro");
                String nome = rs.getString("nome");
                String userEmail = rs.getString("email");
                // Aqui você pode fazer o que precisar com os dados do usuário, por exemplo:
                UsuarioAc usuario = new UsuarioAc();
                usuario.setId(id);
                usuario.setNome(nome);
                usuario.setEmail(userEmail);
                fal.addLast(usuario);
                
                
                
      String sql =   "INSERT INTO orgão (nome,tiposanguineo, idadedoador,DoadorFalecido_nomefalecido,UsuarioDoador_email,lat,lon,telefone) VALUES ('"
      + org.getOrgao()+ "','"
      + org.getTiposang()+ "','"
      + org.getIdadedoador() + "',"
      + "(select nomefalecido from doadorfalecido where UsuarioDoador_email='"+ usuario.getEmail() + "'ORDER BY id DESC LIMIT 1),"
      + "(select email from usuariodoador where cadastro='"+usuario.getId()+ "'),"
      + "(select lat from usuariodoador where cadastro='"+usuario.getId()+ "'),"
      + "(select lon from usuariodoador where cadastro='"+usuario.getId()+ "'),"
      + "(select telefone from usuariodoador where cadastro='"+usuario.getId() + "'));" ;  
      
       System.out.println(sql);
       
         try (PreparedStatement ps = conn.prepareStatement(sql)){
        ps.execute();
        JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");	
        ps.close();
        conn.close();               

         
        } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao executar a inserção no banco de dados");
               
            }
        }
 }}
    
         public void consultareInserirOrgaoVivo(String email, List<UsuarioAc> vivo,Orgao org) throws SQLException {
        String query = "SELECT * FROM usuariodoador WHERE email='"+email+"';";
        
        try (Connection conn = ConexaoDB.obtemConexao();
                PreparedStatement stmt = conn.prepareStatement(query)) {
                        ResultSet rs = stmt.executeQuery();
            System.out.println(query);
            while (rs.next()) {
                int id = rs.getInt("cadastro");
                String nome = rs.getString("nome");
                String userEmail = rs.getString("email");
                // Aqui você pode fazer o que precisar com os dados do usuário, por exemplo:
                UsuarioAc usuario = new UsuarioAc();
                usuario.setId(id);
                usuario.setNome(nome);
                usuario.setEmail(userEmail);
                vivo.addLast(usuario);
                
                
                
      String sql =   "INSERT INTO orgão (nome,tiposanguineo, idadedoador,DoadorFalecido_nomefalecido,UsuarioDoador_email,lat,lon,telefone) VALUES ('"
      + org.getOrgao()+ "','"
      + org.getTiposang()+ "','"
      + org.getIdadedoador() + "',"
      + "null,"
      + "(select email from usuariodoador where cadastro='"+usuario.getId()+ "'),"
      + "(select lat from usuariodoador where cadastro='"+usuario.getId()+ "'),"
      + "(select lon from usuariodoador where cadastro='"+usuario.getId()+ "'),"
      + "(select telefone from usuariodoador where cadastro='"+usuario.getId() + "'));" ;  
      
       System.out.println(sql);
       
         try (PreparedStatement ps = conn.prepareStatement(sql)){
        ps.execute();
        JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");	
        ps.close();
        conn.close();               

         
        } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao executar a inserção no banco de dados");
                 
                return;
            }
        }
 }} 
     
    
    public void inserirDoadorFalecido(DoadorFal fale) throws SQLException{
    
         String sql =   "INSERT INTO doadorfalecido (nomefalecido,dataobto,UsuarioDoador_email) VALUES ('"
          + fale.getNome()+ "','" 
          + fale.getDataobto()+ "','"
          + fale.getEmailUsuario()+ "')";
         
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


     }

        
    
    


   