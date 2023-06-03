package com.mycompany.models;

import java.util.UUID;

public class Activity {
    private String id;
    private String subject;
    private String theme;
    private String teacher;
    private String email;
    private String dueDate;
    private String notes;

    public Activity(String id, String subject, String theme, String teacher, String email, String dueDate, String notes) {
        this.id = generateId();
        this.subject = subject;
        this.theme = theme;
        this.teacher = teacher;
        this.email = email;
        this.dueDate = dueDate;
        this.notes = notes;
    }
    
    private String generateId() {
        return UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public String getSubject() {
        return subject;
    }

    public String getTheme() {
        return theme;
    }

    public String getTeacher() {
        return teacher;
    }

    public String getEmail() {
        return email;
    }

    public String getDueDate() {
        return dueDate;
    }

    public String getNotes() {
        return notes;
    }
}

