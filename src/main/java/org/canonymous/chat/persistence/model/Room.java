package org.canonymous.chat.persistence.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "room")
public class Room extends AbstractModel{

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private int userCount;

    public void setId(Integer id) {
        this.id = id;
    }

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

    public int getUserCount() {
        return userCount;
    }

    public void setUserCount(int userCount) {
        this.userCount = userCount;
    }

    @Override
    public String toString() {

        // printing recipients with lazy loading
        // and no session will cause issues
        return "Customer{" +
                "roomName='" + name + '\'' +
                ", id='" + id + '\'' +
                ", userCount='" + userCount + '\'' +
                "} " + super.toString();
    }

}
