package knowledgebank.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import knowledgebank.entity.Account;
import knowledgebank.entity.Knowledge;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-10-29T21:28:50")
@StaticMetamodel(KnowledgeComment.class)
public class KnowledgeComment_ { 

    public static volatile SingularAttribute<KnowledgeComment, Date> updateAt;
    public static volatile SingularAttribute<KnowledgeComment, Long> id;
    public static volatile SingularAttribute<KnowledgeComment, String> message;
    public static volatile SingularAttribute<KnowledgeComment, Date> createAt;
    public static volatile SingularAttribute<KnowledgeComment, Account> account;
    public static volatile SingularAttribute<KnowledgeComment, Knowledge> knowledge;

}