/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atividade18.aluno.repository;


import br.com.ifba.atividade18.aluno.entity.AlunoA18;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author gerviz
 */
@Repository
public interface AlunoRepository extends JpaRepository<AlunoA18, Long> {
  public List<AlunoA18> findByNomeContainingIgnoreCase (String nome);
}
