package com.chan.uae.teletronics.service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.chan.uae.teletronics.entity.ContributorsByProjectId;
import com.chan.uae.teletronics.entity.DetailExtract;
import com.chan.uae.teletronics.entity.LoadFeedFromMarkup;
import com.chan.uae.teletronics.entity.Project;
import com.chan.uae.teletronics.entity.ProjectByUser;
import com.chan.uae.teletronics.entity.User;

@Service
@Component
public class ProjectService {
	
	private static List<Project> projects = LoadFeedFromMarkup.getProjects();
	private static List<User> users = LoadFeedFromMarkup.getUsers();
	
	
	/*public ProjectByUser getProjectsByUser2(String username){
		
		List<ProjectByUser> lst = new ArrayList<>();
		ProjectByUser byUser = null;
		//for(int i=0; i<100; i++) {
			byUser = new ProjectByUser();
			byUser.setProjectId("Vlink-" + i);
			byUser.setTitle("Checking Content Negotiation-" + i);
			byUser.setUrl("tanuscraft.com-" + i);
			byUser.setUser(username + "-" + i);
		//	lst.add(byUser);
		//}
		 return byUser;
		
		//return Arrays.asList("Chandra", "Sharma", username);
	}*/
	public ProjectByUser getProjectsByUser(String username){
		ProjectByUser byUser = new ProjectByUser();
		
		List<DetailExtract> lstPrj = new ArrayList<>();
		User user = users.stream().filter(x -> username.equals(x.getUserName())).findAny().orElse(null);
		
		if(null!=user) {
			List<String> association = user.getAssProjectIds().stream().collect(Collectors.toList());
			//association.forEach(System.out::println);
			
			byUser.setUser(user.getUserName());
			
			for(String projectId: association) {
				
				
				DetailExtract extract = new DetailExtract();
				
				
				for(Project project: projects) {				
					if(projectId.equals(project.getId())) {					
						
						//
						extract.setProjectId(project.getId());//(project.getId());
						extract.setTitle(project.getTitle());
						extract.setUrl(project.getUrl());
						lstPrj.add(extract);
					}
				}
				
			}

			byUser.setProjectDetails(lstPrj);
			return byUser;			
		} else
			return null;
	}
	
	


	public ContributorsByProjectId contribByProjectId(String username, String projectId){
		
		ContributorsByProjectId byProjectId = null;
		
		ProjectByUser projectByUser = getProjectsByUser(username);
		
		List<DetailExtract> detailExtracts = projectByUser.getProjectDetails();
		
		List<String> projectIds = new ArrayList<String>();
		
	for(DetailExtract id :detailExtracts) {
		projectIds.add(id.getProjectId());
	}
        
       
	if(projectIds.size() > 0) {
		byProjectId = new ContributorsByProjectId();
		for(String eachPId: projectIds) {
			if(projectId.equals(eachPId)) {
				for(Project projectLst: projects) {				
					
					if(eachPId.equals(projectLst.getId())) {					
						byProjectId.setReadmeMd(loadProjectMd(eachPId+".md"));//projectLst.getDesc()
						byProjectId.setTotalCommits(projectLst.getCommits());
						byProjectId.setContributors(listOfContributors(eachPId));
					}
				}
			}
		}
		
	} else
		return null;
	return byProjectId;
	}

	private String loadProjectMd(String string) {
		
		String path = "documents\\" + string;
		StringBuilder contentBuilder = new StringBuilder();
	    try (Stream<String> stream = Files.lines( Paths.get(path), StandardCharsets.UTF_8)) 
	    {
	        stream.forEach(s -> contentBuilder.append(s).append("\n"));
	    }
	    catch (IOException e) 
	    {
	        e.printStackTrace();
	    }
	    return limit50WordsOnly(contentBuilder.toString());
	}


	private String limit50WordsOnly(String line) {
		String[] wordList = {};
		 StringBuilder sb = new StringBuilder();
		
		if(!(line.equals(""))) 
         
            wordList = line.split(" ");
            
		if(wordList.length > 50) {
			for(int i=0; i<50; i++ ) 
				sb.append(wordList[i]+" ");
			return sb.append("..").toString();
		}else
			return line;
	}
		




	private List<String> listOfContributors(String projectId) {
		List<String> contributors = new ArrayList<String>();
		for(User user: users) {			
			List<String> contrib = user.getAssProjectIds();
			if(contrib.contains(projectId))
				contributors.add(user.getUserName());
				
		}
		return contributors;
	}
		
		
	
}
