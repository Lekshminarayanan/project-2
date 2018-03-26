package com.niit.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;

@Controller
public class SockController {
private final SimpMessagingTemplate messagingTemplate;
private List<String> users=new ArrayList<String>();
@Autowired
public SockController(SimpMessagingTemplate messagingTemplate) {
	super();
	this.messagingTemplate=messagingTemplate;
	
}
@SubscribeMapping("/join/{username}")
public List<String> join(@DestinationVariable String username){
System.out.println("Newly joined username is"+username);
if(!users.contains(username))
	users.add(username);
messagingTemplate.convertAndSend("/topic/join",username);
return users;
}

}
