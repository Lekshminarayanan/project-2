package com.niit.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.dao.FriendDao;
import com.niit.dao.UserDao;
import com.niit.model.ErrorClazz;
import com.niit.model.Friend;
import com.niit.model.User;

@Controller
public class FriendController {
@Autowired
private FriendDao friendDao;
@RequestMapping(value="/suggestedusers",method=RequestMethod.GET)
public ResponseEntity<?> suggestedusers(){
	String email=(String)session.getAttribute("loginId");
	if(email==null) {
		ErrorClazz error = new ErrorClazz(5,"Unauthorized access...");
		return new ResponseEntity<ErrorClazz> (error,HttpStatus.UNAUTHORIZED);
}
	List<User> suggestedUsers=friendDao.suggestedUsers(email);
	return new ResponseEntity<List<User>>(suggestedUsers,HttpStatus.OK);
}
public ResponseEntity<?> addFriend(@RequestBody User toId,HttpSession session){
	if(email==null) {
		ErrorClazz error = new ErrorClazz(5,"Unauthorized access...");
		return new ResponseEntity<ErrorClazz> (error,HttpStatus.UNAUTHORIZED);
}
	User fromId=UserDao.getUser(email);
	Friend friend=new Friend();
	friend.setFromId(fromId);
	friend.setToId(toId);
	friend.setStatus('p');
friendDao.addFriend(friend);
return new ResponseEntity<Void>(HttpStatus.OK);
	
}
@RequestMapping(value="/pendingrequests",method=RequestMethod.GET)
public ResponseEntity<?> pendingRequests(HttpStatus session){
	String email=(String)session.getAttribute("loginId");
	if(email==null) {
		ErrorClazz error = new ErrorClazz(5,"Unauthorized access...");
		return new ResponseEntity<ErrorClazz> (error,HttpStatus.UNAUTHORIZED);
}
	List<Friend> pendingRequests=friendDao.pendingRequests(email);
	return new ResponseEntity<List<Friend>> (pendingRequests,HttpStatus.OK);
}
@RequestMapping(value="/acceptrequest",method=RequestMethod.PUT)
public ResponseEntity<?> acceptRequest(@RequestBody Friend request,HttpSession session){
	String email=(String)session.getAttribute("loginId");
	if(email==null) {
		ErrorClazz error = new ErrorClazz(5,"Unauthorized access...");
		return new ResponseEntity<ErrorClazz> (error,HttpStatus.UNAUTHORIZED);
	
}
	friendDao.acceptRequest(request);
	return new ResponseEntity<Void>(HttpStatus.OK);
}
@RequestMapping(value="/deleterequest",method=RequestMethod.PUT)
public ResponseEntity<?> deleteRequest(@RequestBody Friend request,HttpSession session){
	String email=(String)session.getAttribute("loginId");
	if(email==null) {
		ErrorClazz error = new ErrorClazz(5,"Unauthorized access...");
		return new ResponseEntity<ErrorClazz> (error,HttpStatus.UNAUTHORIZED);
	
}
	friendDao.deleteRequest(request);
	return new ResponseEntity<Void>(HttpStatus.OK);
}
@RequestMapping(value="/friends",method=RequestMethod.GET)
public ResponseEntity<?> getAllFriends(HttpStatus session){
	String email=(String)session.getAttribute("loginId");
	if(email==null) {
		ErrorClazz error = new ErrorClazz(5,"Unauthorized access...");
		return new ResponseEntity<ErrorClazz> (error,HttpStatus.UNAUTHORIZED);
}
	List<Friend> friendDao.listOfFriends(email);
	return new  ResponseEntity<List<Friend>>(friends,HttpStatus.OK);
}
}