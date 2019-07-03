/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.silvio.operacoes;

import com.silvio.dao.CandidatoDao;
import com.silvio.dao.DaoFactory;
import com.silvio.dominio.Candidato;
import java.util.List;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author SILVIO
 */
@ManagedBean
public class teste {
    
       private Candidato candidato = new Candidato();
       private DaoFactory dao = new DaoFactory();
       
       public void adicionar(){
           dao.getCandidatoDao().add(candidato);
       }
}
