package com.avansproftaak.secondsound.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ResourceDto {
    private Long id;
    private String filePath;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
