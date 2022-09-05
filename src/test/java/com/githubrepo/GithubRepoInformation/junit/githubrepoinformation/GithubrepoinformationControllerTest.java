/**
 * 
 */
package com.githubrepo.GithubRepoInformation.junit.githubrepoinformation;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.githubrepo.GithubRepoInformation.junit.constants.TestDataConstants;
import com.githubrepo.githubrepoinformation.controller.GitRepoInfoController;
import com.githubrepo.githubrepoinformation.service.GitRepoInformationService;

/**
 * @author u533001
 *
 */

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = GitRepoInfoController.class)
public class GithubrepoinformationControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private GitRepoInformationService gitRepoInformationService;

	/**
	 * Git Repository Information controller test with valid user.
	 *
	 */
	@Test
	public void gitRepoInformationSuccess() throws Exception {

		given(gitRepoInformationService.getRepoDetailsForUser(Mockito.anyString()))
				.willReturn(TestData.getGitHubResponceEntity());
		this.mockMvc.perform(get("/gitrepoinfo/api/v1/getuserrepodetails").param(TestDataConstants.PARAM_USER_ID,
				TestDataConstants.VALID_USER)).andExpect(status().isOk());
	}

	/**
	 * Git Repository Information controller test throws exception .
	 *
	 */
	@Test
	public void gitRepoInformationThrowExceptionFromServiceClass() throws Exception {

		given(gitRepoInformationService.getRepoDetailsForUser(Mockito.anyString()))
				.willThrow(new RuntimeException("Exception"));
		this.mockMvc.perform(get("/gitrepoinfo/api/v1/getuserrepodetails").param(TestDataConstants.PARAM_USER_ID,
				TestDataConstants.VALID_USER)).andExpect(status().is(TestDataConstants.HTTP_CODE_500));
	}

}
