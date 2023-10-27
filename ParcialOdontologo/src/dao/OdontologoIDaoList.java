package dao;

import model.Odontologo;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class OdontologoIDaoList implements IDao<Odontologo>{
    private List<Odontologo> odontologos = new ArrayList<>();
    Logger logger = Logger.getLogger(OdontologoIDaoList.class);

    @Override
    public void guardar(Odontologo odontologo) {
        odontologos.add(odontologo);
        logger.info("El odontologo " + odontologo + " fue agregado al array");
    }

    @Override
    public String listar() {

        String odontologosString = "";

        for (int i = 0; i < odontologos.size() ; i++) {
            odontologosString += odontologos.get(i);
        }

        System.out.println("Se imprimen los odontologos dentro del array:");
        System.out.println(odontologosString);
        return odontologosString;
    }

    public List<Odontologo> getOdontologos() {
        return odontologos;
    }
}
