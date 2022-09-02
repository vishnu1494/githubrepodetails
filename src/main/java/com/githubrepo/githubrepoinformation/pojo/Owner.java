/**
 * 
 */
package com.githubrepo.githubrepoinformation.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Vishnu
 *
 */

@JsonInclude(Include.NON_NULL)
public class Owner {
	@JsonProperty
	private String login;

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

}
