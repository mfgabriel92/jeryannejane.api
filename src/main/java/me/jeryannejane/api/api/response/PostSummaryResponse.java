package me.jeryannejane.api.api.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.OffsetDateTime;

@Getter
@Setter
@NoArgsConstructor
public class PostSummaryResponse implements Serializable {
    private String title;

    private String slug;

    private OffsetDateTime createdAt;
}
