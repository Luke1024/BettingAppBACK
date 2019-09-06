package com.betting.application.domain.dto.note;

public class NoteUpdaterDto {
    private Long noteId;
    private String content;
    private Long userId;

    public NoteUpdaterDto(Long noteId, String content, Long userId) {
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
