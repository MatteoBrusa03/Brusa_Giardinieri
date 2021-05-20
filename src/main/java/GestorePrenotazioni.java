
import com.mycompany.brusa_giardinieri.Intervento;

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
    
     public void aggiungiIntervento(Intervento intervento)
    {
        prenotazioni[nPrenotazioni]=new Intervento(intervento);  
        nPrenotazioni++;
    }
}
