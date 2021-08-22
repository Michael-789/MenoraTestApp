package com.javatpoint;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.javatpoint.mappers.ProductDetailsMapper;
import com.javatpoint.model.ProductDetails;
import com.javatpoint.xmlparse.ParseXML;
import lombok.extern.java.Log;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pojoclasses.Request;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.ArrayList;

@Log
@Component
public class Scheduler {

    @Autowired
    ParseXML parseXML;

    @Scheduled(fixedRateString = "${fixrate}")
    public void scheduleFixedRateTask() {
        Request request = null;
        try {
            request =  parseXML.execute();
        } catch (JAXBException e) {
            e.printStackTrace();
            log.warning("Parsing XML failed" + e.getMessage());
        }

        if (request != null) {
            try {
                sendUpdateRequst(request);
            } catch (IOException e) {
                e.printStackTrace();
                log.warning("Parsing XML ailed" + e.getMessage());
            }
        }

    }


    private void sendUpdateRequst(Request request) throws IOException {
        ArrayList<ProductDetails> productDetailsList = new ProductDetailsMapper().mapFromRequest(request);

        HttpPost httpPost = new HttpPost("http://localhost:9091/product");
        httpPost.setHeader("Content-type", "application/json");


        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonReq = ow.writeValueAsString(productDetailsList);

        StringEntity stringEntity = new StringEntity(jsonReq);
        httpPost.getRequestLine();
        httpPost.setEntity(stringEntity);

        CloseableHttpClient httpClient = HttpClients.createDefault();

        CloseableHttpResponse response = httpClient.execute(httpPost);

        log.info("Update Request sent. Response " + response);

    }
}
