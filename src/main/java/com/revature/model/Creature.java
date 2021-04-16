package com.revature.model;

import java.util.List;

/** Creature - Base class for creatures encountered + getSign(List<String> input) + die() */
public abstract class Creature {
  private String name;
  private String description;

  public Creature(String name, String description) {
    this.name = name;
    this.description = description;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getSign() {
    return Integer.toString((int) ((Math.random() * (2 - 0)) + 0));
  }

  public abstract String getSign(List<String> input);

  public String die() {
    return "Blegh! *Drops dead*";
  }
}
