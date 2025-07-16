/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.atividade16.curso.dao;

import br.com.ifba.atividade16.curso.entity.CursoA16;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author gerviz
 */
@Repository
public interface CursoIDao extends JpaRepository<CursoA16, Long> {

    List<CursoA16> findByNome(String nome);
}
