import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.nodes.Document;

import edu.ntu.net.http.HttpsConnect;

public class DownloadNasdaqStockAllName {

	public static void main(String[] args) {
		String url = "https://api.nasdaq.com/api/screener/stocks?download=true";
		try {
			HttpsConnect conn = new HttpsConnect(url);
			
			JSONObject obj =conn.getJSONObject();
			JSONArray stocks = obj.getJSONObject("data").getJSONArray("rows");
			for (int i = 0; i < stocks.length(); i++) {
				String stockid = stocks.getJSONObject(i).getString("symbol");
				String stockname = stocks.getJSONObject(i).getString("name");
				System.out.println(String.format("id:%5s,name:%s",stockid,stockname));
			}

			
			
		} catch (Exception e) {
			System.out.println("無法連上網站，"+e.getMessage());
		}
		
		System.out.println("程式結束");
	}

}
