package ru.zozulyasv.springcourse.dao;

import org.springframework.jdbc.core.RowMapper;
import ru.zozulyasv.springcourse.models.Project;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProjectMapper implements RowMapper<Project> {
    @Override
    public Project mapRow(ResultSet resultSet, int i) throws SQLException {

        Project project = new Project();
        project.setId(resultSet.getInt("id"));
        project.setName(resultSet.getString("name"));

        return project;
    }
}
