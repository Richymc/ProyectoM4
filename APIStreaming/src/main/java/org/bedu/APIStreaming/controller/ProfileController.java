package org.bedu.APIStreaming.controller;

import org.bedu.APIStreaming.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Endpoints del Perfil", description = "CRUD del Perfil")
@RestController
@RequestMapping("profiles")
public class ProfileController {

    @Autowired
    private ProfileService service;


}
