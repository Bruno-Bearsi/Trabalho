/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "receituario")
public class Receituario implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_receituario" , sequenceName = "seq_receituario_id", 
            allocationSize = 1)
    @GeneratedValue(generator = "seq_receituario", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @NotBlank(message = "O campo posologia não pode ser em branco")
    @Column(name = "posologia", nullable = false)
    private String posologia;
    @Temporal(TemporalType.DATE)
    @NotNull(message = "O campo validade não pode ser nulo")
    @Column(name = "validade", nullable = false)
    private Calendar validade;
    @NotNull(message = "O campo consulta deve ser informado")
    @ManyToOne
    @JoinColumn(name = "consulta", referencedColumnName = "id", nullable = false)
    private Consulta consulta;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "medicamentos", 
            joinColumns = 
                    @JoinColumn(name = "id_receituario", referencedColumnName = "id", 
                            nullable = false),
            inverseJoinColumns = 
                    @JoinColumn(name = "nome_medicamento", referencedColumnName = "nome", 
                            nullable = false))
    private Set<Medicamento> medicamento;

    public Receituario() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPosologia() {
        return posologia;
    }

    public void setPosologia(String posologia) {
        this.posologia = posologia;
    }

    public Calendar getValidade() {
        return validade;
    }

    public void setValidade(Calendar validade) {
        this.validade = validade;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    public Set<Medicamento> getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(Set<Medicamento> medicamento) {
        this.medicamento = medicamento;
    }
    
}
