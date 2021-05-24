package com.mycompany.brusa_giardinieri;


import com.mycompany.brusa_giardinieri.Intervento;
import eccezioni.FileException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author matte
 */
public class GestorePrenotazioni 
{
    private Intervento[] prenotazioni;
    private static int NUM_MAX_PRENOTAZIONI=100;
    private int nPrenotazioni=0;
    
    //Costruttore.
    public GestorePrenotazioni()
    {
        prenotazioni=new Intervento[NUM_MAX_PRENOTAZIONI];
    }
    
    //scambia vettori
   public void scambia(int posizione1,int posizione2)
   {
     Intervento c;
     c=prenotazioni[posizione1];
     prenotazioni[posizione1]=prenotazioni[posizione2];
     prenotazioni[posizione2]=c;
     
     int i;
     i=prenotazioni[posizione1].getCI();
     prenotazioni[posizione1].setCI(prenotazioni[posizione2].getCI());
     prenotazioni[posizione2].setCI(i);
   }
    
    public GestorePrenotazioni(Intervento[] prenotazioni)
    {
        prenotazioni=new Intervento[NUM_MAX_PRENOTAZIONI];
        
        int numeroPrenotazioni=0;
        
        //se elencoLibri non contiene libri.
        if(prenotazioni.length==0)
            return;
        
        if(prenotazioni.length>getNumMaxPrenotazioni())
            numeroPrenotazioni=getNumMaxPrenotazioni();
        else
            numeroPrenotazioni=prenotazioni.length;
        
        for(int i=0;i<numeroPrenotazioni;i++)
        {
            if(prenotazioni[i]!=null)
            {
                prenotazioni[i]=new Intervento(prenotazioni[i]);
            }
        }
    }
    
    public static int getNumMaxPrenotazioni()
    {
        return NUM_MAX_PRENOTAZIONI;
    }
    
    public int getNPrenotazioni()
    {
        return nPrenotazioni;
    }
    
    public void aggiungiIntervento(Intervento intervento)
    {
        prenotazioni[nPrenotazioni]=new Intervento(intervento);  
        nPrenotazioni++;
    }
    
    public void terminaIntervento(int scelta1,int anno,int mese,int giorno,int ora,int minuto)
    {
        prenotazioni[scelta1].setDataFineIntervento(anno,mese,giorno,ora,minuto);
    }
    
    public void eliminaPrenotazione(int sceltaEliminazione)
    {
       prenotazioni[sceltaEliminazione]=null;
    }
    
    public String visualizzaInterventi()
    {
        String s="";
        for(int i=0; i<nPrenotazioni; i++)
        {
           if(prenotazioni[i]!=null)
           {
             s+=prenotazioni[i].toString()+"\n";
           }  
        }
        return s;
    }
    
    public String visualizzaInterventiPerData(int anno,int mese,int giorno)
    {
        String s="";
        LocalDate dataRicerca=LocalDate.of(anno, mese, giorno);
        for(int i=0; i<nPrenotazioni; i++)
        {
           if(prenotazioni[i]!=null && prenotazioni[i].getDataInizioIntervento().toLocalDate().compareTo(dataRicerca)==0)
           {
             s+=prenotazioni[i].toString()+"\n";
           }  
        }
        return s;
    }
    
     public void ordinaInterventiDescrescente()
    {
        //selection sort decrescente
        for(int i=0;i<prenotazioni.length-1;i++)
        {
          for(int j=i+1;j<prenotazioni.length;j++)
          {
             if(prenotazioni[j]!=null && prenotazioni[i]!=null)
             {
                if(prenotazioni[j].getDataInizioIntervento().compareTo(prenotazioni[i].getDataInizioIntervento())>0)
                   scambia(i,j);
             }
          }
        }
    }
     
    public Intervento getPrenotazione(int nPrenotazioni)
   {
        return(prenotazioni[nPrenotazioni]);
   }
     
     public void esportaPrenotazioniCSV(String filePathName) throws IOException, FileException
    {
      Intervento intervento;
      String stringaLibro;
      TextFile f1= new TextFile(filePathName, 'W');
      for (int i=0;i<getNPrenotazioni();i++)
      {
             intervento=getPrenotazione(nPrenotazioni);
             if (intervento!=null)
             {
                stringaLibro=i+";"+intervento.getCI()+";"+intervento.getNomeCliente()+";"+intervento.getIndirizzoCliente()+";"+intervento.getNomeGiardiniere()+";"+intervento.getCognomeGiardiniere()+";"+intervento.getDataInizioIntervento()+";"+intervento.getDataFineIntervento()+";";
                f1.toFile(stringaLibro);
            }
      }
      f1.close(); 
  }
  
    public void salvaPrenotazione(String nomeFile) throws IOException
    {   
        FileOutputStream f1=new FileOutputStream(nomeFile);
        ObjectOutputStream writer=new ObjectOutputStream(f1);
        writer.writeObject(this);
        writer.flush();
        writer.close();   
    }

    public GestorePrenotazioni caricaPrenotazione(String nomeFile) throws IOException, FileException
    {
        GestorePrenotazioni i;
        FileInputStream f1=new FileInputStream(nomeFile);
        ObjectInputStream reader=new ObjectInputStream(f1);

         try 
         {
             i=(GestorePrenotazioni)reader.readObject();
             reader.close();
             return i;
         } 
         catch (ClassNotFoundException ex) 
         {
             reader.close();
             throw new FileException("Errore di lettura");
         }   
    }
}
