package com.quizplayground.quizplayground.jsonResources;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class SubmissionResult {
    public @Getter @Setter String categoryName;
    public @Getter @Setter int weightSum;
}
