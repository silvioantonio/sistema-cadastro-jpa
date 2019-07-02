/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.silvio.dominio;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author SILVIO
 */
@Entity
@Table(name="candidato")
public class Candidato implements Serializable, Cadastro {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "candidato_id_seq")
    @SequenceGenerator(name = "candidato_id_seq", sequenceName = "candidato_id_seq", allocationSize = 1)
    private int id;

    @Column(length = 50)
    private String nome;
    
    @Column(length = 11)
    private int cpf;
            
    @Column(name="data_de_nascimento", length = 8)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataDeNascimento;
    
    @Enumerated(EnumType.STRING)
    private Sexo sexo;
    
    @OneToOne(cascade = CascadeType.ALL)
    private Acesso acesso;
    
    @OneToOne(cascade = CascadeType.ALL)
    private Telefone telefone;
    
    @Enumerated(EnumType.STRING)
    @Column(name="estado_civil")
    private EstadoCivil estadoCivil;
    
    @OneToMany(mappedBy = "candidato", cascade = CascadeType.ALL)
    @Column(name="experiencias_proficionais")
    private List<ExperienciaProficional> experienciasProficionais= new ArrayList<>();
    
    @Embedded
    private Rg rg;
    
    @Embedded
    private Endereco endereco;

    @ManyToOne
    @JoinColumn(name = "vaga_id", referencedColumnName = "id")
    private Vaga vaga;
    
    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public Date getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(String dataDeNascimento) throws ParseException {
        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataDeNascimento);
        this.dataDeNascimento = date;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public Rg getRg() {
        return rg;
    }

    public void setRg(Rg rg) {
        this.rg = rg;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<ExperienciaProficional> getExperienciasProficionais() {
        return experienciasProficionais;
    }

    public void setExperienciasProficionais(List<ExperienciaProficional> experienciasProficionais) {
        this.experienciasProficionais = experienciasProficionais;
    }

    public Acesso getAcesso() {
        return acesso;
    }

    public void setAcesso(Acesso acesso) {
        this.acesso = acesso;
    }

    public Telefone getTelefone() {
        return telefone;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.id);
        hash = 17 * hash + Objects.hashCode(this.nome);
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
        final Candidato other = (Candidato) obj;
        return Objects.equals(this.id, other.id);
    }

    public Vaga getVaga() {
        return vaga;
    }

    public void setVaga(Vaga vaga) {
        this.vaga = vaga;
    }
    
    
}
