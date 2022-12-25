/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esta;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Leandro
 */
public class tiempofech {
    
    Calendar fecha = new GregorianCalendar();
    
    String anho = Integer.toString(fecha.get(Calendar.YEAR));
    String mes = Integer.toString(fecha.get(Calendar.MONTH));
    String dia = Integer.toString(fecha.get(Calendar.DATE));
}
