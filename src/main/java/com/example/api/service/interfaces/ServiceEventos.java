package com.example.api.service.interfaces;

import java.util.List;

public interface ServiceEventos <OUT,IN,UP> {
    public OUT create(IN event);

    public List<OUT> findAll();

    public OUT findById(Long id);

    public String delete(Long id);

    public UP update(UP ev,Long id);
}
