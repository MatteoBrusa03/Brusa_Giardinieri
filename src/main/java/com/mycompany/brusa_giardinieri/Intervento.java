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

    public Intervento(int CI, String nomeCliente, String indirizzoCliente, String nomeGiardiniere, String cognomeGiardiniere,int anno,int mese,int giorno,int ora,int minuto) 
    {
      this.CI=CI;
      this.nomeCliente=nomeCliente;
      this.indirizzoCliente=indirizzoCliente;
      this.nomeGiardiniere=nomeGiardiniere;
      this.cognomeGiardiniere=cognomeGiardiniere;
      dataInizioIntervento=LocalDateTime.of(anno,mese,giorno,ora,minuto);
      dataFineIntervento=null;
    }
    public Intervento(Intervento i)
    {
       CI=i.getCI();
       nomeCliente=i.getNomeCliente();
       indirizzoCliente=i.getIndirizzoCliente();
       nomeGiardiniere=i.getNomeGiardiniere();
       cognomeGiardiniere=i.getCognomeGiardiniere();
       dataInizioIntervento=LocalDateTime.from(i.getDataInizioIntervento());
    }
    public Intervento()
    {
        CI=0;
        nomeCliente=" ";
        indirizzoCliente=" ";
        nomeGiardiniere=" ";
        cognomeGiardiniere=" ";
        dataInizioIntervento=LocalDateTime.now();
    }
    
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
    
    public boolean Equals(Object o)
    {
      Intervento intervento;
      intervento=(Intervento)o;
      if(this.getCI()==intervento.getCI() && this.nomeCliente.compareToIgnoreCase(intervento.getNomeCliente())==0 && this.indirizzoCliente.compareToIgnoreCase(intervento.getIndirizzoCliente())==0  && this.nomeGiardiniere.compareToIgnoreCase(intervento.getNomeGiardiniere())==0 && this.cognomeGiardiniere.compareToIgnoreCase(intervento.getCognomeGiardiniere())==0 && this.dataInizioIntervento.isEqual(intervento.getDataInizioIntervento()) && this.dataFineIntervento.isEqual(intervento.getDataFineIntervento()))
              return true;
      
      else
          return false;
    }
}
