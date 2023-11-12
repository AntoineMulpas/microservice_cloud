package com.medilabo.microservice_cloud.beans;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class NoteBean {

    private String id;
    private String note;
    private String patientId;

}
