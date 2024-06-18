package Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author clovis
 */
public class Usuario{

    private String nome;
    private String email;
    private String cpf; 
    private String telefone;
    private String senha;
    private String confSenha;
    private String rua;
    private int num;
    private String cep;
    private double lat;
    private double log;

    
    
   

    public Usuario(String nome, String email, String cpf, String telefone, String senha, String confSenha, String rua, int num, String cep) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.telefone = telefone;
        this.senha = senha;
        this.confSenha = confSenha;
        this.rua = rua;
        this.num = num;
        this.cep = cep;
        this.lat = lat;
        this.log = log;
    }

    Usuario() {
        this.nome= "";
        this.email="";
        this.cpf="";
        this.telefone="";
        this.senha="";
        this.confSenha="";
        this.rua="";
        this.num= 0;
        this.cep= "";
        this.lat=0.0;
        this.log=0.0;
              
            }

    Usuario(String email) {
        this.email= email;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getConfSenha() {
        return confSenha;
    }

    public void setConfSenha(String confSenha) {
        this.confSenha = confSenha;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLog() {
        return log;
    }

    public void setLog(double log) {
        this.log = log;
    }

    void add(Usuario usuario) {
        
    }
    
}


   

            
    

