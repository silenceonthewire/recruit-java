package models;

import play.data.validation.Constraints;

import java.util.List;

public class SecondNode {

    @Constraints.Required
    public Long id;

    public String name;

    public List<ThirdNode> nodes = null;
}
