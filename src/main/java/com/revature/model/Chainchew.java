package com.revature.model;

import java.util.List;

/** Creature - Chainchew class for creature + getSign(List<String> input) + die() */
public class Chainchew extends Creature {

  public Chainchew() {
    super(
        "Chainchew",
        "a pair of scissors strapped to a very long chain. No one dares approach it or they'll get ripped pants.");
  }

  // Scissors
  public String getSign(List<String> signsList) {
    String sign = super.getSign();
    switch (sign) {
      case "2":
        return signsList.get(2);
      case "0":
      case "1":
      default:
        return signsList.get(1);
    }
  }

  @Override
  public String die() {
    return "The bolt keeping the scissors together was removed.";
  }
}
