package Controladores;

import Componentes.Login;
import Componentes.Mensajes;
import static Componentes.URL.urlServer;
import Datos.GestionarEmpresa;
import IU.dlgEmpresa;
import Modelo.Empresa;
import com.devazt.networking.OnHttpRequestComplete;
import com.devazt.networking.Response;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.json.JSONException;
import org.json.JSONObject;
import com.devazt.networking.HttpClient;

public class controlEmpresa {

    static String UsuarioL = "";
    static String codCiudad;

    public static String addEmpresa() {
        String msg;
        int cod = Integer.parseInt(dlgEmpresa.txtCod.getText());
        String nombre = dlgEmpresa.txtNombre.getText().toUpperCase();
        String ruc = dlgEmpresa.txtRuc.getText().toUpperCase();
        String direccion = dlgEmpresa.txtDireccion.getText().toUpperCase();
        String telefono = dlgEmpresa.txtTelefono.getText().toUpperCase();
        int idciudad = Integer.parseInt(dlgEmpresa.lbCiudad.getText());
        Empresa e = new Empresa(cod, nombre, ruc, direccion, telefono, idciudad);
        msg = GestionarEmpresa.addEmpresa(e);
        if (msg.equals("OK")) {
            Mensajes.informacion("Empresa Registrada");
        } else {
            Mensajes.error(msg);
        }
        return msg;
    }

    public static String actEmpresa() {
        String msg;
        int cod = Integer.parseInt(dlgEmpresa.txtCod.getText());
        String nombre = dlgEmpresa.txtNombre.getText().toUpperCase();
        String ruc = dlgEmpresa.txtRuc.getText().toUpperCase();
        String direccion = dlgEmpresa.txtDireccion.getText().toUpperCase();
        String telefono = dlgEmpresa.txtTelefono.getText().toUpperCase();
        String ciudad;
        if(dlgEmpresa.cboCiudad.getSelectedItem().toString().contains(" ")){
            ciudad = dlgEmpresa.cboCiudad.getSelectedItem().toString().replace(" ", "%20");
        }else{
            ciudad = dlgEmpresa.cboCiudad.getSelectedItem().toString();
        }
        try {
            HttpClient idCiudad = new HttpClient(new OnHttpRequestComplete() {
                @Override
                public void onComplete(Response status) {
                    if (status.isSuccess()) {
                        try {
                            JSONObject jsonIDCiudad = new JSONObject(status.getResult());
                            for (int f = 0;; f++) {
                                codCiudad = jsonIDCiudad.getJSONObject("" + f + "").get("idciudad").toString();    
                            }
                        } catch (Exception e) {}
                    }
                }
            });
            
            idCiudad.excecute(urlServer()+"getIDCiudad.php?ciudad="+ciudad);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        String visual = dlgEmpresa.lbvisual.getText().toUpperCase();
        System.out.println(visual);
        String usuario = UsuarioL = Login.getUsuarioLogueado();
        Empresa e = new Empresa(cod, nombre, ruc, direccion, telefono, Integer.parseInt(codCiudad));
        msg = GestionarEmpresa.actEmpresa(e);
        if (msg.equals("OK")) {
            Mensajes.informacion("Empresa Actualizada");
        } else {
            Mensajes.error(msg);
        }
        return msg;
    }

    public static String delEmpresa() {
        String msg;
        String cod = dlgEmpresa.txtCod.getText();
        msg = GestionarEmpresa.delEmpresa(cod);
        if (msg.equals("OK")) {
            Mensajes.informacion("Empresa Eliminada");
        } else {
            Mensajes.error(msg);
        }
        return msg;
    }

    public static void lisEmpresa(JTable tabla) {
        try {
            HttpClient empresa = new HttpClient(new OnHttpRequestComplete() {
                @Override
                public void onComplete(Response status) {
                    if (status.isSuccess()) {
                        try {
                            DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
                            JSONObject jsonEmpresa = new JSONObject(status.getResult());
                            for (int f = 0; /*f < jsonEmpresa.length()*/; f++) {
                                Object[] fila = new Object[8];
                                fila[0] = jsonEmpresa.getJSONObject("" + f + "").get("idempresa").toString();
                                fila[1] = jsonEmpresa.getJSONObject("" + f + "").get("razon_social").toString();
                                fila[2] = jsonEmpresa.getJSONObject("" + f + "").get("ruc").toString();
                                fila[3] = jsonEmpresa.getJSONObject("" + f + "").get("direccion").toString();
                                fila[4] = jsonEmpresa.getJSONObject("" + f + "").get("telefono").toString();
                                fila[5] = jsonEmpresa.getJSONObject("" + f + "").get("estado").toString();
                                fila[6] = jsonEmpresa.getJSONObject("" + f + "").get("idciudad").toString();
                                fila[7] = jsonEmpresa.getJSONObject("" + f + "").get("ciudad").toString();
                                tb.addRow(fila);
                            }

                        } catch (JSONException e) {
                        }
                    }
                }
            });

            empresa.excecute(urlServer() + "getv_empresa1.php");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
