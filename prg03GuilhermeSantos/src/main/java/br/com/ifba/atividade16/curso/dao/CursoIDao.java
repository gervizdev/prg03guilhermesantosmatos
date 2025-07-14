/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.atividade16.curso.dao;

import br.com.ifba.atividade16.curso.entity.CursoA16;
import br.com.ifba.atividade16.infrastructure.dao.GenericIDao;
import java.util.List;

/**
 *
 * @author gerviz
 */
public interface CursoIDao extends GenericIDao<CursoA16> {

  List<CursoA16> findByNome(String nome);

}
