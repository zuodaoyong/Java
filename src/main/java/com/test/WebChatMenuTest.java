/**  
 * <p>Title: WebChatMenuTest.java</p>  
 * @description
 *                       _oo0oo_
 *                      o8888888o
 *                      88" . "88
 *                      (| -_- |)
 *                      0\  =  /0
 *                    ___/`---'\___
 *                  .' \\|     |// '.
 *                 / \\|||  :  |||// \
 *                / _||||| -:- |||||- \
 *               |   | \\\  -  /// |   |
 *               | \_|  ''\---/''  |_/ |
 *               \  .-\__  '-'  ___/-. /
 *             ___'. .'  /--.--\  `. .'___
 *          ."" '<  `.___\_<|>_/___.' >' "".
 *         | | :  `- \`.;`\ _ /`;.`/ - ` : | |
 *         \  \ `_.   \_ __\ /__ _/   .-` /  /
 *     =====`-.____`.___ \_____/___.-`___.-'=====
 *                       `=---='
 *
 *
 *     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *
 *               佛祖保佑         永无BUG
 * <p>Copyright: Copyright (c) 2018</p>  
 * <p>Company: 同程艺龙</p>  
 * @author shangsu
 * @date 2018年12月3日 
 * @version 1.0  
 * 
 */  
package com.test;

import java.util.HashMap;

import com.alibaba.fastjson.JSONObject;

/**
 * @author su.shang
 *
 */
public class WebChatMenuTest {
	
	static String tokenUrl = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wxb44acf67ba74e206&secret=811ebd6a8387cf6dcae06e8bc6b5fc80";
	
	static String createMenu = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=";
	
	static String queryMenu = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=";
	
	static String deleteMenu = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=";
	
	static String createCodition = "https://api.weixin.qq.com/cgi-bin/menu/addconditional?access_token=";
	
	static String deleteCodition = "https://api.weixin.qq.com/cgi-bin/menu/delconditional?access_token=";
	
	static String AllMenuUrl = "https://api.weixin.qq.com/cgi-bin/get_current_selfmenu_info?access_token=";
	
	public static void main(String[] args) throws InterruptedException {
		
		String tokenStr = getToken();
		JSONObject tokenJson = JSONObject.parseObject(tokenStr);
		
		if (tokenJson.containsKey("access_token")) {
			String token = tokenJson.getString("access_token");
			
			for (int i = 0; i < 100; i++) {
				String data1 = "{\r\n" + 
						"     \"button\":[\r\n" + 
						"     {    \r\n" + 
						"          \"name\":\"今日歌曲\",\r\n"
						+ "\"sub_button\":[\r\n" + 
						"           {    \r\n" + 
						"               \"type\":\"view\",\r\n" + 
						"               \"name\":\"搜索\",\r\n" + 
						"               \"url\":\"http://www.soso.com/\"\r\n" + 
						"            },\r\n" + 
						"            {\r\n" + 
						"                 \"type\":\"view\",\r\n" + 
						"                 \"name\":\"wxa\",\r\n" + 
						"                 \"url\":\"http://mp.weixin.qq.com\"\r\n" + 
						"             },\r\n" + 
						"            {\r\n" + 
						"               \"type\":\"click\",\r\n" + 
						"               \"name\":\"赞一下我们\",\r\n" + 
						"               \"key\":\"V1001_GOOD\"\r\n" + 
						"            }]" + 
						"      }"
						+ "  ]" +
						" }";
				
				createMenu(token,data1);
				
				
				System.err.println("11" + getMenu(token));
				
				
				HttpClientUtil.sendGetRequest(deleteMenu + token, "utf-8");
				System.err.println("22" + getMenu(token));
				
				Thread.sleep(10);
			}
		}
	}
	
	
	
	public static String getToken() {
		return HttpClientUtil.sendGetRequest(tokenUrl, null);
	}
	
	public static void createMenu(String token, String data) {
		
		String ret = HttpClientUtil.sendPostRequest(createMenu + token, data, "utf-8");
		
		System.out.println(ret);
	}
	
	public static String getMenu(String token) {
		return HttpClientUtil.sendGetRequest(queryMenu + token, "utf-8");
	}
	
}
