package knowledgebank.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import knowledgebank.entity.Knowledge;
import knowledgebank.entity.KnowledgeComment;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-10-29T21:28:50")
@StaticMetamodel(Account.class)
public class Account_ { 

    public static volatile SingularAttribute<Account, String> password;
    public static volatile SingularAttribute<Account, String> mail;
    public static volatile SingularAttribute<Account, String> accountGroup;
    public static volatile SingularAttribute<Account, String> name;
    public static volatile SingularAttribute<Account, Long> id;
    public static volatile ListAttribute<Account, KnowledgeComment> knowledgeCommentList;
    public static volatile SingularAttribute<Account, String> userId;
    public static volatile ListAttribute<Account, Knowledge> knowledgeList;

}