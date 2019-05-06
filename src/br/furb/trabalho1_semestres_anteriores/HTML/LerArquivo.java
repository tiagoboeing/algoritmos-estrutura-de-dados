/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.furb.trabalho1_semestres_anteriores.HTML;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author F0FP039 - Lúcio M. Andrade
 * @author Lucas Dias da Silva
 */
public class LerArquivo {
    
    public static void main(String[] args){
        CriarHTML ch = new CriarHTML();
        try {
            ch.verificarArquivo();
        } catch (Exception ex) {
            Logger.getLogger(LerArquivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
