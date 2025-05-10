package com.htm.goalservice.mapper;

import com.htm.goalservice.dto.GoalRequestDTO;
import com.htm.goalservice.dto.GoalResponseDTO;
import com.htm.goalservice.model.Goal;

import java.time.LocalDate;
import java.util.UUID;

public class GoalMapper {
    public static GoalResponseDTO toDTO(Goal goal) {
        GoalResponseDTO goalDTO = new GoalResponseDTO();
        goalDTO.setGoalId(goal.getGoalId().toString());
        goalDTO.setUserId(goal.getUserId().toString());
        goalDTO.setTitle(goal.getTitle());
        goalDTO.setPicture(goal.getPicture() != null ? goal.getPicture() : "");
        goalDTO.setDescription(goal.getDescription() != null ? goal.getDescription() : "");
        goalDTO.setCategoryId(goal.getCategoryId() != null ? goal.getCategoryId().toString() : "");
        goalDTO.setIsPublic(goal.isPublic());
        goalDTO.setDeadline(goal.getDeadline().toString());
        goalDTO.setStatus(goal.getStatus());
        goalDTO.setArchivationTime(goal.getArchivationTime() != null ? goal.getArchivationTime().toString() : "");

        return goalDTO;
    }

    public static Goal toModel(GoalRequestDTO goalRequestDTO) {
        Goal goal = new Goal();
        goal.setUserId(UUID.fromString(goalRequestDTO.getUserId()));
        goal.setTitle(goalRequestDTO.getTitle());
        goal.setPicture(goalRequestDTO.getPicture());
        goal.setDescription(goalRequestDTO.getDescription());
        goal.setCategoryId(UUID.fromString(goalRequestDTO.getCategoryId()));
        goal.setIsPublic(goalRequestDTO.isPublic());
        goal.setDeadline(LocalDate.parse(goalRequestDTO.getDeadline()));
        goal.setStatus(goalRequestDTO.getStatus());
        goal.setArchivationTime(LocalDate.parse(goalRequestDTO.getArchivationTime()));

        return goal;
    }
}
