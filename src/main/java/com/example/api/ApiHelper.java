package com.example.api;

import com.example.data.CallResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

/**
 * Created by WagnerMestrinho on 2/23/17.
 */
public class ApiHelper {

    private static final String url = "http://%s:8080/rest/call/%d";
    private static final String[] IP ={
                       "192.168.2.99",  //WAIL
                       "192.168.2.90",  //MATT
                       "192.168.2.42",  //CJ
                       "192.168.2.53",  //ROHAN
                       "192.168.2.185" //OSMAN
    };


    public CallResponse nextComputer (Integer number)
    {
        Random random = new Random();
        int randomNum = random.nextInt(IP.length);
        String nextIP = IP[randomNum];

        String nextUrl = String.format(url, nextIP, number);

        System.out.println("nextUrl=" + nextUrl);
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.add("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.95 Safari/537.36");

        HttpEntity entity = new HttpEntity(headers);
        HttpEntity response = restTemplate.exchange(nextUrl, HttpMethod.GET, entity, CallResponse.class);
        return (CallResponse) response.getBody();
    }


}
