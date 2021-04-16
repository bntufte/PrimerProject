package com.revature.model;

import java.util.List;

/** Creature - Boomba class for creature + getSign(List<String> input) + die() */
public class Boomba extends Creature {

  public Boomba() {
    super(
        "Boomba",
        "A walking boombox with feet. No one knows how it waddles along the road so easily.");
  }

  // Rock
  public String getSign(List<String> signsList) {
    String sign = super.getSign();
    switch (sign) {
      case "2":
        return signsList.get(1);
      case "0":
      case "1":
      default:
        return signsList.get(0);
    }
  }

  @Override
  public String die() {
    return "Boomba was stomped to death.";
  }
}
