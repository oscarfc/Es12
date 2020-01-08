/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.es12;

import java.util.Optional;
import javax.swing.JOptionPane;

/**
 *
 * @author tss
 */
public class MainPersona {

    public static void main(String[] args) {
        GestionePersona gPersona = new GestionePersona();
        String nome = " ";
        String cognome;
        int annoNascita;

        while (0 != nome.substring(0, 1).compareToIgnoreCase("X")) {
            nome = gPersona.AskString("Inserisci Nome (X per terminare): ");
            if (nome.substring(0, 1).compareToIgnoreCase("X") == 0 && nome.length() == 1) {
                continue;
            }
            cognome = gPersona.AskString("Inserisci Cognome: ");
            annoNascita = gPersona.AskInt("Inserisci anno nascita (1900 <> 2019) : ", 1900, 2019);
            gPersona.addPersona(nome, cognome, annoNascita);
        }

        if (gPersona.getNumPersone() > 0) {
            gPersona.stampaScheda(0);
            gPersona.stampaSchedaIF(0);
        }

        String cognome1;
        Optional<Persona> opt = gPersona.getPersona(2);
        opt.ifPresent(p -> p.getCognome());
        Persona p = opt.orElseThrow();
        JOptionPane.showMessageDialog(null, p.getCognome());

    }
}
