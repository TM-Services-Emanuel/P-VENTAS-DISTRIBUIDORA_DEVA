package Controladores;

import Componentes.Login;
import Componentes.Mensajes;
import static Componentes.URL.urlServer;
import Datos.GestionarMotivo;
import IU.dlgMotivo;
import Modelo.Motivo;
import com.devazt.networking.HttpClient;
import com.devazt.networking.OnHttpRequestComplete;
import com.devazt.networking.Response;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.json.JSONException;
import org.json.JSONObject;

public class controlMotivo {

    static String UsuarioL = "";

    public static String addMotivo() {
        String msg;
        int cod = Integer.parseInt(dlgMotivo.txtCod.getText());
        String mot = dlgMotivo.txtMotivo.getText().toUpperCase();
        String usuario = UsuarioL = Login.getUsuarioLogueado();
        Motivo m = new Motivo(cod, mot, usuario);
        msg = GestionarMotivo.addMotivo(m);
        if (msg.equals("OK")) {
            Mensajes.informacion("Motivo Registrado");
        } else {
            Mensajes.error(msg);
        }
        return msg;
    }

    public static String actMotivo() {
        String msg;
        int cod = Integer.parseInt(dlgMotivo.txtCod.getText());
        String mot = dlgMotivo.txtMotivo.getText().toUpperCase();
        UsuarioL = Login.getUsuarioLogueado();
        Motivo m = new Motivo(cod, mot, UsuarioL);
        msg = GestionarMotivo.actMotivo(m);
        if (msg.equals("OK")) {
            Mensajes.informacion("Motivo Actualizado");
        } else {
            Mensajes.error(msg);
        }
        return msg;
    }

    public static String delMotivo() {
        String msg;
        int x = dlgMotivo.tbMotivo.getSelectedRow();
        int cod = Integer.parseInt(dlgMotivo.tbMotivo.getValueAt(x, 0).toString());
        UsuarioL = Login.getUsuarioLogueado();
        Motivo m = new Motivo(cod, UsuarioL);
        msg = GestionarMotivo.delMotivo(m);
        if (msg.equals("OK")) {
            Mensajes.informacion("Motivo Eliminado");
        } else {
            Mensajes.error(msg);
        }
        return msg;
    }

    public static void listMotivo(JTable tabla) {
        try {
            HttpClient motivo = new HttpClient(new OnHttpRequestComplete() {
                @Override
                public void onComplete(Response status) {
                    if (status.isSuccess()) {
                        try {
                            DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
                            JSONObject jsonEmpresa = new JSONObject(status.getResult());
                            for (int f = 0; f < jsonEmpresa.length(); f++) {
                                Object[] fila = new Object[2];
                                fila[0] = jsonEmpresa.getJSONObject("" + f + "").get("mot_codigo").toString();
                                fila[1] = jsonEmpresa.getJSONObject("" + f + "").get("mot_nombre").toString();
                                tb.addRow(fila);
                            }

                        } catch (JSONException e) {
                        }
                    }
                }
            });

            motivo.excecute(urlServer() + "getlistMotivos.php");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
