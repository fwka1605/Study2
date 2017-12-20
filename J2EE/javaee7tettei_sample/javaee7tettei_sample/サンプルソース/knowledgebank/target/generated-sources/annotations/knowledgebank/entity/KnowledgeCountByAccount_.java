package knowledgebank.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-10-29T21:28:51")
@StaticMetamodel(KnowledgeCountByAccount.class)
public class KnowledgeCountByAccount_ { 

    public static volatile SingularAttribute<KnowledgeCountByAccount, BigDecimal> accountId;
    public static volatile SingularAttribute<KnowledgeCountByAccount, Date> asOf;
    public static volatile SingularAttribute<KnowledgeCountByAccount, String> accountName;
    public static volatile SingularAttribute<KnowledgeCountByAccount, Long> count;
    public static volatile SingularAttribute<KnowledgeCountByAccount, BigDecimal> id;

}