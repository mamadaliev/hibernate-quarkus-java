package com.example.model;

import java.util.UUID;

public record Book(UUID id, String name, double price) {
}
