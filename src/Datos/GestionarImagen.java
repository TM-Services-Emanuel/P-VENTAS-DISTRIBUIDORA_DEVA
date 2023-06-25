package Datos;

import Componentes.Mensajes;
import Componentes.Operacion;
import static Componentes.URL.urlServer;
import Componentes.generarCodigos;
import Modelo.Imagen;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONObject;

public class GestionarImagen {
    
    public static String getCodigo() {
        String cod = generarCodigos.getCodigo("SELECT MAX(img_cod) FROM imagen");
        return cod;
    }
    
    public static String addImagen(Imagen i) {
        String msg;
        StringBuilder sql = new StringBuilder("INSERT INTO imagen VALUES (");
        sql.append(getCodigo()).append(",'").append(i.getImgFondo()).append("','N')");
        msg = Operacion.exeOperacion(sql.toString());
        return msg;
    }
    
    public static Imagen busImage(String cod) {
        Imagen im = null;
        String sql = "SELECT * FROM imagen WHERE img_cod=" + cod + "";
        Object[] filaObt = Operacion.getFila(sql);
        if (filaObt != null) {
            im = new Imagen();
            im.setImgCod(Integer.parseInt(filaObt[0].toString()));
            im.setImgFondo(filaObt[1].toString());
        } else {
            System.out.println("No se encontro imagen");
        }
        return im;
    }
    
    public static Imagen fondoPrincipal() {
        Imagen im = null;
        try {
            URL url = new URL(urlServer()+"getFondoPrincipal.php");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            
            int ResponseCod = conn.getResponseCode();
            
            if (ResponseCod != 200) {
                throw new RuntimeException("Ocurrio un error: " + ResponseCod);
            } else {
                StringBuilder fondoPrincipal = new StringBuilder();
                Scanner scan = new Scanner(url.openStream());
                while (scan.hasNext()) {
                    fondoPrincipal.append(scan.nextLine());
                }
                scan.close();
                
                JSONArray jsonfP = new JSONArray(fondoPrincipal.toString());
                if (jsonfP.length() != 0) {
                    JSONObject objectfP = jsonfP.getJSONObject(0);
                    im = new Imagen();
                    im.setImgCod(Integer.parseInt(objectfP.getString("img_cod")));
                    im.setImgFondo(objectfP.getString("img_fondo"));
                    System.out.println("Encontrado :" + objectfP.getString("img_fondo"));
                } else {
                    System.out.println("Imagen no encontrado");
                }
            }
        } catch (Exception e) {
            Mensajes.error("err_fondoPrincipal: " + e.getMessage());
        }
        return im;
    }
    
    public static String quitarFondo() {
        String msg;
        String sql = "UPDATE imagen SET img_estado='N'";
        msg = Operacion.exeOperacion(sql);
        System.out.println("Pase por quitarFondo");
        return msg;
    }
    
    public static void establecerFondo(String cod) {
        String msg;
        System.out.println("Codigo de establecer Fondo: " + cod);
        String sql = "UPDATE imagen SET img_estado='S' WHERE img_cod=" + cod + "";
        msg = Operacion.exeOperacion(sql);
        System.out.println("Pase por establecerFondo");
    }
    
}
