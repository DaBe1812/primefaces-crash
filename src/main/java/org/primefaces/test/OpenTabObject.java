package org.primefaces.test;

import lombok.Getter;

@Getter
public class OpenTabObject {
    private final String title;
    private final String page;
    private final TabEntity content;

    public OpenTabObject(String title, String page, TabEntity content) {
        this.title = title;
        this.page = page;
        this.content = content;
    }

}
