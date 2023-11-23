package com.medilabo.microservice_cloud.proxies;

import com.medilabo.microservice_cloud.beans.NoteBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "microservice-note")
public interface NoteProxy {

    @PostMapping(value = "/add", consumes = "application/json")
    NoteBean addNote(@RequestBody NoteBean note);

    @GetMapping("/all")
    List<NoteBean> findAllNote();

    @GetMapping("/delete/{id}")
    String deleteNoteById(@PathVariable String id);

    @PostMapping("/update/{id}")
    NoteBean updateNoteById(@PathVariable String id, @RequestBody NoteBean note);

    @GetMapping("/patient/{id}")
    List<NoteBean> findNotesByPatientId(@PathVariable String id);


}
