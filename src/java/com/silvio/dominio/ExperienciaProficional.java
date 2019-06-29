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
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author SILVIO
 */
@Entity
@Table(name="experiencia_proficional")
public class ExperienciaProficional implements Serializable, Cadastro {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "experiencia_proficional_id_seq")
    @SequenceGenerator(name = "experiencia_proficional_id_seq", sequenceName = "experiencia_proficional_id_seq", allocationSize = 1)
    private int id;
    
    @Column(name="nome_da_empresa",length = 80)
    private String nomeDaEmpresa;
    
    @Column(length = 80)
    private String cargo;
    
    @Column(name="tarefas_executadas", length = 150)
    private String tarefasExecutadas;
    
    @Column(name="data_de_inicio", length = 8)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataDeInicio;
    
    @Column(name="data_de_fim", length = 8)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataDeFim;
    
    @Enumerated(EnumType.STRING)
    @Column(name="forma_de_contratacao")
    private FormaDeContratacao formaDeContratacao;
    
    @ManyToOne
    @JoinColumn(name = "candidato_id",referencedColumnName = "id")
    private Candidato candidato;

    @Override
    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeDaEmpresa() {
        return nomeDaEmpresa;
    }

    public void setNomeDaEmpresa(String nomeDaEmpresa) {
        this.nomeDaEmpresa = nomeDaEmpresa;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getTarefasExecutadas() {
        return tarefasExecutadas;
    }

    public void setTarefasExecutadas(String tarefasExecutadas) {
        this.tarefasExecutadas = tarefasExecutadas;
    }

    public Date getDataDeInicio() {
        return dataDeInicio;
    }

    public void setDataDeInicio(String dataDeInicio) throws ParseException {
        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataDeInicio);
        this.dataDeInicio = date;
    }

    public Date getDataDeFim() {
        return dataDeFim;
    }

    public void setDataDeFim(String dataDeFim) throws ParseException {
        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataDeFim);
        this.dataDeFim = date;
    }

    public FormaDeContratacao getFormaDeContratacao() {
        return formaDeContratacao;
    }

    public void setFormaDeContratacao(FormaDeContratacao formaDeContratacao) {
        this.formaDeContratacao = formaDeContratacao;
    }

    public Candidato getCandidato() {
        return candidato;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + Objects.hashCode(this.nomeDaEmpresa);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ExperienciaProficional other = (ExperienciaProficional) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public void setId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
