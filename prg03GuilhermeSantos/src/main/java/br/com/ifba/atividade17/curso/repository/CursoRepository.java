/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atividade17.curso.repository;

import br.com.ifba.atividade17.curso.entity.CursoA17;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author gerviz
 */
@Repository
public interface CursoRepository extends JpaRepository<CursoA17, Long> {
  public List<CursoA17> findByNomeContainingIgnoreCase (String nome);
}
