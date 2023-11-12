package com.medilabo.microservice_cloud.beans;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AddressBean {

    private Long id;
    private String address;
    private String zip;
    private String city;

}
