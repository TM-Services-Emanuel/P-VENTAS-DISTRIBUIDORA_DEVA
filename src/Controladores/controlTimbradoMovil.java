package Controladores;

import Componentes.Mensajes;
import static Componentes.URL.urlServer;
import Datos.GestionarTimbradoMovil;
import IU.dlgTimbradoMovil;
import Modelo.TimbradoMovil;
import com.devazt.networking.HttpClient;
import com.devazt.networking.OnHttpRequestComplete;
import com.devazt.networking.Response;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.json.JSONException;
import org.json.JSONObject;

public class controlTimbradoMovil {
    public static String addTimbrado()
    {
        String msg;
        int cod = Integer.parseInt(dlgTimbradoMovil.txtCod.getText().trim());
        int timbrado = Integer.parseInt(dlgTimbradoMovil.txtTimbrado.getText().trim());
        String desde = dlgTimbradoMovil.txtFDesde.getText().trim();
        String hasta = dlgTimbradoMovil.txtFHasta.getText().trim();
        String autorizacion = dlgTimbradoMovil.txtAutorizacion.getText().trim();
        String fautorizacion = dlgTimbradoMovil.txtFAutori.getText().trim();
        String estado="Activo";
        TimbradoMovil m = new TimbradoMovil(cod, timbrado, desde,hasta, autorizacion, fautorizacion,estado);
        msg = GestionarTimbradoMovil.addTimbrado(m);
        if(msg.equals("OK"))
        {
            Mensajes.informacion("Timbrado Registrado");
        }
        else{
            Mensajes.error(msg);
        }
        return msg;
    }
    
    public static String actTimbrado()
    {
        String msg;
        int cod = Integer.parseInt(dlgTimbradoMovil.txtCod.getText().trim());
        int timbrado = Integer.parseInt(dlgTimbradoMovil.txtTimbrado.getText().trim());
        String desde = dlgTimbradoMovil.txtFDesde.getText().trim();
        String hasta = dlgTimbradoMovil.txtFHasta.getText().trim();
        String autorizacion = dlgTimbradoMovil.txtAutorizacion.getText().trim();
        String fautorizacion = dlgTimbradoMovil.txtFAutori.getText().trim();
        String estado;
        if(dlgTimbradoMovil.cbEstado.isSelected()){
            estado="Activo";
        }else{
            estado="Inactivo";
        }
        TimbradoMovil m = new TimbradoMovil(cod, timbrado, desde,hasta,autorizacion,fautorizacion,estado);
        msg = GestionarTimbradoMovil.actTimbrado(m);
        if(msg.equals("OK"))
        {
            Mensajes.informacion("Timbrado Actualizado");
        }
        else{
            Mensajes.error(msg);
        }
        return msg;
    }
    
    public static String delTimbrado()    
    {
        String msg;
        int cod = Integer.parseInt(dlgTimbradoMovil.txtCod.getText().trim());
        msg = GestionarTimbradoMovil.delTimbrado(cod);
        if(msg.equals("OK"))
        {
            Mensajes.informacion("Timbado desactivado");
        }
        else{
            Mensajes.error(msg);
        }
        return msg;
    }
    
    public static void listTimbrado(JTable tabla)
    {
        try {
            HttpClient timbrado = new HttpClient(new OnHttpRequestComplete() {
                @Override
                public void onComplete(Response status) {
                    if (status.isSuccess()) {
                        try {
                            DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
                            JSONObject jsonProductos = new JSONObject(status.getResult());
                            for (int f = 0; /*f < jsonProductos.length()*/; f++) {
                                Object[] fila = new Object[7];
                                fila[0] = jsonProductos.getJSONObject("" + f + "").get("idtimbrado").toString();
                                fila[1] = jsonProductos.getJSONObject("" + f + "").get("descripcion").toString();
                                fila[2] = jsonProductos.getJSONObject("" + f + "").get("fechadesde").toString();
                                fila[3] = jsonProductos.getJSONObject("" + f + "").get("fechahasta").toString();
                                fila[4] = jsonProductos.getJSONObject("" + f + "").get("nr_autorizacion").toString();
                                fila[5] = jsonProductos.getJSONObject("" + f + "").get("fecha_autorizacion").toString();
                                fila[6] = jsonProductos.getJSONObject("" + f + "").get("estado").toString();
                                tb.addRow(fila);
                            }

                        } catch (JSONException e) {
                        }
                    }
                }
            });

            timbrado.excecute(urlServer() + "getTimbrado.php");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}