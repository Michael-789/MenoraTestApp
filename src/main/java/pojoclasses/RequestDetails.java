package pojoclasses;

import javax.xml.bind.annotation.XmlElement;


public class RequestDetails {

    String id;
    String acceptDate;
    String sourceCompany;

    @XmlElement(name = "Id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @XmlElement(name = "AcceptDate")
    public String getAcceptDate() {
        return acceptDate;
    }

    public void setAcceptDate(String acceptDate) {
        this.acceptDate = acceptDate;
    }

    @XmlElement(name = "SourceCompany")
    public String getSourceCompany() {
        return sourceCompany;
    }

    public void setSourceCompany(String sourceCompany) {
        this.sourceCompany = sourceCompany;
    }
}
