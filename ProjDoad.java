/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.projdoad;

import TelasInicial.Inicial;
import Usuario.Usuario;

/**
 *
 * @author clovis
 */
public class ProjDoad {

    public static void main(String[] args) {
                conexao con = new conexao();
        con.obtemConexao();
        
        Inicial ini =new Inicial();
        ini.setVisible(true);
      
    }
}
