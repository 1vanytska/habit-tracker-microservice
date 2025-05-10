package com.htm.goalservice.controller;

import com.htm.goalservice.dto.GoalRequestDTO;
import com.htm.goalservice.dto.GoalResponseDTO;
import com.htm.goalservice.dto.validators.CreateGoalValidationGroup;
import com.htm.goalservice.service.GoalService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.groups.Default;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/goals")
@Tag(name = "Goal", description = "API for managing Goals")
public class GoalController {
    private final GoalService goalService;

    public GoalController(GoalService goalService) {
        this.goalService = goalService;
    }

    @GetMapping
    @Operation(summary = "Get Goals")
    public ResponseEntity<List<GoalResponseDTO>> getGoals() {
        List<GoalResponseDTO> goals = goalService.getGoals();
        return ResponseEntity.ok().body(goals);
    }

    @PostMapping
    @Operation(summary = "Create a new Goal")
    public ResponseEntity<GoalResponseDTO> createGoal(
            @Validated({Default.class, CreateGoalValidationGroup.class})
            @RequestBody GoalRequestDTO goalRequestDTO) {

        GoalResponseDTO goalResponseDTO = goalService.createGoal(goalRequestDTO);

        return ResponseEntity.ok().body(goalResponseDTO);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a Goal")
    public ResponseEntity<GoalResponseDTO> updateGoal(@PathVariable UUID id,
        @Validated({Default.class}) @RequestBody GoalRequestDTO goalRequestDTO) {

        GoalResponseDTO goalResponseDTO = goalService.updateGoal(id, goalRequestDTO);

        return ResponseEntity.ok().body(goalResponseDTO);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a Goal")
    public ResponseEntity<Void> deleteGoal(@PathVariable UUID id) {
        goalService.deleteGoal(id);
        return ResponseEntity.noContent().build();
    }
}
