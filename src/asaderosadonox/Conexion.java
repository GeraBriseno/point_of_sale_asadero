/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asaderosadonox;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.time.*;
/**
 *
 * @author Gerardo
 */
public class Conexion {
    
    static Connection con = null;
    static PreparedStatement statement = null;
    static ResultSet rs = null;
    static String url       = "jdbc:mysql://localhost:3306/asaderos_adono?zeroDateTimeBehavior=CONVERT_TO_NULL";
    static String user      = "root";
    static String password  = "pass";
    static Double precio;
    static int id;
    static int updateCount;
    
    public static Double getPrecio(int get){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            statement = con.prepareStatement("select precio from precios where id_articulo =?");
            statement.setInt(1, get);
            rs = statement.executeQuery();
                if(rs.next()){
                    precio = rs.getDouble("precio");
                }
            con.close();    
        }
            catch(Exception e){
                System.out.print(e);
            }
        return precio;
    }
    public static void guardarCliente(String nombre, String domicilio, String telefono, String referencia){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            statement = con.prepareStatement(
                    "insert into clientes (nombre, domicilio, telefono, referencia) values (?,?,?,?)");
            statement.setString(1, nombre);
            statement.setString(2, domicilio);
            statement.setString(3, telefono);
            statement.setString(4, referencia);
            updateCount = statement.executeUpdate();
            new JOptionPane().showMessageDialog(null, "Nuevo Cliente Guardado", "Clientes", JOptionPane.INFORMATION_MESSAGE);
            con.close();
        }
            catch(Exception e){
                System.out.print(e);
            }
    }
    public static ResultSet buscarClienteTelefono(String telefono){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            statement = con.prepareStatement(
                    "select * from clientes where telefono like ?");
            statement.setString(1, "%" +telefono+ "%");
            rs = statement.executeQuery();  
        }
            catch(Exception e){
                System.out.print(e);
                
            }
        return rs;
    }
    public static void agregarAOrden(Double cantidad, String articulo, String descripcion, Double precio, int id_articulo){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            statement = con.prepareStatement(
                    "insert into orden (cantidad, articulo, descripcion, precio, id_articulo) values (?,?,?,?,?)");
            statement.setDouble(1, cantidad);
            statement.setString(2, articulo);
            statement.setString(3, descripcion);
            statement.setDouble(4, precio);
            statement.setInt(5, id_articulo);
            updateCount = statement.executeUpdate();
            //new JOptionPane().showMessageDialog(null, "Añadido a la Orden", "Orden", JOptionPane.INFORMATION_MESSAGE);
            con.close();
        }
            catch(Exception e){
                System.out.print(e);
            }
    }
    public static void eliminarDeOrden(String articulo){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            statement = con.prepareStatement(
                    "delete from orden where articulo = ?");
            statement.setString(1, articulo);
            updateCount =  statement.executeUpdate();
            new JOptionPane().showMessageDialog(null, "Eliminado de la Orden", "Orden", JOptionPane.INFORMATION_MESSAGE);
            con.close();
        }
            catch(Exception e){
                System.out.print(e);
            }
    }
    public static void agregarATableOrden(JTable tabla){
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        model.setRowCount(0);
        try{
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            statement = con.prepareStatement(
                    "select * from orden");
            rs = statement.executeQuery();
            while(rs.next()){
                Double cantidad = rs.getDouble("cantidad");
                String articulo = rs.getString("articulo");
                String descripcion = rs.getString("descripcion");
                Double precio = rs.getDouble("precio");
                
                Object[] row = {cantidad, articulo, descripcion, precio};
                
                model.insertRow(0, row);
            }
            con.close();
        }
            catch(Exception e){
                System.out.print(e);
            }
    }
    public static void mostrarTotalOrden(JTable tabla){
        Double total = 0.0;
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            statement = con.prepareStatement("select sum(precio) from orden");
            rs = statement.executeQuery();
                if(rs.next()){
                    String sum = rs.getString(1);
                    total = Double.parseDouble(sum);
                }
            con.close();    
        }
            catch(Exception e){
                System.out.print(e);
            }
        Object[] row = {null, "Total", null, total};
        model.addRow(row);
    }
    public static void terminarOrden(int id_cliente, String repartidor, String formaDePago, boolean pagado){
        Double total = 0.0;
        Double servicioDomicilio = 0.0;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            PreparedStatement statementSumaPrecio = null;
            PreparedStatement statementInsertarODia = null;
            PreparedStatement statementTruncateOrden = null;
            PreparedStatement statementServicioDomicilio = null;

            statementSumaPrecio = con.prepareStatement("select sum(precio) from orden");
            ResultSet rsSumaPrecio = statementSumaPrecio.executeQuery();
            if(rsSumaPrecio.next()){
                String sum = rsSumaPrecio.getString(1);
                total = Double.parseDouble(sum);
            }
            
            statementServicioDomicilio = con.prepareStatement("select precio from orden where articulo = ?");
            statementServicioDomicilio.setString(1, "Servicio Domicilio");
            ResultSet rsServicioDomicilio = statementServicioDomicilio.executeQuery();
            if(rsServicioDomicilio.next()){
                servicioDomicilio = rsServicioDomicilio.getDouble(1);
            }

            statementInsertarODia = con.prepareStatement("insert into ordenes_dia (total, id_cliente, repartidor, servicio_domicilio, pagado, forma_pago) values (?,?,?,?,?,?)");
            statementInsertarODia.setDouble(1, total);
            statementInsertarODia.setInt(2, id_cliente);
            statementInsertarODia.setString(3, repartidor);
            statementInsertarODia.setDouble(4, servicioDomicilio);
            statementInsertarODia.setBoolean(5, pagado);
            statementInsertarODia.setString(6, formaDePago);
            updateCount = statementInsertarODia.executeUpdate();
            
            statementTruncateOrden = con.prepareStatement("truncate table orden");
            statementTruncateOrden.executeUpdate();
            
            con.close();
        }
            catch(Exception e){
                System.out.print(e);
            }
    }
    public static void cancelarOrden(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            statement = con.prepareStatement("truncate table orden");
            statement.executeUpdate();

            con.close();    
        }
            catch(Exception e){
                System.out.print(e);
            }
    }
    public static void servicioDomicilio(JTable tablaOrden){
        int servicioGet = 55;
        String servicioArticulo = "Servicio Domicilio";
        Double cantidad = 1.0;
        Double precioSDomicilio = 0.0;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            
            PreparedStatement statementPrecio = con.prepareStatement("select precio from precios where id_articulo = ?");
            statementPrecio.setInt(1, servicioGet);
            ResultSet rsPrecio = statementPrecio.executeQuery();
            if(rsPrecio.next()){
                precioSDomicilio = rsPrecio.getDouble(1);
            }
            
            statement = con.prepareStatement("insert into orden (cantidad, articulo, precio) values (?,?,?)");
            statement.setDouble(1, cantidad);
            statement.setString(2, servicioArticulo);
            statement.setDouble(3, precioSDomicilio);
            statement.executeUpdate();
            con.close();    
        }
            catch(Exception e){
                System.out.print(e);
            }
    }
    public static void mostrarRepartidores(JTable tablaRepartidores){
        DefaultTableModel model = (DefaultTableModel) tablaRepartidores.getModel();
        model.setRowCount(0);
        try{
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            statement = con.prepareStatement(
                    "select * from repartidores");
            rs = statement.executeQuery();
            while(rs.next()){
                String nombre = rs.getString("nombre");
                
                Object[] row = {nombre};
                
                model.insertRow(0, row);
            }
            con.close();
        }
            catch(Exception e){
                System.out.print(e);
            }
    }
    public static void mostrarOrdenesDelDia(JTable tablaOrdenesDia){
        DefaultTableModel model = (DefaultTableModel) tablaOrdenesDia.getModel();
        model.setRowCount(0);
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            statement = con.prepareStatement(
                    "select * from ordenes_dia");
            rs = statement.executeQuery();
            while(rs.next()){
                int numOrden = rs.getInt("nm_orden");
                Double totalOrden= rs.getDouble("total");
                int idClienteOrden = rs.getInt("id_cliente");
                String repartidorOrden = rs.getString("repartidor");
                String pagcad = (rs.getBoolean("pagado")?"SI":"NO");
//                boolean pagado = rs.getBoolean("pagado");
                Double servicio_domicilio = rs.getDouble("servicio_domicilio");
                String formaDePago = rs.getString("forma_pago");
                
                Object[] row = {numOrden, idClienteOrden, totalOrden, pagcad, servicio_domicilio, repartidorOrden, formaDePago};
                
                model.insertRow(0, row);
            }
            
            PreparedStatement statementTotal = con.prepareStatement("select sum(total) from ordenes_dia");
            ResultSet rsTotal = statementTotal.executeQuery();
                if(rsTotal.next()){
                    String sum = rsTotal.getString(1);
                    Double totalDia = Double.parseDouble(sum);
                    Object[] rowTotal = {null, null, totalDia, null, null, "Total"};
                    model.addRow(rowTotal);
                }
            con.close();
        }
            catch(Exception e){
                System.out.print(e);
            }
    }
    public static void mostrarTotalRepartidor(JTable tabla_OrdenesDia, String nombreRepartidor){
        String nombreSRepartidor = nombreRepartidor;
        Double total = 0.0;
        Double servicios = 0.0;
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);           
            
            PreparedStatement statementTotal = con.prepareStatement(
                "select sum(total) from ordenes_dia where repartidor = ? and pagado = ? and forma_pago = ?");
            statementTotal.setString(1,nombreSRepartidor);
            statementTotal.setBoolean(2, false);
            statementTotal.setString(3, "Efectivo");
            ResultSet rsTotal = statementTotal.executeQuery();
            if(rsTotal.next()){
                total = rsTotal.getDouble(1);
            }
            
            PreparedStatement statementServicios = con.prepareStatement(
                    "select sum(servicio_domicilio) from ordenes_dia where repartidor = ?");
            statementServicios.setString(1,nombreRepartidor);
            ResultSet rsServicios = statementServicios.executeQuery();
            if(rsServicios.next()){
                servicios = rsServicios.getDouble(1);
            }
            new JOptionPane().showMessageDialog(
                    null,nombreSRepartidor+" Total: "+total+"\n"+"Servicios: "+servicios+"\n"+"A pagar: "+(total-(servicios)), "Total Repartidor", JOptionPane.INFORMATION_MESSAGE);
            con.close();
        }
            catch(Exception e){
                System.out.print(e);
            }
    }
    public static void cambiarRepartidor(JTable tabla_OrdenesDia, String nombreRepartidor, int nmOrden){
        DefaultTableModel model = (DefaultTableModel) tabla_OrdenesDia.getModel();
        model.setRowCount(0);
        String nombreSRepartidor = nombreRepartidor;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            statement = con.prepareStatement(
                "update ordenes_dia set repartidor = ? where nm_orden = ?");
            statement.setString(1, nombreSRepartidor);
            statement.setInt(2,nmOrden);
            statement.executeUpdate();
            con.close();
        }
            catch(Exception e){
                System.out.print(e);
            }
    }
    public static void mostrarPrecios(JTable tablaPrecios){
        DefaultTableModel model = (DefaultTableModel) tablaPrecios.getModel();
        model.setRowCount(0);
        try{
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            statement = con.prepareStatement(
                    "select * from precios");
            rs = statement.executeQuery();
            while(rs.next()){
                String articulo = rs.getString("articulo");
                Double precio = rs.getDouble("precio");
                Object[] row = {articulo, precio};
                
                model.insertRow(0, row);
            }
            con.close();
        }
            catch(Exception e){
                System.out.print(e);
            }
    }
    public static void cambiarPrecio(JTable tablaPrecios, Double nuevoPrecio, String articulo){
        DefaultTableModel model = (DefaultTableModel) tablaPrecios.getModel();
        model.setRowCount(0);
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            statement = con.prepareStatement(
                "update precios set precio = ? where articulo = ?");
            statement.setDouble(1, nuevoPrecio);
            statement.setString(2, articulo);
            statement.executeUpdate();
            con.close();
        }
            catch(Exception e){
                System.out.print(e);
            }
    }
    public static void eliminarRepartidor(JTable tablaRepartidores, String nombreRepartidor){
        DefaultTableModel model = (DefaultTableModel) tablaRepartidores.getModel();
        model.setRowCount(0);
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            statement = con.prepareStatement(
                "delete from repartidores where nombre = ?");
            statement.setString(1, nombreRepartidor);
            statement.executeUpdate();
            con.close();
        }
            catch(Exception e){
                System.out.print(e);
            }
    }
    public static void agregarRepartidor(JTable tablaRepartidores, String nombreRepartidor){
        DefaultTableModel model = (DefaultTableModel) tablaRepartidores.getModel();
        model.setRowCount(0);
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            statement = con.prepareStatement(
                "insert into repartidores (nombre) values (?)");
            statement.setString(1, nombreRepartidor);
            statement.executeUpdate();
            con.close();
        }
            catch(Exception e){
                System.out.print(e);
            }
    }
    public static void mostrarDatosCliente(int id_cliente){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            statement = con.prepareStatement(
                "select * from clientes where id_cliente = ?");
            statement.setInt(1, id_cliente);
            rs = statement.executeQuery();
            if(rs.next()){
                String nombre = rs.getString("nombre");
                String domicilio = rs.getString("domicilio");
                String telefono = rs.getString("telefono");
                new JOptionPane().showMessageDialog(
                        null, "Nombre: "+nombre+"\n"+"Domicilio: "+domicilio+"\n"+"Telefono: "+telefono, "Información del Cliente", JOptionPane.INFORMATION_MESSAGE);
            }
            con.close();
        }
            catch(Exception e){
                System.out.print(e);
            }
    }
    public static void agregarGasto(String concepto, double total){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            statement = con.prepareStatement(
                "insert into gastos (concepto, total) values (?,?)");
            statement.setString(1, concepto);
            statement.setDouble(2, total);
            statement.executeUpdate();
            con.close();
        }
            catch(Exception e){
                System.out.print(e);
            }
    }
    public static void mostrarGastos(JTable tablaGastos){
        DefaultTableModel model = (DefaultTableModel) tablaGastos.getModel();
        model.setRowCount(0);
        try{
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            statement = con.prepareStatement(
                    "select * from gastos");
            rs = statement.executeQuery();
            while(rs.next()){
                String concepto = rs.getString("concepto");
                Double total = rs.getDouble("total");
                Object[] row = {concepto, total};
                
                model.insertRow(0, row);
            }
            
            PreparedStatement statementTotal = con.prepareStatement(
                    "select sum(total) from gastos");
            ResultSet rsTotal = statementTotal.executeQuery();
            if(rsTotal.next()){
                Double totalGastos = rsTotal.getDouble(1);
                Object[] rowTotal = {"Total", totalGastos};
                
                model.addRow(rowTotal);
            }
            con.close();
        }
            catch(Exception e){
                System.out.print(e);
            }
    }
    public static void eliminarGasto(String concepto){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            statement = con.prepareStatement(
                    "delete from gastos where concepto = ?");
            statement.setString(1, concepto);
            updateCount =  statement.executeUpdate();
            new JOptionPane().showMessageDialog(null, "Eliminado de Gastos", "Gastos", JOptionPane.INFORMATION_MESSAGE);
            con.close();
        }
            catch(Exception e){
                System.out.print(e);
            }
    }
    public static void corteDeCaja(){
        
        JTextPane tp_corteDeCaja = new JTextPane();
        
        Double serviciosDomicilio = 0.0;      
        Double vendido = 0.0;
        Double gastos = 0.0;
        Double total = 0.0;
        Double ingresos = 0.0;
        Double retiros = 0.0;
        Double transferencias = 0.0;
        Double numeroDeOrdenes = 0.0;
        
        //DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd");
        LocalDate localDate = LocalDate.now();
        Date fecha = Date.valueOf(localDate);
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            
            PreparedStatement statementServiciosDomicilio = con.prepareStatement(
                "select sum(servicio_domicilio) from ordenes_dia");
            ResultSet rsServiciosDomicilio = statementServiciosDomicilio.executeQuery();
            if(rsServiciosDomicilio.next()){
                serviciosDomicilio = rsServiciosDomicilio.getDouble(1);
            }
            
            PreparedStatement statementNumeroDeOrdenes = con.prepareStatement(
                "select count(*) from ordenes_dia");
            ResultSet rsNumeroDeOrdenes = statementNumeroDeOrdenes.executeQuery();
            if(rsNumeroDeOrdenes.next()){
                numeroDeOrdenes = rsNumeroDeOrdenes.getDouble(1);
            }
            
            PreparedStatement statementVendido = con.prepareStatement(
                    "select sum(total) from ordenes_dia");
            ResultSet rsVendido = statementVendido.executeQuery();
            if(rsVendido.next()){
                vendido = rsVendido.getDouble(1);
            }
            
            PreparedStatement statementGastos = con.prepareStatement(
                "select sum(total) from gastos");
            ResultSet rsGastos = statementGastos.executeQuery();
            if(rsGastos.next()){
                gastos = rsGastos.getDouble(1);
            }
            
            PreparedStatement statementRetiros = con.prepareStatement(
                "select sum(monto) from retiros");
            ResultSet rsRetiros = statementRetiros.executeQuery();
            if(rsRetiros.next()){
                retiros = rsRetiros.getDouble(1);
            }
            
            PreparedStatement statementIngresos = con.prepareStatement(
                "select sum(monto) from ingresos");
            ResultSet rsIngresos = statementIngresos.executeQuery();
            if(rsIngresos.next()){
                ingresos = rsIngresos.getDouble(1);
            }
            
            PreparedStatement statementTransferencias = con.prepareStatement(
                "select sum(total) from ordenes_dia where forma_pago = ?");
            statementTransferencias.setString(1, "Transferencia");
            ResultSet rsTransferencias = statementTransferencias.executeQuery();
            if(rsTransferencias.next()){
                transferencias = rsTransferencias.getDouble(1);
            }
            
            total = vendido-gastos-retiros-serviciosDomicilio-transferencias+ingresos;
            
            PreparedStatement statementAgregarAHistorial = con.prepareStatement(
                "insert into historial (fecha, vendido, gastos, servicios_domicilio, ingresos, retiros, total) values (?,?,?,?,?,?,?)");
            statementAgregarAHistorial.setDate(1, fecha);
            statementAgregarAHistorial.setDouble(2, vendido);
            statementAgregarAHistorial.setDouble(3, gastos);
            statementAgregarAHistorial.setDouble(4, serviciosDomicilio);
            statementAgregarAHistorial.setDouble(5, ingresos);
            statementAgregarAHistorial.setDouble(6, retiros);
            statementAgregarAHistorial.setDouble(7, total);
            statementAgregarAHistorial.executeUpdate();
            
            PreparedStatement statementBorrarOrdenesDia = con.prepareStatement(
                "truncate table ordenes_dia");
            statementBorrarOrdenesDia.executeUpdate();
            
            PreparedStatement statementBorrarGastos = con.prepareStatement(
                "truncate table gastos");
            statementBorrarGastos.executeUpdate();
            
            PreparedStatement statementBorrarIngresos = con.prepareStatement(
                "truncate table ingresos");
            statementBorrarIngresos.executeUpdate();
            
            PreparedStatement statementBorrarRetiros = con.prepareStatement(
                "truncate table retiros");
            statementBorrarRetiros.executeUpdate();
            
            new JOptionPane().showMessageDialog(
                    null, "Ordenes: "+numeroDeOrdenes+"\n"+"Vendido: "+vendido+"\n"+"Gastos: "+gastos+"\n"+"Ingresos a Caja: "+ingresos+"\n"+"Retiros de Caja: "+retiros+"\n"+"Servicios a Domicilio: "+serviciosDomicilio+"\n"+"Pagos por Transferecia: "+transferencias+"\n"+"Total en Efectivo: "+total , "Corte de Caja", JOptionPane.INFORMATION_MESSAGE);
            
            
            tp_corteDeCaja.setText("\t    Asaderos Adoño \n          Tel: 317 109 0065 y 317 690 2451 \n    Domicilio: 20 Noviembre #110 Col. Centro\n             Autlán de Navarro, Jalisco\n\n");
            tp_corteDeCaja.setText(tp_corteDeCaja.getText() + "-----------------------------------------------------------------\n\n");
            tp_corteDeCaja.setText(tp_corteDeCaja.getText() + "Corte de Caja"+"\n"+"Fecha: "+fecha+"\n\n");
            tp_corteDeCaja.setText(tp_corteDeCaja.getText() + "Ordenes: "+numeroDeOrdenes+"\n"+"Vendido: "+vendido+"\n"+"Gastos: "+gastos+"\n"+"Ingresos a Caja: "+ingresos+"\n"+"Retiros de Caja: "+retiros+"\n"+"Servicios a Domicilio: "+serviciosDomicilio+"\n"+"Pagos por Transferecia: "+transferencias+"\n"+"Total en Efectivo: "+total);
            tp_corteDeCaja.setText(tp_corteDeCaja.getText() + "\n\n-----------------------------------------------------------------\n");
            
            try{tp_corteDeCaja.print();}
            catch(Exception e){System.out.println(e);}
            
            
            
            con.close();
        }
            catch(Exception e){
                System.out.print(e);
            }
    }
    public static void servicioDomicilioLargo(JTable tablaOrden){
        int servicioGet = 56;
        String servicioArticulo = "Servicio Domicilio";
        Double cantidad = 1.0;
        Double precioSDomicilio = 0.0;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            
            PreparedStatement statementPrecio = con.prepareStatement("select precio from precios where id_articulo = ?");
            statementPrecio.setInt(1, servicioGet);
            ResultSet rsPrecio = statementPrecio.executeQuery();
            if(rsPrecio.next()){
                precioSDomicilio = rsPrecio.getDouble(1);
            }
            
            statement = con.prepareStatement("insert into orden (cantidad, articulo, precio) values (?,?,?)");
            statement.setDouble(1, cantidad);
            statement.setString(2, servicioArticulo);
            statement.setDouble(3, precioSDomicilio);
            statement.executeUpdate();
            con.close();    
        }
            catch(Exception e){
                System.out.print(e);
            }
    }
    public static void mostrarHistorial(JTable tablaHistorial){
        DefaultTableModel model = (DefaultTableModel) tablaHistorial.getModel();
        model.setRowCount(0);
        try{
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            statement = con.prepareStatement(
                    "select * from historial");
            rs = statement.executeQuery();
            while(rs.next()){
                String fecha = rs.getString("fecha");
                Double vendido = rs.getDouble("vendido");
                Double servicios = rs.getDouble("servicios_domicilio");
                Double gastos = rs.getDouble("gastos");
                Double ingresos = rs.getDouble("ingresos");
                Double retiros = rs.getDouble("retiros");
                Double total = rs.getDouble("total");
                Object[] row = {fecha, vendido, gastos, servicios, ingresos, retiros, total};
                
                model.insertRow(0, row);
            }
            con.close();
        }
            catch(Exception e){
                System.out.print(e);
            }
    }
    public static void mostrarClientes(JTable tablaClientes){
        DefaultTableModel model = (DefaultTableModel) tablaClientes.getModel();
        model.setRowCount(0);
        try{
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            statement = con.prepareStatement(
                    "select * from clientes");
            rs = statement.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id_cliente");
                String nombre = rs.getString("nombre");
                String domicilio = rs.getString("domicilio");
                String telefono = rs.getString("telefono");
                String referencia = rs.getString("referencia");
                Object[] row = {id, nombre, domicilio, telefono, referencia};
                
                model.insertRow(0, row);
            }
            con.close();
        }
            catch(Exception e){
                System.out.print(e);
            }
    }
    public static void eliminarCliente(int id_cliente){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            statement = con.prepareStatement(
                    "delete from clientes where id_cliente = ?");
            statement.setInt(1, id_cliente);
            updateCount =  statement.executeUpdate();
            new JOptionPane().showMessageDialog(null, "Eliminado de Clientes", "Clientes", JOptionPane.INFORMATION_MESSAGE);
            con.close();
        }
            catch(Exception e){
                System.out.print(e);
            }
    }
    public static void editarCliente(int id_cliente, String nuevoNombre, String nuevoDomicilio, String nuevoTelefono, String nuevaReferencia){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            statement = con.prepareStatement(
                    "update clientes set nombre = ?, domicilio = ?, telefono = ?, referencia = ? where id_cliente = ?");
            statement.setString(1, nuevoNombre);
            statement.setString(2, nuevoDomicilio);
            statement.setString(3, nuevoTelefono);
            statement.setString(4, nuevaReferencia);
            statement.setInt(5, id_cliente);
            updateCount =  statement.executeUpdate();
            new JOptionPane().showMessageDialog(null, "Cliente Editado", "Clientes", JOptionPane.INFORMATION_MESSAGE);
            con.close();
        }
            catch(Exception e){
                System.out.print(e);
            }
    }
    public static ResultSet buscarClienteNombre(String nombre){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            statement = con.prepareStatement(
                    "select * from clientes where nombre like ?");
            statement.setString(1, "%" +nombre+ "%");
            rs = statement.executeQuery();  
        }
            catch(Exception e){
                System.out.print(e);
                
            }
        return rs;
    }
    public static void eliminarOrden(int numeroDeOrden){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            statement = con.prepareStatement(
                    "delete from ordenes_dia where nm_orden = ?");
            statement.setInt(1, numeroDeOrden);
            updateCount =  statement.executeUpdate();
            new JOptionPane().showMessageDialog(null, "Eliminado de Ordenes del Día", "Ordenes del Día", JOptionPane.INFORMATION_MESSAGE);
            con.close();
        }
            catch(Exception e){
                System.out.print(e);
            }
    }
    public static void mostrarIngresos(JTable tablaIngresos){
        DefaultTableModel model = (DefaultTableModel) tablaIngresos.getModel();
        model.setRowCount(0);
        try{
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            statement = con.prepareStatement(
                    "select * from ingresos");
            rs = statement.executeQuery();
            while(rs.next()){
                String concepto = rs.getString("concepto");
                Double monto = rs.getDouble("monto");
                Object[] row = {concepto, monto};
                
                model.insertRow(0, row);
            }
            
            PreparedStatement statementTotal = con.prepareStatement(
                    "select sum(monto) from ingresos");
            ResultSet rsTotal = statementTotal.executeQuery();
            if(rsTotal.next()){
                Double totalIngresos = rsTotal.getDouble(1);
                Object[] rowTotal = {"Total", totalIngresos};
                
                model.addRow(rowTotal);
            }
            con.close();
        }
            catch(Exception e){
                System.out.print(e);
            }
    }
    public static void agregarIngreso(String concepto, double monto){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            statement = con.prepareStatement(
                "insert into ingresos (concepto, monto) values (?,?)");
            statement.setString(1, concepto);
            statement.setDouble(2, monto);
            statement.executeUpdate();
            con.close();
        }
            catch(Exception e){
                System.out.print(e);
            }
    }
    public static void eliminarIngreso(String concepto){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            statement = con.prepareStatement(
                    "delete from ingresos where concepto = ?");
            statement.setString(1, concepto);
            updateCount =  statement.executeUpdate();
            new JOptionPane().showMessageDialog(null, "Eliminado de Ingresos", "Ingresos", JOptionPane.INFORMATION_MESSAGE);
            con.close();
        }
            catch(Exception e){
                System.out.print(e);
            }
    }
    public static int getIdClienteGuardado(String nombre, String telefono){
        int idCurrent = 0;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            statement = con.prepareStatement("select id_cliente from clientes where nombre = ? and telefono = ?");
            statement.setString(1, nombre);
            statement.setString(2, telefono);
            rs = statement.executeQuery();
                if(rs.next()){
                    idCurrent = rs.getInt("id_cliente");
                }
            con.close();    
        }
            catch(Exception e){
                System.out.print(e);
            }
        return idCurrent;
    }
    public static void mostrarOrdenesActivas(JTable tablaOrdenesActivas){
        DefaultTableModel model = (DefaultTableModel) tablaOrdenesActivas.getModel();
        model.setRowCount(0);
        try{
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            PreparedStatement statementOrdenesActivas = con.prepareStatement(
                    "select distinct id_cliente, sum(precio) from ordenes_activas group by id_cliente");
            ResultSet rsOrdenesActivas = statementOrdenesActivas.executeQuery();
            while(rsOrdenesActivas.next()){
                int id_cliente = rsOrdenesActivas.getInt(1);
                double total = rsOrdenesActivas.getDouble(2);

                Object[] row = {id_cliente, total};
                
                model.insertRow(0, row);
            }
            con.close();
        }
            catch(Exception e){
                System.out.print(e);
            }
    }
    public static void eliminarDeOrdenesActivas(int id_cliente){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            statement = con.prepareStatement(
                "delete from ordenes_activas where id_cliente = ?");
            statement.setInt(1, id_cliente);
            statement.executeUpdate();
            con.close();
        }
            catch(Exception e){
                System.out.print(e);
            }
    }
    public static void borrarOrden(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            statement = con.prepareStatement(
                "truncate table orden");
            statement.executeUpdate();
            con.close();
        }
            catch(Exception e){
                System.out.print(e);
            }
    }
    public static void agregarAOrdenDesdeOrdenActiva(int idCliente){
        try{
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            PreparedStatement selectStatement = con.prepareStatement(
                    "select articulo, cantidad, precio, descripcion, id_articulo from ordenes_activas where id_cliente = ?");
            selectStatement.setInt(1, idCliente);
            
            PreparedStatement insertStatement = con.prepareStatement(
                    "insert into orden (articulo, cantidad, precio, id_articulo, descripcion) values (?,?,?,?,?)");

            ResultSet rsSelect = selectStatement.executeQuery();
            while(rsSelect.next()){
                
                String articulo = rsSelect.getString("articulo");
                Double preciox = rsSelect.getDouble("precio");
                Double cantidad = rsSelect.getDouble("cantidad");
                String descripcion = rsSelect.getString("descripcion");
                int id_articulo = rsSelect.getInt("id_articulo");

                System.out.println("xxxxxxxxxxxx");
                
                insertStatement.setString(1,articulo);
                insertStatement.setDouble(2, cantidad);
                insertStatement.setDouble(3, preciox);
                insertStatement.setInt(4, id_articulo);
                insertStatement.setString(5, descripcion);
                
                insertStatement.executeUpdate();
                
            }
            //truncateOrden.executeUpdate();
            con.close();
        }
            catch(Exception e){
                System.out.print(e);
            }
    }
    public static void actualizarOrdenActiva(int idClienteActual){
        try{
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            statement = con.prepareStatement(
                    "select * from orden");
            rs = statement.executeQuery();
            
            PreparedStatement statementBorrarDeActivas = con.prepareStatement(
                    "delete from ordenes_activas where id_cliente = ?");
            statementBorrarDeActivas.setInt(1,idClienteActual);
            
            statementBorrarDeActivas.executeUpdate();
            
            PreparedStatement statementInsertarAOrdenesActivas = con.prepareStatement(
                    "insert into ordenes_activas (id_cliente, id_articulo, articulo, cantidad, precio, descripcion) values (?,?,?,?,?,?)"); 

            while(rs.next()){
                int id_articulo = rs.getInt("id_articulo");
                Double cantidad = rs.getDouble("cantidad");
                String articulo = rs.getString("articulo");
                Double precio = rs.getDouble("precio");
                String descripcion = rs.getString("descripcion");
            
                statementInsertarAOrdenesActivas.setInt(1,idClienteActual);
                statementInsertarAOrdenesActivas.setInt(2, id_articulo);
                statementInsertarAOrdenesActivas.setString(3, articulo);
                statementInsertarAOrdenesActivas.setDouble(4, cantidad);
                statementInsertarAOrdenesActivas.setDouble(5, precio);
                statementInsertarAOrdenesActivas.setString(6, descripcion);
                
                statementInsertarAOrdenesActivas.executeUpdate();

            }
            
            con.close();
        }
            catch(Exception e){
                System.out.print(e);
            }
    }
    public static void mostrarRetiros(JTable tablaRetiros){
        DefaultTableModel model = (DefaultTableModel) tablaRetiros.getModel();
        model.setRowCount(0);
        try{
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            statement = con.prepareStatement(
                    "select * from retiros");
            rs = statement.executeQuery();
            while(rs.next()){
                String concepto = rs.getString("concepto");
                Double total = rs.getDouble("monto");
                Object[] row = {concepto, total};
                
                model.insertRow(0, row);
            }
            
            PreparedStatement statementTotal = con.prepareStatement(
                    "select sum(monto) from retiros");
            ResultSet rsTotal = statementTotal.executeQuery();
            if(rsTotal.next()){
                Double totalRetiros = rsTotal.getDouble(1);
                Object[] rowTotal = {"Total", totalRetiros};
                
                model.addRow(rowTotal);
            }
            con.close();
        }
            catch(Exception e){
                System.out.print(e);
            }
    }
    public static void agregarRetiro(String concepto, double total){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            statement = con.prepareStatement(
                "insert into retiros (concepto, monto) values (?,?)");
            statement.setString(1, concepto);
            statement.setDouble(2, total);
            statement.executeUpdate();
            con.close();
        }
            catch(Exception e){
                System.out.print(e);
            }
    }
    public static void eliminarRetiro(String concepto){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            statement = con.prepareStatement(
                    "delete from retiros where concepto = ?");
            statement.setString(1, concepto);
            updateCount =  statement.executeUpdate();
            new JOptionPane().showMessageDialog(null, "Eliminado de Retiros", "Retiros", JOptionPane.INFORMATION_MESSAGE);
            con.close();
        }
            catch(Exception e){
                System.out.print(e);
            }
    }
    public static ResultSet getInfoClienteOrdenActiva(int id_cliente){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            statement = con.prepareStatement(
                    "select * from clientes where id_cliente = ?");
            statement.setInt(1, id_cliente);
            rs =  statement.executeQuery();
        }
            catch(Exception e){
                System.out.print(e);
            }
        return rs;
    }
}
