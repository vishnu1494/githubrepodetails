/**
 * 
 */
package com.githubrepo.githubrepoinformation.pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * 
 * POJO Class FindGitHubRepoResponse
 * 
 * @author Vishnu
 *
 */

@JsonInclude(Include.NON_NULL)
public class FindGitHubRepoResponse extends ServiceResponse {

	@JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
	private List<GitHubRepoResponse> repositoryList;

	/**
	 * @return the repositoryList
	 */
	public List<GitHubRepoResponse> getRepositoryList() {
		return repositoryList;
	}

	/**
	 * @param repositoryList the repositoryList to set
	 */
	public void setRepositoryList(List<GitHubRepoResponse> repositoryList) {
		this.repositoryList = repositoryList;
	}

}
