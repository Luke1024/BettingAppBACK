package com.betting.application.controller;

import com.betting.application.domain.Note;
import com.betting.application.domain.User;
import com.betting.application.domain.dto.note.NoteDto;
import com.betting.application.mapper.NoteMapper;
import com.betting.application.service.NoteService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.is;

@RunWith(SpringRunner.class)
@WebMvcTest(NoteController.class)
public class NoteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private NoteService noteService;

    @MockBean
    private NoteMapper noteMapper;

    @Test
    public void getUserNotes() throws Exception {
        NoteDto noteDto = new NoteDto(1L, "note content", 1L);
        Note note = new Note(1L, "note content", new User());

        List<NoteDto> noteDtoList = new ArrayList<>(Arrays.asList(noteDto));
        List<Note> notes = new ArrayList<>(Arrays.asList(note));

        when(noteService.getUserNotes(ArgumentMatchers.anyLong())).thenReturn(notes);
        when(noteMapper.mapToDtoList(ArgumentMatchers.anyListOf(Note.class))).thenReturn(noteDtoList);

        mockMvc.perform(get("/betting/note/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].noteId", is(1)))
                .andExpect(jsonPath("$[0].content",is("note content")));
    }

    @Test
    public void createNote() throws Exception {
        mockMvc.perform(post("/betting/note")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8"))
                .andExpect(status().isOk());
    }

    @Test
    public void updateNote() throws Exception {
        mockMvc.perform(put("/betting/note")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}