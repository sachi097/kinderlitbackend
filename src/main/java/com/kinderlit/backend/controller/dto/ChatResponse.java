package com.kinderlit.backend.controller.dto;

import lombok.Data;

@Data
public class ChatResponse {
    Integer userId;
    String content;
    Boolean latex;
}
