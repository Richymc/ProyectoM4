package org.bedu.APIStreaming.profile.controller;

import org.bedu.APIStreaming.profile.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("profiles")
public class ProfileController {

    @Autowired
    private ProfileService service;


}
