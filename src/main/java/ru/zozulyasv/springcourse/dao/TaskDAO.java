package ru.zozulyasv.springcourse.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.zozulyasv.springcourse.models.Task;

import java.util.List;

@Component
public class TaskDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TaskDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Task> index(long projectId) {
        return jdbcTemplate.query("SELECT * FROM tasks WHERE \"projectID\" = ? ORDER BY id", new TaskMapper(), projectId);
    }

/*    public Task show(int id) {
        return jdbcTemplate.query("SELECT * FROM tasks WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Task.class))
            .stream().findAny().orElse(null);
    }*/

    public long save(Task task){
        jdbcTemplate.update("INSERT INTO tasks VALUES (?, ?, ?, ?, ?, DEFAULT, ?)",
            task.getType(), task.getPubDate(), task.getStatus(), task.getText(), task.getTime(), task.getProjectId());
        long result = jdbcTemplate.queryForObject(
            "SELECT  max(id) from tasks", Integer.class);
        return result;
    }

/*    public void update(int id, Task updatedTask) {
        jdbcTemplate.update("UPDATE tasks SET text=?, status=?, taskType = ? WHERE id=?",
            updatedTask.getText(), updatedTask.getStatus(), updatedTask.getType(), id);
    }*/

    public void delete(int id) {
        jdbcTemplate.update("DELETE  FROM tasks WHERE id=?", id);

    }
}
