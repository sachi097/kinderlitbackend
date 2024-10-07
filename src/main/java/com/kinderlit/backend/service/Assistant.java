package com.kinderlit.backend.service;

import com.kinderlit.backend.controller.dto.ChatResponse;
import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;

public interface Assistant {

//    @SystemMessage("""
//                Be nice and answer accurately.
//                If you do not know answer then say it.
//            """)
//    String chat(@MemoryId String memoryId, @UserMessage String message);

    @SystemMessage("""
                If latex code is given as a response then set property latex as true.
                For latex code, consider math mode and generate latex code with correct formatting.
                Avoid LaTeX Error: Command \\end{itemize} invalid in math mode.
                For request messages that ask problem and solution, include applicable headers. For example: Problem Statement, Solution.
                For request messages that ask for latex code, provide response with latex code starting with \\documentclass
            """)
    ChatResponse getResponse(@MemoryId String memoryId, @UserMessage String message);
}
