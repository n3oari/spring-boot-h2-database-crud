package com.bezkoder.spring.jpa.h2;

import com.bezkoder.spring.jpa.h2.dto.UserCommentDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.ContextConfiguration;

import static org.assertj.core.api.Assertions.assertThat;

@JsonTest
@ContextConfiguration(classes = {JacksonAutoConfiguration.class})
public class UserCommentDtoTest {

    @Autowired
    private JacksonTester<UserCommentDto> json;

    @Test
    void testDeserialize() throws Exception {

        String content = """
                {
                    "id": 1,
                    "body": "This is some awesome thinking!",
                    "postId": 242,
                    "likes": 3,
                    "user": {
                        "id": 105,
                        "username": "emmac",
                        "fullName": "Emma Wilson"
                    }
                }
                """;

        UserCommentDto dto = json.parseObject(content);

        assertThat(dto.getId()).isEqualTo(1);
        assertThat(dto.getBody()).contains("awesome thinking");
        assertThat(dto.getUser()).isNotNull();
        assertThat(dto.getUser().getUsername()).isEqualTo("emmac");
        assertThat(dto.getUser().getFullName()).isEqualTo("Emma Wilson");
    }


}
