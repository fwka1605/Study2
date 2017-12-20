package knowledgebank.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import knowledgebank.entity.Account;
import knowledgebank.entity.Category;
import knowledgebank.entity.KnowledgeComment;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-10-29T21:28:50")
@StaticMetamodel(Knowledge.class)
public class Knowledge_ { 

    public static volatile SingularAttribute<Knowledge, Date> lastCommentAt;
    public static volatile ListAttribute<Knowledge, Category> categoryList;
    public static volatile SingularAttribute<Knowledge, String> description;
    public static volatile SingularAttribute<Knowledge, Date> updateAt;
    public static volatile SingularAttribute<Knowledge, Long> id;
    public static volatile ListAttribute<Knowledge, KnowledgeComment> knowledgeCommentList;
    public static volatile SingularAttribute<Knowledge, String> title;
    public static volatile SingularAttribute<Knowledge, Date> createAt;
    public static volatile SingularAttribute<Knowledge, Account> account;

}