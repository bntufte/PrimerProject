package com.revature.model;

public class Player {

  private String name;
  private String description;
  private String sign;

  public Player(String name) {
    this.name = name;
    description =
        "You're an electrician who wears whatever the opposite of overalls are and they're not blue.";
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
    return sign;
  }

  public void setSign(String sign) {
    this.sign = sign;
  }
}
