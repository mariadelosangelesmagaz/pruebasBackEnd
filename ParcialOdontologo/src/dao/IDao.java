package dao;

import java.util.ArrayList;

public interface IDao<T> {

    void guardar(T t);

    String listar();


}
