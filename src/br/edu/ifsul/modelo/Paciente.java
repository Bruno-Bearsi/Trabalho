/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author T-Gamer
 */
@Entity
@Table(name = "paciente")
@DiscriminatorColumn(name = "tipo", discriminatorType = DiscriminatorType.STRING,length = 2)
@DiscriminatorValue(value = "PA")
@Inheritance(strategy = InheritanceType.JOINED)
public class Paciente  implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_paciente" , sequenceName = "seq_paciente_id", 
            allocationSize = 1)
    @GeneratedValue(generator = "seq_paciente", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Length(max = 50, message = "O campo nome não pode ter mais que {max} caracteres")
    @NotBlank(message = "O campo nome não pode ser em branco")
    @Column(name = "nome", length = 50, nullable = false)
    private String nome;
    @Temporal(TemporalType.DATE)
    @NotNull(message = "O campo nascimento não pode ser nulo")
    @Column(name = "nascimento", nullable = false)
    private Calendar nascimento;
    @Length(max = 50, message = "O campo telefone não pode ter mais que {max} caracteres")
    @NotBlank(message = "O campo telefone não pode ser em branco")
    @Column(name = "telefone", length = 50, nullable = false)
    private String telefone;
    @Length(max = 50, message = "O campo sexo não pode ter mais que {max} caracteres")
    @NotBlank(message = "O campo sexo não pode ser em branco")
    @Column(name = "sexo", length = 50, nullable = false)
    private String sexo;
    @NotBlank(message = "O campo historico não pode ser em branco")
    @Column(name = "historico", nullable = false)
    private String historico;
    @NotNull(message = "O campo peso deve ser informado")
    @Column(name = "peso", nullable = false, columnDefinition = "numeric(12,2)")
    private Double peso;
    @NotNull(message = "O campo altura deve ser informado")
    @Column(name = "altura", nullable = false, columnDefinition = "numeric(12,2)")
    private Double altura;

    public Paciente() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Calendar getNascimento() {
        return nascimento;
    }

    public void setNascimento(Calendar nascimento) {
        this.nascimento = nascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.id);
        hash = 83 * hash + Objects.hashCode(this.nome);
        hash = 83 * hash + Objects.hashCode(this.nascimento);
        hash = 83 * hash + Objects.hashCode(this.telefone);
        hash = 83 * hash + Objects.hashCode(this.sexo);
        hash = 83 * hash + Objects.hashCode(this.historico);
        hash = 83 * hash + Objects.hashCode(this.peso);
        hash = 83 * hash + Objects.hashCode(this.altura);
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
        final Paciente other = (Paciente) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.telefone, other.telefone)) {
            return false;
        }
        if (!Objects.equals(this.sexo, other.sexo)) {
            return false;
        }
        if (!Objects.equals(this.historico, other.historico)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.nascimento, other.nascimento)) {
            return false;
        }
        if (!Objects.equals(this.peso, other.peso)) {
            return false;
        }
        if (!Objects.equals(this.altura, other.altura)) {
            return false;
        }
        return true;
    }
    
    
    
}
