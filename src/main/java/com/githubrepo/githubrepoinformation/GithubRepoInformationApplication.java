package com.githubrepo.githubrepoinformation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

/**
 * The Starter Class GithubRepoInformationApplication
 * 
 * @author Vishnu
 *
 */
@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Git Repo Information", version = "2.0", description = "Git repo Information"))
public class GithubRepoInformationApplication {

	public static void main(String[] args) {
		SpringApplication.run(GithubRepoInformationApplication.class, args);
	}

}
