package com.example.api.v1.dto;

import java.util.UUID;

public record BookResponseDto(UUID id, String name, double price) {
}
