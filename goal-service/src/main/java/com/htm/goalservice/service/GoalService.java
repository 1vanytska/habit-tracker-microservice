package com.htm.goalservice.service;

import com.htm.goalservice.dto.GoalResponseDTO;
import com.htm.goalservice.mapper.GoalMapper;
import com.htm.goalservice.model.Goal;
import com.htm.goalservice.repository.GoalRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GoalService {
    private GoalRepository goalRepository;

    public GoalService(GoalRepository goalRepository) {
        this.goalRepository = goalRepository;
    }

    public List<GoalResponseDTO> getGoals (){
        List<Goal> goals = goalRepository.findAll();

        return goals.stream().map(GoalMapper::toDTO).toList();
    }
}
