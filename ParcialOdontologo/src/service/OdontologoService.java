package service;

import dao.IDao;
import model.Odontologo;

import java.util.ArrayList;

public class OdontologoService {

    private IDao<Odontologo> odontologoIDao;

    public OdontologoService(IDao<Odontologo> odontologoIDao) {
        this.odontologoIDao = odontologoIDao;
    }

    public void guardar (Odontologo odontologo){
        odontologoIDao.guardar(odontologo);
    }

    public String listarOdontologos(){
        return odontologoIDao.listar();
    }

}
