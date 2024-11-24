package com.example.model.UserModelFacilities;

import com.example.model.Roles.ClientModel;
import com.example.model.Stuff.StuffModel;

public class ScoreModel {
  private ClientModel clientModel;
  private int scoreNumber;
  private StuffModel stuffModel;
  public ScoreModel(ClientModel clientModel, int scoreNumber, StuffModel stuffModel)
  {
      this.clientModel=clientModel;
      this.scoreNumber=scoreNumber;
      this.stuffModel=stuffModel;
  }

  public ClientModel getClientModel() {
    return clientModel;
  }

  public double getScoreNumber() {
    return scoreNumber;
  }

  public StuffModel getStuffModel() {
    return stuffModel;
  }

  public void setScoreNumber(int scoreNumber) {
    this.scoreNumber = scoreNumber;
  }

  public void setClientModel(ClientModel clientModel) {
    this.clientModel = clientModel;
  }

  public void setStuffModel(StuffModel stuffModel) {
    this.stuffModel = stuffModel;
  }
}
