package org.canonymous.chat.command.dto;

import com.sun.istack.internal.NotNull;

public class RoomDto {


    private int id;

    @NotNull
    private String name;

    private final int capacity = 2;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }


}
