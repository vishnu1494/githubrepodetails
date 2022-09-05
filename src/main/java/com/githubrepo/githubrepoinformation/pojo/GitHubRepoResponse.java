/**
 * 
 */
package com.githubrepo.githubrepoinformation.pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * POJO Class GitHubRepoResponse
 * 
 * @author Vishnu
 *
 */

@JsonInclude(Include.NON_NULL)
public class GitHubRepoResponse {

	private String name;

	private String owner;

	private List<BranchResponse> branches;

	/**
	 * @return the owner
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * @param owner the owner to set
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the branches
	 */
	public List<BranchResponse> getBranches() {
		return branches;
	}

	/**
	 * @param branches the branches to set
	 */
	public void setBranches(List<BranchResponse> branches) {
		this.branches = branches;
	}

}
