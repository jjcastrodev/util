/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.afip.dgi.agencia66.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author u84062
 */
public class FormateaSalidasTexto {
    
    public static final String QUOTE="\"";
    
    public String formatoCuit(String _cuit) {
        System.out.println("Recibo: " +_cuit);
        String prefijo = _cuit.substring(0, 2);
        String documento = _cuit.substring(2,10);
        String posfijo = _cuit.substring(10,11);
        System.out.println("Retorno: " +prefijo + "-" + documento + "-" + posfijo);
        return prefijo + "-" + documento + "-" + posfijo;
    }
    
    public String cuitSinGuiones(String _cuit) {
        System.out.println("Recibo: " +_cuit);
        String prefijo = _cuit.substring(0, 2);
        String documento = _cuit.substring(3,11);
        String posfijo = _cuit.substring(12,13);
        return prefijo+documento+posfijo;
    }
    
    public String cuitADocumento(String _cuit) {
        return _cuit.substring(2,10);
        
    }
    
    public String formatoFecha(String _fecha) throws ParseException {
        SimpleDateFormat entrada = new SimpleDateFormat("yyMMdd");
        SimpleDateFormat salida = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaFormateada = entrada.parse(_fecha);
                    
                    System.out.println("fecha con salida: " +salida.format(_fecha));
         return salida.format(_fecha);               
                    
    }
    
    public String fecha2SqliteFecha(String fechaEntrada) {
        System.out.println("Recibo: " +fechaEntrada);
        System.out.println("anio: " +fechaEntrada.substring(0, 4));
        System.out.println(" Mes: " +fechaEntrada.substring(4, 6) );
        System.out.println(" dia: " +fechaEntrada.substring(6, 8));
        return fechaEntrada.substring(0, 4) + "-" + fechaEntrada.substring(4, 6) + "-" + fechaEntrada.substring(6, 8);
    }
    
    public String fechaImprimir(String fechaEntrada) {
        System.out.println("Recibo de fecha para imprimir: " +fechaEntrada);
        return fechaEntrada.substring(8, 10) + "/" +fechaEntrada.substring(5, 7) +"/" + fechaEntrada.substring(0, 4);
        
    }
    
    public static String[] quitarComillas(String[] fields) {
        
      String result[] = new String[fields.length];

      for (int i=0;i<result.length;i++){
         result[i] = fields[i].replaceAll("^"+QUOTE, "").replaceAll(QUOTE+"$", "");
      }
      return result;
   }
    
    
   /**
    * 
    * @param leyenda es un String con el impuesto + separador + Descripcion
    * por ej.: 30 - IVA o bien 11 - GANANCIAS PERSONAS FISICAS
    * @return un int con el valor numerico del impuesto
    */ 
   public static int impuestoSinDesc(String leyenda) {
        return Integer.parseInt(leyenda.substring(0, leyenda.indexOf("-")-1));
   } 
}
