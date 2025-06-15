package com.example.api.mappers;

public interface MapperCaseIn <TO,FROM> {
    FROM mapperDTOoriginIn (TO dtoin);
    TO mapperDTOIn (FROM dto);
}
