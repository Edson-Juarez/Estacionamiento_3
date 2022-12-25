/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esta;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import Atxy2k.CustomTextField.RestrictedTextField;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.text.ParseException;
import java.util.ArrayList;

/**
 *
 * @author Leandro
 */
public class ingresar extends javax.swing.JPanel implements Runnable {

    String hora, minutos, segundos;
    Thread hilo;
    int aux = 0;
    //double valorAPagarTotal = 0.00;
    double valorAPagarLa = 0.00;
    double valorAPagarP = 0.00;
    double valorAPagarTotal = 00.00;

    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Calendar cal = Calendar.getInstance();
    Date date = cal.getTime();
    String fechaHora = dateFormat.format(date);
    int auxBuscar;

    Connection cn;

    /**
     * Creates new form ingresar
     */
    public ingresar() {
        initComponents();
        fechainicial.setText(fecha());
        hilo = new Thread(this);
        hilo.start();
        otroMar.setVisible(false);
        otroCo.setVisible(false);
        otroModelo.setVisible(false);
        setVisible(true);

        buscarColor.setVisible(false);
        buscarMarca.setVisible(false);
        buscarModelo.setVisible(false);
        tipoVehiculos.setVisible(false);

        tamanioV.setVisible(false);
        RestrictedTextField r = new RestrictedTextField(placas);
        r.setLimit(7);

        modificar.setVisible(false);
    }

    void imprimirTicket() throws SQLException, IOException {
        //Método dentro del JForm de ingreso de vehiculo, para impresion de ticket
        ticketClase impresor = new ticketClase();
        //Instancia de clase

        cn = Dconexion.getConnection();
        Statement st = cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = st.executeQuery("SELECT idfolio FROM vehiculo WHERE idfolio = (SELECT MAX(idfolio) from vehiculo);");
        //Segmento de conexion a BD para consulta del folio que unicamente esta en la BD una vez ingresado el vehículo
        while (rs.next()) {
            int folion = rs.getInt("idfolio");
            String fff = folion + " ";
            impresor.setFolio(fff);
        }
        //Asignacion del Folio al ticket
        if (rbAuto.isSelected() == true) {
            impresor.setTipo("Automovil");
        } else if (rbCami.isSelected() == true) {
            impresor.setTipo("Camioneta");
        } else if (rbMoto.isSelected() == true) {
            impresor.setTipo("Motocicleta");
        } else if (rbAuto.isSelected() == false && rbCami.isSelected() == false && rbMoto.isSelected() == false) {
            impresor.setTipo(tipoVehiculos.getText());
        }
        //Asignacion del campo Tipo al ticket
        impresor.setPlacas(placas.getText());
        //Asignacion del campo placas al ticket

        String opcion = "";
        if (opcion.equals("Otro...")) {
            otroCo.getText();
        } else {
            impresor.setColor(colorOp.getSelectedItem().toString());
            //opcion = colorOp.getSelectedItem().toString();
        }
        String opcion2 = "";

        if (opcion2.equals("Otro...")) {
            otroMar.getText();
            //colorOp.add(this);
        } else {
            impresor.setMarca(marcaOp.getSelectedItem().toString());
            //opcion2 = marcaOp.getSelectedItem().toString();
        }

        String opcion3 = "";
        if (opcion3.equals("Otro...")) {
            impresor.setModelo(otroModelo.getText());
        } else {
            impresor.setModelo(modeloOp.getSelectedItem().toString());
            // opcion3 = modeloOp.getSelectedItem().toString();
        }

        if (aux == 0) {
            impresor.setArticulos("Estacionamiento ");
        } else if (aux == 1) {
            impresor.setArticulos("Lavado de Vehiculo");
            impresor.setTotal("" + valorAPagarLa);
        } else if (aux == 2) {
            impresor.setArticulos("Lavado de Vehiculo\nY \nEstacionamiento");
            impresor.setTotal("" + valorAPagarLa + "\n(Total Parcial*)");
        } else if (aux == 3) {
            impresor.setArticulos("Pension");
            impresor.setTotal(valorAPagarP + "");
        }
        //Asignacion del campo del monto que se conbrara al ticket en 3 de 4 casos posibles

        impresor.print(true);
        //ejecucion del metodo de impresion a la impresora predeterminada del sistema
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoBoton = new javax.swing.ButtonGroup();
        bg = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        placas = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        rbAuto = new javax.swing.JRadioButton();
        rbCami = new javax.swing.JRadioButton();
        rbMoto = new javax.swing.JRadioButton();
        colorOp = new javax.swing.JComboBox<>();
        marcaOp = new javax.swing.JComboBox<>();
        btn_lavado = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        btnregistrar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        horita = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        fechainicial = new javax.swing.JLabel();
        otroCo = new javax.swing.JTextField();
        otroMar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        observacion = new javax.swing.JTextArea();
        jLabel14 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btn_ambos = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        btn_pension = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        servicio = new javax.swing.JTextField();
        tamanioV = new javax.swing.JComboBox<>();
        cobrito = new javax.swing.JTextField();
        buscar = new javax.swing.JButton();
        buscarMarca = new javax.swing.JTextField();
        buscarColor = new javax.swing.JTextField();
        tipoVehiculos = new javax.swing.JTextField();
        label1 = new javax.swing.JLabel();
        label2 = new javax.swing.JLabel();
        label3 = new javax.swing.JLabel();
        label4 = new javax.swing.JLabel();
        label5 = new javax.swing.JLabel();
        label6 = new javax.swing.JLabel();
        btn_retirar = new javax.swing.JButton();
        impo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        modeloOp = new javax.swing.JComboBox<>();
        otroModelo = new javax.swing.JTextField();
        buscarModelo = new javax.swing.JTextField();
        modificar = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1130, 550));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setPreferredSize(new java.awt.Dimension(1130, 550));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        bg.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 120, -1, -1));

        placas.setFont(new java.awt.Font("Segoe UI", 0, 43)); // NOI18N
        placas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        placas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        placas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                placasActionPerformed(evt);
            }
        });
        placas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                placasKeyTyped(evt);
            }
        });
        bg.add(placas, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 250, 70));

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel1.setText("COLOR:");
        bg.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 190, -1, -1));

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel2.setText("MODELO:");
        bg.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 190, -1, -1));

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 36)); // NOI18N
        jLabel3.setText("HORA:");
        bg.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 20, -1, 40));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("TIPO DE VEHÍCULO");
        bg.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 320, -1, -1));

        grupoBoton.add(rbAuto);
        rbAuto.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        rbAuto.setText("AUTOMOVIL");
        rbAuto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbAutoActionPerformed(evt);
            }
        });
        bg.add(rbAuto, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, -1, -1));

        grupoBoton.add(rbCami);
        rbCami.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        rbCami.setText("CAMIONETA");
        bg.add(rbCami, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 360, -1, -1));

        grupoBoton.add(rbMoto);
        rbMoto.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        rbMoto.setText("MOTOCICLETA");
        bg.add(rbMoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 360, -1, -1));

        colorOp.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        colorOp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Blanco", "Gris", "Negro", "Plata", "Azul", "Rojo", "Beige", "Verde", "Amarillo", "Otro..." }));
        colorOp.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                colorOpItemStateChanged(evt);
            }
        });
        colorOp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colorOpActionPerformed(evt);
            }
        });
        bg.add(colorOp, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 230, -1, -1));

        marcaOp.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        marcaOp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nissan", "Toyota", "Volkswagen", "KIA", "Mazda", "Honda", "Hyundai", "Jeep", "Audi", "BMW", "Mercedes", "Yamaha", "Harley Davidson", "Suzuki", "Italika", "Otro..." }));
        marcaOp.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                marcaOpItemStateChanged(evt);
            }
        });
        marcaOp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                marcaOpActionPerformed(evt);
            }
        });
        bg.add(marcaOp, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 110, -1));

        btn_lavado.setBackground(new java.awt.Color(204, 204, 204));
        btn_lavado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_lavadoMouseClicked(evt);
            }
        });

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/wash.png"))); // NOI18N

        jLabel12.setFont(new java.awt.Font("Roboto Condensed", 0, 14)); // NOI18N
        jLabel12.setText("LAVA AUTO");

        javax.swing.GroupLayout btn_lavadoLayout = new javax.swing.GroupLayout(btn_lavado);
        btn_lavado.setLayout(btn_lavadoLayout);
        btn_lavadoLayout.setHorizontalGroup(
            btn_lavadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_lavadoLayout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(btn_lavadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btn_lavadoLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btn_lavadoLayout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(35, 35, 35))))
        );
        btn_lavadoLayout.setVerticalGroup(
            btn_lavadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_lavadoLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addContainerGap())
        );

        bg.add(btn_lavado, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 80, 140, 150));

        btnregistrar.setFont(new java.awt.Font("Roboto", 0, 17)); // NOI18N
        btnregistrar.setText("INGRESAR");
        btnregistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregistrarActionPerformed(evt);
            }
        });
        bg.add(btnregistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 390, 120, 50));

        jButton2.setFont(new java.awt.Font("Roboto", 0, 17)); // NOI18N
        jButton2.setText("CANCELAR");
        bg.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 390, 120, 50));

        horita.setFont(new java.awt.Font("Roboto", 0, 36)); // NOI18N
        horita.setText("18:05:00");
        bg.add(horita, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 20, 160, 40));

        jLabel13.setFont(new java.awt.Font("Roboto", 0, 36)); // NOI18N
        jLabel13.setText("FECHA:");
        bg.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 20, -1, -1));

        fechainicial.setFont(new java.awt.Font("Roboto", 0, 36)); // NOI18N
        fechainicial.setText("29/07/2022");
        bg.add(fechainicial, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 20, -1, -1));

        otroCo.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        otroCo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        bg.add(otroCo, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 280, 110, 30));

        otroMar.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        otroMar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        otroMar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                otroMarActionPerformed(evt);
            }
        });
        bg.add(otroMar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 110, 30));

        observacion.setColumns(20);
        observacion.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        observacion.setRows(5);
        observacion.setText("NINGUNA");
        observacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                observacionKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(observacion);

        bg.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 270, 260, 80));

        jLabel14.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("OBSERVACIONES");
        bg.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 300, -1, -1));

        jLabel5.setFont(new java.awt.Font("Roboto", 0, 36)); // NOI18N
        jLabel5.setText("PLACA/MATRÍCULA");
        bg.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, 60));

        btn_ambos.setBackground(new java.awt.Color(204, 204, 204));
        btn_ambos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_ambosMouseClicked(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Roboto Condensed", 0, 14)); // NOI18N
        jLabel19.setText("ESTACIONAMIENTO");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/coche.png"))); // NOI18N

        jLabel16.setFont(new java.awt.Font("Roboto Condensed", 0, 14)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("LAVA AUTO Y");

        javax.swing.GroupLayout btn_ambosLayout = new javax.swing.GroupLayout(btn_ambos);
        btn_ambos.setLayout(btn_ambosLayout);
        btn_ambosLayout.setHorizontalGroup(
            btn_ambosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_ambosLayout.createSequentialGroup()
                .addGroup(btn_ambosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btn_ambosLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel19))
                    .addGroup(btn_ambosLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(btn_ambosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        btn_ambosLayout.setVerticalGroup(
            btn_ambosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_ambosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addGap(1, 1, 1)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bg.add(btn_ambos, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 80, 140, 150));

        btn_pension.setBackground(new java.awt.Color(204, 204, 204));
        btn_pension.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_pensionMouseClicked(evt);
            }
        });

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/parking.png"))); // NOI18N

        jLabel18.setFont(new java.awt.Font("Roboto Condensed", 0, 14)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("PENSIÓN");

        javax.swing.GroupLayout btn_pensionLayout = new javax.swing.GroupLayout(btn_pension);
        btn_pension.setLayout(btn_pensionLayout);
        btn_pensionLayout.setHorizontalGroup(
            btn_pensionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_pensionLayout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jLabel17)
                .addGap(14, 14, 14))
            .addGroup(btn_pensionLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btn_pensionLayout.setVerticalGroup(
            btn_pensionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_pensionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel18)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bg.add(btn_pension, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 80, -1, 150));

        servicio.setForeground(new java.awt.Color(255, 255, 255));
        servicio.setText("jTextField1");
        servicio.setBorder(null);
        servicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                servicioActionPerformed(evt);
            }
        });
        bg.add(servicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 150, -1, -1));

        tamanioV.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        tamanioV.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Auto chico", "Auto mediano", "Auto grande", "Motocicleta" }));
        tamanioV.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                tamanioVItemStateChanged(evt);
            }
        });
        bg.add(tamanioV, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 240, -1, -1));

        cobrito.setForeground(new java.awt.Color(255, 255, 255));
        cobrito.setText("jTextField1");
        cobrito.setBorder(null);
        bg.add(cobrito, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 190, -1, -1));

        buscar.setFont(new java.awt.Font("Roboto", 0, 17)); // NOI18N
        buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/buscar1.png"))); // NOI18N
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });
        bg.add(buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 70, 70, 60));

        buscarMarca.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        buscarMarca.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        bg.add(buscarMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 110, 40));

        buscarColor.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        buscarColor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        buscarColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarColorActionPerformed(evt);
            }
        });
        bg.add(buscarColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 220, 110, 40));

        tipoVehiculos.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        tipoVehiculos.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tipoVehiculos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoVehiculosActionPerformed(evt);
            }
        });
        bg.add(tipoVehiculos, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 350, 140, 40));

        label1.setText("$15.00 por hora ");
        bg.add(label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, -1, -1));

        label2.setText("y/o fracción");
        bg.add(label2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 420, -1, -1));

        label3.setText("$20.00 por hora");
        bg.add(label3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 400, -1, -1));

        label4.setText("y/o fracción");
        bg.add(label4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 420, -1, -1));

        label5.setText("$15.00 por hora");
        bg.add(label5, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 400, -1, -1));

        label6.setText("y/o fracción");
        bg.add(label6, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 420, -1, -1));

        btn_retirar.setFont(new java.awt.Font("Roboto", 0, 17)); // NOI18N
        btn_retirar.setText("RETIRAR");
        btn_retirar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_retirarActionPerformed(evt);
            }
        });
        bg.add(btn_retirar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 140, 100, 30));

        impo.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        impo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        impo.setText("0.00");
        impo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        bg.add(impo, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 390, 100, 40));

        jLabel7.setFont(new java.awt.Font("Roboto", 0, 22)); // NOI18N
        jLabel7.setText("IMPORTE: $");
        bg.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 400, -1, -1));

        jLabel8.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel8.setText("MARCA:");
        bg.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, -1, -1));

        modeloOp.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        modeloOp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Versa", "March", "Sentra", "Altima", "Tsuru", "Tiida", "Frontier", "Rogue", "Otro..." }));
        modeloOp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modeloOpActionPerformed(evt);
            }
        });
        bg.add(modeloOp, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 230, 130, -1));

        otroModelo.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        otroModelo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        bg.add(otroModelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 280, 110, 30));

        buscarModelo.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        buscarModelo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        bg.add(buscarModelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 220, 110, 40));

        modificar.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        modificar.setText("MODIFICAR");
        modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarActionPerformed(evt);
            }
        });
        bg.add(modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 420, 120, 30));

        add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1130, 570));
    }// </editor-fold>//GEN-END:initComponents

    public void hora() {
        Calendar cal = new GregorianCalendar();
        Date horaactual = new Date();
        cal.setTime(horaactual);
        hora = cal.get(cal.HOUR_OF_DAY) > 9 ? "" + cal.get(cal.HOUR_OF_DAY) : "0" + cal.get(cal.HOUR_OF_DAY);
        minutos = cal.get(cal.MINUTE) > 9 ? "" + cal.get(cal.MINUTE) : "0" + cal.get(cal.MINUTE);
        segundos = cal.get(cal.SECOND) > 9 ? "" + cal.get(cal.SECOND) : "0" + cal.get(cal.SECOND);

    }

    public static String fecha() {
        Date fecha = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/YYYY");
        return formatoFecha.format(fecha);
    }

    @Override
    public void run() {
        Thread current = Thread.currentThread();
        for (int i = 1; 1 > 0; i++) {
            hora();
            horita.setText(hora + ":" + minutos + ":" + segundos);
        }
    }
    private void placasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_placasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_placasActionPerformed

    public int idIncrementable() {
        int id = 1;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection cn = Dconexion.getConnection();
        try {
            ps = cn.prepareStatement("SELECT MAX(idfolio) FROM vehiculo");
            rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getInt(1) + 1;
            }
        } catch (Exception ex) {
            System.out.println("Error" + ex.getMessage());
        }
        return id;
    }

    private void btnregistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregistrarActionPerformed
        // TODO add your handling code here:
        String horaFe;
        String claseVehiculos = "";
        String servicioOp = "";
        //double cobro = 0.00;

        if (claseVehiculos.isEmpty()) {
            claseVehiculos = tipoVehiculos.getText();
        }
        if (rbAuto.isSelected()) {
            claseVehiculos = "Automovil";

        }
        if (rbCami.isSelected()) {
            claseVehiculos = "Camioneta";

        }
        if (rbMoto.isSelected()) {
            claseVehiculos = "Motocicleta";

        }

        if (placas.getText().isEmpty() || claseVehiculos.isEmpty() || observacion.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Favor de NO dejar campos vacios");
        } else {

            try {
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Calendar cal = Calendar.getInstance();
                Date date = cal.getTime();
                horaFe = dateFormat.format(date);
                System.out.print(dateFormat.format(date));

                Connection cn;
                cn = Dconexion.getConnection();
                Statement stat1 = cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
                Statement stat2 = cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ResultSet rs1 = stat1.executeQuery("SELECT * FROM taries where idtarifaEsta=2");
                ResultSet rs2 = stat2.executeQuery("SELECT * FROM taries where idtarifaEsta=3");
                while (rs1.next()) {
                    if (aux == 0) {
                        servicioOp = "Estacionamiento";
                        cobrito.setText("" + 0.00);

                    }
                    if (aux == 1) {
                        servicioOp = "Lava autos";
                        String opcion = tamanioV.getSelectedItem().toString();
                        if (opcion.equals("Auto chico")) {
                            valorAPagarLa = (rs1.getDouble(2));
                        } else if (opcion.equals("Auto mediano")) {
                            valorAPagarLa = (rs1.getDouble(5));
                        } else if (opcion.equals("Auto grande")) {
                            valorAPagarLa = (rs1.getDouble(3));
                        } else {
                            valorAPagarLa = (rs1.getDouble(4));
                        }
                        cobrito.setText("" + valorAPagarLa);
                        JOptionPane.showMessageDialog(null, "VALOR A PAGAR: $" + valorAPagarLa);
                        DecimalFormat df = new DecimalFormat("#.00");
                        impo.setText(String.valueOf(df.format(valorAPagarLa)));
                    }
                    if (aux == 2) {
                        servicioOp = "Estacionamiento y lava autos";
                        String opcion = tamanioV.getSelectedItem().toString();
                        if (opcion.equals("Auto chico")) {
                            valorAPagarLa = (rs1.getDouble(2));
                        } else if (opcion.equals("Auto mediano")) {
                            valorAPagarLa = (rs1.getDouble(5));
                        } else if (opcion.equals("Auto grande")) {
                            valorAPagarLa = (rs1.getDouble(3));
                        } else {
                            valorAPagarLa = (rs1.getDouble(4));
                        }
                        cobrito.setText("" + valorAPagarLa);
                        JOptionPane.showMessageDialog(null, "VALOR A PAGAR: $" + valorAPagarLa);
                        DecimalFormat df = new DecimalFormat("#.00");
                        impo.setText(String.valueOf(df.format(valorAPagarTotal)));
                    }
                    while (rs2.next()) {
                        if (aux == 3) {
                            servicioOp = "Pension";
                            String fechaEntrada = dateFormat.format(date);
                            String fechaSalida = dateFormat.format(date);

                            valorAPagarP = (rs2.getDouble(3));
                            cobrito.setText("" + valorAPagarP);
                            JOptionPane.showMessageDialog(null, "VALOR A PAGAR: $" + valorAPagarP);
                            DecimalFormat df = new DecimalFormat("#.00");
                            impo.setText(String.valueOf(df.format(valorAPagarP)));
                        }
                    }

                }

                servicio.setText("" + servicioOp);

                String opcion = "";
                if (opcion.equals("Otro...")) {
                    otroCo.getText();
                } else if (auxBuscar == 1) {
                    buscarColor.getText();
                } else {
                    opcion = colorOp.getSelectedItem().toString();
                }

                String opcion2 = "";

                if (opcion2.equals("Otro...")) {
                    otroMar.getText();
                    otroModelo.setVisible(true);
                    //colorOp.add(this);
                } else if (auxBuscar == 1) {
                    buscarMarca.getText();
                } else {
                    opcion2 = marcaOp.getSelectedItem().toString();
                }

                String opcion3 = "";
                if (opcion3.equals("Otro..")) {
                    otroModelo.getText();
                    otroModelo.setVisible(true);
                } else if (auxBuscar == 1) {
                    buscarModelo.getText();
                } else {
                    opcion3 = modeloOp.getSelectedItem().toString();
                    otroModelo.setVisible(false);
                }

                PreparedStatement ps = cn.prepareStatement("INSERT INTO vehiculo (idfolio,placas,color,marca,modelo,tipoV,obser,importe,horaEntrada,tipoServicio) "
                        + "VALUES (?,?,?,?,?,?,?,?,?,?);");
                ps.setInt(1, idIncrementable());
                ps.setString(2, placas.getText());
                //ps.setString(3, colorOp.getSelectedItem().toString());
                if (opcion.equals("Otro...")) {
                    ps.setString(3, otroCo.getText());
                } else if(auxBuscar == 1) {
                    ps.setString(3, buscarColor.getText());
                } else{
                    ps.setString(3, colorOp.getSelectedItem().toString());
                }

                if (opcion2.equals("Otro...")) {
                    ps.setString(4, otroMar.getText());
                } else if(auxBuscar == 1) {
                    ps.setString(4, buscarMarca.getText());
                } else{
                    ps.setString(4, marcaOp.getSelectedItem().toString());
                }

                if (opcion3.equals("Otro..")) {
                    ps.setString(5, otroModelo.getText());
                } else if(auxBuscar == 1) {
                    ps.setString(5, buscarModelo.getText());
                } else{
                    ps.setString(5, modeloOp.getSelectedItem().toString());
                }

                ps.setString(6, claseVehiculos);
                ps.setString(7, observacion.getText());
                ps.setString(8, cobrito.getText());
                ps.setString(9, horaFe);
                ps.setString(10, servicio.getText());

                int res = ps.executeUpdate();

                if (res > 0) {

                    JOptionPane.showMessageDialog(null, "DATOS GUARDADOS CORRECTAMENTE");
                } else {
                    JOptionPane.showMessageDialog(null, "ERROR");
                }
                cn.close();
            } catch (Exception e) {
                System.out.println(e);
            }

            try {
                imprimirTicket();
                valorAPagarLa = 0;
                valorAPagarP = 0;
            } catch (SQLException | IOException ex) {
                Logger.getLogger(ingresar.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_btnregistrarActionPerformed

    private void colorOpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colorOpActionPerformed
        // TODO add your handling code here:    
    }//GEN-LAST:event_colorOpActionPerformed

    private void colorOpItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_colorOpItemStateChanged
        // TODO add your handling code here:
        String opcion = colorOp.getSelectedItem().toString();
        if (opcion.equals("Otro...")) {
            otroCo.setVisible(true);
            otroCo.getText();
        } else {
            otroCo.setVisible(false);
        }
    }//GEN-LAST:event_colorOpItemStateChanged

    private void marcaOpItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_marcaOpItemStateChanged
        // TODO add your handling code here:
        String opcion = marcaOp.getSelectedItem().toString();
        if (opcion.equals("Otro...")) {
            otroMar.setVisible(true);
        } else {
            otroMar.setVisible(false);
        }
    }//GEN-LAST:event_marcaOpItemStateChanged

    public void rellenarCombo0() {
        modeloOp.addItem("Otro..");

    }

    public void rellenarCombo() {
        modeloOp.addItem("Versa");
        modeloOp.addItem("March");
        modeloOp.addItem("Sentra");
        modeloOp.addItem("Altima");
        modeloOp.addItem("Tsuru");
        modeloOp.addItem("Tiida");
        modeloOp.addItem("Frontier");
        modeloOp.addItem("Rogue");
        modeloOp.addItem("Otro..");

    }

    public void rellenarCombo2() {
        modeloOp.addItem("Yaris");
        modeloOp.addItem("Hilux");
        modeloOp.addItem("Corolla cross");
        modeloOp.addItem("Rav4");
        modeloOp.addItem("Tacoma");
        modeloOp.addItem("Camry");
        modeloOp.addItem("Hiace");
        modeloOp.addItem("Highlander");
        modeloOp.addItem("Otro..");
    }

    public void rellenarCombo3() {
        modeloOp.addItem("Jetta");
        modeloOp.addItem("Saveiro");
        modeloOp.addItem("Nivus");
        modeloOp.addItem("Taos");
        modeloOp.addItem("Teramont");
        modeloOp.addItem("Cross Sport");
        modeloOp.addItem("Transporter");
        modeloOp.addItem("Otro..");

    }

    public void rellenarCombo4() {
        modeloOp.addItem("Rio");
        modeloOp.addItem("Forte");
        modeloOp.addItem("Sorento");
        modeloOp.addItem("Hatchback");
        modeloOp.addItem("Stinger ");
        modeloOp.addItem("Soul");
        modeloOp.addItem("Seltos ");
        modeloOp.addItem("Otro..");
    }

    public void rellenarCombo5() {
        modeloOp.addItem("Sedán");
        modeloOp.addItem("Hatchback");
        modeloOp.addItem("MX-5");
        modeloOp.addItem("CX-5");
        modeloOp.addItem("CX-30");
        modeloOp.addItem("Otro..");
    }

    public void rellenarCombo6() {
        modeloOp.addItem("City");
        modeloOp.addItem("Civic");
        modeloOp.addItem("Insight");
        modeloOp.addItem("HR-V");
        modeloOp.addItem("CR-V");
        modeloOp.addItem("Otro..");
    }

    public void rellenarCombo7() {
        modeloOp.addItem("Accent");
        modeloOp.addItem("Creta");
        modeloOp.addItem("Tucson");
        modeloOp.addItem("Atos");
        modeloOp.addItem("Toledo");
        modeloOp.addItem("Otro..");

    }

    public void rellenarCombo8() {
        modeloOp.addItem("Compass");
        modeloOp.addItem("Wrangler");
        modeloOp.addItem("Cherokee");
        modeloOp.addItem("Otro..");
    }

    public void rellenarCombo9() {
        modeloOp.addItem("Sportback");
        modeloOp.addItem("Sedán");
        modeloOp.addItem("Q8");
        modeloOp.addItem("A7");
        modeloOp.addItem("A8");
        modeloOp.addItem("R8");
        modeloOp.addItem("Otro..");
    }

    public void rellenarCombo10() {
        modeloOp.addItem("Motorrad");
        modeloOp.addItem("R 1200");
        modeloOp.addItem("R18 Trans");
        modeloOp.addItem("Sedán");
        modeloOp.addItem("Serie 3");
        modeloOp.addItem("Serie 8");
        modeloOp.addItem("Otro..");
    }

    public void rellenarCombo11() {
        modeloOp.addItem("Hatchback");
        modeloOp.addItem("Sedán");
        modeloOp.addItem("SUV");
        modeloOp.addItem("Coupe");
        modeloOp.addItem("Vans");
        modeloOp.addItem("Otro..");
    }

    public void rellenarCombo12() {
        modeloOp.addItem("Cygnus");
        modeloOp.addItem("MT-03 ABS");
        modeloOp.addItem("Vento");
        modeloOp.addItem("New Ray");
        modeloOp.addItem("De trabajo");
        modeloOp.addItem("Otro..");
    }

    public void rellenarCombo13() {
        modeloOp.addItem("Chopper");
        modeloOp.addItem("Sportster");
        modeloOp.addItem("Street");
        modeloOp.addItem("Iron");
        modeloOp.addItem("Forty");
        modeloOp.addItem("Otro..");
    }

    public void rellenarCombo14() {
        modeloOp.addItem("Gixxer");
        modeloOp.addItem("Gsx R150");
        modeloOp.addItem("AX100");
        modeloOp.addItem("Swift");
        modeloOp.addItem("Ignis");
        modeloOp.addItem("Otro..");
    }

    public void rellenarCombo15() {
        modeloOp.addItem("Clasica");
        modeloOp.addItem("Vitalia");
        modeloOp.addItem("Delivery");
        modeloOp.addItem("Sport");
        modeloOp.addItem("Modena");
        modeloOp.addItem("X125 Motoneta");
        modeloOp.addItem("Otro..");
    }

    private void rellenar(String seleccionEnMarca) {
        // Se borran los valores previos
        modeloOp.removeAllItems();

        int op = marcaOp.getSelectedIndex();

        switch (op) {
            case 0:
                rellenarCombo();
                break;
            case 1:
                rellenarCombo2();
                break;
            case 2:
                rellenarCombo3();
                break;
            case 3:
                rellenarCombo4();
                break;
            case 4:
                rellenarCombo5();
                break;
            case 5:
                rellenarCombo6();
                break;
            case 6:
                rellenarCombo7();
                break;
            case 7:
                rellenarCombo8();
                break;
            case 8:
                rellenarCombo9();
                break;
            case 9:
                rellenarCombo10();
                break;
            case 10:
                rellenarCombo11();
                break;
            case 11:
                rellenarCombo12();
                break;
            case 12:
                rellenarCombo13();
                break;
            case 13:
                rellenarCombo14();
                break;
            case 14:
                rellenarCombo15();
                break;
            case 15:
                rellenarCombo0();
                otroModelo.setVisible(true);
                break;
        }
    }

    private void btn_lavadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_lavadoMouseClicked
        // TODO add your handling code here:

        setColor(btn_lavado);
        getColor(btn_pension);
        getColor(btn_ambos);
        tamanioV.setVisible(true);
        aux = 1;
    }//GEN-LAST:event_btn_lavadoMouseClicked

    private void btn_ambosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ambosMouseClicked
        // TODO add your handling code here:

        setColor(btn_ambos);
        getColor(btn_lavado);
        getColor(btn_pension);
        tamanioV.setVisible(true);
        aux = 2;
    }//GEN-LAST:event_btn_ambosMouseClicked

    private void btn_pensionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_pensionMouseClicked
        // TODO add your handling code here:
        tamanioV.setVisible(false);
        setColor(btn_pension);
        getColor(btn_lavado);
        getColor(btn_ambos);

        aux = 3;
    }//GEN-LAST:event_btn_pensionMouseClicked

    private void servicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_servicioActionPerformed

    }//GEN-LAST:event_servicioActionPerformed

    private void tamanioVItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_tamanioVItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_tamanioVItemStateChanged

    private void placasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_placasKeyTyped
        // TODO add your handling code here:
        char caracter = evt.getKeyChar();
        if (Character.isLowerCase(caracter)) {
            evt.setKeyChar(Character.toUpperCase(caracter));

        }
    }//GEN-LAST:event_placasKeyTyped

    private void rbAutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbAutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbAutoActionPerformed

    private void observacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_observacionKeyTyped
        // TODO add your handling code here:}
        char caracter = evt.getKeyChar();
        if (Character.isLowerCase(caracter)) {
            evt.setKeyChar(Character.toUpperCase(caracter));

        }
    }//GEN-LAST:event_observacionKeyTyped

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        PreparedStatement ps;
        
        try {
            Connection cn;
            cn = Dconexion.getConnection();
            Statement stat = cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stat.executeQuery("SELECT * FROM vehiculo WHERE placas='" + placas.getText() + "';");
            rs.first();
            if (placas.getText().equals(rs.getString("placas"))) {
                auxBuscar = 1;
                colorOp.setVisible(false);
                marcaOp.setVisible(false);
                modeloOp.setVisible(false);
                rbAuto.setVisible(false);
                rbCami.setVisible(false);
                rbMoto.setVisible(false);
                buscarColor.setVisible(true);
                buscarMarca.setVisible(true);
                buscarModelo.setVisible(true);
                tipoVehiculos.setVisible(true);
                buscarMarca.setText(rs.getString("marca"));
                buscarColor.setText(rs.getString("color"));
                buscarModelo.setText(rs.getString("modelo"));
                tipoVehiculos.setText(rs.getString("tipoV"));
                observacion.setText(rs.getString("obser"));
                modificar.setVisible(true);
                label1.setVisible(false);
                label2.setVisible(false);
                label3.setVisible(false);
                label4.setVisible(false);
                label5.setVisible(false);
                label6.setVisible(false);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "NO EXISTE REGISTRO DEL CARRO");
            //placas.setText("");
            colorOp.setVisible(true);
            marcaOp.setVisible(true);
            modeloOp.setVisible(true);
            rbAuto.setVisible(true);
            rbCami.setVisible(true);
            rbMoto.setVisible(true);
            buscarColor.setVisible(false);
            buscarMarca.setVisible(false);
            buscarModelo.setVisible(false);
            tipoVehiculos.setVisible(false);
        }
    }//GEN-LAST:event_buscarActionPerformed

    private void tipoVehiculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoVehiculosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tipoVehiculosActionPerformed

    private void btn_retirarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_retirarActionPerformed
        double valorAPagar = 00.00;
        ingresar ing = new ingresar();

        try {
            Connection cn;
            cn = Dconexion.getConnection();
            Statement stat = cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            Statement stat1 = cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            Statement stat2 = cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stat.executeQuery("SELECT horaEntrada, tipoV  FROM vehiculo WHERE placas='" + placas.getText() + "';");
            ResultSet rs1 = stat1.executeQuery("SELECT * FROM taries where idtarifaEsta = '1'");
            ResultSet rs2 = stat2.executeQuery("SELECT importe FROM vehiculo WHERE placas='" + placas.getText() + "';");

            rs.first();

            while (rs1.next()) {

                double cobro = (rs1.getDouble(2));
                String horaSalida = rs.getString(1);
                Date horasalida = dateFormat.parse(horaSalida);
                double minutosACobrar = (double) (date.getTime() - horasalida.getTime()) / 60000;
                valorAPagar = cobro * (minutosACobrar - minutosACobrar % 60) / 60;
                System.out.println(minutosACobrar);

                if (minutosACobrar % 60 != 0) {
                    if (rs.getString(2).equals("Automovil")) {
                        valorAPagar = valorAPagar + rs1.getDouble(2);
                    } else if (rs.getString(2).equals("Motocicleta")) {
                        valorAPagar = valorAPagar + rs1.getDouble(4);
                    } else if (rs.getString(2).equals("Camioneta")) {
                        valorAPagar = valorAPagar + rs1.getDouble(3);
                    }
                }
            }

            while (rs2.next()) {
                if (rs2.getDouble(1) < 700) {
                    valorAPagarTotal = valorAPagar + rs2.getDouble(1);
                }
            }

            System.out.println("Valor a pagar por estacionamiento" + rs.getString(2) + "= " + valorAPagar);
            stat.executeUpdate("UPDATE vehiculo SET importe='" + valorAPagarTotal + "',horaSalida='" + fechaHora + "' WHERE placas='" + placas.getText() + "'AND tipoServicio like 'Esta%';");
            JOptionPane.showMessageDialog(null, "VALOR A PAGAR TOTAL: $" + valorAPagarTotal);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "REVISE LOS DATOS NUEVAMENTE");
            Logger.getLogger(retirar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "PLACAS NO ENCONTRADAS");
            Logger.getLogger(retirar.class.getName()).log(Level.SEVERE, null, ex);
        }
        DecimalFormat df = new DecimalFormat("#.00");
        impo.setText(String.valueOf(df.format(valorAPagarTotal)));

        int op = JOptionPane.showConfirmDialog(null, "¿DESEA IMPRIMIR SU TICKET?", "TICKET", JOptionPane.YES_NO_OPTION);
        if (op == JOptionPane.YES_OPTION) {
            try {
                imprimirTicket();
                JOptionPane.showMessageDialog(null, "Imprimiendo");
                valorAPagarTotal = 0;

            } catch (SQLException | IOException ex) {
                Logger.getLogger(ingresar.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (op == JOptionPane.NO_OPTION) {
            valorAPagarTotal = 0;

        }
        //impo.setText("" + valorAPagarTotal );
        //horaSal.setText("" + fechaHora);
    }//GEN-LAST:event_btn_retirarActionPerformed

    private void modeloOpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modeloOpActionPerformed
        // TODO add your handling code here:
        //marcaOp.addActionListener(colorOp);

    }//GEN-LAST:event_modeloOpActionPerformed

    private void marcaOpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_marcaOpActionPerformed
        // TODO add your handling code here:
        rellenar((String) marcaOp.getSelectedItem());
    }//GEN-LAST:event_marcaOpActionPerformed

    private void buscarColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarColorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buscarColorActionPerformed

    private void otroMarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_otroMarActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_otroMarActionPerformed

    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed
        // TODO add your handling code here:
        PreparedStatement ps;
        ResultSet rs;
        try {
            Connection cn;
            cn = Dconexion.getConnection();
            //Statement stat = cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ps = cn.prepareStatement("UPDATE vehiculo SET modelo=?  WHERE placas='" + placas.getText() + "';");
            ps.setString(1, buscarModelo.getText());
            int res = ps.executeUpdate();
            if (res > 0) {
                JOptionPane.showMessageDialog(null, "MODELO ACTUALIZADO CORRECTAMENTE");
                buscarModelo.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "ERROR AL ACTUALIZAR");
            }
            cn.close();

        } catch (SQLException ex) {
            Logger.getLogger(usuarios.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_modificarActionPerformed

//[51,153,0]color claro 
    void setColor(JPanel panel
    ) {
        panel.setBackground(new Color(64, 64, 64));

    }
//[27,143,6]color fuerte 

    void getColor(JPanel panel
    ) {
        panel.setBackground(new Color(192, 192, 192));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JPanel btn_ambos;
    private javax.swing.JPanel btn_lavado;
    private javax.swing.JPanel btn_pension;
    private javax.swing.JButton btn_retirar;
    private javax.swing.JButton btnregistrar;
    private javax.swing.JButton buscar;
    private javax.swing.JTextField buscarColor;
    private javax.swing.JTextField buscarMarca;
    private javax.swing.JTextField buscarModelo;
    private javax.swing.JTextField cobrito;
    private javax.swing.JComboBox<String> colorOp;
    private javax.swing.JLabel fechainicial;
    private javax.swing.ButtonGroup grupoBoton;
    private javax.swing.JLabel horita;
    private javax.swing.JTextField impo;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label2;
    private javax.swing.JLabel label3;
    private javax.swing.JLabel label4;
    private javax.swing.JLabel label5;
    private javax.swing.JLabel label6;
    private javax.swing.JComboBox<String> marcaOp;
    private javax.swing.JComboBox<String> modeloOp;
    private javax.swing.JButton modificar;
    private javax.swing.JTextArea observacion;
    private javax.swing.JTextField otroCo;
    private javax.swing.JTextField otroMar;
    private javax.swing.JTextField otroModelo;
    private javax.swing.JTextField placas;
    private javax.swing.JRadioButton rbAuto;
    private javax.swing.JRadioButton rbCami;
    private javax.swing.JRadioButton rbMoto;
    private javax.swing.JTextField servicio;
    private javax.swing.JComboBox<String> tamanioV;
    private javax.swing.JTextField tipoVehiculos;
    // End of variables declaration//GEN-END:variables
}
