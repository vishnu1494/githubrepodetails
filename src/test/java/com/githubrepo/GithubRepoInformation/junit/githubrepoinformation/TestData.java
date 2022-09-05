/**
 * 
 */
package com.githubrepo.GithubRepoInformation.junit.githubrepoinformation;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import com.githubrepo.githubrepoinformation.pojo.GitHubResponseEntity;
import com.githubrepo.githubrepoinformation.pojo.ServiceResponse;

/**
 * @author Vishnu
 * 
 *         Test data class for unit test case
 *
 */
public class TestData {

	public static GitHubResponseEntity getGitHubResponceEntity() {

		ServiceResponse obj = new ServiceResponse();
		obj.setMessage("ok");
		obj.setStatus(HttpStatus.NOT_ACCEPTABLE.toString());
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		return new GitHubResponseEntity(obj, HttpStatus.OK);

	}
}
