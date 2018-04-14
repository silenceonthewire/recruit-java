package models;

import play.data.validation.Constraints;

public class ThirdNode {

    @Constraints.Required
    public Long id;

    public String name;
}
