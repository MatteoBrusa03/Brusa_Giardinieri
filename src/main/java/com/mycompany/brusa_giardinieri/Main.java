/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.brusa_giardinieri;

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
