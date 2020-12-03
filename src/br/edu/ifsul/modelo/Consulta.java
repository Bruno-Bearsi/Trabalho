/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
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
    @NotNull(message = "O campo diaMes não pode ser nulo")
    @Column(name = "diaMes", nullable = false)
    private Calendar diaMes;
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
    @OneToMany(mappedBy = "consulta", cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Exame> exames = new ArrayList<>();
    @OneToMany(mappedBy = "consulta", cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Receituario> receituarios = new ArrayList<>();

    public Consulta() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Calendar getDiaMes() {
        return diaMes;
    }

    public void setDiaMes(Calendar diaMes) {
        this.diaMes = diaMes;
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

    public List<Exame> getExames() {
        return exames;
    }

    public void setExames(List<Exame> exames) {
        this.exames = exames;
    }

    public List<Receituario> getReceituarios() {
        return receituarios;
    }

    public void setReceituarios(List<Receituario> receituarios) {
        this.receituarios = receituarios;
    }
    
    public void adicionarExame(Exame obj) {
        obj.setConsulta(this);
        this.exames.add(obj);
    }
    
    public void adicionarReceituario(Receituario obj) {
        obj.setConsulta(this);
        this.receituarios.add(obj);
    }
    
    public void removerExame(int index) {
        this.exames.remove(index);
    } 
    
    public void removerReceituario(int index) {
        this.receituarios.remove(index);
    } 
}
