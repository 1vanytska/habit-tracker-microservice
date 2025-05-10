package com.htm.goalservice.dto;

import com.htm.goalservice.dto.validators.CreateGoalValidationGroup;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class GoalRequestDTO {

    @NotBlank(groups = CreateGoalValidationGroup.class,
            message = "User is required")
    private String userId;

    @NotBlank(message = "Title is required")
    @Size(max = 30, message = "Title cannot exceed 30 characters")
    private String title;

    private String picture;

    @Size(max = 250, message = "Description cannot exceed 250 characters")
    private String description;

    private String categoryId;

    @NotNull(message = "Specify visibility: public or private")
    private boolean isPublic;

    @NotBlank(message = "Deadline is required")
    private String deadline;

    @NotBlank(message = "Status is required")
    private String status;

    private String archivationTime;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTitle() { return title; }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setIsPublic(Boolean isPublic) {
        this.isPublic = isPublic;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getArchivationTime() {
        return archivationTime;
    }

    public void setArchivationTime(String archivationTime) {
        this.archivationTime = archivationTime;
    }
}
