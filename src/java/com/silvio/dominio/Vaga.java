/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.silvio.dominio;

import java.io.Serializable;
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

/**
 *
 * @author SILVIO
 */
@Entity
@Table(name="vaga")
public class Vaga implements Serializable, Cadastro {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vaga_id_seq")
    @SequenceGenerator(name = "vaga_id_seq", sequenceName = "vaga_id_seq", allocationSize = 1)
    private int id;
    
    @Column(length = 80)
    private String cargo;
    
    @Column(name="especificacao_de_cargo", length = 120)
    private String especificacaoDeCargo;
    
    @Column(length = 300)
    private String outro;
    
    @Column(length = 2)
    private String uf;
    
    @Column(precision = 2)
    private double remuneracao;
    
    @Column(name="vale_transporte")
    private boolean valeTransporte;
    
    @Column(name="vale_refeicao")
    private boolean valeRefeicao;
    
    @Enumerated(EnumType.STRING)
    @Column(name="forma_de_contratacao")
    private FormaDeContratacao formaDeContratacao;

    @Enumerated(EnumType.STRING)
    private Turno turno;
    
    @ManyToOne
    @JoinColumn(name = "empresa_id", referencedColumnName = "id")
    private Empresa empresa;

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.id);
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
        final Vaga other = (Vaga) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getEspecificacaoDeCargo() {
        return especificacaoDeCargo;
    }

    public void setEspecificacaoDeCargo(String especificacaoDeCargo) {
        this.especificacaoDeCargo = especificacaoDeCargo;
    }

    public String getOutro() {
        return outro;
    }

    public void setOutro(String outro) {
        this.outro = outro;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public double getRemuneracao() {
        return remuneracao;
    }

    public void setRemuneracao(double remuneracao) {
        this.remuneracao = remuneracao;
    }

    public boolean isValeTransporte() {
        return valeTransporte;
    }

    public void setValeTransporte(boolean valeTransporte) {
        this.valeTransporte = valeTransporte;
    }

    public boolean isValeRefeicao() {
        return valeRefeicao;
    }

    public void setValeRefeicao(boolean valeRefeicao) {
        this.valeRefeicao = valeRefeicao;
    }

    public FormaDeContratacao getFormaDeContratacao() {
        return formaDeContratacao;
    }

    public void setFormaDeContratacao(FormaDeContratacao formaDeContratacao) {
        this.formaDeContratacao = formaDeContratacao;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

}
