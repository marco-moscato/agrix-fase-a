package com.betrybe.agrix.models.entities;

/**
 * Classe Farm representa uma fazenda.
 */
public class Farm {
  private int id;
  private String name;
  private Double size;

  public Farm() {}

  /**
   * Método que cria uma instancia de uma fazenda.
   *
   * @param id id da fazenda
   * @param name nome da fazenda
   * @param size tamanho da fazenda
   */
  public Farm(int id, String name, Double size) {
    this.id = id;
    this.name = name;
    this.size = size;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Double getSize() {
    return size;
  }

  public void setSize(Double size) {
    this.size = size;
  }
}
