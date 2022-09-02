/**
 * 
 */
package com.githubrepo.githubrepoinformation.pojo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * @author Vishnu
 *
 */
public class GitHubResponseEntity extends ResponseEntity {

	public GitHubResponseEntity(Object body, HttpStatus status) {
		super(body, status);

	}

}
