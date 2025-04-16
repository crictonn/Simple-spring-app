package by.cherkas.exam.validators;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfanityCheckResponse {
    private String original;
    private String censored;
    private boolean has_profanity;
}
