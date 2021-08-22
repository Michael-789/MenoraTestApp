package com.javatpoint.xmlparse;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import pojoclasses.Request;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

@Component
public class ParseXML {

    @Value("${sourcefilepath}")
    String filePath ;


    public Request execute() throws JAXBException {

            File file = new File(File.separator + filePath + File.separator +"Request.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Request.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Request  request = (Request) jaxbUnmarshaller.unmarshal(file);


        return request;
    }
}
