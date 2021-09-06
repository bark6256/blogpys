package com.example.blogpys.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoginReqDto {
	private String username;
	private String password;
	private boolean remember;
}
