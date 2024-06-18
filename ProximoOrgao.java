/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.projdoad;

import Usuario.ConexaoDB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ProximoOrgao {
    private String orgaonome; 
    private String orgaotipo;
    private String orgaoidade; 
    private String orgaodoador; 
    private String orgaotelefone;
    private double distancia;

    public ProximoOrgao(String orgaonome, String orgaotipo, String orgaoidade, String orgaodoador, String orgaotelefone, double distancia) {
        this.orgaonome = orgaonome;
        this.orgaotipo = orgaotipo;
        this.orgaoidade = orgaoidade;
        this.orgaodoador = orgaodoador;
        this.orgaotelefone = orgaotelefone;
        this.distancia = distancia;
    }   

    ProximoOrgao() {
        
    }

    public String getOrgaonome() {
        return orgaonome;
    }

    public void setOrgaonome(String orgaonome) {
        this.orgaonome = orgaonome;
    }

    public String getOrgaotipo() {
        return orgaotipo;
    }

    public void setOrgaotipo(String orgaotipo) {
        this.orgaotipo = orgaotipo;
    }

    public String getOrgaoidade() {
        return orgaoidade;
    }

    public void setOrgaoidade(String orgaoidade) {
        this.orgaoidade = orgaoidade;
    }

    public String getOrgaodoador() {
        return orgaodoador;
    }

    public void setOrgaodoador(String orgaodoador) {
        this.orgaodoador = orgaodoador;
    }

    public String getOrgaotelefone() {
        return orgaotelefone;
    }

    public void setOrgaotelefone(String orgaotelefone) {
        this.orgaotelefone = orgaotelefone;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }
    
    
    
    
    

    // Método para calcular a distância entre duas coordenadas geográficas
    public static double calcularDistancia(double lat1, double lon1, double lat2, double lon2) {
        // Raio médio da Terra em km
        double R = 6371.0;

        // Converter graus para radianos
        double lat1Rad = Math.toRadians(lat1);
        double lon1Rad = Math.toRadians(lon1);
        double lat2Rad = Math.toRadians(lat2);
        double lon2Rad = Math.toRadians(lon2);

        // Diferença nas coordenadas
        double dlon = lon2Rad - lon1Rad;
        double dlat = lat2Rad - lat1Rad;

        // Fórmula de Haversine
        double a = Math.pow(Math.sin(dlat / 2), 2) + Math.cos(lat1Rad) * Math.cos(lat2Rad) * Math.pow(Math.sin(dlon / 2), 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        // Distância em km
        double distance = R * c;
        return distance;
    }

    

   
    

    // Método para obter os órgãos ordenados por proximidade com um hospital
    public List<ProximoOrgao> read(String hospitalId,Connection connection) throws SQLException {
        List<ProximoOrgao> orgaos = new ArrayList<>();
        String hospSt = "SELECT lat, log FROM hospital WHERE emailfunc ='" + hospitalId + "';";
        String orgaoSt ="SELECT * FROM orgão";
        // Obter latitude e longitude do hospital
        
         PreparedStatement hospitalStatement = connection.prepareStatement(hospSt);    
        ResultSet hospitalResult = hospitalStatement.executeQuery(hospSt);
        
       if(hospitalResult.next()){
            System.out.println(hospSt);
            double hospitalLat = hospitalResult.getDouble("lat");
            double hospitalLon = hospitalResult.getDouble("log");

            
            PreparedStatement orgaosStatement = connection.prepareStatement(orgaoSt);
            ResultSet orgaosResult = orgaosStatement.executeQuery(orgaoSt);
            System.out.println(orgaoSt);
            while (orgaosResult.next()) {
                int orgaoId = orgaosResult.getInt("id_doações");
                String orgaonome = orgaosResult.getString("nome");
                String orgaotipo = orgaosResult.getString("tiposanguineo");
                String orgaoidade = orgaosResult.getString("idadedoador");
                String orgaodoador = orgaosResult.getString("DoadorFalecido_nomefalecido");
                String orgaotelefone = orgaosResult.getString("telefone");
                double orgaoLat = orgaosResult.getDouble("lat");
                double orgaoLon = orgaosResult.getDouble("lon");

                // Calcular a distância de cada órgão ao hospital
                double distancia = calcularDistancia(hospitalLat, hospitalLon, orgaoLat, orgaoLon);
                orgaos.add(new ProximoOrgao(orgaonome,orgaotipo,orgaoidade,orgaodoador,orgaotelefone, distancia));
                System.out.println("Foi Ordenado");
                
            // Ordenar os órgãos por proximidade
       }
            
        
       }orgaos.sort((o1, o2) -> Double.compare(o1.distancia, o2.distancia));
            return orgaos;
}
        
        
   
}
    

