/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;


/**
 *
 * @author T-Gamer
 */
@Entity
@Table(name = "medico")
public class Medico extends Paciente implements Serializable{
    @Length(max = 20, message = "O campo crm não pode ter mais que {max} caracteres")
    @NotBlank(message = "O campo crm não pode ser em branco")
    @Column(name = "crm", length = 20, nullable = false)
    private String crm;
    @NotNull(message = "O campo especialidade deve ser informado")
    @ManyToOne
    @JoinColumn(name = "especialidade", referencedColumnName = "id", nullable = false)
    private Especialidade especialidade;

    public Medico() {
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.crm);
        hash = 17 * hash + Objects.hashCode(this.especialidade);
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
        final Medico other = (Medico) obj;
        if (!Objects.equals(this.crm, other.crm)) {
            return false;
        }
        if (!Objects.equals(this.especialidade, other.especialidade)) {
            return false;
        }
        return true;
    }
    
    
}
