package Proyecto;

import java.sql.*;
import java.util.*;

public class DAO_Vehiculo extends DAO_Abstract{

    /**
     * Crea un array de vehÝculos con los datos de la tabla vehÝculos de la base de datos.
     * 
     * @return array de vehÝculos
     */
    @Override
    public ArrayList<Object> recibirDatos() {
        ArrayList<Object> datosVehÝculos= new ArrayList<>();
        try {
            rs = stm.executeQuery("select * from desarrollodeinterfaces.vehÝculo");
            while(rs.next()){
                datosVehÝculos.add(new Vehiculo(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7)));
            }
        } catch (SQLException ex) {
            System.out.println("Oh no!");
        }
        return datosVehÝculos;
    }

    /**
     * Inserta los datos pasados como parßmetro en la tabla vehÝculos de la BD.
     * 
     * @param datos 
     */
    @Override
    public void subirDatos(ArrayList<Object> datos) {
        try {
            for (Object dato : datos){
                Vehiculo datoVehÝculo=(Vehiculo)dato;
            stm.executeUpdate("INSERT INTO `desarrollodeinterfaces`.`vehÝculo` "
                    + "(`Num_Serial`, `Modelo`, `Marca`, "
                    + "`Tipo`, `Precio`, `Fecha_Entrada`, `Inf_Adicional`) VALUES"
                    + " ("+datoVehÝculo.numSerial+", '"+datoVehÝculo.modelo+
                    "', '"+datoVehÝculo.marca+"', '"+datoVehÝculo.tipo+"', "+
                    datoVehÝculo.precio+", '"+datoVehÝculo.fechaEntrada+"', '"+
                    datoVehÝculo.infoAdicional+"');");
            }
        } catch (SQLException ex) {
            System.out.println("Oh no!");
        }
    }
    
    public void agregarDatos(Object[]datos) {
        try {
        	if(datos.length==6) {
        		stm.executeUpdate("INSERT INTO `desarrollodeinterfaces`.`vehÝculo` (`Num_Serial`, `Modelo`, `Marca`, `Tipo`, `Precio`, `Fecha_Entrada`) VALUES ("+datos[0]+", '"+datos[1]+"', '"+datos[2]+"', '"+datos[3]+"', "+datos[4]+", '"+datos[5]+"');");
        	}else if (datos.length==7) {
        		stm.executeUpdate("INSERT INTO `desarrollodeinterfaces`.`vehÝculo` (`Num_Serial`, `Modelo`, `Marca`, `Tipo`, `Precio`, `Fecha_Entrada`, `Inf_Adicional`) VALUES ("+datos[0]+", '"+datos[1]+"', '"+datos[2]+"', '"+datos[3]+"', "+datos[4]+", '"+datos[5]+"', '"+datos[6]+"');");
        	}
        } catch (SQLException ex) {
            System.out.println("Oh no!");
        }
    }
    
    public ArrayList<Object> buscarVehiculos(Object[]datos) {
        ArrayList<Object> datosVehÝculos= new ArrayList<>();
        try {
            rs = stm.executeQuery("SELECT * FROM desarrollodeinterfaces.vehÝculo WHERE `Modelo` = '"+datos[0]+"' `Marca` = '"+datos[1]+"', `Tipo` = '"+datos[2]+"';");
            while(rs.next()){
                datosVehÝculos.add(new Vehiculo(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7)));
            }
        } catch (SQLException ex) {
            System.out.println("Oh no!");
        }
        return datosVehÝculos;
    }
    
    public ArrayList<Object> buscarVehiculosModelo(String modelo) {
        ArrayList<Object> datosVehÝculos= new ArrayList<>();
        try {
            rs = stm.executeQuery("SELECT * FROM desarrollodeinterfaces.vehÝculo WHERE `Modelo` = '"+modelo+"';");
            while(rs.next()){
                datosVehÝculos.add(new Vehiculo(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7)));
            }
        } catch (SQLException ex) {
            System.out.println("Oh no!");
        }
        return datosVehÝculos;
    }
    
    public ArrayList<Object> buscarVehiculosMarca(String marca) {
        ArrayList<Object> datosVehÝculos= new ArrayList<>();
        try {
            rs = stm.executeQuery("SELECT * FROM desarrollodeinterfaces.vehÝculo WHERE `Marca` = '"+marca+"';");
            while(rs.next()){
                datosVehÝculos.add(new Vehiculo(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7)));
            }
        } catch (SQLException ex) {
            System.out.println("Oh no!");
        }
        return datosVehÝculos;
    }
    
    public ArrayList<Object> buscarVehiculosTipos(String tipo) {
        ArrayList<Object> datosVehÝculos= new ArrayList<>();
        try {
            rs = stm.executeQuery("SELECT * FROM desarrollodeinterfaces.vehÝculo WHERE `Tipo` = '"+tipo+"';");
            while(rs.next()){
                datosVehÝculos.add(new Vehiculo(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7)));
            }
        } catch (SQLException ex) {
            System.out.println("Oh no!");
        }
        return datosVehÝculos;
    }
    
    public void modificarDatos(int num_serie, Object[]data) {
        try {
        	stm.executeUpdate("UPDATE `vehÝculo` SET `Marca` = '"+data[0]+"', `Modelo` = '"+data[1]+"', `Precio` = '"+data[2]+"' WHERE `vehÝculo`.`Num_Serial` = '"+num_serie+"'");
        } catch (SQLException ex) {
            System.out.println("Oh no!");
        }
    }
    
}
