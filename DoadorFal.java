/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usuario;

import java.sql.Date;

/**
 *
 * @author clovis
 */
public class DoadorFal {
   
    private String nome;
    private String dataobto;
    private String emailUsuario;

    public DoadorFal(String nome, String dataobto, String emailUsuario) {
        this.nome = nome;
        this.dataobto = dataobto;
        this.emailUsuario = emailUsuario;
    }

    DoadorFal() {
         this.nome = nome;
        this.dataobto = dataobto;
        this.emailUsuario = emailUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataobto() {
        return dataobto;
    }

    public void setDataobto(String dataobto) {
        this.dataobto = dataobto;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario= emailUsuario;
    }


    
}
    

    
