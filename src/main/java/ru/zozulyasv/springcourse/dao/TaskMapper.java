package ru.zozulyasv.springcourse.dao;

import org.springframework.jdbc.core.RowMapper;
import ru.zozulyasv.springcourse.models.Task;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TaskMapper implements RowMapper<Task> {
    @Override
    public Task mapRow(ResultSet resultSet, int i) throws SQLException {
        Task task= new Task();
        task.setId(resultSet.getInt("id"));
        task.setType(resultSet.getString("taskType"));
        task.setPubDate(resultSet.getString("pubDate"));
        task.setStatus(resultSet.getString("status"));
        task.setText(resultSet.getString("text"));
        task.setTime(resultSet.getString("time"));
        task.setProjectId(resultSet.getInt("projectID"));

        return task;
    }
}
