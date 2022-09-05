/**
 * 
 */
package com.githubrepo.githubrepoinformation.util;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.githubrepo.githubrepoinformation.exception.DataNotFoundException;

/**
 * 
 * Util class FindGitHubRepoUtil
 * 
 * @author Vishnu
 *
 */

@Component
public class FindGitHubRepoUtil {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(FindGitHubRepoUtil.class);

	public static String getResponseForApiAsString(String url) throws Exception {
		LOGGER.debug("getResponseForApiAsString start");
		String response = null;
		try {
			LOGGER.debug("URL: {} ", url);
			CloseableHttpClient httpClient = HttpClientBuilder.create().build();

			HttpGet request = new HttpGet(url);
			request.addHeader("content-type", "application/json");
			HttpResponse result = httpClient.execute(request);
			result.getStatusLine().getStatusCode();
			LOGGER.debug("Status Code {}", result.getStatusLine().getStatusCode());
			if (result.getStatusLine().getStatusCode() == 200) {
				response = EntityUtils.toString(result.getEntity(), "UTF-8");
			} else if (result.getStatusLine().getStatusCode() == 404) {
				throw new DataNotFoundException("No data found");
			} else {
				throw new Exception(result.getStatusLine().getReasonPhrase());
			}

		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			throw e;
		}
		LOGGER.debug("getResponseForApiAsString end");
		return response;

	}

}
