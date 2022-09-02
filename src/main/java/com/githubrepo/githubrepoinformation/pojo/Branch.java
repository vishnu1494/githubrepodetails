/**
 * 
 */
package com.githubrepo.githubrepoinformation.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author u533001
 *
 */
@JsonInclude(Include.NON_NULL)
public class Branch {

	private String name;

	private Commit commit;

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
	 * @return the commit
	 */
	public Commit getCommit() {
		return commit;
	}

	/**
	 * @param commit the commit to set
	 */
	public void setCommit(Commit commit) {
		this.commit = commit;
	}
}
