/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author clovis
 */
public class OrgaodoDoador {
    
            private String nome;
            private String tiposang;
            private String idadedoador;
            private String doadorfale;
       
            
        public OrgaodoDoador() {
            
        }

        public OrgaodoDoador(String nome, String tiposang, String idadedoador, String doadorfale) {
            this.nome = nome;
            this.tiposang = tiposang;
            this.idadedoador = idadedoador;
            this.doadorfale = doadorfale;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getTiposang() {
            return tiposang;
        }

        public void setTiposang(String tiposang) {
            this.tiposang = tiposang;
        }

        public String getIdadedoador() {
            return idadedoador;
        }

        public void setIdadedoador(String idadedoador) {
            this.idadedoador = idadedoador;
        }

        public String getDoadorfale() {
            return doadorfale;
        }

        public void setDoadorfale(String doadorfale) {
            this.doadorfale = doadorfale;
        }
            
            
            
            
   public List<OrgaodoDoador> read(String email) throws SQLException{
       
       List<OrgaodoDoador> busca= new ArrayList<>();
       
       String query = "SELECT * FROM orgão WHERE UsuarioDoador_email='"+email+"';";
        
        try (Connection conn = ConexaoDB.obtemConexao();
                PreparedStatement stmt = conn.prepareStatement(query)) {
                        ResultSet rs = stmt.executeQuery();
            System.out.println(query);
            while (rs.next()) {
                String nome = rs.getString("nome");
                String tiposang = rs.getString("tiposanguineo");
                String idadedoador=rs.getString("idadedoador");
                String doadorfal=rs.getString("DoadorFalecido_nomefalecido");
                // Aqui você pode fazer o que precisar com os dados do usuário, por exemplo:
                OrgaodoDoador usuario = new OrgaodoDoador();
                usuario.setNome(nome);
                usuario.setTiposang(tiposang);
                usuario.setIdadedoador(idadedoador);
                usuario.setDoadorfale(doadorfal);
                busca.addLast(usuario);
                
      
    }} catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erros na Transação");
        e.printStackTrace();
        }
            return busca;
            
    }
    
}
