package ru.zozulyasv.springcourse.controllers;

import com.google.gson.Gson;
import com.google.gson.internal.StringMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.zozulyasv.springcourse.dao.TaskDAO;
import ru.zozulyasv.springcourse.models.Task;

/**
 * todo Document type tasksContorller
 */
@RestController
@RequestMapping("/api")
public class tasksController {

    private final TaskDAO taskDAO;

    private class PostRequestResponseBody {
        private long resultCode;
        private long id;

        public PostRequestResponseBody(long resultCode, long id) {
            this.resultCode = resultCode;
            this.id = id;
        }
    }

    @Autowired
    public tasksController(TaskDAO taskDAO) {
        this.taskDAO = taskDAO;
    }

    @CrossOrigin
    @GetMapping("/getTasks/{id}")
    public @ResponseBody String getTasks(@PathVariable long id) {
        String json = new Gson().toJson(taskDAO.index(id));
        return json;
    }

    @CrossOrigin
    @PostMapping("/addTask")
    public String addTask(@RequestBody Task task) {
        PostRequestResponseBody responseBody = new PostRequestResponseBody(0, taskDAO.save(task));
        return new Gson().toJson(responseBody);
    }

    @CrossOrigin
    @PostMapping("/delTask")
    public String deleteTask(@RequestBody StringMap<Integer> request) {
        Integer id = request.get("id");
        taskDAO.delete(id);
        PostRequestResponseBody responseBody = new PostRequestResponseBody(0, id);
        return new Gson().toJson(responseBody);
    }
}
