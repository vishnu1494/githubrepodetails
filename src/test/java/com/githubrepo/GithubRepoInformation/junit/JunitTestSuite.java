/**
 * 
 */
package com.githubrepo.GithubRepoInformation.junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.githubrepo.GithubRepoInformation.junit.githubrepoinformation.GithubrepoinformationControllerTest;
import com.githubrepo.GithubRepoInformation.junit.githubrepoinformation.GithubrepoinformationServcieTest;

/**
 * @author Vishnu
 *
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ GithubrepoinformationControllerTest.class, GithubrepoinformationServcieTest.class })
public class JunitTestSuite {

}
