package com.betting.application.mapper;

import com.betting.application.domain.Note;
import com.betting.application.domain.dto.note.NoteDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class NoteMapper {
    public List<NoteDto> mapToDtoList(List<Note> notes){
        return notes.stream().map(note -> new NoteDto(note.getId() ,note.getContent(), note.getUser().getId()))
                .collect(Collectors.toList());
    }
}
