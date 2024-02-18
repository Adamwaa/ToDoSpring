package io.github.Adam.DTO;

import io.github.Adam.Lang.Language;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LanguageDTO {

    private int id;
    private String code;

    public LanguageDTO(Language language) {
        this.id = language.getId();
        this.code = language.getCode();
    }
}
