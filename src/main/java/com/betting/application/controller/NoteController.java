package com.betting.application.controller;

import com.betting.application.domain.dto.note.NoteCreatorDto;
import com.betting.application.domain.dto.note.NoteDto;
import com.betting.application.mapper.NoteMapper;
import com.betting.application.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/betting")
public class NoteController {
    @Autowired
    private NoteService noteService;

    @Autowired
    private NoteMapper noteMapper;

    @GetMapping(value = "/note/{userId}")
    public List<NoteDto> getUserNotes(@PathVariable Long userId){
        return noteMapper.mapToDtoList(noteService.getUserNotes(userId));
    }

    @PostMapping(value = "/note", consumes = APPLICATION_JSON_VALUE)
    public void createNote(@RequestBody NoteCreatorDto noteCreatorDto){
        noteService.createNote(noteCreatorDto);
    }

    @PutMapping(value = "/note", consumes = APPLICATION_JSON_VALUE)
    public void updateNote(@RequestBody NoteDto noteDto){
        noteService.updateNote(noteDto);
    }
}
