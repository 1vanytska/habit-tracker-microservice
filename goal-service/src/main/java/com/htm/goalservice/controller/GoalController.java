package com.htm.goalservice.controller;

import com.htm.goalservice.dto.GoalResponseDTO;
import com.htm.goalservice.service.GoalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/goals")
public class GoalController {
    private final GoalService goalService;

    public GoalController(GoalService goalService) {
        this.goalService = goalService;
    }

    @GetMapping
    public ResponseEntity<List<GoalResponseDTO>> getGoals() {
        List<GoalResponseDTO> goals = goalService.getGoals();
        return ResponseEntity.ok().body(goals);
    }
}
