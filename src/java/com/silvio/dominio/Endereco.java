/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.silvio.dominio;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
 
/**
 *
 * @author SILVIO
 */
@Embeddable
public class Endereco implements Serializable {
    
    @Column(length = 50)
    private String cidade;
    
    @Column(length = 2)
    private String uf;
    
    @Column(length = 8)
    private int cep;
    
    @Column(length = 3)
    private int numero;

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
}
