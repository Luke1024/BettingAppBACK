package com.betting.application.mapper;

import com.betting.application.domain.Note;
import com.betting.application.domain.User;
import com.betting.application.domain.dto.note.NoteDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.shazam.shazamcrest.matcher.Matchers.sameBeanAs;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NoteMapperTest {

    @Autowired
    private NoteMapper noteMapper;

    private NoteDto noteDto = new NoteDto(1L, "note content", 1L);
    private Note note = new Note(1L, "note content", new User(1L,
            "", "", "", ""));

    private List<NoteDto> noteDtoList = new ArrayList<>(Arrays.asList(noteDto));
    private List<Note> notes = new ArrayList<>(Arrays.asList(note));

    @Test
    public void mapToDtoList() {
        assertThat(noteDtoList ,sameBeanAs(noteMapper.mapToDtoList(notes)));
    }
}