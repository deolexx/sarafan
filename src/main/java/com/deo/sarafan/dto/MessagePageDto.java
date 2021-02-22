package com.deo.sarafan.dto;

import com.deo.sarafan.entity.Message;
import com.deo.sarafan.entity.Views;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

import java.util.List;

@Data
@JsonView(Views.FullMessage.class)
public class MessagePageDto {
    private List<Message> messages;
    private int currentPage;
    private int totalPages;
}
