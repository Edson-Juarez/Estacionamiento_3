/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esta;

/**
 *
 * @author edson
 */
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.Doc;
import javax.print.PrintException;
import javax.print.ServiceUI;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.swing.JOptionPane;
//Impotacion de librerias para utilizar metodos conforme a la cola de impresion y formato de ticket

/**
 * @author edson
 */
public class ticketClase {

    java.sql.Date hoy = new java.sql.Date(new java.util.Date().getTime());
    String horaActual = new SimpleDateFormat("HH:mm").format(Calendar.getInstance().getTime());
    //Obtencion de la fecha y hora actuales

    //Atributos que almacenan los datos de la empresa y de la compra
    private String empresa = "Estacionamiento, LavaAutos y   Pension\n          Estacion 3";
    private String propietario = "Ing. Jorge M. Landeta";
    private String correo = "jorge.landeta@yahoo.com.mx";
    private String rfc = "LAMJ710703U45";
    private String direccion = "Col Reforma CP. 68050\n           Calzada Porfirio Diaz";
    private String telefono = "951-129-5870";
    private String fecha = (horaActual + " " + hoy.toString());
    private String folio;
    private String tipo;
    private String placas;
    private String color;
    private String marca;
    private String modelo;
    private String articulos;
    private String total = "_______";
    private String matriz = "Sucursal Unica";

    /**
     * Atributo que almacena la estructura del contenido del ticket Los campos
     * que tengan la siguiente estructura {{nombreAtributo}}, ejemplo:
     * {{telefono}} serán reemplazados por los datos correspondientes.
     */
    private String formatoTicket
            = "**\n" + (char) 27 + (char) 112 + (char) 0 + (char) 10 + (char) 100 + "\n {{empresa}} \n"
            + "       {{propietario}}\n"
            + "     Quejas y sugerencias\n"
            + "email:{{correo}}\n"
            + "RFC:       {{rfc}}\n"
            + "Direccion: {{direccion}}\n"
            + "Celular:   {{telefono}}\n"
            + "Fecha y Hora:  {{fecha}}\n"
            + "\n"
            + "FOLIO:     {{folio}} \n"
            + "Tipo:      {{tipo}}\n"
            + "Placas:    {{placas}}\n"
            + "Marca:     {{marca}}\n"
            + "Modelo:     {{modelo}}\n"
            + "Color:     {{color}}\n"
            + "\n"
            + "DESCRIPCION DE SERVICIO:\n"
            + "================================\n"
            + "{{articulos}}\n"
            + "================================\n\n\n"
            + "TOTAL:   $ {{total}}\n\n"
            + "    GRACIAS POR SU CONFIANZA\n\n"
            + "*Indispensable dejar sus llaves*\n"
            + "Costo por reposicion $50 mxn\n "
            + " \n"
            + "Expedido en {{matriz}}\n\n"
            + "Horario de atencion:\n"
            + "L-V 8:00 am a 20:30 pm\n"
            + "S 8:00 am a 15:00 pm\n"
            + "\n\n\n\n ";

    //Definimos los metodos SET de cada atributo para asignar los datos al TICKET.
    /**
     * @param empresa nombre del negocio
     */
    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    /**
     * @param propietario dueño del negocio
     */
    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    /**
     * @param correo registro del negocio
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * @param rfc registro del negocio
     */
    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    /**
     * @param direccion del negocio
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @param telefono del negocio
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @param fecha fecha de impresion
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @param folio el folio de la venta
     */
    public void setFolio(String folio) {
        this.folio = folio;
    }

    /**
     * @param tipo el tipo de vehículo
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @param placas placas de la unidad
     */
    public void setPlacas(String placas) {
        this.placas = placas;
    }

    /**
     * @param marca Marca comercial del vehículo
     *
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    /**
     * @param color color de la unidad de motor
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * @param articulos datos del producto vendido
     */
    public void setArticulos(String articulos) {
        this.articulos = articulos;
    }

    /**
     * @param total total de la compra
     */
    public void setTotal(String total) {
        this.total = total;
    }

    /**
     * @param matriz nombre de la sucursal principal
     */
    public void setMatriz(String matriz) {
        this.matriz = matriz;
    }

    /*-------------------------------------- Condiciones aun por discutir con el usuario final, por politicas o ahorro de papel
    "Terminos y Condiciones\n" +
"No nos hacemos responsables por:\n" +
"a)Danios ocasionados directamente por los usuarios del estacionamiento\n" +
"b)Perdida de objetos dejados en vehiculo\n" +
"c)Danios por fenomenos, alborotos populares o estudiantiles\n" +
"d)Fallas mecanicas y/o electricas del   vehiculo\n" +
"e)Robo Total o Parcial del vehiculo por extravio del boleto sin haberlo reportado al encargado a tiempo\n" +
"f)Las tarifas del estacionamiento estan sujetas a cambios sin previo aviso\n" +
"     ¡¡No pierda su Boleto!!\n" +
"a)Si pierde su boleto se le cobrara un adicional equivalente a $50 mxn\n" +
"b)El vehiculo se entregara unicamente a la persona que entregue este boleto en caso de perdida se debera reportar de inmediato al encargado\n" +
"y el vehiculo se entregara unicamente al propietario\n" +
"c)En caso de no recoger su vehiculo en  horario de servicio, se cobrara el costo por noche de $150 mxn\n" +*/
    /**
     *
     * EL CUAL LE ASIGNAMOS DESDE LA VENTANA DE IMPRESORA Y DISPOSITIVOS
     * (WINDOWS) Configuración del documento de impresión y reemplazo de los
     * campos con el valor de las propiedades
     */
    public void print(boolean flagServicio) throws IOException {
        //Datos de impresion.
        //Datos de la Empresa y/o negocio
        this.formatoTicket = formatoTicket.replace("{{empresa}}", this.empresa);
        this.formatoTicket = formatoTicket.replace("{{propietario}}", this.propietario);
        this.formatoTicket = formatoTicket.replace("{{correo}}", this.correo);
        this.formatoTicket = formatoTicket.replace("{{rfc}}", this.rfc);
        this.formatoTicket = formatoTicket.replace("{{direccion}}", this.direccion);
        this.formatoTicket = formatoTicket.replace("{{telefono}}", this.telefono);
        this.formatoTicket = formatoTicket.replace("{{fecha}}", this.fecha);
        //Datos de la unidad de motor
        this.formatoTicket = formatoTicket.replace("{{folio}}", this.folio);
        this.formatoTicket = formatoTicket.replace("{{tipo}}", this.tipo);
        this.formatoTicket = formatoTicket.replace("{{placas}}", this.placas);
        this.formatoTicket = formatoTicket.replace("{{marca}}", this.marca);
        this.formatoTicket = formatoTicket.replace("{{modelo}}", this.modelo);
        this.formatoTicket = formatoTicket.replace("{{color}}", this.color);
        this.formatoTicket = formatoTicket.replace("{{articulos}}", this.articulos);
        this.formatoTicket = formatoTicket.replace("{{total}}", this.total);
        this.formatoTicket = formatoTicket.replace("{{matriz}}", this.matriz);

        //Especificamos el tipo de dato a imprimir
        //Tipo: bytes -- Subtipo: autodetectado
        DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
        //Creamos un arreglo de tipo byte y le agregamos el string convertido (cuerpo del ticket)
        //a bytes tal como lo maneja la impresora.
        byte[] bytes = this.formatoTicket.getBytes();
        //Creamos un documento a imprimir pasandole el arreglo de byte
        Doc doc = new SimpleDoc(bytes, flavor, null);

        //Creamos un trabajo de impresión
        DocPrintJob job = null;
        //Creamos una bandera para determinar si se encontro la impresora
        //que especificamos en este caso "subarasi" O si usamos la impresora predeterminada del S.O.
        boolean flagJob = false;

        //Opcion 1 ->nos da el array de los servicios de impresion
        PrintService[] services = PrintServiceLookup.lookupPrintServices(null, null);
        //Opcion 2-> servicios de impresion por default
        PrintService defaultService = PrintServiceLookup.lookupDefaultPrintService();
        //Opcion 3-> mostramos dialogo para seleccionar impresoras que soporten arreglos de bits
        PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
        PrintService printService[] = PrintServiceLookup.lookupPrintServices(flavor, pras);

        /*flagServicio
        *   
        *true --si queremos imprimir en una impresora especifica  en este caso "subarasi"
        *       o si deseamos imprimir en la impresora establecida como predeterminada en el Sistema Operativo
        *false --si queremos visualizar el cuadro de dialogo de impresion y elegir una impresora
        *        que soporte arreglo de bits
         */
        if (flagServicio == true) {
            if (services.length > 0) {//usamos la opcion 1 y comprobamos si hay impresoras disponibles
                //Recorremos el arreglo de impresoras
                for (PrintService service1 : services) {
                    //Aqui definimos el nombre de la impresora (para este ejemplo: subarasi)
                    // y comparamos si esta dentro del arreglo de impresoras
                    if (service1.getName().equals("Tickets")) {
                        job = service1.createPrintJob(); // creamos el trabajo de impresion
                        flagJob = true; //si la impresora existe ponemos en TRUE la bandera
                    }
                }
            }
            //En caso de que la opcion 1 no encuentre la impresora que buscamos
            // el flagJob es false y job es null, entonces empleamos la opcion 2
            if (job == null && flagJob == false) {
                //creamos el trabajo de impresion con el servicio de impresion por default
                //(la impresora establecida como predeterminada en el sistema operativo)
                job = defaultService.createPrintJob();
            }
            flagJob = false;
        } else {
            //si flagServicio es false, usamos la opcion 3 para crear el trabajo de impresion
            //seleccionando la impresora desde el cuadro de dialogo de impresion
            PrintService service = ServiceUI.printDialog(null, 700, 200, printService, defaultService, flavor, pras);
            job = service.createPrintJob();
        }

        //por ultimo Imprimimos dentro de un try obligatoriamente para el contro de excepciones
        try {
            job.print(doc, null);
        } catch (PrintException ex) {
            JOptionPane.showMessageDialog(null, "IMPRIMIR TICKET (Compruebe impresion) " + ex.getMessage());
        }
    }

    void print() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
