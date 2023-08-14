package com.rest.api.auth;

import com.rest.api.user.UserDto;

public record LoginResponse(String jwtToken, UserDto user) {
    
}
