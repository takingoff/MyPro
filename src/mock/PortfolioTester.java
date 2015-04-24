/**
 *	2015年4月24日 下午2:23:28
 *	TangLi
 */
package mock;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;

/**
 * @author TangLi 2015年4月24日下午2:23:28
 */
public class PortfolioTester
{
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args)
	{

		// Create a portfolio object which is to be tested
		Portfolio portfolio = new Portfolio();

		// Creates a list of stocks to be added to the portfolio
		List stocks = new ArrayList();
		Stock googleStock = new Stock("1", "Google", 10);
		Stock microsoftStock = new Stock("2", "Microsoft", 100);

		stocks.add(googleStock);
		stocks.add(microsoftStock);

		// Create the mock object of stock service
		StockService stockServiceMock = EasyMock.createMock(StockService.class);

		// mock the behavior of stock service to return the value of various
		// stocks
		EasyMock.expect(stockServiceMock.getPrice(googleStock)).andReturn(50.00);
		EasyMock.expect(stockServiceMock.getPrice(microsoftStock)).andReturn(1000.00);

		EasyMock.replay(stockServiceMock);

		// add stocks to the portfolio
		portfolio.setStocks(stocks);

		// set the stockService to the portfolio
		portfolio.setStockService(stockServiceMock);

		double marketValue = portfolio.getMarketValue();

		// verify the market value to be
		// 10*50.00 + 100* 1000.00 = 500.00 + 100000.00 = 100500
		System.out.println("Market value of the portfolio: " + marketValue);
	}

	static interface StockService
	{
		public double getPrice(Stock stock);
	}

	static class Stock
	{
		private String stockId;
		private String name;
		private int quantity;

		public Stock(String stockId, String name, int quantity)
		{
			this.stockId = stockId;
			this.name = name;
			this.quantity = quantity;
		}

		public String getStockId()
		{
			return stockId;
		}

		public void setStockId(String stockId)
		{
			this.stockId = stockId;
		}

		public int getQuantity()
		{
			return quantity;
		}

		public String getTicker()
		{
			return name;
		}
	}

	@SuppressWarnings("rawtypes")
	static class Portfolio
	{
		private StockService stockService;
		private List stocks;

		public StockService getStockService()
		{
			return stockService;
		}

		public void setStockService(StockService stockService)
		{
			this.stockService = stockService;
		}

		public List getStocks()
		{
			return stocks;
		}

		public void setStocks(List stocks)
		{
			this.stocks = stocks;
		}

		public double getMarketValue()
		{
			double marketValue = 0.0;

			for (Object stock : stocks)
			{
				Stock s = (Stock) stock;
				marketValue += stockService.getPrice(s) * s.getQuantity();
			}
			return marketValue;
		}
	}
}