package beans;

import db.*;
import entity.*;
import java.io.ByteArrayInputStream;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import javax.inject.Inject;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/*
 * ・フィールド変数とアクセサメソッドを持つ
 * ・初期化処理を行う
 * ・ページング処理を行う
 * ・ユーティリティメソッドもスーパークラスに用意する
 */
public class SuperBb implements Serializable {

    @Inject
    protected transient Logger log;		// ロガー

    protected String s = null;
    protected List<Product> ls;
    protected boolean flag = false;

    /* *****（データベース処理）*******************************/
    @EJB
    ProductDb productDb;		// 商品データベース

    @EJB
    dp_JPQL jpql;

    @PostConstruct
    public void init() {
        s = null;
    }

    /* *****（画像表示処理＜小画像＞）************************/
    public StreamedContent getPicS() {
        FacesContext context = FacesContext.getCurrentInstance();
        if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
            return new DefaultStreamedContent();
        } else {

            ExternalContext sv = context.getExternalContext();
            Map<String, String> map = sv.getRequestParameterMap();
            String key = map.get("productId");
            Product e = (Product) (productDb.find(Long.valueOf(key)));
            ByteArrayInputStream in = new ByteArrayInputStream(e.getPic_S());
            DefaultStreamedContent ds = new DefaultStreamedContent(in);
            return ds;
        }
    }
    /* *****（画像表示処理＜大画像＞）************************/

    public StreamedContent getPicL() {
        FacesContext context = FacesContext.getCurrentInstance();
        if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
            return new DefaultStreamedContent();
        } else {

            ExternalContext sv = context.getExternalContext();
            Map<String, String> map = sv.getRequestParameterMap();
            String key = map.get("productId");
            Product e = (Product) (productDb.find(Long.valueOf(key)));
            ByteArrayInputStream in = new ByteArrayInputStream(e.getPic_L());
            DefaultStreamedContent ds = new DefaultStreamedContent(in);
            return ds;
        }
    }
    /* *****（メッセージを作成しキューに入れる）**************/

    public void facesMessage(String s) {
        FacesMessage msg = new FacesMessage(s);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

}
