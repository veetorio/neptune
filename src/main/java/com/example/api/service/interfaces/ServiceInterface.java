package com.example.api.service.interfaces;

import java.util.List;

import com.example.api.controller.dtos.EventoDtoIn;
import com.example.api.controller.dtos.EventoDtoOut;
import com.example.api.controller.dtos.EventoDtoUpdateOut;

public interface ServiceInterface <OUT,IN> {
    public OUT create(IN event);

    public List<OUT> findAll();

    public OUT findById(Long id);

    public String delete(Long id);

}
