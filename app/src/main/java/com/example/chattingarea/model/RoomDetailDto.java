package com.example.chattingarea.model;

public class RoomDetailDto {
    public String roomId;
    public String roomName;
    public Boolean isSingleRoom;
    public String createdAt;

    public RoomDetailDto() {
    }

    public RoomDetailDto(String roomId, String roomName, Boolean isSingleRoom, String createdAt) {
        this.roomId = roomId;
        this.roomName = roomName;
        this.isSingleRoom = isSingleRoom;
        this.createdAt = createdAt;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public Boolean getSingleRoom() {
        return isSingleRoom;
    }

    public void setSingleRoom(Boolean singleRoom) {
        isSingleRoom = singleRoom;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
