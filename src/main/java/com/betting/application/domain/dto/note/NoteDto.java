package com.betting.application.domain.dto.note;

public class NoteDto {
    private Long noteId;
    private String content;
    private Long userId;

    public NoteDto() {
    }

    public NoteDto(Long noteId, String content, Long userId) {
        this.noteId = noteId;
        this.content = content;
        this.userId = userId;
    }

    public Long getNoteId() {
        return noteId;
    }

    public String getContent() {
        return content;
    }

    public Long getUserId() {
        return userId;
    }
}
