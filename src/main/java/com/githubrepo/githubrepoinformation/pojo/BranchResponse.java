package com.githubrepo.githubrepoinformation.pojo;

/**
 * @author Vishnu
 *
 */
public class BranchResponse {

	private String name;

	private String lastCommitSha;

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
	 * @return the lastCommitSha
	 */
	public String getLastCommitSha() {
		return lastCommitSha;
	}

	/**
	 * @param lastCommitSha the lastCommitSha to set
	 */
	public void setLastCommitSha(String lastCommitSha) {
		this.lastCommitSha = lastCommitSha;
	}

}
