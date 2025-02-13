package com.ianfelps.todo_list.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

// Entidade To-do.
@Entity
@Table(name = "todos")
public class Todo {
  // Atributos da entidade To-do.
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @NotBlank
  private String nome;
  @NotBlank
  private String descricao;
  private boolean realizado;
  private int prioridade;

  // Construtores da entidade To-do.
  public Todo() {

  }

  public Todo(Long id, @NotBlank String nome, @NotBlank String descricao, boolean realizado, int prioridade) {
    this.id = id;
    this.nome = nome;
    this.descricao = descricao;
    this.realizado = realizado;
    this.prioridade = prioridade;
  }

  public Todo(String nome, String descricao, boolean realizado, int prioridade) {
    this.nome = nome;
    this.descricao = descricao;
    this.realizado = realizado;
    this.prioridade = prioridade;
  }

  // Getters e Setters da entidade To-do.
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
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

  public boolean isRealizado() {
    return realizado;
  }

  public void setRealizado(boolean realizado) {
    this.realizado = realizado;
  }

  public int getPrioridade() {
    return prioridade;
  }

  public void setPrioridade(int prioridade) {
    this.prioridade = prioridade;
  }
}