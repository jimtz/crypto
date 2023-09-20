package com.cryptoTransactionSystem.RealData;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;

import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.HttpHeaders;
import org.apache.hc.core5.http.NameValuePair;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.message.BasicNameValuePair;
import org.apache.hc.core5.net.URIBuilder;
import org.springframework.stereotype.Component;

@Component
public class RealCryptoService {

	private static String apiKey = "8e216076-e49a-48f8-86fa-b9dbe36f7ded";
	 String uri = "https://sandbox-api.coinmarketcap.com/v2/cryptocurrency/quotes/latest";
	
	public String getRealCryptoPrice(String name) {
		List<NameValuePair> paratmers = new ArrayList<NameValuePair>();
	    //paratmers.add(new BasicNameValuePair("start","1"));
	    //paratmers.add(new BasicNameValuePair("limit","1"));
	    paratmers.add(new BasicNameValuePair("slug","bitcoin"));
	    paratmers.add(new BasicNameValuePair("convert","USD"));
	   
	    String result = "";
	    try {
	      result = makeAPICall(uri, paratmers);
	      System.out.println(result);
	    } catch (IOException e) {
	      System.out.println("Error: cannont access content - " + e.toString());
	    } catch (URISyntaxException e) {
	      System.out.println("Error: Invalid URL " + e.toString());
	    }
	    return result;
	}
	
	  public static String makeAPICall(String uri, List<NameValuePair> parameters)
		      throws URISyntaxException, IOException {
		    String response_content = "";

		    URIBuilder query = new URIBuilder(uri);
		    query.addParameters(parameters);

		    CloseableHttpClient client = HttpClients.createDefault();
		    HttpGet request = new HttpGet(query.build());

		    request.setHeader(HttpHeaders.ACCEPT, "application/json");
		    request.addHeader("X-CMC_PRO_API_KEY", apiKey);
		    CloseableHttpResponse response = client.execute(request);
		    try {
		      HttpEntity entity = response.getEntity();
		      try {
				response_content = EntityUtils.toString(entity);
		      } catch (ParseException | IOException e) {
				e.printStackTrace();
		      }
		      EntityUtils.consume(entity);
		    } finally {
		      response.close();
		    }
		    return response_content;
		  }

}
