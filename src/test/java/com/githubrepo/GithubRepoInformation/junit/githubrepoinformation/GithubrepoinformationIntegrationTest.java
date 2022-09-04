/**
 * 
 */
package com.githubrepo.GithubRepoInformation.junit.githubrepoinformation;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.githubrepo.GithubRepoInformation.junit.constants.TestDataConstants;

/**
 * @author Vishnu
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class GithubrepoinformationIntegrationTest {

	@Autowired
	private MockMvc mockMvc;

	/**
	 * Test case for GitHubRepoInfomation valid user
	 *
	 */
	@Test
	public void getGitHubRepoInfomationValidUserSuccess() throws Exception {

		MvcResult result = this.mockMvc.perform(get("/gitrepoinfo/api/v1/getuserrepodetails")
				.param(TestDataConstants.PARAM_USER_ID, TestDataConstants.VALID_USER)).andExpect(status().isOk())
				.andReturn();
		assertEquals(TestDataConstants.HTTP_CODE_200, result.getResponse().getStatus());
	}

	/**
	 * Test case for GitHubRepoInfomation invalid user
	 *
	 */
	@Test
	public void getGitHubRepoInfomationInvalidUser() throws Exception {

		MvcResult result = this.mockMvc.perform(get("/gitrepoinfo/api/v1/getuserrepodetails")
				.param(TestDataConstants.PARAM_USER_ID, TestDataConstants.INVALID_USER)).andReturn();
		assertEquals(TestDataConstants.HTTP_CODE_404, result.getResponse().getStatus());
	}

	/**
	 * Test case for GitHubRepoInfomation with different header for Accept type
	 *
	 */
	@Test
	public void getGitHubRepoInfomationValidUserWithDiffHeader() throws Exception {

		MvcResult result = this.mockMvc.perform(get("/gitrepoinfo/api/v1/getuserrepodetails")
				.param(TestDataConstants.PARAM_USER_ID, TestDataConstants.VALID_USER)
				.header("Accept", "application/xml")).andReturn();
		assertEquals(TestDataConstants.HTTP_CODE_406, result.getResponse().getStatus());
	}

}
