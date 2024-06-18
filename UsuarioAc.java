package Usuario;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author clovis
 */
public class UsuarioAc {

    public UsuarioAc getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioAc usuario) {
        this.usuario = usuario;
    }
    private UsuarioAc usuario;
    private DoadorFal fale;

    public DoadorFal getFale() {
        return fale;
    }

    public void setFale(DoadorFal fale) {
        this.fale = fale;
    }
    
    UsuarioAc() {
       
    }

    

    
    private String cpf;
    private int id;
    private String nome;
    private String email;


   
    public UsuarioAc(int id, String nome, String email, UsuarioAc usuario) {
        this.id = id;
        this.usuario = usuario;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
    }

   
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
    
    
    
}