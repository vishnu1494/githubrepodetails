/**
 * 
 */
package com.githubrepo.GithubRepoInformation.junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.githubrepo.GithubRepoInformation.junit.githubrepoinformation.GithubrepoinformationControllerTest;
import com.githubrepo.GithubRepoInformation.junit.githubrepoinformation.GithubrepoinformationIntegrationTest;

/**
 * @author Vishnu
 *
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({ GithubrepoinformationControllerTest.class, GithubrepoinformationIntegrationTest.class })
public class AllTestSuite {

}
