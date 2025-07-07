/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.atividade15.curso.dao;

import br.com.ifba.atividade15.curso.entity.CursoA15;
import br.com.ifba.atividade15.infrastructure.dao.GenericIDao;
import java.util.List;

/**
 *
 * @author gerviz
 */
public interface CursoIDao extends GenericIDao<CursoA15> {

  List<CursoA15> findByNome(String nome);

}
