package ru.zozulyasv.springcourse.controllers;

import com.google.gson.Gson;
import com.google.gson.internal.StringMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.zozulyasv.springcourse.dao.ProjectsDAO;
import ru.zozulyasv.springcourse.models.Project;

/**
 * todo Document type projectsController
 */

@RestController
@RequestMapping("/api")
public class projectsController {
    private final ProjectsDAO projectsDAO;

    @Autowired
    public projectsController(ProjectsDAO projectsDAO) {
        this.projectsDAO = projectsDAO;
    }

    @CrossOrigin
    @GetMapping("/getProjects")
    public @ResponseBody
    String sendProjects() {
        String json = new Gson().toJson(projectsDAO.index());
        return json;
    }

    @CrossOrigin
    @PostMapping("/addProject")
    public void addProject(@RequestBody Project project) {
        projectsDAO.save(project);
    }

    @CrossOrigin
    @PostMapping("/delProject")
    public void deleteProject(@RequestBody StringMap<Integer> request) {
        Integer id = request.get("id");
        projectsDAO.delete(id);
    }
}
