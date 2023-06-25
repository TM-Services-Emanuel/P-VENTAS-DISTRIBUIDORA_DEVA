package Datos;

import Modelo.DetalleSalida;
import java.util.ArrayList;

public class ArregloDetalles {

    public ArrayList<DetalleSalida> ds; //Arreglo de objetos para las lineas de la salida

    //Constructor
    public ArregloDetalles() {
        ds = new ArrayList(); //Creamos el objeto
    }

    //Agregamos una nueva fila al detalle
    public void agregar(DetalleSalida nuevo)
    {
        ds.add(nuevo);
    }
    
    //Obtenemos una fila del detalle
    public DetalleSalida getFila(int i)
    {
        return ds.get(i);
    }
    
    //Remplazamos la informacion de la linea
    public void update(int i, DetalleSalida act)
    {
        ds.set(i, act);
    }
    
    //Obtenemos el numero de filas registradas
    public int numFilas()
    {
        return ds.size();
    }
    
    //Elimina una fila del detalle
    public void eliminar(int i)
    {
        ds.remove(i);
    }        
    
    //Elimina toda la fila del detalle
    public void vaciar()
    {
        for (int i = 0; i < numFilas(); i++) {
            //dc.remove(0);
            ds.clear();
        }
    }
    
    public int busca(int codigo)
    {
        for(int i=0;i<numFilas();i++)
        {
            if(codigo == getFila(i).getCodArt())
                return i; //Retorna indice
        }
        return -1; //No se encontro objeto
    }

}
