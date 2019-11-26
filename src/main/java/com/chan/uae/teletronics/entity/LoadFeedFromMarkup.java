package com.chan.uae.teletronics.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoadFeedFromMarkup {
	
	static List<Project> projects;
	static List<User> users;
	
	static {
		
		projects = new ArrayList<>();
				
		Project project = new Project("T101", "PHP migration", "http://www.T101-PHP.com", "WJ996O", 8117);
		projects.add(project);
		
		project = new Project("T102", "Cloud and Devops", "http://www.T102-Cloud.com", "SC113U", 5989);
		projects.add(project);
		
		project = new Project("T103", "Kubernates",	"http://www.T103-Kubernates.com", "YH650M",	7096);
		projects.add(project);
		
		project = new Project("T104", "Teraform Provisioning", "http://www.T104-Teraform.com", "IS143L",	4052);
		projects.add(project);
		
		project = new Project("T105", "Micro Services", "http://www.T105-Micro.com", "LE982C",	7324);
		projects.add(project);
		
		project = new Project("T106", "Multi Threading", "http://www.T106-Multi.com", "RL794L",	7475);
		projects.add(project);
		
		project = new Project("T107", "Azure Provisioning", "http://www.T107-Azure.com", "YX347N",	6108);
		projects.add(project);
		
		project = new Project("T108", "Legacy 2SpringBoot", "http://www.T108-Legacy.com", "KU699J",	3919);
		projects.add(project);
		
		project = new Project("T109", "Oracle Golden Gate", "http://www.T109-Oracle.com", "YX128B",	2138);
		projects.add(project);
		
		project = new Project("T110", "Oracle WebLogic 12c", "http://www.T110-Oracle.com", "AE148W",	6691);
		projects.add(project);
		
		users = new ArrayList<>();
		User user = new User("tele-111", Arrays.asList("T106", "T103", "T109", "T108"));
		users.add(user);
		user = new User("tele-112", Arrays.asList("T104", "T101", "T108", "T110"));
		users.add(user);
		user = new User("tele-113", Arrays.asList("T106", "T108", "T105"));
		users.add(user);
		user = new User("tele-114", Arrays.asList("T107", "T101", "T106", "T108"));
		users.add(user);
		user = new User("tele-115", Arrays.asList("T101", "T105"));
		users.add(user);
		user = new User("tele-116", Arrays.asList("T101", "T103"));
		users.add(user);
		user = new User("tele-117", Arrays.asList("T106", "T103", "T102", "T101"));
		users.add(user);
		user = new User("tele-118", Arrays.asList("T110", "T103", "T101", "T105"));
		users.add(user);
		user = new User("tele-119", Arrays.asList("T104", "T101"));
		users.add(user);
		user = new User("tele-120", Arrays.asList("T101", "T109", "T103", "T108", "T104"));
		users.add(user);
	}

	public static List<Project> getProjects() {
		return projects;
	}

//	public static void setProjects(List<Project> projects) {
//		LoadFeedFromMarkup.projects = projects;
//	}

	public static List<User> getUsers() {
		return users;
	}

//	public static void setUsers(List<User> users) {
//		LoadFeedFromMarkup.users = users;
//	}

	
	/*
	 * public static void main(String args[]) {
		
	List<Project> projects = new LoadFeedFromMarkup().getProjects();
	List<User> users = new LoadFeedFromMarkup().getUsers();
	
	projects.forEach(System.out::println);
	users.forEach(System.out::println);
	
		getProjectsByUser("tele-111");
		
}

public static List<ProjectByUser> getProjectsByUser(String username){
	
	
	
	List<ProjectByUser> lstPrj = new ArrayList<>();
	
	
	User user = users.stream().filter(x -> username.equals(x.getUserName())).findAny().orElse(null);
	
	System.out.println(user.getUserName());
	
	if(null!=user.getAssProjectIds()) {
		List<String> association = user.getAssProjectIds().stream().collect(Collectors.toList());
		association.forEach(System.out::println);
		
		//association.forEach(System.out::println);
		
		for(String projectId: association) {
			
			for(Project project: projects) {
				ProjectByUser byUser = new ProjectByUser();
				
				if(projectId.equals(project.getId())) {					
					
					byUser.setUser(user.getUserName());
					byUser.setProjectId(project.getId());
					byUser.setTitle(project.getTitle());
					byUser.setUrl(project.getUrl());
				}
				
				lstPrj.add(byUser);
			}
			
		}
		
		return lstPrj;
		
	} else
		return null;
}*/

}
