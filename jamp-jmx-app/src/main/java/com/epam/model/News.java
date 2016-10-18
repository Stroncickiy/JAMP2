package com.epam.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class News implements Serializable {
    private String news;
    private List<String> allowedProviders = new ArrayList<>();

    public News(String data, String... allowedProviders) {
        this.news = data;
        this.allowedProviders.addAll(Arrays.asList(allowedProviders));
    }

    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
    }

    public List<String> getAllowedProviders() {
        return allowedProviders;
    }

    public void setAllowedProviders(List<String> allowedProviders) {
        this.allowedProviders = allowedProviders;
    }
}
