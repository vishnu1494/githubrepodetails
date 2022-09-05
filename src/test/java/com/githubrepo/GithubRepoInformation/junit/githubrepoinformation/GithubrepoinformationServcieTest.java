
package com.githubrepo.GithubRepoInformation.junit.githubrepoinformation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.githubrepo.GithubRepoInformation.junit.constants.TestDataConstants;
import com.githubrepo.githubrepoinformation.pojo.GitHubResponseEntity;
import com.githubrepo.githubrepoinformation.service.GitRepoInformationService;

/**
 * @author Vishnu
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@EnableWebMvc
public class GithubrepoinformationServcieTest {

	@Autowired
	private GitRepoInformationService gitRepoInformationService;

	/**
	 * Git Repository Information Service test for Valid user.
	 */
	@Test
	public void getRepoDetailsForValidUser() {

		GitHubResponseEntity resp = gitRepoInformationService.getRepoDetailsForUser(TestDataConstants.VALID_USER);
		assertEquals(TestDataConstants.HTTP_CODE_200, resp.getStatusCodeValue());

	}

	/**
	 * Git Repository Information Service test for Invalid user.
	 */
	@Test
	public void getRepoDetailsForInvalidUser() {

		GitHubResponseEntity resp = gitRepoInformationService.getRepoDetailsForUser(TestDataConstants.INVALID_USER);
		assertEquals(TestDataConstants.HTTP_CODE_404, resp.getStatusCodeValue());

	}
}
