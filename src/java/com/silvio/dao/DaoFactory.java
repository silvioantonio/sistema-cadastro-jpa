package com.silvio.dao;

import com.silvio.dominio.Acesso;
import com.silvio.dominio.Candidato;
import com.silvio.dominio.Empresa;
import com.silvio.dominio.Telefone;
import com.silvio.dominio.Vaga;
/**
 *
 * @author SILVIO
 * @param <T>
 */ 
public class DaoFactory {

    
    public DaoGenerico<Empresa> getEmpresaDao(){
        return new DaoGenerico<>(Empresa.class);
    }
    
    public DaoGenerico<Candidato> getCandidatoDao(){
        return new DaoGenerico<>(Candidato.class);
    }
    
    public DaoGenerico<Telefone> getTelefoneDao(){
        return new DaoGenerico<>(Telefone.class);
    }
    
    public DaoGenerico<Acesso> getAcessoDao(){
        return new DaoGenerico<>(Acesso.class);
    }
    
    public VagaDao getVagaDao(){
        return new VagaDao(Vaga.class);
    }
     
}
