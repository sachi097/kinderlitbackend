package com.kinderlit.backend.service;

import com.kinderlit.backend.controller.dto.ChatResponse;
import com.kinderlit.backend.entity.Chat;
import com.kinderlit.backend.repo.ChatsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GenerativeAIService implements IGenerativeAIService {

    @Autowired
    private final Assistant assistant;

    @Autowired
    private final ChatsRepository chatsRepository;
    @Override
    public ChatResponse getResponse(Chat chat) {
        chatsRepository.saveChat(chat);
        ChatResponse chatResponse = assistant.getResponse(chat.getUserId(), chat.getContent());
        chatResponse.setUserId(chat.getUserId());
        Chat assistantResponse = new Chat();
        assistantResponse.setUserId(chat.getUserId());
        assistantResponse.setContent(chatResponse.getContent());
        assistantResponse.setRole("assistant");
        assistantResponse.setTimestamp(System.currentTimeMillis());
        chatsRepository.saveChat(assistantResponse);
        return chatResponse;
    }

}
