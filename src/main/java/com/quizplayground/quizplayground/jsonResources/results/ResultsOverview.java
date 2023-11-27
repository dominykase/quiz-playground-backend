package com.quizplayground.quizplayground.jsonResources.results;

import java.util.List;
import java.util.Map;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ResultsOverview {
    public Map<Long, Long> categoryDistribution;
    public List<FrequenciesQuestion> frequencies;
}
