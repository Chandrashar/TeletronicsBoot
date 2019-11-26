package com.chan.uae.teletronics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.chan.uae.teletronics.entity.ContributorsByProjectId;
import com.chan.uae.teletronics.entity.ProjectByUser;
import com.chan.uae.teletronics.service.ProjectService;

@RestController
@RequestMapping("/projects")
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;
	
	@RequestMapping(value="/{username}", method=RequestMethod.GET, produces = { "application/json","application/xml" })
	//@ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
	public @ResponseBody ProjectByUser getProjectsByUser(@PathVariable String username) {
		//public @ResponseBody ProjectByUser getProjectsByUser2(@PathVariable String username) {
		
		return projectService.getProjectsByUser(username);//.orElseThrow(() -> new ResourceNotFoundException("Username", "username", username));
		//return Arrays.asList("Chandra", "Sharma", username);
		//return projectService.getProjectsByUser2(username);
	}
	
	@RequestMapping(value="/{username}/{projectId}", method=RequestMethod.GET, produces = { "application/json","application/xml" })
	//@ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
	public @ResponseBody ContributorsByProjectId getProjectsByUser(@PathVariable String username, @PathVariable String projectId) {
		
		return projectService.contribByProjectId(username, projectId);//.orElseThrow(() -> new ResourceNotFoundException("ProjectId", "username", project_id));
	}
	
	
	

}
