package com.githubrepo.githubrepoinformation.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Vishnu
 *
 */

@JsonInclude(Include.NON_NULL)
public class Repository {

	@JsonProperty
	private String name;
	@JsonProperty
	private Owner owner;
	@JsonProperty
	private boolean fork;

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
	 * @return the owner
	 */
	public Owner getOwner() {
		return owner;
	}

	/**
	 * @param owner the owner to set
	 */
	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	/**
	 * @return the fork
	 */
	public boolean isFork() {
		return fork;
	}

	/**
	 * @param fork the fork to set
	 */
	public void setFork(boolean fork) {
		this.fork = fork;
	}

}
