/**
 * 
 */
package com.githubrepo.githubrepoinformation.util;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import com.githubrepo.githubrepoinformation.exception.UserNotFoundException;

/**
 * @author Vishnu
 *
 */

@Component
public class FindGitHubRepoUtil {

	public static String getResponseForApiAsString(String url) throws Exception {

		String response = null;
		try {

			CloseableHttpClient httpClient = HttpClientBuilder.create().build();

			HttpGet request = new HttpGet(url);
			request.addHeader("content-type", "application/json");

			HttpResponse result = httpClient.execute(request);
			result.getStatusLine().getStatusCode();

			if (result.getStatusLine().getStatusCode() == 404) {
				throw new UserNotFoundException("No data found");
			}
			response = EntityUtils.toString(result.getEntity(), "UTF-8");

		} catch (Exception e) {

			throw e;
		}
		return response;

	}

}
