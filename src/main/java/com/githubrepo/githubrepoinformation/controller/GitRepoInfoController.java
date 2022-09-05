
package com.githubrepo.githubrepoinformation.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.githubrepo.githubrepoinformation.pojo.FindGitHubRepoResponse;
import com.githubrepo.githubrepoinformation.pojo.GitHubResponseEntity;
import com.githubrepo.githubrepoinformation.service.GitRepoInformationService;

import io.swagger.v3.oas.annotations.Operation;

/**
 * The Controller Class GitRepoInfoController
 * 
 * @author Vishnu
 *
 */

@RestController
@ControllerAdvice
@RequestMapping("/gitrepoinfo/api/v1")
public class GitRepoInfoController {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(GitRepoInfoController.class);

	@Autowired
	private GitRepoInformationService repoInformationService;

	@Operation(description = "This API will fetch the Github Repository information for the user")
	@GetMapping(value = "/getuserrepodetails", produces = MediaType.APPLICATION_JSON_VALUE)
	public GitHubResponseEntity getGitRepoDetails(@RequestParam(name = "userid", required = true) String userId) {
		LOGGER.debug("getGitRepoDetails start");
		GitHubResponseEntity repoDetails = null;
		LOGGER.info("Request param user id {}", userId);

		try {
			repoDetails = repoInformationService.getRepoDetailsForUser(userId);
		} catch (Exception e) {
			FindGitHubRepoResponse respObj = new FindGitHubRepoResponse();
			respObj.setMessage(e.getMessage());
			respObj.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			return new GitHubResponseEntity(respObj, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		LOGGER.debug("getGitRepoDetails end");
		return repoDetails;

	}

}
