/**
 * 
 */
package com.githubrepo.githubrepoinformation.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * POJO Class Commit
 * 
 * @author Vishnu
 *
 */
@JsonInclude(Include.NON_NULL)
public class Commit {

	private String sha;

	/**
	 * @return the sha
	 */
	public String getSha() {
		return sha;
	}

	/**
	 * @param sha the sha to set
	 */
	public void setSha(String sha) {
		this.sha = sha;
	}

}
