package com.example.api.mappers;

public interface MapperCaseOut <FROM, TO> {
    public FROM mapToOrigin(TO evento);

    public TO mapToDtoOut(FROM evento);
}
