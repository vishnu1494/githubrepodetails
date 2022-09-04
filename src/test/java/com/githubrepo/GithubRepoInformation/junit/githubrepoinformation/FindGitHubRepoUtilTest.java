/**
 * 
 */
package com.githubrepo.GithubRepoInformation.junit.githubrepoinformation;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.githubrepo.GithubRepoInformation.junit.constants.TestDataConstants;
import com.githubrepo.githubrepoinformation.exception.DataNotFoundException;
import com.githubrepo.githubrepoinformation.util.FindGitHubRepoUtil;

/**
 * @author Vishnu
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@EnableWebMvc
public class FindGitHubRepoUtilTest {

	@MockBean
	private FindGitHubRepoUtil findGitHubRepoUtil;

	/**
	 * Test case for ResponseForApiAsString for valid repo url
	 *
	 */
	@Test
	public void getResponseForApiAsStringForGitRepositoryDetails() throws Exception {

		String result = findGitHubRepoUtil.getResponseForApiAsString(TestDataConstants.VALID_GITHUB_REPO_URL);
		assertNotNull(result);

	}

	/**
	 * Test case for ResponseForApiAsString for invalid repo url
	 *
	 */
	@Test(expected = DataNotFoundException.class)
	public void getResponseForApiAsStringForGitRepositoryDetailsError() throws Exception {

		String result = findGitHubRepoUtil.getResponseForApiAsString(TestDataConstants.INVALID_GITHUB_REPO_URL);

	}

	/**
	 * Test case for ResponseForApiAsString for valid branch url
	 *
	 */
	@Test()
	public void getResponseForApiAsStringForGitBranchDetails() throws Exception {

		String result = findGitHubRepoUtil.getResponseForApiAsString(TestDataConstants.VALID_GITHUB_BRANCH_URL);

	}

	/**
	 * Test case for ResponseForApiAsString for invalid branch url
	 *
	 */
	@Test(expected = DataNotFoundException.class)
	public void getResponseForApiAsStringForGitBranchDetailsError() throws Exception {

		String result = findGitHubRepoUtil.getResponseForApiAsString(TestDataConstants.INVALID_GITHUB_BRANCH_URL);

	}

}
