/**
 * 
 */
package com.githubrepo.githubrepoinformation.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.githubrepo.githubrepoinformation.exception.UserNotFoundException;
import com.githubrepo.githubrepoinformation.pojo.Branch;
import com.githubrepo.githubrepoinformation.pojo.BranchResponse;
import com.githubrepo.githubrepoinformation.pojo.FindGitHubRepoResponse;
import com.githubrepo.githubrepoinformation.pojo.GitHubRepoResponse;
import com.githubrepo.githubrepoinformation.pojo.GitHubResponseEntity;
import com.githubrepo.githubrepoinformation.pojo.Repository;
import com.githubrepo.githubrepoinformation.util.FindGitHubRepoUtil;

/**
 * Service Class RepoInformationService
 * 
 * @author Vishnu
 *
 */
@Service
public class GitRepoInformationService {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(GitRepoInformationService.class);

	@Value("${github.repo.url}")
	private String githubRepoUrl;

	@Value("${github.branch.url}")
	private String githubBranchUrl;

	public GitHubResponseEntity getRepoDetailsForUser(String userId) {

		FindGitHubRepoResponse respObj = new FindGitHubRepoResponse();
		try {
			ObjectMapper objMapper = new ObjectMapper();
			objMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			objMapper.setSerializationInclusion(Include.NON_NULL);

			String respAPI = FindGitHubRepoUtil.getResponseForApiAsString(String.format(githubRepoUrl, userId));
			List<Repository> initialRepoList = objMapper.readValue(respAPI, new TypeReference<List<Repository>>() {
			});
			List<Repository> repoList = initialRepoList.stream().filter(repo -> !repo.isFork())
					.collect(Collectors.toList());

			if (!CollectionUtils.isEmpty(repoList)) {

				List<GitHubRepoResponse> repoListResp = new ArrayList<GitHubRepoResponse>();

				repoList.forEach(repo -> {
					GitHubRepoResponse objRepo = new GitHubRepoResponse();
					objRepo.setName(repo.getName());
					objRepo.setOwner(repo.getOwner().getLogin());

					String branches;
					List<Branch> branchList = null;

					try {

						branches = FindGitHubRepoUtil.getResponseForApiAsString(
								githubBranchUrl + userId + "/" + repo.getName() + "/branches");
						branchList = objMapper.readValue(branches, new TypeReference<List<Branch>>() {
						});
						List<BranchResponse> branResponseList = new ArrayList<BranchResponse>();

						if (!CollectionUtils.isEmpty(branchList)) {
							branchList.forEach(branch -> {
								BranchResponse objBranchResponse = new BranchResponse();
								objBranchResponse.setName(branch.getName());
								objBranchResponse.setLastCommitSha(branch.getCommit().getSha());
								branResponseList.add(objBranchResponse);
							});
							objRepo.setBranches(branResponseList);

						}
					} catch (Exception e) {
						LOGGER.error(e.getMessage(), e);
					}
					repoListResp.add(objRepo);
				});
				respObj.setRepositoryList(repoListResp);
			}

		} catch (UserNotFoundException e) {

			respObj.setMessage(e.getMessage());
			respObj.setStatus(HttpStatus.NOT_FOUND.toString());
			return new GitHubResponseEntity(respObj, HttpStatus.NOT_FOUND);

		} catch (Exception ex) {

			respObj.setMessage(ex.getMessage());
			respObj.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			return new GitHubResponseEntity(respObj, HttpStatus.INTERNAL_SERVER_ERROR);

		}

		return new GitHubResponseEntity(respObj, HttpStatus.OK);

	}

}
