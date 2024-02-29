package org.primefaces.test;

import lombok.Getter;

@Getter
public class OpenTabObject {
    private String title;
    private String page;
    private TabEntity content;

    public OpenTabObject(String title, String page, TabEntity content) {
        this.title = title;
        this.page = page;
        this.content = content;
    }

}
