package ru.zozulyasv.springcourse.dao;

import org.springframework.stereotype.Component;
import ru.zozulyasv.springcourse.models.Task;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class TaskDAO {
    private static int TASK_COUNT;

    private static final String URL = "jdbc:postgresql://localhost:5432/my_db";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "postgres";

    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<Task> index(){
        List<Task> taskList = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM tasks";
            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()) {
                Task task = new Task();

                task.setId(resultSet.getInt("id"));
                task.setText(resultSet.getString("text"));
                task.setType(resultSet.getString("type"));
                task.setPubDate(resultSet.getString("pubDate"));
                task.setStatus(resultSet.getString("status"));
                task.setTime(resultSet.getString("time"));
                taskList.add(task);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return taskList;
    }

    public Task show(int id) {

        Task task = null;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM tasks WHERE id = ?");

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();

            task= new Task();
            task.setId(resultSet.getInt("id"));
            task.setType(resultSet.getString("type"));
            task.setPubDate(resultSet.getString("pubDate"));
            task.setStatus(resultSet.getString("status"));
            task.setText(resultSet.getString("text"));
            task.setTime(resultSet.getString("time"));


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return task;
    }

    public void save(Task task){

        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("INSERT INTO tasks VALUES (1, ?, ?, ?)");

            preparedStatement.setString(1, task.getType());
            preparedStatement.setString(2, task.getStatus());
            preparedStatement.setString(3, task.getText());

            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void update(int id, Task updatedTask) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE tasks " +
                    "SET text=?, type=?, pubDate=?, status=?, time=?" +
                    "WHERE id = ?");

            preparedStatement.setString(1, updatedTask.getType());
            preparedStatement.setString(2, updatedTask.getStatus());
            preparedStatement.setString(3, updatedTask.getText());
            preparedStatement.setInt(4, updatedTask.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void delete(int id) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("DELETE FROM tasks WHERE  id = ?");

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
