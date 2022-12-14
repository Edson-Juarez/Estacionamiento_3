/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esta;

import Atxy2k.CustomTextField.RestrictedTextField;
import java.awt.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Leandro
 */
public class usuarios extends javax.swing.JPanel {

    /**
     * Creates new form consulta
     */
    public usuarios() {
        initComponents();
        btn_modi.setVisible(false);
        btn_eliminar.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        getEstAz = new javax.swing.JLabel();
        getEstAra = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nom = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        ape = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        usu = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        con = new javax.swing.JTextField();
        confi = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        rool = new javax.swing.JComboBox<>();
        btn_aceptar = new javax.swing.JButton();
        boton_bus = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        btn_modi = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaUsuario = new javax.swing.JTable();

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setPreferredSize(new java.awt.Dimension(1110, 460));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        bg.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 120, -1, -1));
        bg.add(getEstAz, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 400, 110, 20));
        bg.add(getEstAra, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 400, 110, 20));

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 0));
        jLabel1.setText("ADMINISTRACI??N DE USUARIOS");
        bg.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 20, 380, -1));

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("NOMBRE:");
        bg.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, 70, -1));

        nom.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        bg.add(nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 230, 130, -1));

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel3.setText("APELLIDOS:");
        bg.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, -1, -1));

        ape.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ape.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apeActionPerformed(evt);
            }
        });
        bg.add(ape, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 280, 130, -1));

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel4.setText("USUARIO:");
        bg.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, -1, -1));

        usu.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        usu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                usuKeyTyped(evt);
            }
        });
        bg.add(usu, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 130, -1));

        jLabel5.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel5.setText("CONTRASE??A:");
        bg.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, -1, -1));

        con.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        bg.add(con, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, 130, -1));

        confi.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        bg.add(confi, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, 130, -1));

        jLabel6.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel6.setText("ROL:");
        bg.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 330, 40, 20));

        jLabel7.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel7.setText("CONFIRMAR:");
        bg.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 90, 20));

        rool.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        rool.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Colaborador" }));
        bg.add(rool, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 330, -1, -1));

        btn_aceptar.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btn_aceptar.setText("AGREGAR");
        btn_aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_aceptarActionPerformed(evt);
            }
        });
        bg.add(btn_aceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 130, -1, 30));

        boton_bus.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        boton_bus.setText("BUSCAR");
        boton_bus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_busActionPerformed(evt);
            }
        });
        bg.add(boton_bus, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 80, 100, 30));

        btn_eliminar.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btn_eliminar.setText("ELIMINAR");
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });
        bg.add(btn_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 180, -1, 30));

        btn_modi.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btn_modi.setText("MODIFICAR");
        btn_modi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modiActionPerformed(evt);
            }
        });
        bg.add(btn_modi, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 230, -1, 30));

        tablaUsuario.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        tablaUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaUsuario.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane1.setViewportView(tablaUsuario);

        bg.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 80, 570, 290));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void apeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_apeActionPerformed
    public int idIncrementable() {
        int id = 1;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection cn = Dconexion.getConnection();
        try {
            ps = cn.prepareStatement("SELECT MAX(idusaurio) FROM usuario");
            rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getInt(1) + 1;
            }
        } catch (Exception ex) {
            System.out.println("Error" + ex.getMessage());
        }
        return id;
    }
    private void btn_aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_aceptarActionPerformed
        // TODO add your handling code here:

        if (usu.getText().isEmpty() || con.getText().isEmpty() || nom.getText().isEmpty() || ape.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Favor de NO dejar campos vacios");
        } else {
            try {
                if (con.getText().equals(confi.getText())) {
                    Connection cn;
                    cn = Dconexion.getConnection();
                    PreparedStatement ps = cn.prepareStatement("INSERT INTO usuario (idusaurio,user,password,rool,nombre,apellidos) "
                            + "VALUES (?,?,?,?,?,?);");
                    ps.setInt(1, idIncrementable());
                    ps.setString(2, usu.getText());

                    ps.setString(3, con.getText());

                    ps.setString(4, rool.getSelectedItem().toString());
                    ps.setString(5, nom.getText());
                    ps.setString(6, ape.getText());
                    int res = ps.executeUpdate();
                    if (res > 0) {
                        JOptionPane.showMessageDialog(null, "DATOS GUARDADOS CORRECTAMENTE");
                        usu.setText("");
                        con.setText("");
                        nom.setText("");
                        ape.setText("");
                        confi.setText("");
                        rool.setSelectedIndex(0);
                    } else {
                        JOptionPane.showMessageDialog(null, "ERROR");
                    }
                    cn.close();
                } else {
                    JOptionPane.showMessageDialog(null, "CONTRASE??AS DIFERENTES");
                }
            } catch (Exception e) {
                System.out.println(e);
            }

        }
    }//GEN-LAST:event_btn_aceptarActionPerformed

    private void boton_busActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_busActionPerformed
        // TODO add your handling code here:
        PreparedStatement ps;
        try {
            Connection cn;
            cn = Dconexion.getConnection();
            Statement stat = cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stat.executeQuery("SELECT * FROM usuario WHERE user='" + usu.getText() + "';");
            if (rs.first()) {
                this.usu.setText(rs.getString("user"));
                this.con.setText(rs.getString("password"));
                this.nom.setText(rs.getString("nombre"));
                this.ape.setText(rs.getString("apellidos"));
                this.rool.setSelectedItem(rs.getString("rool"));
                btn_modi.setVisible(true);
                btn_eliminar.setVisible(true);

                DefaultTableModel miModelo;
                miModelo = consultita();
                tablaUsuario.setModel(miModelo);

            } else {
                JOptionPane.showMessageDialog(null, "NO SE ENCUENTRA EL USUARIO");
            }
        } catch (SQLException ex) {
            Logger.getLogger(usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_boton_busActionPerformed

    public DefaultTableModel consultitaEs() {
        DefaultTableModel miModelo = null;
        try {
            String titulos[] = {"Usuario", "Hora entrada", "Hora salida"};
            String dts[] = new String[2];
            miModelo = new DefaultTableModel(null, titulos);
            Connection cn;
            cn = Dconexion.getConnection();
            String sql = "SELECT * FROM vehiculo WHERE tipoServicio = 'Estacionamiento'";
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                dts[0] = rs.getString("idfolio");
                dts[1] = rs.getString("placas");
                dts[2] = rs.getString("color");
                dts[3] = rs.getString("marca");
                dts[4] = rs.getString("tipoV");
                dts[5] = rs.getString("importe");
                dts[6] = rs.getString("tipoServicio");
                miModelo.addRow(dts);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return miModelo;
    }

    private void btn_modiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modiActionPerformed
        // TODO add your handling code here:

        PreparedStatement ps;
        ResultSet rs;

        try {
            if (con.getText().equals(confi.getText())) {
                Connection cn;
                cn = Dconexion.getConnection();
                //Statement stat = cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ps = cn.prepareStatement("UPDATE usuario SET password=?, user=?, rool=?, nombre=?, apellidos =? WHERE user='" + usu.getText() + "'OR nombre ='" + nom.getText() + "';");
                ps.setString(1, con.getText());
                ps.setString(2, usu.getText());
                ps.setString(3, rool.getSelectedItem().toString());
                ps.setString(4, nom.getText());
                ps.setString(5, ape.getText());
                int res = ps.executeUpdate();
                if (res > 0) {
                    JOptionPane.showMessageDialog(null, "DATOS ACTUALIZADOS CORRECTAMENTE");
                    usu.setText("");
                    con.setText("");
                    nom.setText("");
                    ape.setText("");
                    confi.setText("");
                    rool.setSelectedIndex(0);
                } else {
                    JOptionPane.showMessageDialog(null, "ERROR AL ACTUALIZAR");
                }
                cn.close();
            } else {
                JOptionPane.showMessageDialog(null, "CONTRASE??AS DIFERENTES");
            }
        } catch (SQLException ex) {
            Logger.getLogger(usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btn_modiActionPerformed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
        // TODO add your handling code here:
        PreparedStatement ps;
        ResultSet rs;
        Connection cn;
        cn = Dconexion.getConnection();
        try {
            ps = cn.prepareStatement("DELETE FROM USUARIO WHERE user ='" + usu.getText() + "';");
            int res = ps.executeUpdate();

            if (res > 0) {
                JOptionPane.showMessageDialog(null, "USUARIO ELIMINADO");
                usu.setText("");
                con.setText("");
                nom.setText("");
                ape.setText("");
                confi.setText("");
                rool.setSelectedIndex(0);
            } else{
                JOptionPane.showMessageDialog(null, "ERROR AL ELIMINAR EL USUARIO");
            }
            cn.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void usuKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usuKeyTyped
        // TODO add your handling code here:
        char caracter = evt.getKeyChar();
        if (Character.isLowerCase(caracter)) {
            evt.setKeyChar(Character.toUpperCase(caracter));

        }
    }//GEN-LAST:event_usuKeyTyped
    public DefaultTableModel consultita() {
        DefaultTableModel miModelo = null;
        try {
            String titulos[] = {"Usuario", "Fecha", "Hora Entrada", "Hora Salida"};
            String dts[] = new String[4];
            miModelo = new DefaultTableModel(null, titulos);
            Connection cn;
            cn = Dconexion.getConnection();
            String sql = "SELECT * FROM checador WHERE user = '" + usu.getText() + "';";
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                dts[0] = rs.getString("user");
                dts[1] = rs.getString("fecha");
                dts[2] = rs.getString("horaEntrada");
                dts[3] = rs.getString("horaSalida");

                miModelo.addRow(dts);
            }
        } catch (Exception ex) {

            ex.printStackTrace();
        }
        return miModelo;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ape;
    private javax.swing.JPanel bg;
    private javax.swing.JButton boton_bus;
    private javax.swing.JButton btn_aceptar;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_modi;
    private javax.swing.JTextField con;
    private javax.swing.JTextField confi;
    private javax.swing.JLabel getEstAra;
    private javax.swing.JLabel getEstAz;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nom;
    private javax.swing.JComboBox<String> rool;
    private javax.swing.JTable tablaUsuario;
    private javax.swing.JTextField usu;
    // End of variables declaration//GEN-END:variables
}
