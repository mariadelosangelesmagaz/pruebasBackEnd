package dao;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {

    public static Connection getConnection() throws Exception {
        Logger logger = Logger.getLogger(DB.class);
        logger.info("Conexion establecida");
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/odontest","sa","");
    }

    public static void crearTablaOdontologo(){
        Logger logger = Logger.getLogger(DB.class);
        Connection connection = null;

        try{
            connection = getConnection();
            Statement statement = connection.createStatement();
            statement.execute("DROP TABLE IF EXISTS ODONTOLOGO");
            statement.execute("CREATE TABLE ODONTOLOGO (NUMEROMATRICULA INT, NOMBRE VARCHAR (50), APELLIDO VARCHAR (50))");
            logger.info("Tabla creada satisfactoriamente");

        }catch (Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();

        }finally {
            try{
                connection.close();

            }catch (SQLException ex){
                logger.error(ex.getMessage());
                ex.printStackTrace();
            }
        }
    }
}
