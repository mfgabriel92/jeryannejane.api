package me.jeryannejane.api.api.response;

import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
public class PostSummaryResponse {
    private String title;

    private String slug;

    private OffsetDateTime createdAt;
}
