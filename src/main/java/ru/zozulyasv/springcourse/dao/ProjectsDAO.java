package ru.zozulyasv.springcourse.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.zozulyasv.springcourse.models.Project;

import java.util.List;

@Component
public class ProjectsDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ProjectsDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Project> index() {
        return jdbcTemplate.query("SELECT * FROM projects", new ProjectMapper());
    }

/*    public Task show(int id) {
        return jdbcTemplate.query("SELECT * FROM tasks WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Task.class))
            .stream().findAny().orElse(null);
    }*/

    public void save(Project project){
        jdbcTemplate.update("INSERT INTO projects VALUES (?, ?)",
            project.getId(), project.getName());
    }

/*    public void update(int id, Task updatedTask) {
        jdbcTemplate.update("UPDATE tasks SET text=?, status=?, taskType = ? WHERE id=?",
            updatedTask.getText(), updatedTask.getStatus(), updatedTask.getType(), id);
    }*/

    public void delete(int id) {
        jdbcTemplate.update("DELETE  FROM projects WHERE id=?", id);

    }
}
