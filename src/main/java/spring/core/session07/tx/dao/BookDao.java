package spring.core.session07.tx.dao;

public interface BookDao {
	Integer getBookPrice(Integer bid); // 根據 bid 取得書本價額
	Integer getStockAmount(Integer bid); // 根據 bid 取得該書籍庫存數量
	Integer getWalletMoney(Integer wid); // 根據 wid 取得可用餘額
	Integer updateStock(Integer bid, Integer amount); // 修改庫存, 減去 amount
	Integer updateWallet(Integer wid, Integer money); // 變更錢包餘額, 減去 money
}
