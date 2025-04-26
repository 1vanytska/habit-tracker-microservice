package com.htm.goalservice.mapper;

import com.htm.goalservice.dto.GoalResponseDTO;
import com.htm.goalservice.model.Goal;

public class GoalMapper {
    public static GoalResponseDTO toDTO(Goal goal) {
        GoalResponseDTO goalDTO = new GoalResponseDTO();
        goalDTO.setGoalId(goal.getGoalId().toString());
        goalDTO.setTitle(goal.getTitle());
        goalDTO.setPicture(goal.getPicture() != null ? goal.getPicture() : "");
        goalDTO.setDescription(goal.getDescription() != null ? goal.getDescription() : "");
        goalDTO.setCategoryId(goal.getCategoryId() != null ? goal.getCategoryId().toString() : "");
        goalDTO.setPublic(goal.isPublic());
        goalDTO.setDeadline(goal.getDeadline().toString());
        goalDTO.setStatus(goal.getStatus());
        goalDTO.setArchivationTime(goal.getArchivationTime() != null ? goal.getArchivationTime().toString() : "");
        return goalDTO;
    }
}
