package com.bezkoder.spring.jpa.h2.dto;

import org.apache.catalina.User;

public class UserCommentDto {

    private int id;
    private String body;
    private int postId;
    private int likes;
    private UserDto user;
}


/*
id	1
body	"This is some awesome thinking!"
postId	242
likes	3
user
id	105
username	"emmac"
fullName	"Emma Wilson"
*
* */