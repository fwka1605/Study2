package knowledgebank.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import knowledgebank.entity.Knowledge;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-10-29T21:28:51")
@StaticMetamodel(Category.class)
public class Category_ { 

    public static volatile SingularAttribute<Category, String> name;
    public static volatile SingularAttribute<Category, Long> id;
    public static volatile ListAttribute<Category, Knowledge> knowledgeList;

}