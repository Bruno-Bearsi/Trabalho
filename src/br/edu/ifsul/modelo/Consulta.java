/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "consulta")
public class Consulta implements Serializable {
    @Id
    @SequenceGenerator(name = "seq_consulta" , sequenceName = "seq_consulta_id", 
            allocationSize = 1)
    @GeneratedValue(generator = "seq_consulta", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Temporal(TemporalType.DATE)
    @NotNull(message = "O campo data não pode ser nulo")
    @Column(name = "data", nullable = false)
    private Calendar data;
    @Temporal(TemporalType.DATE)
    @NotNull(message = "O campo hora não pode ser nulo")
    @Column(name = "hora", nullable = false)
    private Calendar hora;
    @NotBlank(message = "O campo preconsulta não pode ser em branco")
    @Column(name = "preconsulta", nullable = false)
    private String preconsulta;
    @NotBlank(message = "O campo posconsulta não pode ser em branco")
    @Column(name = "posconsulta", nullable = false)
    private String posconsulta;
    @NotNull(message = "O campo medico deve ser informado")
    @ManyToOne
    @JoinColumn(name = "medico", referencedColumnName = "id", nullable = false)
    private Medico medico;
    @NotNull(message = "O campo paciente deve ser informado")
    @ManyToOne
    @JoinColumn(name = "paciente", referencedColumnName = "id", nullable = false)
    private Paciente paciente;

    public Consulta() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public Calendar getHora() {
        return hora;
    }

    public void setHora(Calendar hora) {
        this.hora = hora;
    }

    public String getPreconsulta() {
        return preconsulta;
    }

    public void setPreconsulta(String preconsulta) {
        this.preconsulta = preconsulta;
    }

    public String getPosconsulta() {
        return posconsulta;
    }

    public void setPosconsulta(String posconsulta) {
        this.posconsulta = posconsulta;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    
}
