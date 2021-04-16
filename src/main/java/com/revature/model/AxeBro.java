package com.revature.model;

import java.util.List;

/** Creature - Axebro class for creature + getSign(List<String> input) + die() */
public class AxeBro extends Creature {

  public AxeBro() {
    super(
        "Axebro",
        "Axebros spray too much axe on themselves. Their personality is as thin as paper.");
  }

  // Paper
  public String getSign(List<String> signsList) {
    String sign = super.getSign();
    switch (sign) {
      case "2":
        return signsList.get(0);
      case "0":
      case "1":
      default:
        return signsList.get(2);
    }
  }

  @Override
  public String die() {
    return "A flame easily causes them to combust.";
  }
}
