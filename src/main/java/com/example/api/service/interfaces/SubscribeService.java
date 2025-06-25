package com.example.api.service.interfaces;

import com.example.api.service.ProjetoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public interface SubscribeService {
    public void subscribe(Long paramId1,Long paramId2);
}
