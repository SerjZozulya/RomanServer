package ru.zozulyasv.springcourse.controllers;

import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;
import ru.zozulyasv.springcourse.models.Message;
import ru.zozulyasv.springcourse.models.UserData;

/**
 * todo Document type authContorller
 */
@CrossOrigin
@RestController
@RequestMapping("/auth")
public class AuthController {

    private UserData data;
    private final boolean resultCode = true;
    private Message[] messages;

    @GetMapping("/me")
    public @ResponseBody
    String getData() {

        String json;

        if (resultCode) {

            data  = new UserData(10, "sergey@mail.ru", "sergey");
            messages = new Message[] {
                new Message(0, "Привет, пользователь, твой id = " + data.getId() + "!"),
                new Message(1, "Email: " + data.getEmail()),
                new Message(2, "Login: " + data.getLogin()),
            };
        }
        else {
            data = new UserData();
            messages = new Message[] {
                new Message(0, "You are not authorized!"),
            };
        }
        json = new Gson().toJson(this);

        return json;
    }
}
