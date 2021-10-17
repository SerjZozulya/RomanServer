package ru.zozulyasv.springcourse.models;

public class Task {
    private int id;
    private String taskType;
    private String pubDate;
    private String status;
    private String text;
    private String time;

    public Task() {

    }

    public Task(int id, String taskType, String pubDate, String status, String text, String time) {
        this.id = id;
        this.taskType = taskType;
        this.pubDate = pubDate;
        this.status = status;
        this.text = text;
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {return taskType;}

    public void setType(String type) {
        this.taskType = type;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}
