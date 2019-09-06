package com.betting.application.controller;

import com.betting.application.domain.dto.note.NoteCreatorDto;
import com.betting.application.domain.dto.note.NoteDto;
import com.betting.application.mapper.NoteMapper;
import com.betting.application.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/betting")
public class NoteController {
    @Autowired
    private NoteService noteService;

    @Autowired
    private NoteMapper noteMapper;

    @GetMapping(value = "/note")
    public List<NoteDto> getUserNotes(@PathVariable Long userId){
        return noteMapper.mapToDtoList(noteService.getUserNotes(userId));
    }

    @PostMapping(value = "/note")
    public void createNote(@RequestBody NoteCreatorDto noteCreatorDto){
        noteService.createNote(noteCreatorDto);
    }

    @PutMapping(value = "/note")
    public void updateNote(@RequestBody NoteDto noteDto){
        noteService.updateNote(noteDto);
    }
}
