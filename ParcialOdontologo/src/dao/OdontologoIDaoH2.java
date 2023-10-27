package dao;

import model.Odontologo;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;


public class OdontologoIDaoH2 implements IDao<Odontologo>{

    Logger logger = Logger.getLogger(OdontologoIDaoH2.class);

    private static final String SQL_INSERT = "INSERT INTO ODONTOLOGO VALUES (?,?,?)";

    @Override
    public void guardar(Odontologo odontologo) {
        Connection connection = null;


        try {

            connection = DB.getConnection();
            PreparedStatement sentencia = connection.prepareStatement(SQL_INSERT);
            sentencia.setInt(1,odontologo.getNumeroMatricula());
            sentencia.setString(2, odontologo.getNombre());
            sentencia.setString(3, odontologo.getApellido());
            sentencia.execute();

            logger.info("Odontologo insertado satisfactoriamente");

        }catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            }catch (SQLException ex){
                logger.error(ex.getMessage());
                ex.printStackTrace();
            }
        }
    }


    @Override
    public String listar() {
        Connection connection = null;
        String resultado = "";
        try {

            connection = DB.getConnection();

            ResultSet rs = connection.createStatement().executeQuery("SELECT * FROM ODONTOLOGO");

            while(rs.next()){
                Odontologo odontologoEncontrado = new Odontologo(rs.getInt(1), rs.getString(2), rs.getString(3));
                //System.out.println(odontologoEncontrado.toString());
                resultado += odontologoEncontrado;
            }


        }catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            }catch (SQLException ex){
                logger.error(ex.getMessage());
                ex.printStackTrace();
            }
        }
        System.out.println("Se imprimen los odontologos dentro de la DB H2");
        System.out.println(resultado);
        return resultado;
    }
}











