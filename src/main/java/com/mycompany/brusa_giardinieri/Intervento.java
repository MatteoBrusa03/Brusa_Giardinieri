/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.brusa_giardinieri;

import java.time.*;

/**
 *
 * @author matte
 */
public class Intervento 
{
    private int CI;
    private String nomeCliente;
    private String indirizzoCliente;
    private String nomeGiardiniere;
    private String cognomeGiardiniere;
    private LocalDateTime dataInizioIntervento;
    private LocalDateTime dataFineIntervento;

    public int getCI() 
    {
        return CI;
    }

    public void setCI(int CI) 
    {
        this.CI = CI;
    }

    public String getNomeCliente() 
    {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) 
    {
        this.nomeCliente = nomeCliente;
    }

    public String getIndirizzoCliente() 
    {
        return indirizzoCliente;
    }

    public void setIndirizzoCliente(String indirizzoCliente) 
    {
        this.indirizzoCliente = indirizzoCliente;
    }

    public String getNomeGiardiniere() 
    {
        return nomeGiardiniere;
    }

    public void setNomeGiardiniere(String nomeGiardiniere) 
    {
        this.nomeGiardiniere = nomeGiardiniere;
    }

    public String getCognomeGiardiniere() 
    {
        return cognomeGiardiniere;
    }

    public void setCognomeGiardiniere(String cognomeGiardiniere) 
    {
        this.cognomeGiardiniere = cognomeGiardiniere;
    }

    public LocalDateTime getDataInizioIntervento() 
    {
        return dataInizioIntervento;
    }

    public void setDataInizioIntervento(LocalDateTime dataInizioIntervento,int anno,int mese,int giorno,int ora,int minuto) 
    {
        dataInizioIntervento.of(anno,mese,giorno,ora,minuto);
    }

    public LocalDateTime getDataFineIntervento() 
    {
        return dataFineIntervento;
    }
    
    public String toString()
    {
      String s;
      s="CI: "+getCI()+" nome cliente: "+getNomeCliente()+" indirizzo cliente: "+getIndirizzoCliente()+" nome giardiniere: "+getNomeGiardiniere()+" cognome giardiniere: "+getCognomeGiardiniere()+" data inizio intervento:"+getDataInizioIntervento();
      return s;
    }
}
