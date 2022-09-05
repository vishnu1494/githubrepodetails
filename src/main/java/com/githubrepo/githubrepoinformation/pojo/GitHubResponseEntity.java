/**
 * 
 */
package com.githubrepo.githubrepoinformation.pojo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * POJO Class GitHubResponseEntity
 * 
 * @author Vishnu
 *
 */
public class GitHubResponseEntity extends ResponseEntity {

	public GitHubResponseEntity(Object body, HttpStatus status) {
		super(body, status);

	}

}
