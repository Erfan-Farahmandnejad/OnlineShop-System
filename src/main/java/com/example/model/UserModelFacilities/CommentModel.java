package com.example.model.UserModelFacilities;

import com.example.model.Roles.ClientModel;

public class CommentModel {
    private ClientModel clientModel;
    private final int StuffID;
    private String commentText;
    private CommentStatusModel commentStatusModel;
    private boolean buy;
    public CommentModel(int StuffID, String commentText, ClientModel clientModel)
    {
        this.StuffID=StuffID;
        this.commentText=commentText;
        this.clientModel=clientModel;
        commentStatusModel= CommentStatusModel.WAITINGFORACCEPT;
    }

    public ClientModel getClientModel() {
        return clientModel;
    }

    public boolean isBuy() {
        return buy;
    }

    public CommentStatusModel getCommentStatusModel() {
        return commentStatusModel;
    }

    public int getStuffID() {
        return StuffID;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setBuy(boolean buy) {
        this.buy = buy;
    }

    public void setCommentStatusModel(CommentStatusModel commentStatusModel) {
        this.commentStatusModel = commentStatusModel;
    }

    public void setClientModel(ClientModel clientModel) {
        this.clientModel = clientModel;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    @Override
    public String toString() {
        return
                "clientModel: " + clientModel.getUserName() +
                " StuffID: " + StuffID +
                " commentText: " + commentText +
                " commentStatusModel: " + commentStatusModel +
                " buy: " + buy
                ;
    }
}
