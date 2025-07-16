/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atividade16.curso.dao;

import br.com.ifba.atividade16.curso.entity.CursoA16;
import br.com.ifba.atividade16.infrastructure.dao.GenericDao;
import org.springframework.stereotype.Repository;

/**
 *
 * @author gerviz
 */
@Repository
public class CursoDao extends GenericDao<CursoA16> {
    public CursoDao() {
        super(CursoA16.class);
    }
}
