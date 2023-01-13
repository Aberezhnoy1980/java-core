package ru.home.git_article_dpfh_creational_design_petterns.factory_method;

public class DevelopmentManager extends HiringManager {

    @Override
    protected Interviewer makeInterviewer() {
        return new Developer();
    }
}
