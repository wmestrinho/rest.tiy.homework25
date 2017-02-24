package com.example.controller;

import com.example.api.ApiHelper;
import com.example.data.CallResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;

/**
 * Created by WagnerMestrinho on 2/23/17.
 */
@org.springframework.web.bind.annotation.RestController
public class RestController {

    @RequestMapping(path = "/rest/call/{number}", method = RequestMethod.GET)
    public CallResponse callingNumber(@PathVariable Integer number) throws IOException, InterruptedException {

        String msg = String.valueOf(number);


        if (number == null) {
            number = 25;
        }

        if (number == 0 ){
            msg = "houston we have a problem";
        }

        ProcessBuilder pb = new ProcessBuilder("say",  msg );
        //make computer speak

        Process p = pb.start();

        CallResponse callResponse = new CallResponse(true, number);

        Thread.sleep(2000);

        ApiHelper apiHelper = new ApiHelper();
        apiHelper.nextComputer(number-1);

        return callResponse;


    }


}
