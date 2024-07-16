package com.dailycodebuffer.cricket.model;

import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PlayerRequest {

    @NotNull
    @NotEmpty
    private String name;
    private String role;
}

