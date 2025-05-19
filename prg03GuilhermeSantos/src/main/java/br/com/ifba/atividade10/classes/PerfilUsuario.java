/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atividade10.classes;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author jotin
 */
public class PerfilUsuario {
    private long id;
    private String descricao;
    private List<String> permissoes = new ArrayList<>();
    
    
    //metodo Construtor
    public PerfilUsuario(Long id,String descricao, List<String> permissoes ){
    this.id = id;
    this.descricao = descricao;
    this.permissoes = permissoes;
    }

    public long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public List<String> getPermissoes() {
        return permissoes;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setPermissoes(List<String> permissoes) {
        this.permissoes = permissoes;
    }
    
    
 
    public String toString() {
        return "PerfilUsuario{" +
               "id=" + id +
               ", descricao='" + descricao + '\'' +
               ", permissoes=" + permissoes +
               '}';
    }



}

