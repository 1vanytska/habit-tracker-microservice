package com.htm.goalservice.service;

import com.htm.goalservice.dto.GoalRequestDTO;
import com.htm.goalservice.dto.GoalResponseDTO;
import com.htm.goalservice.exception.GoalNotFoundException;
import com.htm.goalservice.mapper.GoalMapper;
import com.htm.goalservice.model.Goal;
import com.htm.goalservice.repository.GoalRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class GoalService {

    private final GoalRepository goalRepository;

    public GoalService(GoalRepository goalRepository) {
        this.goalRepository = goalRepository;
    }

    public List<GoalResponseDTO> getGoals() {
        List<Goal> goals = goalRepository.findAll();

        return goals.stream()
                .map(GoalMapper::toDTO).toList();
    }

    public GoalResponseDTO createGoal(GoalRequestDTO goalRequestDTO) {
        Goal newGoal = goalRepository.save(
                GoalMapper.toModel(goalRequestDTO));

        return GoalMapper.toDTO(newGoal);
    }

    public GoalResponseDTO updateGoal(UUID id, GoalRequestDTO goalRequestDTO) {

        Goal goal = goalRepository.findById(id).orElseThrow(
                () -> new GoalNotFoundException("Goal not found with ID: " + id));

        goal.setTitle(goalRequestDTO.getTitle());
        goal.setPicture(goalRequestDTO.getPicture());
        goal.setDescription(goalRequestDTO.getDescription());
        goal.setCategoryId(UUID.fromString(goalRequestDTO.getCategoryId()));
        goal.setIsPublic(goalRequestDTO.isPublic());
        goal.setDeadline(LocalDate.parse(goalRequestDTO.getDeadline()));
        goal.setStatus(goalRequestDTO.getStatus());
        goal.setArchivationTime(LocalDate.parse(goalRequestDTO.getArchivationTime()));

        Goal updateGoal = goalRepository.save(goal);
        return GoalMapper.toDTO(updateGoal);
    }

    public void deleteGoal(UUID id) {
        goalRepository.deleteById(id);
    }
}
