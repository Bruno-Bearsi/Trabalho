/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.util;

import br.edu.ifsul.modelo.Consulta;
import br.edu.ifsul.modelo.Especialidade;
import br.edu.ifsul.modelo.Exame;
import br.edu.ifsul.modelo.Medico;
import br.edu.ifsul.modelo.Paciente;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author T-Gamer
 */
public class UtilRelatorios {
    public static List<Consulta> listaMedicos(){
        List<Consulta> l = new ArrayList<>();
        
        Consulta c = new Consulta();
        c.setDiaMes(Calendar.getInstance());
        c.setHora(Calendar.getInstance());
        Medico m = new Medico();
        m.setNome("Roberto");
        c.setMedico(m);
        Paciente p = new Paciente();
        p.setNome("Carlos");
        c.setPaciente(p);
        c.setPosconsulta("Curado");
        c.setPreconsulta("Dor de barriga");
        Exame e = new Exame();
        e.setDescricao("total");
        e.setNome("Radiologia");
        c.getExames().add(e);
        
        l.add(c);
        
        Consulta c2 = new Consulta();
        c2.setDiaMes(Calendar.getInstance());
        c2.setHora(Calendar.getInstance());
        Medico m2 = new Medico();
        m2.setNome("Luiza");
        c2.setMedico(m2);
        Paciente p2 = new Paciente();
        p2.setNome("Jheferson");
        c2.setPaciente(p2);
        c2.setPosconsulta("Dores de cabeça, voltar em 15 dias");
        c2.setPreconsulta("Marcas amarelas pelo corpo, possivelmente dengue");
        c2.getExames().add(e);
        
        l.add(c2);
        
        return l;
    }
}
