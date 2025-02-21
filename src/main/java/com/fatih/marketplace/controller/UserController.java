package com.fatih.marketplace.controller;

import com.fatih.marketplace.controller.api.UserApi;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController implements UserApi {
}
