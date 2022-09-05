/**
 * 
 */
package com.githubrepo.GithubRepoInformation.junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.githubrepo.GithubRepoInformation.junit.githubrepoinformation.GithubrepoinformationIntegrationTest;

/**
 * 
 * The Class IntegrationTestSuite.
 * 
 * @author Vishnu
 *
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ GithubrepoinformationIntegrationTest.class })
public class IntegrationTestSuite {

}
