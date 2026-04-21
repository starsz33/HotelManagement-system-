package org.spring.hotelmanagementsystem.exception;

public class RoomNotAvailableException extends RuntimeException{
    RoomNotAvailableException(String message){
        super(message);
    }
}
