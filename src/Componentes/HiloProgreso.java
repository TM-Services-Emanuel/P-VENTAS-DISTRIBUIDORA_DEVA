package Componentes;

import javax.swing.JProgressBar;

public class HiloProgreso extends Thread
{
    JProgressBar progreso;

    public HiloProgreso(JProgressBar progreso1)
    {        
        super();
        this.progreso=progreso1;
    }

    /**
     *
     */
    @Override
    public void run()
    {
        int l;
        for(l=0;l<=100000;l++)
        {
            progreso.setValue(l);
            pausa(25);
        }
   
    }
    public void pausa(int mlSeg)
    {
        try
        {
            // pausa para el splash
            Thread.sleep(mlSeg);
        }catch(InterruptedException e){}
    }
}
