package baseDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class SqlServerConnection {
        //Consultas para realizar
	    String strConsultaSQL,strConsultaSQL1,strConsultaSQL2;
	    //Apuntador a la conexion a la base de datos
	    Connection conn = null;
	    //Para ejecutar operaciones SQL
	    Statement estSQL1;
	    //Para guardar los resultados de una operacion SELECT
	    ResultSet rs;
            //Para los datos del servidor
            String datosservidor;
    
public SqlServerConnection(){
    
    
       // this.datosservidor = "jdbc:sqlserver://192.168.168.193:1433; databaseName=G001; user=alumBD; password=Gbd2002;";
       

}

public SqlServerConnection(String ipservidor, String database, String user, String pass, boolean encrypt, boolean tSCertificate){
    
    this.datosservidor = "jdbc:sqlserver://"+ipservidor+"; databaseName="+database+"; user="+user+"; password="+pass+";encrypt=true;trustServerCertificate=true;";
    System.out.println("Datos conexion: "+this.datosservidor);
    
    }
    
public void insertarSqlQuery(String strConsultaSQL){
    
      //boolean miflag = false;
     
      
      try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
            Connection con = DriverManager.getConnection(datosservidor);
            JOptionPane.showMessageDialog( null, "TODO OK","TODO OK", JOptionPane.INFORMATION_MESSAGE );
            
                    //Comprobar si hay una refencia valida
	            if(con!=null)
	            {
	                    //Mostrar MSG al usuario de la conexion se ha establecido
	                    JOptionPane.showMessageDialog(null,"Conexion establecida con el servidor correctamente");
	                    //Se prepara para ejecutar sentencias en la conexion recien abierta
                            estSQL1 = con.createStatement();
                            //rs = estSQL1.executeQuery(strConsultaSQL);
                            estSQL1.executeQuery(strConsultaSQL);
                            //Cerrar los objetos de manejo de BD
	                
	                
	            }       //Fin de if  
	                   
	    //System.out.println("CIERRO RS "+strConsultaSQL);
            //rs.close();
	    System.out.println("CIERRO STATEMENT "+strConsultaSQL);
            estSQL1.close();
            System.out.println("CIERRO CONEXION "+strConsultaSQL);
            con.close();//se cierra la conexion con la base de datos
            //miflag = true;
            }
            catch ( SQLException excepcionSql){ //excepcionSql = puede ponerle otro nombre
                System.out.println(excepcionSql.getMessage());
                JOptionPane.showMessageDialog( null, excepcionSql.getMessage(),"Error en base de datos Listando tablas", JOptionPane.ERROR_MESSAGE );

            }

            //errores con la carga del controlador de la base de datos(Driver)

      catch ( ClassNotFoundException claseNoEncontrada ){
            JOptionPane.showMessageDialog( null, claseNoEncontrada.getMessage(),
            "No se encontró el controlador", JOptionPane.ERROR_MESSAGE );

       }
      //System.out.println("INSERTADA EN BD? "+miflag);

    //return miflag;
    }

public void listadoTablaArticulos(JTextArea ta){
  try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
            Connection con = DriverManager.getConnection(datosservidor);
            JOptionPane.showMessageDialog( null, "TODO OK","TODO OK", JOptionPane.INFORMATION_MESSAGE );
            
                //Comprobar si hay una refencia valida
	            if(con!=null)
	            {
	                    //Mostrar MSG al usuario de la conexion se ha establecido
	                    JOptionPane.showMessageDialog(null,"Conexion establecida con el servidor correctamente");
	                    //Se prepara para ejecutar sentencias en la conexion recien abierta
                            estSQL1 = con.createStatement();
                            strConsultaSQL = "SELECT * from articulos";
        	            //System.out.println(strConsultaSQL);
                            rs = estSQL1.executeQuery(strConsultaSQL);
                            
                            //Aux = new TrioArtRefPro(rs.getInt("CODARTICULO"), rs.getString("REFPROVEEDOR").trim(),rs.getInt("CODPROVEEDOR"));
                            //idArt referencia descripcion precio stock stockMinimo

                            ta.setText("");
                            while (rs.next()){
                                
                                ta.append(rs.getInt("idArt")+" |  "+ rs.getString("referencia")
                                        +" |  "+rs.getString("descripcion")
                                        +" |  "+rs.getInt("precio")
                                        +" |  "+rs.getInt("stock")
                                        +" |  "+rs.getInt("stockMinimo") + "\n");
                                
                             }
                             
	                //Cerrar los objetos de manejo de BD
	                
	                
	            }       //Fin de if  
	                   
	
	    rs.close();
	    estSQL1.close();
            con.close();//se cierra la conexion con la base de datos

            }
            catch ( SQLException excepcionSql){ //excepcionSql = puede ponerle otro nombre
                
            JOptionPane.showMessageDialog( null, excepcionSql.getMessage(),"Error en base de datos", JOptionPane.ERROR_MESSAGE );

            }

            //errores con la carga del controlador de la base de datos(Driver)

      catch ( ClassNotFoundException claseNoEncontrada ){
            JOptionPane.showMessageDialog( null, claseNoEncontrada.getMessage(),
            "No se encontró el controlador", JOptionPane.ERROR_MESSAGE );

       }



}

}
