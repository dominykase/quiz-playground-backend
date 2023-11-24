package com.quizplayground.quizplayground.jsonResources.results;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class FrequenciesQuestion {
    private @Getter @Setter Long id;
    private @Getter @Setter String questionText;
    public List<FrequenciesAnswer> answers;
}
