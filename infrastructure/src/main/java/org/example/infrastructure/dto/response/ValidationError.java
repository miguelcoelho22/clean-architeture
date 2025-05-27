package org.example.infrastructure.dto.response;

public record ValidationError(String field, String message) {
}
