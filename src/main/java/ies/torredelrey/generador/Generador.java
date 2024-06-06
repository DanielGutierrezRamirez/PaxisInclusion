/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ies.torredelrey.generador;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 * Clase Generador 
 * Para la generación de informes de reservas.
 * Utiliza JasperReports para la generación y visualización de informes.
 * 
 * @version 1.0
 * @autor Daniel Gutierrez Ramirez
 */
public class Generador {

    /**
     * Método para leer y generar un informe de reservas.
     * 
     * @param listaReservas Colección de reservas a incluir en el informe.
     * @param rutaInforme Ruta del archivo de informe Jasper (.jasper).
     * @param nombreInformeSalida Nombre del archivo PDF de salida.
     */
    public static void leerInformeReservas(Collection listaReservas, String rutaInforme, String nombreInformeSalida) {
        try {
            JasperPrint print;
            HashMap<String, Object> param = new HashMap<>();
            param.put("fecha", LocalDate.now().toString());

            JRDataSource datasource = new JRBeanArrayDataSource(listaReservas.toArray());
            print = JasperFillManager.fillReport(rutaInforme, param, datasource);
            JasperExportManager.exportReportToPdfFile(print, nombreInformeSalida);
            JasperViewer.viewReport(print);
        } catch (JRException ex) {
            Logger.getLogger(Generador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}