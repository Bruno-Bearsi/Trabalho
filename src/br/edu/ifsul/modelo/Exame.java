/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author T-Gamer
 */
@Entity
@Table(name = "exame")
public class Exame  implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_exame" , sequenceName = "seq_exame_id", 
            allocationSize = 1)
    @GeneratedValue(generator = "seq_exame", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Length(max = 20, message = "O campo nome não pode ter mais que {max} caracteres")
    @NotBlank(message = "O campo nome não pode ser em branco")
    @Column(name = "nome", length = 20, nullable = false)
    private String nome;
    @Length(max = 20, message = "O campo descricao não pode ter mais que {max} caracteres")
    @NotBlank(message = "O campo descricao não pode ser em branco")
    @Column(name = "descricao", length = 20, nullable = false)
    private String descricao;
    @NotNull(message = "O campo consulta deve ser informado")
    @ManyToOne
    @JoinColumn(name = "consulta", referencedColumnName = "id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_exame_consulta"))
    private Consulta consulta;

    public Exame() {
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }
    
}
