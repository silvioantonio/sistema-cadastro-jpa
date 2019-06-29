package com.silvio.dao;

import com.silvio.dominio.Cadastro;
import java.util.List;

/**
 *
 * @author SILVIO
 * @param <T>
 */
public interface IDaoGenerico<T> {
    
    public void add(T u);

    public void upd(T u);

    public void del(T u);

    public T findById(int id);

    public List<T> listaAll();

    public List<T> JpqlLike(String campo, String valor);
    
}
