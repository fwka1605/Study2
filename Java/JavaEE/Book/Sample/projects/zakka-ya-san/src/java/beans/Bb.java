package beans;
import entity.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
@Named
@SessionScoped
public class Bb extends SuperBb implements Serializable {
	/* ******（content-1）**************************************/
	// カートを見る
	public String dispCart() {
		if (cart.isEmpty()) {
			facesMessage("現在、カートは空です。");
			return "index";
		}
		return "cart?faces-redirect=true";
	}
	// 詳細説明画面へ
	public String detail(Product product) {
		sel = product;						// 表示する商品をselにセットする
		return "detail?faces-redirect=true";// 詳細画面を開く
	}
	// 1ページ分の商品データを取得する（content-1.xhtmlから利用される）
	public List<Product> getFromDb() {
		List<Product> ls = null;
		try {
			ls = pm.getFromDb(priceItem, kindItem, productPage);
		} catch (Exception e) {
			facesMessage("商品の検索処理でエラーが発生しました");
		}
		return ls;
	}
	// 総件数と最大取得件数を再設定する
	public void counterClear() {
		try {
			pm.counterClear(kindItem, productPage);
		} catch (Exception e) {
			facesMessage("商品情報の初期化でエラーが発生しました");
		}
	}
	/* ******（content-2）**************************************/
	// カートに商品を追加する
	public String addToCart() {
		addOrder();
		return "cart?faces-redirect=true";
	}
	// カートに同じ商品があれば個数を追加し、なければ新規に追加する
	public OrderLine addOrder() {
		Long id = sel.getId();							// selは詳細情報を見ている商品
		for (OrderLine pastOrder : cart) {				// カートから注文明細を取り出して
			Product c_product = pastOrder.getProduct();	// 明細から商品を取り出す 
			if (Objects.equals(c_product.getId(), id)) {// 同じ商品かidを比較する
				pastOrder.increase();					// 同じなら明細の件数を+1する
				return pastOrder;						// 処理をここで終わる
			}
		}
		OrderLine newOrder = new OrderLine(sel, 1);	// カートに同じ商品がなかったので
		cart.add(newOrder);							// 新規に追加する
		return newOrder;
	}
	/* ******（content-3）**************************************/
	// カート画面から注文情報入力画面を表示する
	public String gotoOrderForm() {
		if (cart.isEmpty()) {					// カートが空なら戻る
			facesMessage("現在、カートは空です。");
			return "cart";
		}
		return "orderForm?faces-redirect=true";	// 注文画面へ
	}
	// カート内の商品を削除する
	public String delete(OrderLine order) {
		cart.remove(order);
		return null;
	}
	/* ******（content-4）**************************************/
	// カートの商品を購入する
	public String buy() {
		String uid = getUserId();// ログインしている顧客のidを得る（SuperBbで定義したユーティリティ）
		if (uid == null) {
			uid = "guest";	// ログインしていないのでidをゲストとしておく
		}
		makeOrder(uid);		// 注文をデータベースに保存
		sendMail();			// 確認メールを送信する
		clear();			// カートを空にする
		return "confirm?faces-redirect=true";
	}
	// 注文を保存
	public void makeOrder(String uid) {
		Customer c = (Customer) customerDb.search(uid);
		int total = 0;
		for (OrderLine ol : cart) {
			total += ol.getQuantity() * ol.getProduct().getPrice(); // 個数×単価
		}
		AppOrder appOrder = new AppOrder(c, c_name, c_mail, c_msg, new Date(), total, cart);
		appOrderDb.add(appOrder);
	}
	// 確認メールの送信(非同期の処理)
	public void sendMail() {
		sender.send(c_mail, "ご注文のご確認", text.getText(c_name, c_msg, cart));
	}
	// 表示をクリアし、カートも空にする
	public void clear() {
		c_name = c_address = c_mail = c_msg = null;	// 注文画面のフィールド変数をクリア
		cart.clear();	// カートを空にする
	}
	/* ******（content-6）**************************************/
	// 注文履歴を返す
	public List<AppOrder> getHistory() {
		List<AppOrder> history = new ArrayList<>();
		try {
			history = orderManager.getHistory(getUserId());
		} catch (Exception e) {
			facesMessage("注文履歴を取得できません");
		}
		return history;
	}
}
