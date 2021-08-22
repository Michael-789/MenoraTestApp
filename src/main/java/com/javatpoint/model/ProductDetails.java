package com.javatpoint.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
@Data
public class ProductDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    String requestId;
    @Column
    String sourceCompany;
    @Column
    String insuredId;
    @Column
    String type;
    @Column
    long price;
    @Column
    Date startDate;
    @Column
    Date endDate;

}
