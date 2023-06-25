package Controladores;

import Componentes.Mensajes;
import Datos.GestionarArticulosMovil;
import Datos.GestionarStock;
import IU.dlgAjusteStock;
import IU.dlgCantStock;
import Modelo.ArticuloMovil;
import Modelo.DetalleStock;
import Modelo.Stock;

public class controlGestStock {
    
    public static void aModificar()
    {
        int x = dlgAjusteStock.tbDetalle.getSelectedRow();
        String cod = dlgAjusteStock.tbDetalle.getValueAt(x, 0).toString();
        String desc = dlgAjusteStock.tbDetalle.getValueAt(x, 3).toString();
        ArticuloMovil ar = GestionarArticulosMovil.busArticulo(cod);
        
        dlgCantStock.lblCodA.setText(String.valueOf(ar.getIdproducto()));
        dlgCantStock.lblDesc.setText("COD: "+String.valueOf(ar.getIdproducto())+" - "+desc);
        dlgCantStock.lblStA.setText(String.valueOf(ar.getStock()));
    }
    
    public static String addDetalleStock()
    {
        String msg;
        int codArt = Integer.valueOf(dlgCantStock.lblCodA.getText());
        int codMot = Integer.valueOf(dlgCantStock.txtCodMov.getText());
        float st_a = Float.parseFloat(dlgCantStock.lblStA.getText());
        float st_n = Float.parseFloat(dlgCantStock.txtStock.getText());
        String obs;
        if(dlgCantStock.txtObs.getText().isEmpty()){
            obs=" ";
        }else{
            obs = dlgCantStock.txtObs.getText();
        }
        
        DetalleStock ds = new DetalleStock(codArt, codMot, st_a, st_n, obs);
        msg = GestionarStock.addDetalleStock(ds);
        if(msg==null)
        {
           Mensajes.informacion("STOCK ACTUALIZADO");
        }
        else{
            Mensajes.error(msg);
        }
        return msg;
    }
    public static String actStock()
    {
        String msg;
        
        int cod = Integer.valueOf(dlgCantStock.lblCodA.getText());
        double st = Double.parseDouble(dlgCantStock.txtStock.getText());
        Stock s = new Stock(cod, st);
        msg = GestionarStock.actStock(s);
        if(msg==null)
        {
            System.out.println("STOCK ACTUALIZADO");
        }
        else{
            Mensajes.error(msg);
        }
        return msg;
    }
        
    /*public static String delStock()
    {
        int x = dlgArticulos.tbProductos.getSelectedRow();
        String msg;
        String cod = dlgArticulos.tbProductos.getValueAt(x, 0).toString();
        msg = GestionarStock.delStock(cod);
        if(msg==null)
        {
            System.out.println("Se elimino stock junto con articulo");
        }
        else{
            Mensajes.error(msg);
        }
        return msg;
    }*/
}
