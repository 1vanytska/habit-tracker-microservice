package com.htm.goalservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.UUID;

@Entity
public class Goal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID goalId;

    @NotNull
    private String title;

    @NotNull
    private String pictures;

    @NotNull
    private String description;

    @NotNull
    private int categoryId;

    @NotNull
    private boolean isPublic;

    @NotNull
    private LocalDate deadline;

    @NotNull
    private String status;

    @NotNull
    private LocalDate archivationTime;

    public UUID getGoalId() {
        return goalId;
    }

    public void setGoalId(UUID goalId) {
        this.goalId = goalId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPictures() {
        return pictures;
    }

    public void setPictures(String pictures) {
        this.pictures = pictures;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getArchivationTime() {
        return archivationTime;
    }

    public void setArchivationTime(LocalDate archivationTime) {
        this.archivationTime = archivationTime;
    }
}
