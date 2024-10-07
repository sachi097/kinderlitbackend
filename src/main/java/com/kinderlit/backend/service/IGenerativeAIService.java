package com.kinderlit.backend.service;

import com.kinderlit.backend.controller.dto.ChatResponse;
import com.kinderlit.backend.entity.Chat;

public interface IGenerativeAIService {
    public ChatResponse getResponse(Chat chat);
}
