package org.canonymous.chat.controllers.web;

import org.canonymous.chat.server.RoomManager;
import org.canonymous.chat.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class WebController {

    private RoomService roomService;
    private RoomManager roomManager = new RoomManager();


    @Autowired
    public void setRoomService(RoomService roomService) {
        this.roomService = roomService;
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/chat/testing", "/", ""})
    public String listCustomers(Model model) {

        return "/testing";
    }

}
