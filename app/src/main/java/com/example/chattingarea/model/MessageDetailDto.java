package com.example.chattingarea.model;

public class MessageDetailDto {
    private String messageId;
    private String roomId;
    private String content;
    private String timestamp;
    private boolean isStringType;

    private String senderId;
    private String senderName;
    public String urlAva;

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public boolean isStringType() {
        return isStringType;
    }

    public void setStringType(boolean stringType) {
        isStringType = stringType;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getUrlAva() {
        return urlAva;
    }

    public void setUrlAva(String urlAva) {
        this.urlAva = urlAva;
    }

    public MessageDetailDto() {
    }

    public MessageDetailDto(String messageId, String roomId, String content, String timestamp, boolean isStringType, String senderId, String senderName, String urlAva) {
        this.messageId = messageId;
        this.roomId = roomId;
        this.content = content;
        this.timestamp = timestamp;
        this.isStringType = isStringType;
        this.senderId = senderId;
        this.senderName = senderName;
        this.urlAva = urlAva;
    }
}
