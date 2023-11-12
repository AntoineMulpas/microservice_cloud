package com.medilabo.microservice_cloud.beans;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PatientBean {

    private Long      id;
    private String    firstName;
    private String    lastName;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dob;
    private String    phone;
    private String gender;
    private AddressBean address;

}
