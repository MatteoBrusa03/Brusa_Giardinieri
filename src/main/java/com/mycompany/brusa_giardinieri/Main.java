/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.brusa_giardinieri;

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
       int sceltaUtente;
       Scanner tastiera=new Scanner(System.in);
       Intervento intervento;
       String nomeCliente;
       String indirizzoCliente;
       String nomeGiardiniere;
       String cognomeGiardiniere;
       int anno,mese,giorno,ora,minuto;
       
        
       String[] vociMenu=new String[8]; 
       vociMenu[0]="Esci";
       vociMenu[1]="Aggiungi prenotazine";
       vociMenu[2]="termina prenotazione";
       vociMenu[3]="Elimina prenotazione";
       vociMenu[4]="Visualizza prenotazioni di una certa data";
       vociMenu[5]="Visualizza prenotazioni in ordine cronologico inverso";
       vociMenu[6]="Esporta in CSV";
       vociMenu[7]="Esporta in file binario";
       
       Menu menu=new Menu(vociMenu);
       
       do
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
                 System.out.println("Operazione ok");
                 System.out.println("Premi un pulsante per continuare");
                 tastiera.nextLine();
                 break;
             }
             
             case 2:
             {
                 System.out.println("Operazione ok");
                 System.out.println("Premi un pulsante per continuare");
                 tastiera.nextLine();
                 break;
             }
             
             case 3:
             {
                 System.out.println("Operazione ok");
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
         }
         
       }while(sceltaUtente!=0);
    }
}
