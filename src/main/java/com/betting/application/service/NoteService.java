package com.betting.application.service;

import com.betting.application.domain.Note;
import com.betting.application.domain.User;
import com.betting.application.domain.dto.note.NoteCreatorDto;
import com.betting.application.domain.dto.note.NoteDto;
import com.betting.application.repository.NoteRepository;
import com.betting.application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NoteService {
    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Note> getUserNotes(Long userId){
        Optional<User> user = userRepository.findById(userId);
        List<Note> notes = new ArrayList<>();
        if(user.isPresent()){
            notes = user.get().getNotes();
        } else {}
        return notes;
    }

    public void createNote(NoteCreatorDto noteCreatorDto){
        Optional<User> user = userRepository.findById(noteCreatorDto.getUserId());
        if(user.isPresent()){
            noteRepository.save(new Note(noteCreatorDto.getContent(), user.get()));
        } else {}
    }

    public void updateNote(NoteDto noteDto){
        Optional<User> user = userRepository.findById(noteDto.getUserId());
        if(user.isPresent()) {
            noteRepository.save(new Note(noteDto.getNoteId(), noteDto.getContent(), user.get()));
        } else {}
    }
}
