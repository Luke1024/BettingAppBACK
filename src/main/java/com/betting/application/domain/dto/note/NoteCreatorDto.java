package com.betting.application.domain.dto.note;

public class NoteCreatorDto {
    private String content;
    private Long userId;

    public NoteCreatorDto() {
    }

    public NoteCreatorDto(String content, Long userId) {
        this.content = content;
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public Long getUserId() {
        return userId;
    }
}
