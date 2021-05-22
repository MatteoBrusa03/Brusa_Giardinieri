/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.brusa_giardinieri;

import eccezioni.FileException;
import java.io.IOException;
import java.time.*;
import java.util.*;

/**
 *
 * @author matte
 */
public class Main
{
    public static void main(String[] args) 
    {
       int sceltaUtente=-1;
       Intervento intervento;
       GestorePrenotazioni g1=new GestorePrenotazioni();
       Scanner tastiera=new Scanner(System.in);
       String nomeCliente;
       String indirizzoCliente;
       String nomeGiardiniere;
       String cognomeGiardiniere;
       int anno,mese,giorno,ora,minuto;
       int CI=0;
       int sceltaTerminazione;
       int sceltaEliminazione;
       String caricamentoDaFileOK;
       String nomeFileTesto="Giardinieri.txt";
       String nomeFileBinario="Prenotazioni.bin";
        
       String[] vociMenu=new String[8]; 
       vociMenu[0]="Esci";
       vociMenu[1]="Aggiungi prenotazine";
       vociMenu[2]="Termina prenotazione";
       vociMenu[3]="Elimina prenotazione";
       vociMenu[4]="Visualizza prenotazioni di una certa data";
       vociMenu[5]="Visualizza prenotazioni in ordine cronologico inverso";
       vociMenu[6]="Esporta in CSV";
       vociMenu[7]="Salva Dati";
       
       try 
        {
            g1=g1.caricaPrenotazione(nomeFileBinario);
            System.out.println("Dati caricati correttamente");
        } 
        catch (IOException ex) 
        {
            System.out.println("Impossibile accedere al file in lettura. I dati non sono stati caricati");
        } 
        catch (FileException ex) 
        {
            System.out.println(ex.toString());
        }
       
       Menu menu=new Menu(vociMenu);
       
       do
       {
         try
         {
           sceltaUtente=menu.sceltaMenu();
         
            switch(sceltaUtente)
            {
                case 0:
                {
                   System.out.println("L'applicazione verrà terminata");
                   break;
                }            

                case 1:
                {
                   System.out.println("Aggiungi Prenotazione: ");
                   System.out.println("Nome del cliente --> ");
                   nomeCliente=tastiera.nextLine();
                   System.out.println("Indirizzo del cliente --> ");
                   indirizzoCliente=tastiera.nextLine();
                   System.out.println("Nome del giardiniere --> ");
                   nomeGiardiniere=tastiera.nextLine();
                   System.out.println("Cognome del giardiniere --> ");
                   cognomeGiardiniere=tastiera.nextLine();
                   //LocalDateTime per l'inizio dell'intervento
                   System.out.println("Anno prenotazione --> ");
                   anno=tastiera.nextInt();
                   System.out.println("Mese prenotazione --> ");
                   mese=tastiera.nextInt();
                   System.out.println("Giorno prenotazione --> ");
                   giorno=tastiera.nextInt();
                   System.out.println("Ora prenotazione --> ");
                   ora=tastiera.nextInt();
                   System.out.println("Minuto prenotazione --> ");
                   minuto=tastiera.nextInt();
                   Intervento i1=new Intervento(CI, nomeCliente, indirizzoCliente, nomeGiardiniere, cognomeGiardiniere, anno, mese, giorno, ora, minuto);
                   g1.aggiungiIntervento(i1);
                   System.out.println("Operazione ok");
                   System.out.println("Premi un pulsante per continuare");
                   tastiera.nextLine();
                   break;
                }

                case 2:
                {
                   System.out.println(g1.visualizzaInterventi());
                   System.out.println("Scegli l'operazione che desideri terminare: ");
                   sceltaTerminazione=tastiera.nextInt();
                   System.out.println("Anno fine prenotazione --> ");
                   anno=tastiera.nextInt();
                   System.out.println("Mese fine prenotazione --> ");
                   mese=tastiera.nextInt();
                   System.out.println("Giorno fine prenotazione --> ");
                   giorno=tastiera.nextInt();
                   System.out.println("Ora fine prenotazione --> ");
                   ora=tastiera.nextInt();
                   System.out.println("Minuto fine prenotazione --> ");
                   minuto=tastiera.nextInt();
                   g1.terminaIntervento(sceltaTerminazione, anno, mese, giorno, ora, minuto);
                   System.out.println(g1.visualizzaInterventi());
                   System.out.println("Terminazione ok");
                   System.out.println("Premi un pulsante per continuare");
                   tastiera.nextLine();
                   break;
                }

                case 3:
                {
                   System.out.println(g1.visualizzaInterventi());
                   System.out.println("Scegli l'operazione che desideri eliminare: ");
                   sceltaEliminazione=tastiera.nextInt();
                   g1.eliminaPrenotazione(sceltaEliminazione);
                   System.out.println(g1.visualizzaInterventi());
                   System.out.println("Eliminazione ok");
                   System.out.println("Premi un pulsante per continuare");
                   tastiera.nextLine();
                   break;
                }

                case 4:
                {
                   System.out.println("Operazione ok");
                   System.out.println("Premi un pulsante per continuare");
                   tastiera.nextLine();
                   break;
                }

                case 5:
                {
                   System.out.println("Operazione ok");
                   System.out.println("Premi un pulsante per continuare");
                   tastiera.nextLine();
                   break;
                }

                case 6:
                {
                  try
                   {
                       g1.esportaPrenotazioniCSV(nomeFileTesto);
                       System.out.println("Libri esportati correttamente");
                   }
                   catch(IOException e1)
                   {
                       System.out.println("Impossibile accedere al file");
                   }
                   catch(FileException e2)
                   {
                      System.out.println(e2.toString());
                   }
                   break;
                }

                case 7:
                {
                   try 
                   {
                       g1.salvaPrenotazione(nomeFileBinario);
                       System.out.println("Dati salvati correttamente");
                   } 
                   catch (IOException ex) 
                   {
                      System.out.println("Impossibile accedere al file in scrittura");
                   }
                }
            }
         }
         
         catch (InputMismatchException | NumberFormatException e1 )
            {
                tastiera.nextLine();
                System.out.println("Input non corretto");
            }
         
       }while(sceltaUtente!=0);
    }
}
