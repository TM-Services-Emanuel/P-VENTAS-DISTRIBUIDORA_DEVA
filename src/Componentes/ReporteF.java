/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Componentes;

import java.sql.Connection;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.*;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Cris-Men
 */
public class ReporteF {
    
    Connection con;
    static ConexionBD conectar = ConexionBD.getInstancia();
    
    public ReporteF(){
        con = (Connection) conectar.getConexion();
        if (con == null) {
            System.out.println("No hay Conexion con la Base de Datos");
        }
        
    }
    
    public void StockCrGral(String ubicacion){
        try{
            String master=System.getProperty("user.dir")+ubicacion;
            System.out.println("master "+master);
            if (master==null) {
                //System.out.println("NO encuentro el archivo del reporte maestro");
                Mensajes.error("NO encuentro el archivo del reporte maestro");
                //System.exit(2);
            }
            JasperReport masterReport=null;
            try{
                masterReport=(JasperReport) JRLoader.loadObjectFromFile(master);
            }catch(JRException e){
                //System.out.println("Error cargando el reporte maestro: "+e.getMessage());
                Mensajes.error("Error cargando el reporte maestro: "+e.getMessage());
                //System.exit(3);
            }
            //Map parametro= new HashMap<>();
            HashMap<String, Object> parametro = new HashMap<>();
            JasperPrint jasperPrint=JasperFillManager.fillReport(masterReport, parametro,con);
            JasperViewer jviewer=new JasperViewer(jasperPrint,false);
            jviewer.setTitle("Reporte de Articulos con Stock Crítico");
            jviewer.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Iconos/logo1.png")));
            jviewer.setSize(610, 645);
            jviewer.setResizable(false);
            jviewer.setZoomRatio((float) 0.7);
            jviewer.setLocationRelativeTo(null);
            jviewer.setVisible(true);
        }catch(JRException j){
            Mensajes.error("Error:"+j.getMessage());
        }
    }
    public void ListadoArticuloG(String ubicacion){
        try{
            String master=System.getProperty("user.dir")+ubicacion;
            System.out.println("master "+master);
            if (master==null) {
                //System.out.println("NO encuentro el archivo del reporte maestro");
                Mensajes.error("NO encuentro el archivo del reporte maestro");
                //System.exit(2);
            }
            JasperReport masterReport=null;
            try{
                masterReport=(JasperReport) JRLoader.loadObjectFromFile(master);
            }catch(JRException e){
                //System.out.println("Error cargando el reporte maestro: "+e.getMessage());
                Mensajes.error("Error cargando el reporte maestro: "+e.getMessage());
                //System.exit(3);
            }
            //Map parametro= new HashMap<>();
            HashMap<String, Object> parametro = new HashMap<>();
            JasperPrint jasperPrint=JasperFillManager.fillReport(masterReport, parametro,con);
            JasperViewer jviewer=new JasperViewer(jasperPrint,false);
            jviewer.setTitle("Listado de artículos en general");
            jviewer.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Iconos/logo1.png")));
            jviewer.setSize(880, 670);
            jviewer.setResizable(false);
            jviewer.setZoomRatio((float) 0.7);
            jviewer.setLocationRelativeTo(null);
            jviewer.setVisible(true);
        }catch(JRException j){
            Mensajes.error("Error:"+j.getMessage());
        }
    }
    public void StockValorizado(String ubicacion){
        try{
            String master=System.getProperty("user.dir")+ubicacion;
            System.out.println("master "+master);
            if (master==null) {
                //System.out.println("NO encuentro el archivo del reporte maestro");
                Mensajes.error("NO encuentro el archivo del reporte maestro");
                //System.exit(2);
            }
            JasperReport masterReport=null;
            try{
                masterReport=(JasperReport) JRLoader.loadObjectFromFile(master);
            }catch(JRException e){
                //System.out.println("Error cargando el reporte maestro: "+e.getMessage());
                Mensajes.error("Error cargando el reporte maestro: "+e.getMessage());
                //System.exit(3);
            }
            //Map parametro= new HashMap<>();
            HashMap<String, Object> parametro = new HashMap<>();
            JasperPrint jasperPrint=JasperFillManager.fillReport(masterReport, parametro,con);
            JasperViewer jviewer=new JasperViewer(jasperPrint,false);
            jviewer.setTitle("Reporte stock valorizado");
            jviewer.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Iconos/logo1.png")));
            jviewer.setSize(880, 670);
            jviewer.setResizable(false);
            jviewer.setZoomRatio((float) 0.7);
            jviewer.setLocationRelativeTo(null);
            jviewer.setVisible(true);
        }catch(JRException j){
            Mensajes.error("Error:"+j.getMessage());
        }
    }
    public void InventarioArticuloG(String ubicacion){
        try{
            String master=System.getProperty("user.dir")+ubicacion;
            System.out.println("master "+master);
            if (master==null) {
                //System.out.println("NO encuentro el archivo del reporte maestro");
                Mensajes.error("NO encuentro el archivo del reporte maestro");
                //System.exit(2);
            }
            JasperReport masterReport=null;
            try{
                masterReport=(JasperReport) JRLoader.loadObjectFromFile(master);
            }catch(JRException e){
                //System.out.println("Error cargando el reporte maestro: "+e.getMessage());
                Mensajes.error("Error cargando el reporte maestro: "+e.getMessage());
                //System.exit(3);
            }
            //Map parametro= new HashMap<>();
            HashMap<String, Object> parametro = new HashMap<>();
            JasperPrint jasperPrint=JasperFillManager.fillReport(masterReport, parametro,con);
            JasperViewer jviewer=new JasperViewer(jasperPrint,false);
            jviewer.setTitle("Inventario de artículos en general");
            jviewer.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Iconos/logo1.png")));
            jviewer.setSize(610, 645);
            jviewer.setResizable(false);
            jviewer.setZoomRatio((float) 0.7);
            jviewer.setLocationRelativeTo(null);
            jviewer.setVisible(true);
        }catch(JRException j){
            Mensajes.error("Error:"+j.getMessage());
        }
    }
    
    public void StockCrL(String ubicacion,String Nombrepar,Integer Valor_p1){
        try{
            String master=System.getProperty("user.dir")+ubicacion;
            System.out.println("master "+master);
            if (master==null) {
                System.out.println("NO encuentro el archivo del reporte maestro");
                //System.exit(2);
            }
            JasperReport masterReport =null;
            try{
                masterReport=(JasperReport) JRLoader.loadObjectFromFile(master);
            }catch(JRException e){
                System.out.println("Error cargando el reporte maestro: "+e.getMessage());
                //System.exit(3);
            }
            //Map parametro= new HashMap();
            Map<String, Object> parametro = new HashMap<>();
            parametro.put(Nombrepar, Valor_p1);
            JasperPrint jasperPrint=JasperFillManager.fillReport(masterReport, parametro, con);
            JasperViewer jviewer = new JasperViewer(jasperPrint,false);
            jviewer.setTitle("Reporte de Articulos con Stock Crítico");
            jviewer.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Iconos/logo1.png")));
            jviewer.setSize(610, 645);
            jviewer.setResizable(false);
            jviewer.setZoomRatio((float) 0.7);
            jviewer.setLocationRelativeTo(null);
            jviewer.setVisible(true);

        }catch(JRException j){
        Mensajes.error("Error:"+j.getMessage());
        }
    }
    
    public void StockValorizadoL(String ubicacion,String Nombrepar,Integer Valor_p1){
        try{
            String master=System.getProperty("user.dir")+ubicacion;
            System.out.println("master "+master);
            if (master==null) {
                System.out.println("NO encuentro el archivo del reporte maestro");
                //System.exit(2);
            }
            JasperReport masterReport =null;
            try{
                masterReport=(JasperReport) JRLoader.loadObjectFromFile(master);
            }catch(JRException e){
                System.out.println("Error cargando el reporte maestro: "+e.getMessage());
                //System.exit(3);
            }
            //Map parametro= new HashMap();
            Map<String, Object> parametro = new HashMap<>();
            parametro.put(Nombrepar, Valor_p1);
            JasperPrint jasperPrint=JasperFillManager.fillReport(masterReport, parametro, con);
            JasperViewer jviewer = new JasperViewer(jasperPrint,false);
            jviewer.setTitle("Reporte stock valorizado");
            jviewer.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Iconos/logo1.png")));
            jviewer.setSize(880, 670);
            jviewer.setResizable(false);
            jviewer.setZoomRatio((float) 0.7);
            jviewer.setLocationRelativeTo(null);
            jviewer.setVisible(true);

        }catch(JRException j){
        Mensajes.error("Error:"+j.getMessage());
        }
    }
    
    
    public void ListadoArticuloL(String ubicacion,String Nombrepar,Integer Valor_p1){
        try{
            String master=System.getProperty("user.dir")+ubicacion;
            System.out.println("master "+master);
            if (master==null) {
                System.out.println("NO encuentro el archivo del reporte maestro");
                //System.exit(2);
            }
            JasperReport masterReport =null;
            try{
                masterReport=(JasperReport) JRLoader.loadObjectFromFile(master);
            }catch(JRException e){
                System.out.println("Error cargando el reporte maestro: "+e.getMessage());
                //System.exit(3);
            }
            //Map parametro= new HashMap();
            Map<String, Object> parametro = new HashMap<>();
            parametro.put(Nombrepar, Valor_p1);
            JasperPrint jasperPrint=JasperFillManager.fillReport(masterReport, parametro, con);
            JasperViewer jviewer = new JasperViewer(jasperPrint,false);
            jviewer.setTitle("Listado de artículos por  laboratorio");
            jviewer.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Iconos/logo1.png")));
            jviewer.setSize(880, 670);
            jviewer.setResizable(false);
            jviewer.setZoomRatio((float) 0.7);
            jviewer.setLocationRelativeTo(null);
            jviewer.setVisible(true);

        }catch(JRException j){
        Mensajes.error("Error:"+j.getMessage());
        }
    }
    
    public void InventarioArticuloL(String ubicacion,String Nombrepar,Integer Valor_p1){
        try{
            String master=System.getProperty("user.dir")+ubicacion;
            System.out.println("master "+master);
            if (master==null) {
                System.out.println("NO encuentro el archivo del reporte maestro");
                //System.exit(2);
            }
            JasperReport masterReport =null;
            try{
                masterReport=(JasperReport) JRLoader.loadObjectFromFile(master);
            }catch(JRException e){
                System.out.println("Error cargando el reporte maestro: "+e.getMessage());
                //System.exit(3);
            }
            //Map parametro= new HashMap();
            Map<String, Object> parametro = new HashMap<>();
            parametro.put(Nombrepar, Valor_p1);
            JasperPrint jasperPrint=JasperFillManager.fillReport(masterReport, parametro, con);
            JasperViewer jviewer = new JasperViewer(jasperPrint,false);
            jviewer.setTitle("Inventario de artículos por Laboratorio");
            jviewer.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Iconos/logo1.png")));
            jviewer.setSize(610, 645);
            jviewer.setResizable(false);
            jviewer.setZoomRatio((float) 0.7);
            jviewer.setLocationRelativeTo(null);
            jviewer.setVisible(true);

        }catch(JRException j){
        Mensajes.error("Error:"+j.getMessage());
        }
    }
    
    public void reporteUnParametroVertical(String ubicacion, String Nombrepar, Integer Valor_p1){
        try{
            String master=System.getProperty("user.dir")+ubicacion;
            System.out.println("master "+master);
            if (master==null) {
                System.out.println("NO encuentro el archivo del reporte maestro");
            }
            JasperReport masterReport =null;
            try{
                masterReport= (JasperReport) JRLoader.loadObjectFromFile(master);
            }catch(JRException e){
                System.out.println("Error cargando el reporte maestro: "+e.getMessage());
            }
            //Map parametro= new HashMap();
            Map<String, Object> parametro = new HashMap<>();
            parametro.put(Nombrepar, Valor_p1);
            JasperPrint jasperPrint = JasperFillManager.fillReport(masterReport, parametro, con);
            JasperViewer jviewer = new JasperViewer(jasperPrint,false);
            jviewer.setTitle("Reporte");
            jviewer.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Iconos/logo1.png")));
            jviewer.setSize(610, 645);
            jviewer.setResizable(false);
            jviewer.setZoomRatio((float) 0.7);
            jviewer.setLocationRelativeTo(null);
            jviewer.setVisible(true);

        }catch(JRException j){
        Mensajes.error("Error:"+j.getMessage());
        }
    }
    
    public void reporte3ParametroVertical(String ubicacion,String codVend,Integer Valor_p1,String fechaD, Date Valor_p2, String fechaH, Date Valor_p3){
        try{
            String master=System.getProperty("user.dir")+ubicacion;
            System.out.println("master "+master);
            if (master==null) {
                System.out.println("NO encuentro el archivo del reporte maestro");
                //System.exit(2);
            }
            JasperReport masterReport =null;
            try{
                masterReport=(JasperReport) JRLoader.loadObjectFromFile(master);
            }catch(JRException e){
                System.out.println("Error cargando el reporte maestro: "+e.getMessage());
                //System.exit(3);
            }
            //Map parametro= new HashMap();
            Map<String, Object> parametro = new HashMap<>();
            parametro.put(fechaD, Valor_p2);
            parametro.put(fechaH, Valor_p3);
            parametro.put(codVend, Valor_p1);
            JasperPrint jasperPrint=JasperFillManager.fillReport(masterReport, parametro, con);
            JasperViewer jviewer = new JasperViewer(jasperPrint,false);
            jviewer.setTitle("Reporte");
            jviewer.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Iconos/logo1.png")));
            jviewer.setSize(610, 645);
            jviewer.setResizable(false);
            jviewer.setZoomRatio((float) 0.7);
            jviewer.setLocationRelativeTo(null);
            jviewer.setVisible(true);

        }catch(JRException j){
        Mensajes.error("Error:"+j.getMessage());
        }
    }
    
    public void reporteDosParametroHorizontal(String ubicacion,String fechaD,Date Valor_p1,String fechaH,Date Valor_p2){
        try{
            String master=System.getProperty("user.dir")+ubicacion;
            System.out.println("master "+master);
            if (master==null) {
                System.out.println("NO encuentro el archivo del reporte maestro");
                //System.exit(2);
            }
            JasperReport masterReport =null;
            try{
                masterReport=(JasperReport) JRLoader.loadObjectFromFile(master);
            }catch(JRException e){
                System.out.println("Error cargando el reporte maestro: "+e.getMessage());
                //System.exit(3);
            }
            //Map parametro= new HashMap();
            Map<String, Object> parametro = new HashMap<>();
            parametro.put(fechaD, Valor_p1);
            parametro.put(fechaH, Valor_p2);
            JasperPrint jasperPrint=JasperFillManager.fillReport(masterReport, parametro, con);
            JasperViewer jviewer = new JasperViewer(jasperPrint,false);
            jviewer.setTitle("Reporte");
            jviewer.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Iconos/logo1.png")));
            jviewer.setSize(880, 670);
            jviewer.setResizable(false);
            jviewer.setZoomRatio((float) 0.7);
            jviewer.setLocationRelativeTo(null);
            jviewer.setVisible(true);

        }catch(JRException j){
        Mensajes.error("Error:"+j.getMessage());
        }
    }
    
    public void reporteTresParametroHorizontal(String ubicacion,String codLab,int Valor_p1,String fechaD,Date Valor_p2,String fechaH,Date Valor_p3){
        try{
            String master=System.getProperty("user.dir")+ubicacion;
            System.out.println("master "+master);
            if (master==null) {
                System.out.println("NO encuentro el archivo del reporte maestro");
                //System.exit(2);
            }
            JasperReport masterReport =null;
            try{
                masterReport=(JasperReport) JRLoader.loadObjectFromFile(master);
            }catch(JRException e){
                System.out.println("Error cargando el reporte maestro: "+e.getMessage());
                //System.exit(3);
            }
            //Map parametro= new HashMap();
            Map<String, Object> parametro = new HashMap<>();
            parametro.put(codLab, Valor_p1);
            parametro.put(fechaD, Valor_p2);
            parametro.put(fechaH, Valor_p3);
            JasperPrint jasperPrint=JasperFillManager.fillReport(masterReport, parametro, con);
            JasperViewer jviewer = new JasperViewer(jasperPrint,false);
            jviewer.setTitle("Reporte");
            jviewer.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Iconos/logo1.png")));
            jviewer.setSize(880, 670);
            jviewer.setResizable(false);
            jviewer.setZoomRatio((float) 0.7);
            jviewer.setLocationRelativeTo(null);
            jviewer.setVisible(true);

        }catch(JRException j){
        Mensajes.error("Error:"+j.getMessage());
        }
    }
     
    public void Historial_de_compras(String ubicacion,String Nombrepar,Integer Valor_p1){
        try{
            String master=System.getProperty("user.dir")+ubicacion;
            System.out.println("master "+master);
            if (master==null) {
                System.out.println("NO encuentro el archivo del reporte maestro");
                //System.exit(2);
            }
            JasperReport masterReport =null;
            try{
                masterReport=(JasperReport) JRLoader.loadObjectFromFile(master);
            }catch(JRException e){
                System.out.println("Error cargando el reporte maestro: "+e.getMessage());
                //System.exit(3);
            }
            //Map parametro= new HashMap();
            Map<String, Object> parametro = new HashMap<>();
            parametro.put(Nombrepar, Valor_p1);
            JasperPrint jasperPrint=JasperFillManager.fillReport(masterReport, parametro, con);
            JasperViewer jviewer = new JasperViewer(jasperPrint,false);
            jviewer.setTitle("Historial de Compras por Artículos");
            jviewer.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Iconos/logo1.png")));
            jviewer.setSize(930, 550);
            jviewer.setResizable(false);
            jviewer.setZoomRatio((float) 0.7);
            jviewer.setLocationRelativeTo(null);
            jviewer.setVisible(true);

        }catch(JRException j){
        Mensajes.error("Error:"+j.getMessage());
        }
    }
    public void BoletaCredito(String ubicacion,String Nombrepar,Integer Valor_p1){
        try{
            String master=System.getProperty("user.dir")+ubicacion;
            System.out.println("master "+master);
            if (master==null) {
                System.out.println("NO encuentro el archivo del reporte maestro");
                //System.exit(2);
            }
            JasperReport masterReport =null;
            try{
                masterReport=(JasperReport) JRLoader.loadObjectFromFile(master);
            }catch(JRException e){
                System.out.println("Error cargando el reporte maestro: "+e.getMessage());
                //System.exit(3);
            }
            //Map parametro= new HashMap();
            Map<String, Object> parametro = new HashMap<>();
            parametro.put(Nombrepar, Valor_p1);
            JasperPrint jasperPrint=JasperFillManager.fillReport(masterReport, parametro, con);
            JasperPrintManager.printReport(jasperPrint, false);
            //JasperViewer jviewer = new JasperViewer(jasperPrint,false);
            //jviewer.setTitle("Boleta Crédito");
            //jviewer.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Iconos/logo1.png")));
            //jviewer.setSize(610, 430);
            //jviewer.setResizable(false);
            //jviewer.setZoomRatio((float) 0.7);
            //jviewer.setLocationRelativeTo(null);
            //jviewer.setVisible(true);

        }catch(JRException j){
        Mensajes.error("Error:"+j.getMessage());
        }
    }   
    
    public void FacturaLegal(String ubicacion,String Nombrepar,Integer Valor_p1, String Nombrepar2, String Valor_p2){
        try{
            String master=System.getProperty("user.dir")+ubicacion;
            System.out.println("master "+master);
            if (master==null) {
                System.out.println("NO encuentro el archivo del reporte maestro");
                //System.exit(2);
            }
            JasperReport masterReport =null;
            try{
                masterReport=(JasperReport) JRLoader.loadObjectFromFile(master);
            }catch(JRException e){
                System.out.println("Error cargando el reporte maestro: "+e.getMessage());
                //System.exit(3);
            }
            //Map parametro= new HashMap();
            Map<String, Object> parametro = new HashMap<>();
            parametro.put(Nombrepar, Valor_p1);
            parametro.put(Nombrepar2, Valor_p2);
            JasperPrint jasperPrint=JasperFillManager.fillReport(masterReport, parametro, con);
            JasperPrintManager.printReport(jasperPrint, false);
            //JasperViewer jviewer = new JasperViewer(jasperPrint,false);
            //jviewer.setTitle("Factura Legal");
            //jviewer.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Iconos/logo1.png")));
           // jviewer.setSize(610, 430);
            //jviewer.setResizable(false);
            //jviewer.setZoomRatio((float) 0.7);
            //jviewer.setLocationRelativeTo(null);
            //jviewer.setVisible(true);

        }catch(JRException j){
        Mensajes.error("Error:"+j.getMessage());
        }
    } 
    
    public void FacturaLegal_m(String ubicacion,String Nombrepar,Integer Valor_p1, String Nombrepar2, Integer Valor_p2, String Nombrepar3, String Valor_p3){
        try{
            String master=System.getProperty("user.dir")+ubicacion;
            System.out.println("master "+master);
            if (master==null) {
                System.out.println("NO encuentro el archivo del reporte maestro");
                //System.exit(2);
            }
            JasperReport masterReport =null;
            try{
                masterReport=(JasperReport) JRLoader.loadObjectFromFile(master);
            }catch(JRException e){
                System.out.println("Error cargando el reporte maestro: "+e.getMessage());
                //System.exit(3);
            }
            //Map parametro= new HashMap();
            Map<String, Object> parametro = new HashMap<>();
            parametro.put(Nombrepar, Valor_p1);
            parametro.put(Nombrepar2, Valor_p2);
            parametro.put(Nombrepar3, Valor_p3);
            JasperPrint jasperPrint=JasperFillManager.fillReport(masterReport, parametro, con);
            JasperPrintManager.printReport(jasperPrint, false);
            //JasperViewer jviewer = new JasperViewer(jasperPrint,false);
            //jviewer.setTitle("Factura Legal");
            //jviewer.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Iconos/logo1.png")));
           // jviewer.setSize(610, 430);
            //jviewer.setResizable(false);
            //jviewer.setZoomRatio((float) 0.7);
            //jviewer.setLocationRelativeTo(null);
            //jviewer.setVisible(true);

        }catch(JRException j){
        Mensajes.error("Error:"+j.getMessage());
        }
    }
    
    public void BoletaCreditoRE(String ubicacion,String Nombrepar,Integer Valor_p1){
        try{
            String master=System.getProperty("user.dir")+ubicacion;
            System.out.println("master "+master);
            if (master==null) {
                System.out.println("NO encuentro el archivo del reporte maestro");
                //System.exit(2);
            }
            JasperReport masterReport =null;
            try{
                masterReport=(JasperReport) JRLoader.loadObjectFromFile(master);
            }catch(JRException e){
                System.out.println("Error cargando el reporte maestro: "+e.getMessage());
                //System.exit(3);
            }
            //Map parametro= new HashMap();
            Map<String, Object> parametro = new HashMap<>();
            parametro.put(Nombrepar, Valor_p1);
            JasperPrint jasperPrint=JasperFillManager.fillReport(masterReport, parametro, con);
            JasperPrintManager.printReport(jasperPrint, false);
            //JasperViewer jviewer = new JasperViewer(jasperPrint,false);
            //jviewer.setTitle("Boleta Crédito - Re-Impresión");
            //jviewer.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Iconos/logo1.png")));
            //jviewer.setSize(610, 430);
            //jviewer.setResizable(false);
            //jviewer.setZoomRatio((float) 0.7);
            //jviewer.setLocationRelativeTo(null);
            //jviewer.setVisible(true);

        }catch(JRException j){
        Mensajes.error("Error:"+j.getMessage());
        }
    }   
    
    public void cerrar(){
    try{
        con.close();
    }catch(SQLException ex){
        ex.getMessage();
    }
    }
    
}
