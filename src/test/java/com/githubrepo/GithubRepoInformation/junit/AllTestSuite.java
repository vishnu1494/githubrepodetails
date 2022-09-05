/**
 * 
 */
package com.githubrepo.GithubRepoInformation.junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.githubrepo.GithubRepoInformation.junit.githubrepoinformation.FindGitHubRepoUtilTest;
import com.githubrepo.GithubRepoInformation.junit.githubrepoinformation.GithubrepoinformationControllerTest;
import com.githubrepo.GithubRepoInformation.junit.githubrepoinformation.GithubrepoinformationIntegrationTest;
import com.githubrepo.GithubRepoInformation.junit.githubrepoinformation.GithubrepoinformationServcieTest;

/**
 * @author Vishnu
 * 
 *         TestSuite class
 *
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({ GithubrepoinformationControllerTest.class, GithubrepoinformationServcieTest.class,
		FindGitHubRepoUtilTest.class, GithubrepoinformationIntegrationTest.class })
public class AllTestSuite {

}
