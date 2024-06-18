/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usuario;

/**
 *
 * @author clovis
 */
public class Orgao {
    private String orgao;
    private String tiposang;
    private int idadedoador;

    public Orgao(String orgao, String tiposang, int idadedoador) {
        this.orgao = orgao;
        this.tiposang = tiposang;
        this.idadedoador = idadedoador;
    }

    Orgao() {
       this.orgao = orgao;
       this.tiposang= tiposang;
       this.idadedoador= idadedoador;
               
    }

    public String getOrgao() {
        return orgao;
    }

    public void setOrgao(String orgao) {
        this.orgao = orgao;
    }

    public String getTiposang() {
        return tiposang;
    }

    public void setTiposang(String tiposang) {
        this.tiposang = tiposang;
    }

    public int getIdadedoador() {
        return idadedoador;
    }

    public void setIdadedoador(int idadedoador) {
        this.idadedoador = idadedoador;
    }
    
    
}

