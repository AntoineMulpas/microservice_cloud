package com.medilabo.microservice_cloud.controllers;

import com.medilabo.microservice_cloud.beans.NoteBean;
import com.medilabo.microservice_cloud.proxies.NoteProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/note")
@CrossOrigin(origins = "*")
public class NoteController {

    private final NoteProxy noteProxy;

    @Autowired
    public NoteController(NoteProxy noteProxy) {
        this.noteProxy = noteProxy;
    }

    @PostMapping(value = "/add", consumes = "application/json")
    public ResponseEntity <NoteBean> addNote(
            @RequestBody NoteBean note
    ) {
        NoteBean addedNote = noteProxy.addNote(note);
        return ResponseEntity.ok().body(addedNote);
    }

    @GetMapping("/all")
    public ResponseEntity<List <NoteBean>> findAllNotes() {
        List <NoteBean> allNote = noteProxy.findAllNote();
        return ResponseEntity.ok().body(allNote);
    }


    @GetMapping("/delete/{id}")
    public ResponseEntity<String> deleteNoteById(
            @PathVariable String id
    ) {
        noteProxy.deleteNoteById(id);
        return ResponseEntity.ok().body("Note deleted with success.");
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<NoteBean> updateNoteById(
            @PathVariable String id,
            @RequestBody NoteBean note
    ) {
        NoteBean updatedNote = noteProxy.updateNoteById(id, note);
        return ResponseEntity.ok().body(updatedNote);
    }

    @GetMapping("/patient/{id}")
    public ResponseEntity<List<NoteBean>> findNoteByPatientId(
            @PathVariable String id
    ) {
        System.out.println(id);
        List <NoteBean> notes = noteProxy.findNotesByPatientId(id);
        System.out.println(notes);
        return ResponseEntity.ok().body(notes);
    }


}
