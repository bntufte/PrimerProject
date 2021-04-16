package com.revature.model;

import java.util.List;

/** Creature - Trouser class for creature + getSign(List<String> input) + die() */
public class Trouser extends Creature {

  public Trouser() {
    super(
        "Trouser",
        "Trouser envies the princess's fashion so he plans on using her brains to rule  the fashion world! Trouser hates chainchews.");
  }

  // Paper
  public String getSign(List<String> signsList) {
    String sign = super.getSign();
    switch (sign) {
      case "0":
        return signsList.get(0);
      case "1":
        return signsList.get(1);
      case "2":
      default:
        return signsList.get(2);
    }
  }

  @Override
  public String die() {
    return "He's been pants'd and shirt'd";
  }
}
