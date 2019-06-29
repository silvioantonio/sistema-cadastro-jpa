/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.silvio.dominio;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;

/**
 *
 * @author SILVIO
 */
@Embeddable
public class Rg implements Serializable {
    
    @Column(name="data_expedicao", length = 8)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataExpedicao;
    
    @Column(name="numero_rg", length = 11)
    private int numeroRg;
            
    @Column(name="orgao_expeditor", length = 20)
    private String orgaoExpeditor;
    
    @Column(name="uf_expedicao", length = 2)
    private String ufExpedicao;

    public Date getDataExpedicao() {
        return dataExpedicao;
    }

    public void setDataExpedicao(String dataExpedicao) throws ParseException {
        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataExpedicao);
        this.dataExpedicao = date;
    }

    public int getNumeroRg() {
        return numeroRg;
    }

    public void setNumeroRg(int numeroRg) {
        this.numeroRg = numeroRg;
    }

    public String getOrgaoExpeditor() {
        return orgaoExpeditor;
    }

    public void setOrgaoExpeditor(String orgaoExpeditor) {
        this.orgaoExpeditor = orgaoExpeditor;
    }

    public String getUfExpedicao() {
        return ufExpedicao;
    }

    public void setUfExpedicao(String ufExpedicao) {
        this.ufExpedicao = ufExpedicao;
    }
    
    
}
