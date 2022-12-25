/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esta;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author edson
 */
public final class reportesgrandes extends javax.swing.JPanel{
    
    Dconexion con = new Dconexion();
    Connection conexion= null;
    Statement st;
    ResultSet rs;
    DefaultTableModel columnasm;
       
    int idc;
    
    void rellenatablasNTodo(){
        Date desde=  desdeChooser.getDate();
        Date hasta=  hastaChooser.getDate();
        long d = desde.getTime();
        long h = hasta.getTime();
        java.sql.Date desdef = new java.sql.Date(d);
        java.sql.Date hastaf = new java.sql.Date(h);
        String sql =  "SELECT (Select count(tipoV) FROM vehiculo where tipoV='Motocicleta' and horaEntrada>=\""+desdef+" 00:00:00\" and horaSalida <=\""+hastaf+" 23:59:59\" and tipoServicio='Estacionamiento')as im,"
                           + "(SELECT count(tipoV) FROM vehiculo where tipoV='Motocicleta' and horaEntrada>=\""+desdef+" 00:00:00\" and horaEntrada<=\""+desdef+" 23:59:59\" and tipoServicio='Lava autos')as im2,"
                           + "(SELECT count(tipoV) FROM vehiculo where tipoV='Motocicleta' and horaEntrada>=\""+desdef+" 00:00:00\" and horaSalida <=\""+hastaf+" 23:59:00\" and tipoServicio='Estacionamiento y lava autos') as im3,"
                           + "(SELECT count(tipoV) FROM vehiculo where tipoV='Motocicleta' and horaEntrada>=\""+desdef+" 00:00:00\" and horaEntrada<=\""+desdef+" 23:59:59\" and tipoServicio='Pension') as im4,"
                           + "(SELECT count(tipoV) FROM vehiculo where tipoV='Motocicleta' and horaEntrada>=\""+desdef+" 00:00:00\" and horaSalida <=\""+hastaf+" 23:59:00\" and tipoServicio='Pension por noche') as im5;";
        String sql1 = "SELECT (Select count(tipoV) FROM vehiculo where tipoV='Automovil' and horaEntrada>=\""+desdef+" 00:00:00\" and horaSalida <=\""+hastaf+" 23:59:59\" and tipoServicio='Estacionamiento')as ia,"
                           + "(SELECT count(tipoV) FROM vehiculo where tipoV='Automovil' and horaEntrada>=\""+desdef+" 00:00:00\" and horaEntrada<=\""+desdef+" 23:59:59\" and tipoServicio='Lava autos')as ia2,"
                           + "(SELECT count(tipoV) FROM vehiculo where tipoV='Automovil' and horaEntrada>=\""+desdef+" 00:00:00\" and horaSalida <=\""+hastaf+" 23:59:00\" and tipoServicio='Estacionamiento y lava autos') as ia3,"
                           + "(SELECT count(tipoV) FROM vehiculo where tipoV='Automovil' and horaEntrada>=\""+desdef+" 00:00:00\" and horaEntrada<=\""+desdef+" 23:59:59\" and tipoServicio='Pension') as ia4,"
                           + "(SELECT count(tipoV) FROM vehiculo where tipoV='Automovil' and horaEntrada>=\""+desdef+" 00:00:00\" and horaSalida <=\""+hastaf+" 23:59:00\" and tipoServicio='Pension por noche') as ia5;";
        String sql2 = "SELECT (Select count(tipoV) FROM vehiculo where tipoV='Camioneta' and horaEntrada>=\""+desdef+" 00:00:00\" and horaSalida <=\""+hastaf+" 23:59:59\" and tipoServicio='Estacionamiento')as ic,"
                           + "(SELECT count(tipoV) FROM vehiculo where tipoV='Camioneta' and horaEntrada>=\""+desdef+" 00:00:00\" and horaEntrada<=\""+desdef+" 23:59:59\" and tipoServicio='Lava autos')as ic2,"
                           + "(SELECT count(tipoV) FROM vehiculo where tipoV='Camioneta' and horaEntrada>=\""+desdef+" 00:00:00\" and horaSalida <=\""+hastaf+" 23:59:00\" and tipoServicio='Estacionamiento y lava autos') as ic3,"
                           + "(SELECT count(tipoV) FROM vehiculo where tipoV='Camioneta' and horaEntrada>=\""+desdef+" 00:00:00\" and horaEntrada<=\""+desdef+" 23:59:59\" and tipoServicio='Pension') as ic4,"
                           + "(SELECT count(tipoV) FROM vehiculo where tipoV='Camioneta' and horaEntrada>=\""+desdef+" 00:00:00\" and horaSalida <=\""+hastaf+" 23:59:00\" and tipoServicio='Pension por noche') as ic5;";
//-----------------------------------------------------------------------------------------------------------
        // Rellena tabla  ingreso de motos desde cierta fecha hasta otra
        try {
            conexion = Dconexion.getConnection();;
            st = conexion.createStatement();
            rs = st.executeQuery(sql);
            
            Object[] dato = new Object[1];
            columnasm = (DefaultTableModel) reportesM.getModel();
            columnasm.setColumnCount(0);
            columnasm.setNumRows(0);    
            
            
            columnasm.addColumn("Motos atendidas");
            
                    
            while (rs.next()) {
                int n=rs.getInt("im");
                int n1=rs.getInt("im2");
                int n2=rs.getInt("im3");
                int n3=rs.getInt("im4");
                int n4=rs.getInt("im5");
                
                int n5 = (n+n1+n2+n3+n4);
                dato[0]=n5;
                columnasm.addRow(dato);  
               }
            reportesM.setModel(columnasm);
        } catch (SQLException ex) {
            Logger.getLogger(reportesgrandes.class.getName()).log(Level.SEVERE, null, ex);
        }
        //-----------------------------------------------------------------------------------------------------------
        // Rellena tabla  ingreso de carros desde cierta fecha hasta otra
        try {
            conexion = Dconexion.getConnection();;
            st = conexion.createStatement();
            rs = st.executeQuery(sql1);
            
            Object[] dato = new Object[1];
            columnasm = (DefaultTableModel) reportesCN.getModel();
            columnasm.setColumnCount(0);
            columnasm.setNumRows(0);    
            
            
            columnasm.addColumn("Autos atendidos");
            
                    
            while (rs.next()) {
                int n=rs.getInt("ia");
                int n1=rs.getInt("ia2");
                int n2=rs.getInt("ia3");
                int n3=rs.getInt("ia4");
                int n4=rs.getInt("ia5");
                
                int n5 = (n+n1+n2+n3+n4);
                dato[0]=n5;
                columnasm.addRow(dato);  
               }
            reportesCN.setModel(columnasm);
        } catch (SQLException ex) {
            Logger.getLogger(reportesgrandes.class.getName()).log(Level.SEVERE, null, ex);
        }
        //-----------------------------------------------------------------------------------------------------------
        // Rellena tabla  ingreso de camionetas desde cierta fecha hasta otra
        try {
            conexion = Dconexion.getConnection();;
            st = conexion.createStatement();
            rs = st.executeQuery(sql2);
            
            Object[] dato = new Object[1];
            columnasm = (DefaultTableModel) reportesCAN.getModel();
            columnasm.setColumnCount(0);
            columnasm.setNumRows(0);    
            
            
            columnasm.addColumn("Camionetas atendidas");
            
                    
            while (rs.next()) {
                int n=rs.getInt("ic");
                int n1=rs.getInt("ic2");
                int n2=rs.getInt("ic3");
                int n3=rs.getInt("ic4");
                int n4=rs.getInt("ic5");
                
                int n5 = (n+n1+n2+n3+n4);
                dato[0]=n5;
                columnasm.addRow(dato);  
               }
            reportesCAN.setModel(columnasm);
        } catch (SQLException ex) {
            Logger.getLogger(reportesgrandes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @SuppressWarnings("empty-statement")
    void rellenatablasNEst(){
        setVisible(true);
        Date desde=  desdeChooser.getDate();
        Date hasta=  hastaChooser.getDate();
        long d = desde.getTime();
        long h = hasta.getTime();
        java.sql.Date desdef = new java.sql.Date(d);
        java.sql.Date hastaf = new java.sql.Date(h);
        String sql =  "SELECT count(tipoV) FROM vehiculo where tipoV='Motocicleta' and horaEntrada >=\""+desdef+" 00:00:00\" and horaSalida <=\""+hastaf+" 23:59:59\" and tipoServicio='Estacionamiento';";
        String sql1 = "SELECT count(tipoV) FROM vehiculo where tipoV='Automovil'   and horaEntrada >=\""+desdef+" 00:00:00\" and horaSalida <=\""+hastaf+" 23:59:59\" and tipoServicio='Estacionamiento';";
        String sql2 = "SELECT count(tipoV) FROM vehiculo where tipoV='Camioneta'   and horaEntrada >=\""+desdef+" 00:00:00\" and horaSalida <=\""+hastaf+" 23:59:59\" and tipoServicio='Estacionamiento';";
        //-----------------------------------------------------------------------------------------------------------
        // Rellena tabla  ingreso de motos desde cierta fecha hasta otra
        try {
            conexion = Dconexion.getConnection();;
            st = conexion.createStatement();
            rs = st.executeQuery(sql);
            
            Object[] dato = new Object[1];
            columnasm = (DefaultTableModel) reportesM.getModel();
            columnasm.setColumnCount(0);
            columnasm.setNumRows(0);    
            
            
            columnasm.addColumn("Total Motos Ingresadas");
            
                    
            while (rs.next()) {
                dato[0]=rs.getInt("count(tipoV)");
                columnasm.addRow(dato);  
               }
            reportesM.setModel(columnasm);
        } catch (SQLException ex) {
            Logger.getLogger(reportesgrandes.class.getName()).log(Level.SEVERE, null, ex);
        }
        //-----------------------------------------------------------------------------------------------------------
        // Rellena tabla  ingreso de carros desde cierta fecha hasta otra
        try {
            conexion = Dconexion.getConnection();;
            st = conexion.createStatement();
            rs = st.executeQuery(sql1);
            
            Object[] dato = new Object[1];
            columnasm = (DefaultTableModel) reportesCN.getModel();
            columnasm.setColumnCount(0);
            columnasm.setNumRows(0);    
            
            
            columnasm.addColumn("Total Autos Ingresados");
            
                    
            while (rs.next()) {
                dato[0]=rs.getInt("count(tipoV)");
                columnasm.addRow(dato);  
               }
            reportesCN.setModel(columnasm);
        } catch (SQLException ex) {
            Logger.getLogger(reportesgrandes.class.getName()).log(Level.SEVERE, null, ex);
        }
        //-----------------------------------------------------------------------------------------------------------
        // Rellena tabla  ingreso de camionetas desde cierta fecha hasta otra
        try {
            conexion = Dconexion.getConnection();;
            st = conexion.createStatement();
            rs = st.executeQuery(sql2);
            
            Object[] dato = new Object[1];
            columnasm = (DefaultTableModel) reportesCAN.getModel();
            columnasm.setColumnCount(0);
            columnasm.setNumRows(0);    
            
            
            columnasm.addColumn("Total Camionetas Ingresadas");
            
                    
            while (rs.next()) {
                dato[0]=rs.getInt("count(tipoV)");
                columnasm.addRow(dato);  
               }
            reportesCAN.setModel(columnasm);
        } catch (SQLException ex) {
            Logger.getLogger(reportesgrandes.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    } 
    
    void rellenatablasNLa(){
        setVisible(true);
        Date desde=  desdeChooser.getDate();
        Date hasta=  hastaChooser.getDate();
        long d = desde.getTime();
        long h = hasta.getTime();
        java.sql.Date desdef = new java.sql.Date(d);
        java.sql.Date hastaf = new java.sql.Date(h);
        String sql =  "SELECT count(tipoV) FROM vehiculo where tipoV='Motocicleta' and horaEntrada >=\""+desdef+" 00:00:00\" and horaEntrada <=\""+hastaf+" 23:59:59\" and tipoServicio='Lava autos';";
        String sql1 = "SELECT count(tipoV) FROM vehiculo where tipoV='Automovil'   and horaEntrada >=\""+desdef+" 00:00:00\" and horaEntrada <=\""+hastaf+" 23:59:59\" and tipoServicio='Lava autos';";
        String sql2 = "SELECT count(tipoV) FROM vehiculo where tipoV='Camioneta'   and horaEntrada >=\""+desdef+" 00:00:00\" and horaEntrada <=\""+hastaf+" 23:59:59\" and tipoServicio='Lava autos';";
        //-----------------------------------------------------------------------------------------------------------
        // Rellena tabla  ingreso de motos desde cierta fecha hasta otra
        try {
            conexion = Dconexion.getConnection();;
            st = conexion.createStatement();
            rs = st.executeQuery(sql);
            
            Object[] dato = new Object[1];
            columnasm = (DefaultTableModel) reportesM.getModel();
            columnasm.setColumnCount(0);
            columnasm.setNumRows(0);    
            
            
            columnasm.addColumn("Total Motos Ingresadas");
            
                    
            while (rs.next()) {
                dato[0]=rs.getInt("count(tipoV)");
                columnasm.addRow(dato);  
               }
            reportesM.setModel(columnasm);
        } catch (SQLException ex) {
            Logger.getLogger(reportesgrandes.class.getName()).log(Level.SEVERE, null, ex);
        }
        //-----------------------------------------------------------------------------------------------------------
        // Rellena tabla  ingreso de carros desde cierta fecha hasta otra
        try {
            conexion = Dconexion.getConnection();;
            st = conexion.createStatement();
            rs = st.executeQuery(sql1);
            
            Object[] dato = new Object[1];
            columnasm = (DefaultTableModel) reportesCN.getModel();
            columnasm.setColumnCount(0);
            columnasm.setNumRows(0);    
            
            
            columnasm.addColumn("Total Autos Ingresados");
            
                    
            while (rs.next()) {
                dato[0]=rs.getInt("count(tipoV)");
                columnasm.addRow(dato);  
               }
            reportesCN.setModel(columnasm);
        } catch (SQLException ex) {
            Logger.getLogger(reportesgrandes.class.getName()).log(Level.SEVERE, null, ex);
        }
        //-----------------------------------------------------------------------------------------------------------
        // Rellena tabla  ingreso de camionetas desde cierta fecha hasta otra
        try {
            conexion = Dconexion.getConnection();;
            st = conexion.createStatement();
            rs = st.executeQuery(sql2);
            
            Object[] dato = new Object[1];
            columnasm = (DefaultTableModel) reportesCAN.getModel();
            columnasm.setColumnCount(0);
            columnasm.setNumRows(0);    
            
            
            columnasm.addColumn("Total Camionetas Ingresadas");
            
                    
            while (rs.next()) {
                dato[0]=rs.getInt("count(tipoV)");
                columnasm.addRow(dato);  
               }
            reportesCAN.setModel(columnasm);
        } catch (SQLException ex) {
            Logger.getLogger(reportesgrandes.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    } 
    
    void rellenatablasNEstyLa(){
        setVisible(true);
        Date desde=  desdeChooser.getDate();
        Date hasta=  hastaChooser.getDate();
        long d = desde.getTime();
        long h = hasta.getTime();
        java.sql.Date desdef = new java.sql.Date(d);
        java.sql.Date hastaf = new java.sql.Date(h);
        String sql =  "SELECT count(tipoV) FROM vehiculo where tipoV='Motocicleta' and horaEntrada >=\""+desdef+" 00:00:00\" and horaSalida <=\""+hastaf+" 23:59:59\" and tipoServicio='Estacionamiento y lava autos';";
        String sql1 = "SELECT count(tipoV) FROM vehiculo where tipoV='Automovil'   and horaEntrada >=\""+desdef+" 00:00:00\" and horaSalida <=\""+hastaf+" 23:59:59\" and tipoServicio='Estacionamiento y lava autos';";
        String sql2 = "SELECT count(tipoV) FROM vehiculo where tipoV='Camioneta'   and horaEntrada >=\""+desdef+" 00:00:00\" and horaSalida <=\""+hastaf+" 23:59:59\" and tipoServicio='Estacionamiento y lava autos';";
        //-----------------------------------------------------------------------------------------------------------
        // Rellena tabla  ingreso de motos desde cierta fecha hasta otra
        try {
            conexion = Dconexion.getConnection();;
            st = conexion.createStatement();
            rs = st.executeQuery(sql);
            
            Object[] dato = new Object[1];
            columnasm = (DefaultTableModel) reportesM.getModel();
            columnasm.setColumnCount(0);
            columnasm.setNumRows(0);    
            
            
            columnasm.addColumn("Total Motos Ingresadas");
            
                    
            while (rs.next()) {
                dato[0]=rs.getInt("count(tipoV)");
                columnasm.addRow(dato);  
               }
            reportesM.setModel(columnasm);
        } catch (SQLException ex) {
            Logger.getLogger(reportesgrandes.class.getName()).log(Level.SEVERE, null, ex);
        }
        //-----------------------------------------------------------------------------------------------------------
        // Rellena tabla  ingreso de carros desde cierta fecha hasta otra
        try {
            conexion = Dconexion.getConnection();;
            st = conexion.createStatement();
            rs = st.executeQuery(sql1);
            
            Object[] dato = new Object[1];
            columnasm = (DefaultTableModel) reportesCN.getModel();
            columnasm.setColumnCount(0);
            columnasm.setNumRows(0);    
            
            
            columnasm.addColumn("Total Autos Ingresados");
            
                    
            while (rs.next()) {
                dato[0]=rs.getInt("count(tipoV)");
                columnasm.addRow(dato);  
               }
            reportesCN.setModel(columnasm);
        } catch (SQLException ex) {
            Logger.getLogger(reportesgrandes.class.getName()).log(Level.SEVERE, null, ex);
        }
        //-----------------------------------------------------------------------------------------------------------
        // Rellena tabla  ingreso de camionetas desde cierta fecha hasta otra
        try {
            conexion = Dconexion.getConnection();;
            st = conexion.createStatement();
            rs = st.executeQuery(sql2);
            
            Object[] dato = new Object[1];
            columnasm = (DefaultTableModel) reportesCAN.getModel();
            columnasm.setColumnCount(0);
            columnasm.setNumRows(0);    
            
            
            columnasm.addColumn("Total Camionetas Ingresadas");
            
                    
            while (rs.next()) {
                dato[0]=rs.getInt("count(tipoV)");
                columnasm.addRow(dato);  
               }
            reportesCAN.setModel(columnasm);
        } catch (SQLException ex) {
            Logger.getLogger(reportesgrandes.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    } 
    
    void rellenatablasNP(){
        setVisible(true);
        Date desde=  desdeChooser.getDate();
        Date hasta=  hastaChooser.getDate();
        long d = desde.getTime();
        long h = hasta.getTime();
        java.sql.Date desdef = new java.sql.Date(d);
        java.sql.Date hastaf = new java.sql.Date(h);
        String sql =  "SELECT count(tipoV) FROM vehiculo where tipoV='Motocicleta' and horaEntrada >=\""+desdef+" 00:00:00\" and horaEntrada <=\""+hastaf+" 23:59:59\" and tipoServicio='Pension';";
        String sql1 = "SELECT count(tipoV) FROM vehiculo where tipoV='Automovil'   and horaEntrada >=\""+desdef+" 00:00:00\" and horaEntrada <=\""+hastaf+" 23:59:59\" and tipoServicio='Pension';";
        String sql2 = "SELECT count(tipoV) FROM vehiculo where tipoV='Camioneta'   and horaEntrada >=\""+desdef+" 00:00:00\" and horaEntrada <=\""+hastaf+" 23:59:59\" and tipoServicio='Pension';";
        //-----------------------------------------------------------------------------------------------------------
        // Rellena tabla  ingreso de motos desde cierta fecha hasta otra
        try {
            conexion = Dconexion.getConnection();;
            st = conexion.createStatement();
            rs = st.executeQuery(sql);
            
            Object[] dato = new Object[1];
            columnasm = (DefaultTableModel) reportesM.getModel();
            columnasm.setColumnCount(0);
            columnasm.setNumRows(0);    
            
            
            columnasm.addColumn("Total Motos Ingresadas");
            
                    
            while (rs.next()) {
                dato[0]=rs.getInt("count(tipoV)");
                columnasm.addRow(dato);  
               }
            reportesM.setModel(columnasm);
        } catch (SQLException ex) {
            Logger.getLogger(reportesgrandes.class.getName()).log(Level.SEVERE, null, ex);
        }
        //-----------------------------------------------------------------------------------------------------------
        // Rellena tabla  ingreso de carros desde cierta fecha hasta otra
        try {
            conexion = Dconexion.getConnection();;
            st = conexion.createStatement();
            rs = st.executeQuery(sql1);
            
            Object[] dato = new Object[1];
            columnasm = (DefaultTableModel) reportesCN.getModel();
            columnasm.setColumnCount(0);
            columnasm.setNumRows(0);    
            
            
            columnasm.addColumn("Total Autos Ingresados");
            
                    
            while (rs.next()) {
                dato[0]=rs.getInt("count(tipoV)");
                columnasm.addRow(dato);  
               }
            reportesCN.setModel(columnasm);
        } catch (SQLException ex) {
            Logger.getLogger(reportesgrandes.class.getName()).log(Level.SEVERE, null, ex);
        }
        //-----------------------------------------------------------------------------------------------------------
        // Rellena tabla  ingreso de camionetas desde cierta fecha hasta otra
        try {
            conexion = Dconexion.getConnection();;
            st = conexion.createStatement();
            rs = st.executeQuery(sql2);
            
            Object[] dato = new Object[1];
            columnasm = (DefaultTableModel) reportesCAN.getModel();
            columnasm.setColumnCount(0);
            columnasm.setNumRows(0);    
            
            
            columnasm.addColumn("Total Camionetas Ingresadas");
            
                    
            while (rs.next()) {
                dato[0]=rs.getInt("count(tipoV)");
                columnasm.addRow(dato);  
               }
            reportesCAN.setModel(columnasm);
        } catch (SQLException ex) {
            Logger.getLogger(reportesgrandes.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    } 
    
    void rellenatablasNPnoche(){
        setVisible(true);
        Date desde=  desdeChooser.getDate();
        Date hasta=  hastaChooser.getDate();
        long d = desde.getTime();
        long h = hasta.getTime();
        java.sql.Date desdef = new java.sql.Date(d);
        java.sql.Date hastaf = new java.sql.Date(h);
        String sql =  "SELECT count(tipoV) FROM vehiculo where tipoV='Motocicleta' and horaEntrada >=\""+desdef+" 00:00:00\" and horaSalida <=\""+hastaf+" 23:59:59\" and tipoServicio='Pension por noche';";
        String sql1 = "SELECT count(tipoV) FROM vehiculo where tipoV='Automovil'   and horaEntrada >=\""+desdef+" 00:00:00\" and horaSalida <=\""+hastaf+" 23:59:59\" and tipoServicio='Pension por noche';";
        String sql2 = "SELECT count(tipoV) FROM vehiculo where tipoV='Camioneta'   and horaEntrada >=\""+desdef+" 00:00:00\" and horaSalida <=\""+hastaf+" 23:59:59\" and tipoServicio='Pension por noche';";
        //-----------------------------------------------------------------------------------------------------------
        // Rellena tabla  ingreso de motos desde cierta fecha hasta otra
        try {
            conexion = Dconexion.getConnection();;
            st = conexion.createStatement();
            rs = st.executeQuery(sql);
            
            Object[] dato = new Object[1];
            columnasm = (DefaultTableModel) reportesM.getModel();
            columnasm.setColumnCount(0);
            columnasm.setNumRows(0);    
            
            
            columnasm.addColumn("Total Motos Ingresadas");
            
                    
            while (rs.next()) {
                dato[0]=rs.getInt("count(tipoV)");
                columnasm.addRow(dato);  
               }
            reportesM.setModel(columnasm);
        } catch (SQLException ex) {
            Logger.getLogger(reportesgrandes.class.getName()).log(Level.SEVERE, null, ex);
        }
        //-----------------------------------------------------------------------------------------------------------
        // Rellena tabla  ingreso de carros desde cierta fecha hasta otra
        try {
            conexion = Dconexion.getConnection();;
            st = conexion.createStatement();
            rs = st.executeQuery(sql1);
            
            Object[] dato = new Object[1];
            columnasm = (DefaultTableModel) reportesCN.getModel();
            columnasm.setColumnCount(0);
            columnasm.setNumRows(0);    
            
            
            columnasm.addColumn("Total Autos Ingresados");
            
                    
            while (rs.next()) {
                dato[0]=rs.getInt("count(tipoV)");
                columnasm.addRow(dato);  
               }
            reportesCN.setModel(columnasm);
        } catch (SQLException ex) {
            Logger.getLogger(reportesgrandes.class.getName()).log(Level.SEVERE, null, ex);
        }
        //-----------------------------------------------------------------------------------------------------------
        // Rellena tabla  ingreso de camionetas desde cierta fecha hasta otra
        try {
            conexion = Dconexion.getConnection();;
            st = conexion.createStatement();
            rs = st.executeQuery(sql2);
            
            Object[] dato = new Object[1];
            columnasm = (DefaultTableModel) reportesCAN.getModel();
            columnasm.setColumnCount(0);
            columnasm.setNumRows(0);    
            
            
            columnasm.addColumn("Total Camionetas Ingresadas");
            
                    
            while (rs.next()) {
                dato[0]=rs.getInt("count(tipoV)");
                columnasm.addRow(dato);  
               }
            reportesCAN.setModel(columnasm);
        } catch (SQLException ex) {
            Logger.getLogger(reportesgrandes.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
      
    
        
    @SuppressWarnings("empty-statement")
    void rellenatablasITtodo(){
        Date desde=  desdeChooser.getDate();
        Date hasta=  hastaChooser.getDate();
        long d = desde.getTime();
        long h = hasta.getTime();
        java.sql.Date desdef = new java.sql.Date(d);
        java.sql.Date hastaf = new java.sql.Date(h);
        String sql =  "SELECT (Select sum(importe) FROM vehiculo where tipoV='Motocicleta' and horaEntrada>=\""+desdef+" 00:00:00\" and horaSalida <=\""+hastaf+" 23:59:59\" and tipoServicio='Estacionamiento')as im,"
                           + "(SELECT sum(importe) FROM vehiculo where tipoV='Motocicleta' and horaEntrada>=\""+desdef+" 00:00:00\" and horaEntrada<=\""+desdef+" 23:59:59\" and tipoServicio='Lava autos')as im2,"
                           + "(SELECT sum(importe) FROM vehiculo where tipoV='Motocicleta' and horaEntrada>=\""+desdef+" 00:00:00\" and horaSalida <=\""+hastaf+" 23:59:00\" and tipoServicio='Estacionamiento y lava autos') as im3,"
                           + "(SELECT sum(importe) FROM vehiculo where tipoV='Motocicleta' and horaEntrada>=\""+desdef+" 00:00:00\" and horaEntrada<=\""+desdef+" 23:59:59\" and tipoServicio='Pension') as im4 ,"
                           + "(SELECT sum(importe) FROM vehiculo where tipoV='Motocicleta' and horaEntrada>=\""+desdef+" 00:00:00\" and horaSalida <=\""+hastaf+" 23:59:00\" and tipoServicio='Pension por noche') as im5;";
        String sql1 = "SELECT (Select sum(importe) FROM vehiculo where tipoV='Automovil' and horaEntrada>=\""+desdef+" 00:00:00\" and horaSalida <=\""+hastaf+" 23:59:59\" and tipoServicio='Estacionamiento')as ia,"
                           + "(SELECT sum(importe) FROM vehiculo where tipoV='Automovil' and horaEntrada>=\""+desdef+" 00:00:00\" and horaEntrada<=\""+desdef+" 23:59:59\" and tipoServicio='Lava autos')as ia2,"
                           + "(SELECT sum(importe) FROM vehiculo where tipoV='Automovil' and horaEntrada>=\""+desdef+" 00:00:00\" and horaSalida <=\""+hastaf+" 23:59:00\" and tipoServicio='Estacionamiento y lava autos') as ia3,"
                           + "(SELECT sum(importe) FROM vehiculo where tipoV='Automovil' and horaEntrada>=\""+desdef+" 00:00:00\" and horaEntrada<=\""+desdef+" 23:59:59\" and tipoServicio='Pension') as ia4,"
                           + "(SELECT sum(importe) FROM vehiculo where tipoV='Automovil' and horaEntrada>=\""+desdef+" 00:00:00\" and horaSalida <=\""+hastaf+" 23:59:00\" and tipoServicio='Pension por noche') as ia5;";
        String sql2 = "SELECT (Select sum(importe) FROM vehiculo where tipoV='Camioneta' and horaEntrada>=\""+desdef+" 00:00:00\" and horaSalida <=\""+hastaf+" 23:59:59\" and tipoServicio='Estacionamiento')as ic,"
                           + "(SELECT sum(importe) FROM vehiculo where tipoV='Camioneta' and horaEntrada>=\""+desdef+" 00:00:00\" and horaEntrada<=\""+desdef+" 23:59:59\" and tipoServicio='Lava autos')as ic2,"
                           + "(SELECT sum(importe) FROM vehiculo where tipoV='Camioneta' and horaEntrada>=\""+desdef+" 00:00:00\" and horaSalida <=\""+hastaf+" 23:59:00\" and tipoServicio='Estacionamiento y lava autos') as ic3,"
                           + "(SELECT sum(importe) FROM vehiculo where tipoV='Camioneta' and horaEntrada>=\""+desdef+" 00:00:00\" and horaEntrada<=\""+desdef+" 23:59:59\" and tipoServicio='Pension') as ic4,"
                           + "(SELECT sum(importe) FROM vehiculo where tipoV='Camioneta' and horaEntrada>=\""+desdef+" 00:00:00\" and horaSalida <=\""+hastaf+" 23:59:00\" and tipoServicio='Pension por noche') as ic5;";
//-----------------------------------------------------------------------------------------------------------
        // Rellena tabla  ingreso de motos desde cierta fecha hasta otra
        try {
            conexion = Dconexion.getConnection();;
            st = conexion.createStatement();
            rs = st.executeQuery(sql);
            
            Object[] dato = new Object[1];
            columnasm = (DefaultTableModel) reportesMi.getModel();
            columnasm.setColumnCount(0);
            columnasm.setNumRows(0);    
            
            
            columnasm.addColumn("Ingresos por Motos");
            
                    
            while (rs.next()) {
                int n=rs.getInt("im");
                int n1=rs.getInt("im2");
                int n2=rs.getInt("im3");
                int n3=rs.getInt("im4");
                int n4=rs.getInt("im5");
                
                int n5 = (n+n1+n2+n3+n4);
                dato[0]=n5;
                columnasm.addRow(dato);  
               }
            reportesMi.setModel(columnasm);
        } catch (SQLException ex) {
            Logger.getLogger(reportesgrandes.class.getName()).log(Level.SEVERE, null, ex);
        }
        //-----------------------------------------------------------------------------------------------------------
        // Rellena tabla  ingreso de carros desde cierta fecha hasta otra
        try {
            conexion = Dconexion.getConnection();;
            st = conexion.createStatement();
            rs = st.executeQuery(sql1);
            
            Object[] dato = new Object[1];
            columnasm = (DefaultTableModel) reportesCi.getModel();
            columnasm.setColumnCount(0);
            columnasm.setNumRows(0);    
            
            
            columnasm.addColumn("Ingresos por Autos");
            
                    
            while (rs.next()) {
                int n=rs.getInt("ia");
                int n1=rs.getInt("ia2");
                int n2=rs.getInt("ia3");
                int n3=rs.getInt("ia4");
                int n4=rs.getInt("ia5");
                
                int n5 = (n+n1+n2+n3+n4);
                dato[0]=n5;
                columnasm.addRow(dato);  
               }
            reportesCi.setModel(columnasm);
        } catch (SQLException ex) {
            Logger.getLogger(reportesgrandes.class.getName()).log(Level.SEVERE, null, ex);
        }
        //-----------------------------------------------------------------------------------------------------------
        // Rellena tabla  ingreso de camionetas desde cierta fecha hasta otra
        try {
            conexion = Dconexion.getConnection();;
            st = conexion.createStatement();
            rs = st.executeQuery(sql2);
            
            Object[] dato = new Object[1];
            columnasm = (DefaultTableModel) reportesCAi.getModel();
            columnasm.setColumnCount(0);
            columnasm.setNumRows(0);    
            
            
            columnasm.addColumn("Ingresos por Camionetas");
            
                    
            while (rs.next()) {
                int n=rs.getInt("ic");
                int n1=rs.getInt("ic2");
                int n2=rs.getInt("ic3");
                int n3=rs.getInt("ic4");
                int n4=rs.getInt("ic5");
                
                int n5 = (n+n1+n2+n3+n4);
                dato[0]=n5;
                columnasm.addRow(dato);  
               }
            reportesCAi.setModel(columnasm);
        } catch (SQLException ex) {
            Logger.getLogger(reportesgrandes.class.getName()).log(Level.SEVERE, null, ex);
        }       
         
    } 
    
    void rellenatablasIEst(){
        setVisible(true);
        Date desde=  desdeChooser.getDate();
        Date hasta=  hastaChooser.getDate();
        long d = desde.getTime();
        long h = hasta.getTime();
        java.sql.Date desdef = new java.sql.Date(d);
        java.sql.Date hastaf = new java.sql.Date(h);
        String sql =  "SELECT sum(importe) FROM vehiculo where tipoV='Motocicleta' and horaEntrada >=\""+desdef+" 00:00:00\" and horaSalida <=\""+hastaf+" 23:59:59\" and tipoServicio='Estacionamiento';";
        String sql1 = "SELECT sum(importe) FROM vehiculo where tipoV='Automovil'   and horaEntrada >=\""+desdef+" 00:00:00\" and horaSalida <=\""+hastaf+" 23:59:59\" and tipoServicio='Estacionamiento';";
        String sql2 = "SELECT sum(importe) FROM vehiculo where tipoV='Camioneta'   and horaEntrada >=\""+desdef+" 00:00:00\" and horaSalida <=\""+hastaf+" 23:59:59\" and tipoServicio='Estacionamiento';";
        //-----------------------------------------------------------------------------------------------------------
        // Rellena tabla  ingreso de motos desde cierta fecha hasta otra
        try {
            conexion = Dconexion.getConnection();;
            st = conexion.createStatement();
            rs = st.executeQuery(sql);
            
            Object[] dato = new Object[1];
            columnasm = (DefaultTableModel) reportesMi.getModel();
            columnasm.setColumnCount(0);
            columnasm.setNumRows(0);    
            
            
            columnasm.addColumn("$$ Motocicletas");
            
                    
            while (rs.next()) {
                dato[0]=rs.getInt("sum(importe)");
                columnasm.addRow(dato);  
               }
            reportesMi.setModel(columnasm);
        } catch (SQLException ex) {
            Logger.getLogger(reportesgrandes.class.getName()).log(Level.SEVERE, null, ex);
        }
        //-----------------------------------------------------------------------------------------------------------
        // Rellena tabla  ingreso de carros desde cierta fecha hasta otra
        try {
            conexion = Dconexion.getConnection();;
            st = conexion.createStatement();
            rs = st.executeQuery(sql1);
            
            Object[] dato = new Object[1];
            columnasm = (DefaultTableModel) reportesCi.getModel();
            columnasm.setColumnCount(0);
            columnasm.setNumRows(0);    
            
            
            columnasm.addColumn("$$ Autos");
            
                    
            while (rs.next()) {
                dato[0]=rs.getInt("sum(importe)");
                columnasm.addRow(dato);  
               }
            reportesCi.setModel(columnasm);
        } catch (SQLException ex) {
            Logger.getLogger(reportesgrandes.class.getName()).log(Level.SEVERE, null, ex);
        }
        //-----------------------------------------------------------------------------------------------------------
        // Rellena tabla  ingreso de camionetas desde cierta fecha hasta otra
        try {
            conexion = Dconexion.getConnection();;
            st = conexion.createStatement();
            rs = st.executeQuery(sql2);
            
            Object[] dato = new Object[1];
            columnasm = (DefaultTableModel) reportesCAi.getModel();
            columnasm.setColumnCount(0);
            columnasm.setNumRows(0);    
            
            
            columnasm.addColumn("$$ Camionetas");
            
                    
            while (rs.next()) {
                dato[0]=rs.getInt("sum(importe)");
                columnasm.addRow(dato);  
               }
            reportesCAi.setModel(columnasm);
        } catch (SQLException ex) {
            Logger.getLogger(reportesgrandes.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    } 
    
    void rellenatablasILa(){
        setVisible(true);
        Date desde=  desdeChooser.getDate();
        Date hasta=  hastaChooser.getDate();
        long d = desde.getTime();
        long h = hasta.getTime();
        java.sql.Date desdef = new java.sql.Date(d);
        java.sql.Date hastaf = new java.sql.Date(h);
        String sql =  "SELECT sum(importe) FROM vehiculo where tipoV='Motocicleta' and horaEntrada >=\""+desdef+" 00:00:00\" and horaEntrada <=\""+hastaf+" 23:59:59\" and tipoServicio='Lava autos';";
        String sql1 = "SELECT sum(importe) FROM vehiculo where tipoV='Automovil'   and horaEntrada >=\""+desdef+" 00:00:00\" and horaEntrada <=\""+hastaf+" 23:59:59\" and tipoServicio='Lava autos';";
        String sql2 = "SELECT sum(importe) FROM vehiculo where tipoV='Camioneta'   and horaEntrada >=\""+desdef+" 00:00:00\" and horaEntrada <=\""+hastaf+" 23:59:59\" and tipoServicio='Lava autos';";
        //-----------------------------------------------------------------------------------------------------------
        // Rellena tabla  ingreso de motos desde cierta fecha hasta otra
        try {
            conexion = Dconexion.getConnection();;
            st = conexion.createStatement();
            rs = st.executeQuery(sql);
            
            Object[] dato = new Object[1];
            columnasm = (DefaultTableModel) reportesMi.getModel();
            columnasm.setColumnCount(0);
            columnasm.setNumRows(0);    
            
            
            columnasm.addColumn("$$ Motos");
            
                    
            while (rs.next()) {
                dato[0]=rs.getInt("sum(importe)");
                columnasm.addRow(dato);  
               }
            reportesMi.setModel(columnasm);
        } catch (SQLException ex) {
            Logger.getLogger(reportesgrandes.class.getName()).log(Level.SEVERE, null, ex);
        }
        //-----------------------------------------------------------------------------------------------------------
        // Rellena tabla  ingreso de carros desde cierta fecha hasta otra
        try {
            conexion = Dconexion.getConnection();;
            st = conexion.createStatement();
            rs = st.executeQuery(sql1);
            
            Object[] dato = new Object[1];
            columnasm = (DefaultTableModel) reportesCi.getModel();
            columnasm.setColumnCount(0);
            columnasm.setNumRows(0);    
            
            
            columnasm.addColumn("$$ Autos");
            
                    
            while (rs.next()) {
                dato[0]=rs.getInt("sum(importe)");
                columnasm.addRow(dato);  
               }
            reportesCi.setModel(columnasm);
        } catch (SQLException ex) {
            Logger.getLogger(reportesgrandes.class.getName()).log(Level.SEVERE, null, ex);
        }
        //-----------------------------------------------------------------------------------------------------------
        // Rellena tabla  ingreso de camionetas desde cierta fecha hasta otra
        try {
            conexion = Dconexion.getConnection();;
            st = conexion.createStatement();
            rs = st.executeQuery(sql2);
            
            Object[] dato = new Object[1];
            columnasm = (DefaultTableModel) reportesCAi.getModel();
            columnasm.setColumnCount(0);
            columnasm.setNumRows(0);    
            
            
            columnasm.addColumn("$$ Camionetas");
            
                    
            while (rs.next()) {
                dato[0]=rs.getInt("sum(importe)");
                columnasm.addRow(dato);  
               }
            reportesCAi.setModel(columnasm);
        } catch (SQLException ex) {
            Logger.getLogger(reportesgrandes.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    } 
    
    void rellenatablasIEstyLa(){
        setVisible(true);
        Date desde=  desdeChooser.getDate();
        Date hasta=  hastaChooser.getDate();
        long d = desde.getTime();
        long h = hasta.getTime();
        java.sql.Date desdef = new java.sql.Date(d);
        java.sql.Date hastaf = new java.sql.Date(h);
        String sql =  "SELECT sum(importe) FROM vehiculo where tipoV='Motocicleta' and horaEntrada >=\""+desdef+" 00:00:00\" and horaSalida <=\""+hastaf+" 23:59:59\" and tipoServicio='Estacionamiento y lava autos';";
        String sql1 = "SELECT sum(importe) FROM vehiculo where tipoV='Automovil'   and horaEntrada >=\""+desdef+" 00:00:00\" and horaSalida <=\""+hastaf+" 23:59:59\" and tipoServicio='Estacionamiento y lava autos';";
        String sql2 = "SELECT sum(importe) FROM vehiculo where tipoV='Camioneta'   and horaEntrada >=\""+desdef+" 00:00:00\" and horaSalida <=\""+hastaf+" 23:59:59\" and tipoServicio='Estacionamiento y lava autos';";
        //-----------------------------------------------------------------------------------------------------------
        // Rellena tabla  ingreso de motos desde cierta fecha hasta otra
        try {
            conexion = Dconexion.getConnection();;
            st = conexion.createStatement();
            rs = st.executeQuery(sql);
            
            Object[] dato = new Object[1];
            columnasm = (DefaultTableModel) reportesMi.getModel();
            columnasm.setColumnCount(0);
            columnasm.setNumRows(0);    
            
            
            columnasm.addColumn("$$ Motos");
            
                    
            while (rs.next()) {
                dato[0]=rs.getInt("sum(importe)");
                columnasm.addRow(dato);  
               }
            reportesMi.setModel(columnasm);
        } catch (SQLException ex) {
            Logger.getLogger(reportesgrandes.class.getName()).log(Level.SEVERE, null, ex);
        }
        //-----------------------------------------------------------------------------------------------------------
        // Rellena tabla  ingreso de carros desde cierta fecha hasta otra
        try {
            conexion = Dconexion.getConnection();;
            st = conexion.createStatement();
            rs = st.executeQuery(sql1);
            
            Object[] dato = new Object[1];
            columnasm = (DefaultTableModel) reportesCi.getModel();
            columnasm.setColumnCount(0);
            columnasm.setNumRows(0);    
            
            
            columnasm.addColumn("$$ Autos");
            
                    
            while (rs.next()) {
                dato[0]=rs.getInt("sum(importe)");
                columnasm.addRow(dato);  
               }
            reportesCi.setModel(columnasm);
        } catch (SQLException ex) {
            Logger.getLogger(reportesgrandes.class.getName()).log(Level.SEVERE, null, ex);
        }
        //-----------------------------------------------------------------------------------------------------------
        // Rellena tabla  ingreso de camionetas desde cierta fecha hasta otra
        try {
            conexion = Dconexion.getConnection();;
            st = conexion.createStatement();
            rs = st.executeQuery(sql2);
            
            Object[] dato = new Object[1];
            columnasm = (DefaultTableModel) reportesCAi.getModel();
            columnasm.setColumnCount(0);
            columnasm.setNumRows(0);    
            
            
            columnasm.addColumn("$$ Camionetas");
            
                    
            while (rs.next()) {
                dato[0]=rs.getInt("sum(importe)");
                columnasm.addRow(dato);  
               }
            reportesCAi.setModel(columnasm);
        } catch (SQLException ex) {
            Logger.getLogger(reportesgrandes.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    } 
    
    void rellenatablasIP(){
        setVisible(true);
        Date desde=  desdeChooser.getDate();
        Date hasta=  hastaChooser.getDate();
        long d = desde.getTime();
        long h = hasta.getTime();
        java.sql.Date desdef = new java.sql.Date(d);
        java.sql.Date hastaf = new java.sql.Date(h);
        String sql =  "SELECT sum(importe) FROM vehiculo where tipoV='Motocicleta' and horaEntrada >=\""+desdef+" 00:00:00\" and horaEntrada <=\""+hastaf+" 23:59:59\" and tipoServicio='Pension';";
        String sql1 = "SELECT sum(importe) FROM vehiculo where tipoV='Automovil'   and horaEntrada >=\""+desdef+" 00:00:00\" and horaEntrada <=\""+hastaf+" 23:59:59\" and tipoServicio='Pension';";
        String sql2 = "SELECT sum(importe) FROM vehiculo where tipoV='Camioneta'   and horaEntrada >=\""+desdef+" 00:00:00\" and horaEntrada <=\""+hastaf+" 23:59:59\" and tipoServicio='Pension';";
        //-----------------------------------------------------------------------------------------------------------
        // Rellena tabla  ingreso de motos desde cierta fecha hasta otra
        try {
            conexion = Dconexion.getConnection();;
            st = conexion.createStatement();
            rs = st.executeQuery(sql);
            
            Object[] dato = new Object[1];
            columnasm = (DefaultTableModel) reportesMi.getModel();
            columnasm.setColumnCount(0);
            columnasm.setNumRows(0);    
            
            
            columnasm.addColumn("$$ Motos");
            
                    
            while (rs.next()) {
                dato[0]=rs.getInt("sum(importe)");
                columnasm.addRow(dato);  
               }
            reportesMi.setModel(columnasm);
        } catch (SQLException ex) {
            Logger.getLogger(reportesgrandes.class.getName()).log(Level.SEVERE, null, ex);
        }
        //-----------------------------------------------------------------------------------------------------------
        // Rellena tabla  ingreso de carros desde cierta fecha hasta otra
        try {
            conexion = Dconexion.getConnection();;
            st = conexion.createStatement();
            rs = st.executeQuery(sql1);
            
            Object[] dato = new Object[1];
            columnasm = (DefaultTableModel) reportesCi.getModel();
            columnasm.setColumnCount(0);
            columnasm.setNumRows(0);    
            
            
            columnasm.addColumn("$$ Autos");
            
                    
            while (rs.next()) {
                dato[0]=rs.getInt("sum(importe)");
                columnasm.addRow(dato);  
               }
            reportesCi.setModel(columnasm);
        } catch (SQLException ex) {
            Logger.getLogger(reportesgrandes.class.getName()).log(Level.SEVERE, null, ex);
        }
        //-----------------------------------------------------------------------------------------------------------
        // Rellena tabla  ingreso de camionetas desde cierta fecha hasta otra
        try {
            conexion = Dconexion.getConnection();;
            st = conexion.createStatement();
            rs = st.executeQuery(sql2);
            
            Object[] dato = new Object[1];
            columnasm = (DefaultTableModel) reportesCAi.getModel();
            columnasm.setColumnCount(0);
            columnasm.setNumRows(0);    
            
            
            columnasm.addColumn("$$ Camionetas");
            
                    
            while (rs.next()) {
                dato[0]=rs.getInt("sum(importe)");
                columnasm.addRow(dato);  
               }
            reportesCAi.setModel(columnasm);
        } catch (SQLException ex) {
            Logger.getLogger(reportesgrandes.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    } 
    
    void rellenatablasIPnoche(){
        setVisible(true);
        Date desde=  desdeChooser.getDate();
        Date hasta=  hastaChooser.getDate();
        long d = desde.getTime();
        long h = hasta.getTime();
        java.sql.Date desdef = new java.sql.Date(d);
        java.sql.Date hastaf = new java.sql.Date(h);
        String sql =  "SELECT sum(importe) FROM vehiculo where tipoV='Motocicleta' and horaEntrada >=\""+desdef+" 00:00:00\" and horaSalida <=\""+hastaf+" 23:59:59\" and tipoServicio='Pension por noche';";
        String sql1 = "SELECT sum(importe) FROM vehiculo where tipoV='Automovil'   and horaEntrada >=\""+desdef+" 00:00:00\" and horaSalida <=\""+hastaf+" 23:59:59\" and tipoServicio='Pension por noche';";
        String sql2 = "SELECT sum(importe) FROM vehiculo where tipoV='Camioneta'   and horaEntrada >=\""+desdef+" 00:00:00\" and horaSalida <=\""+hastaf+" 23:59:59\" and tipoServicio='Pension por noche';";
        //-----------------------------------------------------------------------------------------------------------
        // Rellena tabla  ingreso de motos desde cierta fecha hasta otra
        try {
            conexion = Dconexion.getConnection();;
            st = conexion.createStatement();
            rs = st.executeQuery(sql);
            
            Object[] dato = new Object[1];
            columnasm = (DefaultTableModel) reportesMi.getModel();
            columnasm.setColumnCount(0);
            columnasm.setNumRows(0);    
            
            
            columnasm.addColumn("$$ Motos");
            
                    
            while (rs.next()) {
                dato[0]=rs.getInt("sum(importe)");
                columnasm.addRow(dato);  
               }
            reportesMi.setModel(columnasm);
        } catch (SQLException ex) {
            Logger.getLogger(reportesgrandes.class.getName()).log(Level.SEVERE, null, ex);
        }
        //-----------------------------------------------------------------------------------------------------------
        // Rellena tabla  ingreso de carros desde cierta fecha hasta otra
        try {
            conexion = Dconexion.getConnection();;
            st = conexion.createStatement();
            rs = st.executeQuery(sql1);
            
            Object[] dato = new Object[1];
            columnasm = (DefaultTableModel) reportesCi.getModel();
            columnasm.setColumnCount(0);
            columnasm.setNumRows(0);    
            
            
            columnasm.addColumn("$$ Autos");
            
                    
            while (rs.next()) {
                dato[0]=rs.getInt("sum(importe)");
                columnasm.addRow(dato);  
               }
            reportesCi.setModel(columnasm);
        } catch (SQLException ex) {
            Logger.getLogger(reportesgrandes.class.getName()).log(Level.SEVERE, null, ex);
        }
        //-----------------------------------------------------------------------------------------------------------
        // Rellena tabla  ingreso de camionetas desde cierta fecha hasta otra
        try {
            conexion = Dconexion.getConnection();;
            st = conexion.createStatement();
            rs = st.executeQuery(sql2);
            
            Object[] dato = new Object[1];
            columnasm = (DefaultTableModel) reportesCAi.getModel();
            columnasm.setColumnCount(0);
            columnasm.setNumRows(0);    
            
            
            columnasm.addColumn("$$ Camionetas");
            
                    
            while (rs.next()) {
                dato[0]=rs.getInt("sum(importe)");
                columnasm.addRow(dato);  
               }
            reportesCAi.setModel(columnasm);
        } catch (SQLException ex) {
            Logger.getLogger(reportesgrandes.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
    
    
    void graficaCant(){     
        JDesktopPane desk = new JDesktopPane();
        elFrame1.setContentPane(desk);
        int n1 =Integer.parseInt(reportesM.getValueAt(0, 0).toString());
        int n2 =Integer.parseInt(reportesCN.getValueAt(0, 0).toString());
        int n3 =Integer.parseInt(reportesCAN.getValueAt(0, 0).toString());
        
        DefaultCategoryDataset datos =  new DefaultCategoryDataset();
        
        datos.setValue(n1, "Cantidad", "Motos");
        datos.setValue(n2, "Cantidad", "Carros");
        datos.setValue(n3, "Cantidad", "Camionetas");
        
        JFreeChart grafico_barras = ChartFactory.createBarChart3D(
        "Autos Ingresados", //nombre del gráfico
        "Tipos", //nombre de las barras o columnas
        "# Por Tipo", //nombre de la numeración
        datos,  //datos del gráfico
                PlotOrientation.VERTICAL, //orientación de las barras
                true, //Leyenda de barras indivicduales por columna
                true, // herramientas
                false //url del grafico
        );
        ChartPanel panel = new ChartPanel(grafico_barras);
        panel.setMouseWheelEnabled(true);
        panel.setPreferredSize(new Dimension(elFrame1.getWidth(), elFrame1.getHeight()));
        
        elFrame1.setLayout(new BorderLayout());
        
        elFrame1.add(panel, BorderLayout.CENTER);        
        elFrame1.revalidate();
        
        elFrame1.pack();
        repaint();
        
    }
        
    void graficaIngresos(){  
        JDesktopPane desk = new JDesktopPane();
        elFrame2.setContentPane(desk);
        int n1 =Integer.parseInt(reportesMi.getValueAt(0, 0).toString());
        int n2 =Integer.parseInt(reportesCi.getValueAt(0, 0).toString());
        int n3 =Integer.parseInt(reportesCAi.getValueAt(0, 0).toString());
        
        DefaultCategoryDataset datos =  new DefaultCategoryDataset();
        
        datos.setValue(n1, "Monto $$", "Motos");
        datos.setValue(n2, "Monto $$", "Carros");
        datos.setValue(n3, "Monto $$", "Camionetas");
        
        JFreeChart grafico_barras = ChartFactory.createBarChart3D(
        "Ingresos $$", //nombre del gráfico
        "Tipos", //nombre de las barras o columnas
        "Ganancia Por Tipo", //nombre de la numeración
        datos,  //datos del gráfico
                PlotOrientation.VERTICAL, //orientación de las barras
                true, //Leyenda de barras indivicduales por columna
                true, // herramientas
                false //url del grafico
        );
        
        ChartPanel panel = new ChartPanel(grafico_barras);
        panel.setMouseWheelEnabled(true);
        panel.setPreferredSize(new Dimension(elFrame2.getWidth(), elFrame2.getHeight()));
        elFrame2.setLayout(new BorderLayout());
        
        elFrame2.add(panel, BorderLayout.NORTH);
        elFrame2.revalidate();
        
        elFrame2.pack();
        repaint();
    }

    /**
     * Creates new form reportesgrandes
     */
    public reportesgrandes() {
        initComponents();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg1 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        desdeChooser = new com.toedter.calendar.JDateChooser();
        hastaChooser = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        OpcionesBox = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        reportesM = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        reportesCN = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        reportesCAN = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        reportesMi = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        reportesCi = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        reportesCAi = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        elFrame2 = new javax.swing.JInternalFrame();
        elFrame1 = new javax.swing.JInternalFrame();

        setMinimumSize(new java.awt.Dimension(1200, 550));
        setPreferredSize(new java.awt.Dimension(1200, 550));

        bg1.setBackground(new java.awt.Color(255, 255, 255));
        bg1.setMinimumSize(new java.awt.Dimension(1200, 500));
        bg1.setPreferredSize(new java.awt.Dimension(1200, 550));
        bg1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 0));

        desdeChooser.setBackground(new java.awt.Color(255, 255, 255));
        desdeChooser.setForeground(new java.awt.Color(255, 255, 255));

        hastaChooser.setBackground(new java.awt.Color(255, 255, 255));
        hastaChooser.setForeground(new java.awt.Color(255, 255, 255));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Desde:");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Hasta:");

        jButton1.setText("Generar Reporte");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        OpcionesBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todo", "Estacionamiento", "Lava autos", "Estacionamiento y Lava autos", "Pensión", "Pensión por noche" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(desdeChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(116, 116, 116)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(hastaChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(OpcionesBox, 0, 177, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(207, 207, 207))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(OpcionesBox, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButton1)
                        .addComponent(jLabel2)
                        .addComponent(desdeChooser, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                        .addComponent(hastaChooser, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                        .addComponent(jLabel3)))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        bg1.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1260, 80));

        reportesM.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null}
            },
            new String [] {
                "Sin Datos"
            }
        ));
        jScrollPane1.setViewportView(reportesM);

        bg1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 130, 50));

        reportesCN.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null}
            },
            new String [] {
                "Sin Datos"
            }
        ));
        jScrollPane2.setViewportView(reportesCN);

        bg1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, 130, 50));

        reportesCAN.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null}
            },
            new String [] {
                "Sin Datos"
            }
        ));
        jScrollPane3.setViewportView(reportesCAN);

        bg1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 100, 130, 50));

        reportesMi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null}
            },
            new String [] {
                "Motocicletas"
            }
        ));
        jScrollPane4.setViewportView(reportesMi);

        bg1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 100, 130, 50));

        reportesCi.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        reportesCi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null}
            },
            new String [] {
                "Automoviles"
            }
        ));
        jScrollPane5.setViewportView(reportesCi);

        bg1.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 100, 130, 50));

        reportesCAi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null}
            },
            new String [] {
                "Camionetas"
            }
        ));
        jScrollPane6.setViewportView(reportesCAi);

        bg1.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 100, 130, 50));

        jLabel4.setBackground(new java.awt.Color(153, 153, 0));
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Reporte de Vehículos Ingresados en ese periodo de Tiempo");
        jLabel4.setMaximumSize(new java.awt.Dimension(600, 16));
        jLabel4.setMinimumSize(new java.awt.Dimension(600, 16));
        jLabel4.setOpaque(true);
        jLabel4.setPreferredSize(new java.awt.Dimension(600, 16));
        bg1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, -1, -1));

        jLabel5.setBackground(new java.awt.Color(0, 102, 0));
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Reporte de ingresos generados en ese periodo de Tiempo");
        jLabel5.setToolTipText("");
        jLabel5.setMaximumSize(new java.awt.Dimension(600, 16));
        jLabel5.setMinimumSize(new java.awt.Dimension(600, 16));
        jLabel5.setOpaque(true);
        jLabel5.setPreferredSize(new java.awt.Dimension(600, 16));
        bg1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 80, -1, -1));

        elFrame2.setBackground(new java.awt.Color(255, 204, 0));
        elFrame2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        elFrame2.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        elFrame2.setMinimumSize(new java.awt.Dimension(450, 370));
        elFrame2.setOpaque(true);
        elFrame2.setPreferredSize(new java.awt.Dimension(450, 370));
        elFrame2.setVisible(true);

        javax.swing.GroupLayout elFrame2Layout = new javax.swing.GroupLayout(elFrame2.getContentPane());
        elFrame2.getContentPane().setLayout(elFrame2Layout);
        elFrame2Layout.setHorizontalGroup(
            elFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 448, Short.MAX_VALUE)
        );
        elFrame2Layout.setVerticalGroup(
            elFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 368, Short.MAX_VALUE)
        );

        bg1.add(elFrame2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 160, -1, -1));

        elFrame1.setBackground(new java.awt.Color(255, 204, 0));
        elFrame1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        elFrame1.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        elFrame1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        elFrame1.setMinimumSize(new java.awt.Dimension(450, 370));
        elFrame1.setOpaque(true);
        elFrame1.setPreferredSize(new java.awt.Dimension(450, 370));
        elFrame1.setVisible(true);

        javax.swing.GroupLayout elFrame1Layout = new javax.swing.GroupLayout(elFrame1.getContentPane());
        elFrame1.getContentPane().setLayout(elFrame1Layout);
        elFrame1Layout.setHorizontalGroup(
            elFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 448, Short.MAX_VALUE)
        );
        elFrame1Layout.setVerticalGroup(
            elFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 368, Short.MAX_VALUE)
        );

        bg1.add(elFrame1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (OpcionesBox.getSelectedItem().toString().equals("Todo")) {
            rellenatablasNTodo();    
            rellenatablasITtodo();
        }
        if (OpcionesBox.getSelectedItem().toString().equals("Estacionamiento")) {
            rellenatablasNEst();  
            rellenatablasIEst();
        }
        if (OpcionesBox.getSelectedItem().toString().equals("Lava autos")) {
            rellenatablasNLa();
            rellenatablasILa();
        }
        if (OpcionesBox.getSelectedItem().toString().equals("Estacionamiento y Lava autos")) {
            rellenatablasNEstyLa();
            rellenatablasIEstyLa();
        }
        if (OpcionesBox.getSelectedItem().toString().equals("Pensión")) {
            rellenatablasNP();  
            rellenatablasIP();
        }
        if (OpcionesBox.getSelectedItem().toString().equals("Pensión por noche")) {
            rellenatablasNPnoche(); 
            rellenatablasIPnoche();
        }
        graficaCant();
        graficaIngresos();
        
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> OpcionesBox;
    private javax.swing.JPanel bg1;
    private com.toedter.calendar.JDateChooser desdeChooser;
    private javax.swing.JInternalFrame elFrame1;
    private javax.swing.JInternalFrame elFrame2;
    private com.toedter.calendar.JDateChooser hastaChooser;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable reportesCAN;
    private javax.swing.JTable reportesCAi;
    private javax.swing.JTable reportesCN;
    private javax.swing.JTable reportesCi;
    private javax.swing.JTable reportesM;
    private javax.swing.JTable reportesMi;
    // End of variables declaration//GEN-END:variables

    
    
}
