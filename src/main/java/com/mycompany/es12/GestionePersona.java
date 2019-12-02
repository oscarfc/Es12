/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.es12;

import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author tss
 */
public class GestionePersona {

    private ArrayList<Persona> persone;

    public GestionePersona() {
        persone = new ArrayList<>();

    }

    public int AskInt(String testo, int min, int max) {
        String strInt;
        int ret = 0;
        boolean controllo = false;

        while (!controllo) {
            strInt = JOptionPane.showInputDialog(testo + " - minimo" + min + "e massimo" + max);
            try {
                ret = Integer.parseInt(strInt);
                if (ret > min && ret <= max) {
                    controllo = true;
                } else {
                    JOptionPane.showMessageDialog(null, "numero non corretto");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "numero non corretto");
            }
        }
        return ret;
    }

    public String AskString(String testo) {
        String ret;

        ret = JOptionPane.showInputDialog(testo);
        return ret;
    }

    public void addPersona(String nome, String cognome, int annoNascita) {
        persone.add(new Persona(nome, cognome, annoNascita));
    }

    public Persona getPersona(int indice) {
        return persone.get(indice);
    }

    public int getNumPersone() {
        return persone.size();
    }

    public void stampaSheda(int i) {
        int eta = LocalDateTime.now().getYear() - persone.get(i).getAnnoNascita();
        JOptionPane.showMessageDialog(null, "nome:         " + persone.get(i).getNome() + 
                                          "\ncognome:      " + persone.get(i).getCognome() + 
                                          "\nanno nascita: " + persone.get(i).getAnnoNascita() + 
                                          "\netà:          " + eta);  
    }
    
    public void stampaShedaIF(int i) {
        int eta = LocalDateTime.now().getYear() - persone.get(i).getAnnoNascita();
        String tipo;
        
        if (eta >= 0 && eta < 19) {
            tipo = "giovane";
        } else if (eta >= 60) {
            tipo = "senior";
        } else {
            tipo = "adulto";
        } 
        JOptionPane.showMessageDialog(null, "nome:         " + persone.get(i).getNome() + 
                                          "\ncognome:      " + persone.get(i).getCognome() + 
                                          "\nanno nascita: " + persone.get(i).getAnnoNascita() + 
                                          "\netà:          " + eta +
                                          "\ntipo:         " + tipo);  
    }
}
