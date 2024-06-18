/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projdoad;

/**
 *
 * @author clovis
 */
public class Hospital {
    
    private String nomehosp;
    private String emailfunc;
    private String emailsup;
    private String senha;
    private String confsenha;
    private String cnpj;
    private String cep;
    private String telef;
    private String endereço;
    private String CET;
    private double lat;
    private double lon;

    public Hospital(String nomehosp, String emailfunc, String emailsup, String senha, String confsenha, String cnpj, String cep, String telef, String endereço,String CET, double lat, double lon) {
        this.nomehosp = nomehosp;
        this.emailfunc = emailfunc;
        this.emailsup = emailsup;
        this.senha = senha;
        this.confsenha = confsenha;
        this.cnpj = cnpj;
        this.cep = cep;
        this.telef = telef;
        this.endereço = endereço;
        this.CET= CET;
        this.lat = lat;
        this.lon = lon;
    }

    public Hospital() {
        
    }

    public String getNomehosp() {
        return nomehosp;
    }

    public void setNomehosp(String nomehosp) {
        this.nomehosp = nomehosp;
    }

    public String getEmailfunc() {
        return emailfunc;
    }

    public void setEmailfunc(String emailfunc) {
        this.emailfunc = emailfunc;
    }

    public String getEmailsup() {
        return emailsup;
    }

    public void setEmailsup(String emailsup) {
        this.emailsup = emailsup;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getConfsenha() {
        return confsenha;
    }

    public void setConfsenha(String confsenha) {
        this.confsenha = confsenha;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getTelef() {
        return telef;
    }

    public void setTelef(String telef) {
        this.telef = telef;
    }

    public String getEndereço() {
        return endereço;
    }

    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }

    public String getCET() {
        return CET;
    }

    public void setCET(String CET) {
        this.CET = CET;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

      public double getLon() {
        return lon;
    }

  
    public void setLon(double lon) {
        this.lon = lon;
    }
    
}
