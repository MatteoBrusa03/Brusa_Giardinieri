/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author matte
 */
public class Prenotazione 
{
    private Intervento[] prenotazioni;
    private static int NUM_MAX_PRENOTAZIONI=100;
    
    //Costruttore.
    public Prenotazione()
    {
        prenotazioni=new Intervento[NUM_MAX_PRENOTAZIONI];
    }
    
    //Costruttore di copia.
    public Prenotazione(Intervento Int)
    {
        prenotazioni=new Intervento[NUM_MAX_PRENOTAZIONI];
        
        for(int i=0;i<getNumMaxPrenotazioni();i++)
        {
            prenotazioni[i]=Int.getVolume(i);
        }
    }
    
    public Prenotazione(Intervento[] prenotazioni)
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
}
